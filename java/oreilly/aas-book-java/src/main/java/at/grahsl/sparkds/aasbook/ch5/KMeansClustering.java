package at.grahsl.sparkds.aasbook.ch5;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.StreamSupport;

import org.apache.commons.lang.ArrayUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.mllib.clustering.KMeans;
import org.apache.spark.mllib.clustering.KMeansModel;
import org.apache.spark.mllib.linalg.Vector;
import org.apache.spark.mllib.linalg.Vectors;

import scala.Tuple2;

public class KMeansClustering {

    public static void main(String[] args) {

    	if(args.length!=1) {
			System.err.println("usage: java "+KMeansClustering.class.getName()
									+" <PATH_TO_KDDCUP_DATA_SET>");
			System.exit(-1);
		}
    	
        SparkConf cnf = new SparkConf().setMaster("local")
                .setAppName(KMeansClustering.class.getName());

        JavaSparkContext jsc = new JavaSparkContext(cnf);
        JavaRDD<String> rawData = jsc.textFile(args[0]);
        
        JavaPairRDD<String, Vector> labelsAndData = preprocessRawData(rawData);
        clusteringTake0(labelsAndData);
        
        JavaRDD<Vector> dataFeatures = labelsAndData.values().cache();
        clusteringTake1(dataFeatures);
        clusteringTake2(dataFeatures);
        
        clusteringTake3(rawData);
        clusteringTake4(rawData);
        
        detectAnomalies(rawData, 150, 10, 1.0e-6);

        dataFeatures.unpersist();
        
        jsc.stop();

    }

    static void clusteringTake0(JavaPairRDD<String, Vector> labelsAndData) {

    	JavaPairRDD<String, Vector> cached = labelsAndData;
    	
        //NOTE: we use k-Means with default settings here
        //{k: 2, maxIterations: 20, runs: 1, initializationMode: "k-means||",
        //initializationSteps: 5, epsilon: 1e-4, seed: random}
        KMeans km = new KMeans();
        KMeansModel kmm = km.run(cached.values().rdd().cache());

        Arrays.stream(kmm.clusterCenters()).forEach(System.out::println);

        Map<Tuple2<Integer, String>, Long> clusterLabelCount = 
        									cached.map(ld -> new Tuple2<>(kmm.predict(ld._2), ld._1))
        										.countByValue();
 
        clusterLabelCount.forEach((t, l) -> System.out.format("%d\t%20s\t%10d\n", t._1, t._2, l));
        
    }

    static void clusteringTake1(JavaRDD<Vector> data) {

        //try various solutions for k cluster centroids
        //and different cluster scoring settings as well
        List<Tuple2<Integer, Double>> clusterScores = IntStream.rangeClosed(5, 35)
                .filter(i -> i % 5 == 0)
                	.mapToObj(k -> new Tuple2<>(k, clusteringScore(data, k, 1, 1.0e-4)))
                		.collect(Collectors.toList());

        clusterScores.forEach(System.out::println);

        clusterScores = IntStream.rangeClosed(30,100)
                .filter(i -> i % 10 == 0).parallel()
                	.mapToObj(k -> new Tuple2<>(k, clusteringScore(data,k,10,1.0e-6)))
                		.collect(Collectors.toList());

        clusterScores.forEach(System.out::println);

    }

    static void clusteringTake2(JavaRDD<Vector> data) {
    	
    	Tuple2<double[],double[]> normParams = calcNormalizationParams(data);
        JavaRDD<Vector> normalized = normalizeAllFeatureVectors(data,normParams).cache();

        List<Tuple2<Integer, Double>> clusterScores = IntStream.rangeClosed(60, 120)
                .filter(i -> i % 10 == 0).parallel()
                	.mapToObj(k -> new Tuple2<>(k, clusteringScore(normalized,k,10,1.0e-6)))
                		.collect(Collectors.toList());

        clusterScores.forEach(System.out::println);

        normalized.unpersist();

    }

    static void clusteringTake3(JavaRDD<String> rawData) {

        JavaPairRDD<String,Vector> encodedFeatures = oneHotEncodeCategoricalFeatures(rawData);
        Tuple2<double[],double[]> normParams = calcNormalizationParams(encodedFeatures.values());
        JavaRDD<Vector> normalized = normalizeAllFeatureVectors(encodedFeatures.values(),normParams).cache();

        List<Tuple2<Integer, Double>> clusterScores = IntStream.rangeClosed(80, 160)
                .filter(i -> i % 10 == 0)
                	.mapToObj(k -> new Tuple2<>(k, clusteringScore(normalized,k,10,1.0e-6)))
                		.collect(Collectors.toList());

        clusterScores.forEach(System.out::println);

        normalized.unpersist();

    }
    
    static void clusteringTake4(JavaRDD<String> rawData) {
        JavaPairRDD<String,Vector> encodedFeatures = oneHotEncodeCategoricalFeatures(rawData);
        Tuple2<double[],double[]> normParams = calcNormalizationParams(encodedFeatures.values());
        JavaPairRDD<String,Vector> normalizedFeatures = 
        			encodedFeatures.mapValues(v -> normalizeSingleFeatureVector(v, normParams));
        
         List<Tuple2<Integer, Double>> clusterScores = IntStream.rangeClosed(80, 160)
                .filter(i -> i % 10 == 0)
                	.mapToObj(k -> new Tuple2<>(k, clusteringScoreEntropy(normalizedFeatures,k,10,1.0e-6)))
                		.collect(Collectors.toList());
        
        clusterScores.forEach(System.out::println);
    }
    
    static void detectAnomalies(JavaRDD<String> rawData, int clusters, int runs, double epsilon) {
    	
    	JavaPairRDD<String,Vector> encodedFeatures = oneHotEncodeCategoricalFeatures(rawData);
    	Tuple2<double[],double[]> normParams = calcNormalizationParams(encodedFeatures.values());
    	JavaRDD<Vector> normalizedData = normalizeAllFeatureVectors(encodedFeatures.values(),normParams).cache();
    	
    	KMeansModel kmmDetector = new KMeans().setK(clusters).setRuns(runs)
										.setEpsilon(epsilon).run(normalizedData.rdd());
    	
    	int nthFarthest = 100;	
    	JavaRDD<Double> distances = normalizedData.map(v -> distToCentroid(v, kmmDetector));    									
    	double threshold = distances.top(nthFarthest).get(nthFarthest-1);
    	
    	JavaRDD<String> anomalies = encodedFeatures.filter(t -> 
    			distToCentroid(normalizeSingleFeatureVector(t._2, normParams), kmmDetector) > threshold)
    				.keys();
    	
    	anomalies.take(10).forEach(System.out::println);
        	
    	normalizedData.unpersist();
    	
    }
    
    static JavaPairRDD<String, Vector> preprocessRawData(JavaRDD<String> rawData) {
        //replace textual with numeric features and create (label,features) tuples
        return rawData.mapToPair(
                line -> {
                    String[] parts = line.split(",");
                    double[] slice1 = Arrays.asList(Arrays.copyOfRange(parts, 0, 1))
                    					.stream().mapToDouble(s -> Double.parseDouble(s)).toArray();
                    double[] slice2 = Arrays.asList(Arrays.copyOfRange(parts, 4, parts.length - 1))
                    					.stream().mapToDouble(s -> Double.parseDouble(s)).toArray();
                    return new Tuple2<>(parts[parts.length - 1], Vectors.dense(ArrayUtils.addAll(slice1, slice2)));
                }
        );
    }

    static JavaPairRDD<String,Vector> oneHotEncodeCategoricalFeatures(JavaRDD<String> rawData) {

        JavaRDD<String[]> splitData = rawData.map(s -> s.split(","));
        final Map<String,Long> protocols = splitData.map(sa -> sa[1]).distinct().zipWithIndex().collectAsMap();
        final Map<String,Long> services = splitData.map(sa -> sa[2]).distinct().zipWithIndex().collectAsMap();
        final Map<String,Long> tcpStates = splitData.map(sa -> sa[3]).distinct().zipWithIndex().collectAsMap();

        JavaPairRDD<String,Vector> oneHotEncodedFeatures = splitData.mapToPair(
                fields -> {
                    String[] parts = fields;
                    double[] before = Arrays.asList(Arrays.copyOfRange(parts, 0, 1)).stream().mapToDouble(s -> Double.parseDouble(s)).toArray();
                    double[] after = Arrays.asList(Arrays.copyOfRange(parts, 4, parts.length - 1)).stream().mapToDouble(s -> Double.parseDouble(s)).toArray();

                    double[] protocolFeatures = new double[protocols.size()];
                    protocolFeatures[protocols.get(parts[1]).intValue()] = 1.0;
                    double[] serviceFeatures = new double[services.size()];
                    serviceFeatures[services.get(parts[2]).intValue()] = 1.0;
                    double[] tcpStateFeatures = new double[tcpStates.size()];
                    tcpStateFeatures[tcpStates.get(parts[3]).intValue()] = 1.0;

                    double[] allFeatures = ArrayUtils.addAll(before,ArrayUtils.addAll(protocolFeatures, ArrayUtils.addAll(ArrayUtils.addAll(serviceFeatures, tcpStateFeatures), after)));

                    return new Tuple2<>(parts[parts.length - 1], Vectors.dense(allFeatures));
                }
        );

        return oneHotEncodedFeatures;
    }


    static JavaRDD<Vector> normalizeAllFeatureVectors(JavaRDD<Vector> data,Tuple2<double[],double[]> normParams) {

         JavaRDD<Vector> normalized = data.map(v -> {
            double[] vs = v.toArray();
            double[] nf = new double[v.size()];
            for (int i = 0; i < v.size(); i++) {
                nf[i] = vs[i] - normParams._1[i];
                if (normParams._2[i] > 0)
                    nf[i] /= normParams._2[i];
            }
            return Vectors.dense(nf);
        });
        
        return normalized;
    }
    
    static Vector normalizeSingleFeatureVector(Vector data,Tuple2<double[],double[]> normParams) {
            double[] vs = data.toArray();
            double[] nf = new double[data.size()];
            for (int i = 0; i < data.size(); i++) {
                nf[i] = vs[i] - normParams._1[i];
                if (normParams._2[i] > 0)
                    nf[i] /= normParams._2[i];
            }
            return Vectors.dense(nf);
    }

    static Tuple2<double[],double[]> calcNormalizationParams(JavaRDD<Vector> data) {

        JavaRDD<double[]> dataAsArray = data.map(v -> v.toArray());
        final int numCols = dataAsArray.first().length;
        long n = dataAsArray.count();

        double[] sums = dataAsArray.reduce((a,b) -> {
                    double[] c = new double[numCols];
                    for(int i=0;i<c.length;i++){
                        c[i] = a[i]+b[i];
                    }
                    return c;
                }
        );

        double[] sumSquares = dataAsArray.reduce((a, b) -> {
            double[] c = new double[numCols];
            for (int i = 0; i < c.length; i++) {
                c[i] = a[i] + b[i]*b[i];
            }
            return c;
        });

        double[] stddevs = new double[numCols];
        for(int i=0;i<stddevs.length;i++) {
            stddevs[i] = Math.sqrt(n*sumSquares[i]-sums[i]*sums[i])/n;
        }

        double[] means = Arrays.stream(sums).map(s -> s/n).toArray();

        return new Tuple2<>(means,stddevs);

    }

    static void exportClusterSolutionData4R(JavaRDD<String> rawData) {

        JavaPairRDD<String, Vector> labelsAndData = preprocessRawData(rawData);
        KMeansModel kmm = new KMeans().setK(100).setRuns(10).setEpsilon(1.0e-6)
        						.run(labelsAndData.values().rdd().cache());

        //sampling 5% of the actual data for the R export
        JavaRDD<String> dataSample = labelsAndData.map(
                t -> kmm.predict(t._2) + ","
                        + Arrays.stream(t._2.toArray())
                        .mapToObj(d -> String.valueOf(d))
                        .collect(Collectors.joining(","))
        ).sample(false, 0.05);

        dataSample.saveAsTextFile("data/output/book_ch5/sampleData4R.txt");
    }

   static double euclideanDistance(Vector a, Vector b) {

        double[] va = a.toArray();
        double[] vb = b.toArray();
        double sum = 0.0;

        for (int i = 0; i < a.size(); i++) {
            sum += Math.pow(va[i] - vb[i], 2);
        }

        return Math.sqrt(sum);
    }

    static double distToCentroid(Vector vector, KMeansModel model) {
        return euclideanDistance(model.clusterCenters()[model.predict(vector)], vector);
    }

    static double clusteringScore(JavaRDD<Vector> data, int k, int runs, double epsilon) {
        KMeansModel kmm = new KMeans().setK(k).setRuns(runs)
        					.setEpsilon(epsilon).run(data.rdd());
        return data.mapToDouble(v -> distToCentroid(v, kmm)).mean();
    }
    
    static double clusteringScoreEntropy(JavaPairRDD<String,Vector> data, int k, int runs, double epsilon) {
        
    	KMeansModel kmm = new KMeans().setK(k).setRuns(runs)
    							.setEpsilon(epsilon).run(data.values().rdd().cache());
    	
    	//predict cluster for each datum
    	JavaPairRDD<String,Integer> labelsAndClusters = data.mapValues(v -> kmm.predict(v));
    	//swap keys / values        
    	JavaPairRDD<Integer,String> clustersAndLabels = labelsAndClusters.mapToPair(t -> t.swap());
        //extract collections of labels, per cluster
        JavaRDD<Iterable<String>> labelsInCluster = clustersAndLabels.groupByKey().values();        
        //count labels in collections
        JavaRDD<Collection<Long>> labelCounts = labelsInCluster
        											.map(is -> StreamSupport.stream(is.spliterator(), false)
        														.collect(Collectors.groupingBy(String::toString,
        															Collectors.counting())).values());
        //average entropy weighted by cluster size
        long n = data.count();
        return labelCounts.map(m -> m.stream().mapToLong(l->l).sum() * calcEntropy(m))
        			.mapToDouble(d->d).sum() / n;        
    }
    
    static double calcEntropy(Collection<Long> counts) {
    	LongStream values = counts.stream().filter(l -> l > 0).mapToLong(l->l);
    	double n = (double)values.sum();
    	return counts.stream().filter(l -> l > 0).mapToDouble(v -> {
    		double p = v/n;
    		return -p*Math.log(p);
    	}).sum();
    	
    }

}
