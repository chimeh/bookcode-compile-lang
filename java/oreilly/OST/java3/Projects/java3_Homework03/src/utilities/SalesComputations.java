package utilities;

public class SalesComputations {

  public static int computeSum(int[] sales) {
    int sum = 0;
    for (int i = 0; i < sales.length; i++) {
      sum += sales[i];
    }
    return sum;
  }

  public static int findMaxSales(int[] sales) {
    int max = sales[0];
    int i;
    for (i = 0; i < sales.length; i++) {
      if (max < sales[i]) {
        max = sales[i];
      }
    }
    return max;
  }

  public static int findMaxIndex(int[] sales) {
    int max = sales[0];
    int who = 0;
    int i;
    for (i = 0; i < sales.length; i++) {
      if (max < sales[i]) {
        max = sales[i];
        who = i;
      }
    }
    return (who + 1);
  }

  public static int findMinSales(int[] sales) {
    int min = sales[0];
    int i;
    for (i = 0; i < sales.length; i++) {
      if (min > sales[i]) {
        min = sales[i];
      }
    }
    return min;
  }

  public static int findMinIndex(int[] sales) {
    int min = sales[0];
    int who = 0;
    int i;
    for (i = 0; i < sales.length; i++) {
      if (min > sales[i]) {
        min = sales[i];
        who = i;
      }
    }
    return who + 1;
  }

  public static int[] greaterThanValues(int userVal, int[] sales) {
    int[] returnArray = new int[sales.length];
    int j = 0;

    for (int i = 0; i < sales.length; i++) {
      if (sales[i] > userVal) {
        returnArray[j] = sales[i];
        j++;
      }
    }
    return returnArray;
  }

  public static int[] greaterThanIndex(int userVal, int[] sales) {
    int[] returnArray = new int[sales.length];
    int j = 0;

    for (int i = 0; i < sales.length; i++) {
      if (sales[i] > userVal) {
        returnArray[j] = i + 1;
        j++;
      }
    }
    return returnArray;
  }

  public static int greaterThanTotal(int userVal, int[] sales) {
    int i;
    int total = 0;
    for (i = 0; i < sales.length; i++) {
      if (sales[i] > userVal) {
        total += 1;
      }
    }
    return total;
  }
}
