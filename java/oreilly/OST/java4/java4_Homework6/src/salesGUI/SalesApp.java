package salesGUI;

public class SalesApp {

  //array to hold sales of each salesperson
  private int[] sales;
  //variable for sales goal (to be established by user)
  private int salesBar;
  private int totalSales;
  //why not average = totalSales/sales.length; here?
  private double average;
  private int minIndex = 0;
  private int maxIndex = 0;
  SalesUserInterface myUserInterface;
  
  public void setMyUserInterface(SalesUserInterface myGUI) {
    myUserInterface = myGUI;
  }
  
  public void setSales(int[] sales) {
    this.sales = sales;
    for (int i = 0; i < sales.length; i++) {
      // checking to see if it's working
      System.out.println(sales[i]);
      setTotalSales();
    }
  }
  
  public void setTotalSales() {
    totalSales = 0;
    for (int x = 0; x < sales.length; x++) {
      totalSales += sales[x];
      setAverage();
    }
  }
  
  public void setAverage() {
    if (sales.length != 0)
      average = (double) (totalSales/sales.length);
    System.out.println("totalSales is " + totalSales + " and sales.length is " +
    		+ sales.length + " making average "
    		+ ((double) totalSales/sales.length));
  }
  
  public void setSalesBar(int goal) {
    salesBar = goal;
  }
  
  public int[] getSales() {
    return sales;
  }
  
  public double getAverage() {
    if ( sales.length != 0)
      return ((double) totalSales/sales.length);
    else
      return average;
  }
  
  public int getBar() {
    return salesBar;
  }
  
  public int getTotalSales() {
    return totalSales;
  }
  
  public int getMin() {
    return minIndex;
  }
  
  public int getMax() {
    return maxIndex;
  }
  
  public void calculateMinMax() {
    int minimum = sales[0];
    int maximum = sales[0];
    // loop through the sales array to see each sales amount
    for (int x = 0; x < sales.length; x++) {
      if (sales[x] > maximum) {
        maximum = sales[x];
        maxIndex = x;
      }
      else if (sales[x] < minimum) {
        minimum = sales[x];
        minIndex = x;
      }
    }
    System.out.println("Maximum value is at index " + maxIndex
        + " (Salesperson " + (maxIndex +1) + ") with value " + maximum);
    System.out.println("Minimum value is at index " + minIndex
        + " (Salesperson " + (minIndex +1) + ") with value " + minimum);
    setAverage();
  }
  
  public int[] determineTopSalesPeople() {
    // System.out prints to console to be sure we got here --debugging tool
    System.out.println("I'm here and salesBar is " + salesBar);
    
    // an array with the values of -1, 0, 1 to indicate success at reaching goal
    int[] performance = new int[sales.length];
    
    // Loop through the sales array and see who sold more than the sales bar
    for (int x = 0; x < sales.length; x++) {
      if (sales[x] > salesBar) {
        performance[x] = 1;
      }
      else if (sales[x] == salesBar) {
        performance[x] = 0;
      }
      else {
        performance[x] = -1;
      }
    }
    return performance;
  }
  
}
