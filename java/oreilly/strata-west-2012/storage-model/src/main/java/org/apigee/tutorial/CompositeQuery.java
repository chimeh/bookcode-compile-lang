package org.apigee.tutorial;

import me.prettyprint.cassandra.serializers.CompositeSerializer;
import me.prettyprint.cassandra.serializers.StringSerializer;
import me.prettyprint.cassandra.service.ColumnSliceIterator;
import me.prettyprint.hector.api.beans.Composite;
import me.prettyprint.hector.api.beans.HColumn;
import me.prettyprint.hector.api.factory.HFactory;
import me.prettyprint.hector.api.query.SliceQuery;
import org.apigee.tutorial.common.TutorialBase;

import java.util.Iterator;

/**
 * Demonstrates how to slice across a range of columns for a given key. This class does
 * a bit more by using Hector's ColumnSliceIterator (CSI) to retrieve results. CSI
 * handles the paging in groups of 100 columns, presenting itself as an Iterator and
 * automatically re-issueing the query with the last result from the iteration as the
 * first result for the next call (automatically hiding it from display). This is a
 * standard use case for a columnar-oriented distributed database because 'you don't
 * know what you have until you have it'.
 *
 * This class assumes you have created the CountryStateCity column family in the
 * Tutorial keyspace and have already run {@link org.apigee.tutorial.CompositeDataLoader}
 *
 * Execute this class with the following invocation from the project root:
 * mvn -e exec:java -Dexec.mainClass="org.apigee.tutorial.CompositeQuery"
 *
 * to see the whole row in the cassandra-cli:
 * list CompositeSingleRowIndex;
 *
 * CQL
 * Currently CQL will only display the key for composite columns. See:
 * https://issues.apache.org/jira/browse/CASSANDRA-3680 for details
 *
 * @author zznate
 */
public class CompositeQuery extends TutorialBase {

  // this is the first component of the Composite for which we will look
  private static String startArg = "US";
  
  public static void main(String []args) {
    init();
    // TODO add maybeCreate() abstract class to tutorial schema
    CompositeQuery compositeQuery = new CompositeQuery();

    // Note the use of 'equal' and 'greater-than-equal' for the start and end.
    // this has to be the case when we want all 
    Composite start = compositeFrom(startArg, Composite.ComponentEquality.EQUAL);
    Composite end = compositeFrom(startArg, Composite.ComponentEquality.GREATER_THAN_EQUAL);

    compositeQuery.printColumnsFor(start,end);

  }


  protected void maybeCreateSchema() {
    // TODO checkForCf(); throw IllegalArgumentException if CompositeDataLoader has not been run
  }

  /**
   * Prints out the columns we found with a summary of how many there were
   *
   * @param start
   * @param end
   */
  public void printColumnsFor(Composite start, Composite end) {

    CompositeQueryIterator iter = new CompositeQueryIterator(CompositeDataLoader.COMPOSITE_KEY, start, end);
    System.out.printf("Printing all columns starting with %s", startArg);
    int count = 0;
    for ( HColumn<Composite,String> column : iter ) {

      System.out.printf("Country code: %s  Admin Code: %s  Name: %s  Timezone: %s \n",
        column.getName().get(0,StringSerializer.get()),
        column.getName().get(1,StringSerializer.get()),
        column.getName().get(2,StringSerializer.get()),
        column.getValue()
        );
      count++;
    }
    System.out.printf("Found %d columns\n",count);
  }
    

  /**
   * Encapsulates the creation of Composite to make it easier to experiment with values
   * 
   * @param componentName
   * @param equalityOp
   * @return
   */
  public static Composite compositeFrom(String componentName, Composite.ComponentEquality equalityOp) {
    Composite composite = new Composite();
    composite.addComponent(0, componentName, equalityOp);
    return composite;
  }

  /**
   * Demonstrates the use of Hector's ColumnSliceIterator for "paging" automatically over the results
   *
   */
  class CompositeQueryIterator implements Iterable<HColumn<Composite,String>> {

    private final String key;
    private final ColumnSliceIterator<String,Composite,String> sliceIterator;
    private Composite start;
    private Composite end;

    CompositeQueryIterator(String key, Composite start, Composite end) {
      this.key = key;
      this.start = start;
      this.end = end;

      SliceQuery<String,Composite,String> sliceQuery =
        HFactory.createSliceQuery(tutorialKeyspace, StringSerializer.get(), new CompositeSerializer(), StringSerializer.get());
      sliceQuery.setColumnFamily(CompositeDataLoader.CF_COMPOSITE_INDEX);
      sliceQuery.setKey(key);

      sliceIterator = new ColumnSliceIterator(sliceQuery, start, end, false);

    }

    public Iterator<HColumn<Composite, String>> iterator() {
      return sliceIterator;
    }


  }
}
