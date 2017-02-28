package at.grahsl.sparkds.aasbook.ch4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.commons.lang.ArrayUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.mllib.evaluation.MulticlassMetrics;
import org.apache.spark.mllib.linalg.Vector;
import org.apache.spark.mllib.linalg.Vectors;
import org.apache.spark.mllib.regression.LabeledPoint;
import org.apache.spark.mllib.tree.DecisionTree;
import org.apache.spark.mllib.tree.RandomForest;
import org.apache.spark.mllib.tree.model.DecisionTreeModel;
import org.apache.spark.mllib.tree.model.RandomForestModel;

import scala.Tuple2;

public class DecisionTreeRandomForest {

	public static void main(String[] args) {
		
		if(args.length!=1) {
			System.err.println("usage: java "+DecisionTreeRandomForest.class.getName()
									+" <PATH_TO_COVTYPE_DATA_SET>");
			System.exit(-1);
		}

		SparkConf cnf = new SparkConf().setMaster("local")
				.setAppName(DecisionTreeRandomForest.class.getName());
				
		JavaSparkContext jsc = new JavaSparkContext(cnf);

		JavaRDD<String> rawData = jsc.textFile(args[0]);
		JavaRDD<LabeledPoint> fullData = rawData.map(
				line -> {
					//splitting the csv file and create a DoubleStream for array conversion
					double[] values = Arrays.asList(line.split(",")).stream()
							.mapToDouble(s -> Double.parseDouble(s)).toArray();
					//exclude the last entry which is the class/label information itself
					Vector featureVector = Vectors.dense(Arrays.copyOfRange(values, 0, values.length - 1));
					//we have to subtract 1 from the label info get a zero-indexed range
					return new LabeledPoint(values[values.length-1]-1,featureVector);
				}
				);

		//Split data into 80% train, 10% cross validation, 10% test sets
		JavaRDD<LabeledPoint>[] dataSplits = fullData.randomSplit(new double[]{0.8,0.1,0.1},1234L);
		JavaRDD<LabeledPoint> trainData = dataSplits[0].cache();
		JavaRDD<LabeledPoint> cvData = dataSplits[1].cache();
		JavaRDD<LabeledPoint> testData = dataSplits[2].cache();

		//train a simple more or less default DecisionTree Model
		//an check its resulting metrics
		runSimpleDecisionTree(trainData,cvData);

		//check against randomly labeled classes considering
		//also the prevalent distribution of labels in both
		//training and validation set
		checkRandomBaseLine(trainData,cvData);

		//try different hyperparameter combinations to fit
		//a better model then the simple one above
		fitBestModelParams(trainData, cvData, testData);
		
		//try different hyperparameter combinations to fit
		//an even better model with explicit categorical hinting
		fitBestModelParamsCategorical(rawData);

		//train a RandomForest model instead of single DecisionTree 
		evaluateForest(rawData);

		trainData.unpersist();
		cvData.unpersist();
		testData.unpersist();

		jsc.stop();

	}

	static void runSimpleDecisionTree(JavaRDD<LabeledPoint> trainData,JavaRDD<LabeledPoint> cvData) {

		//Build a simple default DecisionTreeModel

		//NOTE: we use of trainClassifier method suggesting that the target
		//value within each LabeledPoint should be treated as a distinct
		//category number not a numeric feature value. The trainRegressor method
		//would work similarly for regression problems.

		//params are as follows:
		//7 => number of different target labels the model will encounter
		//optional map => holding information about categorical features, we don't use it for now
		//gini => strategy to measure impurity of resulting tree (other option: entropy)
		//4 => max. depth of the resulting tree
		//100 => max bin count
		DecisionTreeModel dtm = DecisionTree.trainClassifier(trainData,7,new HashMap<>(),"gini",4,100);
		
		//MulticlassMetrics computes standard metrics that in different ways measure the
		//quality of the predictions from a classifier. Ideally, the classifier would
		//predict the correct label (=target category) for each example.
		//The metrics available here measure this sort of correctness in different ways.
		MulticlassMetrics metrics = getModelMetrics(dtm,cvData);
		//a) check the confusion matrix
		System.out.println("metrics.confusionMatrix()\n" + metrics.confusionMatrix());
		//b) look at overall precision
		System.out.println("metrics.precision() = " + metrics.precision());
		//c) look at individual precision and recall for each label
		for(int l = 0;l <= 6; l++) {
			System.out.format("L_%d => P: %.3f | R: %.3f%n",l,metrics.precision(l),metrics.recall(l));
		}
		//finally lets have a look at the resulting decision tree
		System.out.println(dtm.toDebugString());
	}

	static void fitBestModelParams(JavaRDD<LabeledPoint> trainData, JavaRDD<LabeledPoint> cvData, JavaRDD<LabeledPoint> testData) {

		//train DTM with different hyperparameter combinations
		//and save the outcome including its corresponding params
		List<HyperParamsEval> evaluations = new ArrayList<>();
		for(String impurity : new String[]{"gini","entropy"}) {
			for(int depth : new int[]{1,20}) {
				for(int bins : new int[]{10,300}) {
					DecisionTreeModel dtm = DecisionTree.trainClassifier(trainData, 7, new HashMap<>(), impurity, depth, bins);
					double accuracy = getModelMetrics(dtm,cvData).precision();
					evaluations.add(new HyperParamsEval(impurity,depth,bins,accuracy));
				}
			}
		}

		//check the results DESC sorted by their accuracy
		Collections.sort(evaluations);
		evaluations.stream().forEach(System.out::println);
		
		//run potentially best model again
		HyperParamsEval bestParams = evaluations.get(0);
		DecisionTreeModel model = DecisionTree.trainClassifier(
				trainData.union(cvData),7,new HashMap<>(),
				bestParams.impurity,bestParams.depth,bestParams.bins);
		System.out.println("DTM's accuracy for testData: "+getModelMetrics(model, testData).precision());
		System.out.println("DTM's accuracy: "+getModelMetrics(model, trainData.union(cvData)).precision());
		//System.out.println(model.toDebugString());
	}
	
	static void fitBestModelParamsCategorical(JavaRDD<String> rawData) {

		JavaRDD<LabeledPoint> fullData = oneHotDecoding(rawData);

		JavaRDD<LabeledPoint>[] dataSplits = fullData.randomSplit(new double[]{0.8,0.1,0.1},1234L);
		JavaRDD<LabeledPoint> trainData = dataSplits[0].cache();
		JavaRDD<LabeledPoint> cvData = dataSplits[1].cache();
		JavaRDD<LabeledPoint> testData = dataSplits[2].cache();
				
		Map<Integer,Integer> categoricalFeatures = new HashMap<Integer,Integer>()
														{{put(10,4);put(11,40);}};
		
		//train DTM with different hyperparameter combinations
		//and save the outcome including its corresponding params
		List<HyperParamsEval> evaluations = new ArrayList<>();
		for(String impurity : new String[]{"gini","entropy"}) {
			for(int depth : new int[]{10,20,30}) {
				for(int bins : new int[]{40,300}) {
					DecisionTreeModel dtm = DecisionTree.trainClassifier(trainData, 7,
												categoricalFeatures,impurity, depth, bins);
					double cvAccuracy = getModelMetrics(dtm,cvData).precision();
					evaluations.add(new HyperParamsEval(impurity,depth,bins,cvAccuracy));
				}
			}
		}

		//check the results DESC sorted by their accuracy
		Collections.sort(evaluations);
		evaluations.stream().forEach(System.out::println);
		
		//run potentially best model again
		HyperParamsEval bestParams = evaluations.get(0);
		DecisionTreeModel model = DecisionTree.trainClassifier(
				trainData.union(cvData),7,categoricalFeatures,
					bestParams.impurity,bestParams.depth,bestParams.bins);
		System.out.println("DTM's accuracy for testData: "+getModelMetrics(model, testData).precision());
		//System.out.println(model.toDebugString());
		
		trainData.unpersist();
		cvData.unpersist();
		testData.unpersist();
		
	}

	static void evaluateForest(JavaRDD<String> rawData) {

		JavaRDD<LabeledPoint> fullData = oneHotDecoding(rawData);

		JavaRDD<LabeledPoint>[] dataSplits = fullData.randomSplit(new double[]{0.9,0.1},1234L);
		JavaRDD<LabeledPoint> trainData = dataSplits[0].cache();
		JavaRDD<LabeledPoint> cvData = dataSplits[1].cache();

		final RandomForestModel rfm = RandomForest.trainClassifier(
					trainData, 7, new HashMap<Integer,Integer>() {{put(10,4);put(11,40);}}, 20,
						"auto", "entropy", 30, 300, new Random().nextInt());
		
		//System.out.println(rfm.toDebugString());
		
		JavaPairRDD<Object,Object> predictionsAndLabels = cvData.mapToPair(
				example -> new Tuple2<>(rfm.predict(example.features()),example.label())
		);

		MulticlassMetrics mcm = new MulticlassMetrics(JavaPairRDD.toRDD(predictionsAndLabels));
		System.out.println("RFM's accuracy = " + mcm.precision());
		
		Vector testVector = Vectors.dense(new double[]{2709,125,28,67,23,3224,253,207,61,6094,0,29});
		System.out.println("RFM's prediction = "+rfm.predict(testVector));
		
		trainData.unpersist();
		cvData.unpersist();
	}


	static MulticlassMetrics getModelMetrics(DecisionTreeModel dtm, JavaRDD<LabeledPoint> data) {
		//NOTE: this needs to be of raw Object type due to constructor of MulticlassMetrics  
		JavaPairRDD<Object,Object> predictionsAndLabels = data.mapToPair(
				example -> new Tuple2<>(dtm.predict(example.features()),example.label())
				);
		return new MulticlassMetrics(JavaPairRDD.toRDD(predictionsAndLabels));
	}


	static void checkRandomBaseLine(JavaRDD<LabeledPoint> trainData, JavaRDD<LabeledPoint> cvData) {

		double[] trainPriorProbabilities = classProbabilities(trainData);
		double[] cvPriorProbabilities = classProbabilities(cvData);

		if(trainPriorProbabilities.length == cvPriorProbabilities.length) {
			double accuracy = 0;
			for(int d=0;d<trainPriorProbabilities.length;d++) {
				accuracy += trainPriorProbabilities[d]*cvPriorProbabilities[d];
			}
			System.out.println("random baseline accurracy = " + accuracy);
		} else {
			System.err.println("error: arrays' length mismatch");
		}

	}

	static double[] classProbabilities(JavaRDD<LabeledPoint> data) {
		//calc histogram => labels,count-of-label
		Map<Double,Long> countsByCategory = data.map(lp -> lp.label()).countByValue();
		//order by category (=label) and extract counts
		SortedSet<Double> keys = new TreeSet<>(countsByCategory.keySet());
		List<Double> values = new ArrayList<>();
		long tmp = 0;
		for (Double c : keys) {
			Long l = countsByCategory.get(c);
			values.add(new Double(l));
			tmp+=l;
		}
		final long sum = tmp;
		return values.stream().mapToDouble(d->d/sum).toArray();
	}

	static JavaRDD<LabeledPoint> oneHotDecoding(JavaRDD<String> rawData) {
		return rawData.map(
				line -> {
					double[] values = Arrays.asList(line.split(","))
							.stream().mapToDouble(s -> Double.parseDouble(s)).toArray();
					//which of 4 "wilderness" features is 1 ?
					double wilderness = ArrayUtils.indexOf(Arrays.copyOfRange(values,10,14),1.0);
					//which of 40 "soil" features is 1 ?
					double soil = ArrayUtils.indexOf(Arrays.copyOfRange(values, 14, 54), 1.0);
					Vector featureVector = Vectors.dense(ArrayUtils.addAll(Arrays.copyOfRange(values,0,10)
							,new double[]{wilderness,soil}));
					//subtract 1 from the label info to be zero-indexed
					return new LabeledPoint(values[values.length-1]-1,featureVector);
				}
		);
	}

	public static class HyperParamsEval implements Comparable<HyperParamsEval> {

		public final String impurity;
		public final int depth;
		public final int bins;
		public final double accuracy;

		public HyperParamsEval(String impurity, int depth, int bins,
				double accuracy) {
			this.impurity = impurity;
			this.depth = depth;
			this.bins = bins;
			this.accuracy = accuracy;
		}

		@Override
		public String toString() {
			return "(("+impurity+","+depth+","+bins+"),"
					+ accuracy+")";
		}

		@Override
		public int compareTo(HyperParamsEval o) {
			return -1*Double.compare(this.accuracy,o.accuracy);
		}

	}


}

