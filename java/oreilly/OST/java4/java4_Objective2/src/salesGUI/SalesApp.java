package salesGUI;

public class SalesApp {

  //array to hold sales of each salesperson
  private int[] currentSales, savedSales;
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
  
  public void setCurrentSales(int[] sales) {
      if(currentSales == null) {
        System.out.println("No sales saved");
        this.currentSales = sales;
        setTotalSales();
      }
      else {
        System.out.println("Saving sales..");
        this.savedSales = currentSales;
        this.currentSales = sales;
        setTotalSales();
      }
  }
  
  public void setSavedSales(int[] sales) {
    this.savedSales = sales;
    
    for (int i = 0; i < sales.length; i++) {
      setTotalSales();
    }
  }
  
  public void displaySavedSales() {
    
  }
  
  public int[] getSavedSales() {
    return savedSales;
  }
  
  public void setTotalSales() {
    totalSales = 0;
    for (int x = 0; x < currentSales.length; x++) {
      totalSales += currentSales[x];
      setAverage();
    }
  }
  
  public void setAverage() {
    if (currentSales.length != 0)
      average = (double) (totalSales/currentSales.length);
    System.out.println("totalSales is " + totalSales + " and sales.length is " +
    		+ currentSales.length + " making average "
    		+ ((double) totalSales/currentSales.length));
  }
  
  public void setSalesBar(int goal) {
    salesBar = goal;
  }
  
  public int[] getCurrentSales() {
    return currentSales;
  }
  
  public double getAverage() {
    if ( currentSales.length != 0)
      return ((double) totalSales/currentSales.length);
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
    int minimum = currentSales[0];
    int maximum = currentSales[0];
    // loop through the sales array to see each sales amount
    for (int x = 0; x < currentSales.length; x++) {
      if (currentSales[x] > maximum) {
        maximum = currentSales[x];
        maxIndex = x;
      }
      else if (currentSales[x] < minimum) {
        minimum = currentSales[x];
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
    int[] performance = new int[currentSales.length];
    
    // Loop through the sales array and see who sold more than the sales bar
    for (int x = 0; x < currentSales.length; x++) {
      if (currentSales[x] > salesBar) {
        performance[x] = 1;
      }
      else if (currentSales[x] == salesBar) {
        performance[x] = 0;
      }
      else {
        performance[x] = -1;
      }
    }
    return performance;
  }
  
}
