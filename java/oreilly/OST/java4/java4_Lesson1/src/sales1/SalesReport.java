package sales1;

import java.util.Scanner;

public class SalesReport {
  int SALESPEOPLE;
  int sum;
  int sales[];
  Scanner scan = new Scanner(System.in);
  
  public SalesReport() {
    System.out.print("Enter the number of salespersons: ");
    this.SALESPEOPLE = scan.nextInt();
    this.sales = new int[SALESPEOPLE];
  }
  
  public SalesReport(int howMany) {
    this.SALESPEOPLE = howMany;
    this.sales = new int[SALESPEOPLE];
  }
  
  public void testMe() {
    getSalesInput();
    provideSalesOutput();
    findMax();
  }
  
  public void getSalesInput() {
    Scanner scan = new Scanner(System.in);
    
    for (int i = 0; i < sales.length; i++) {
      System.out.print("Enter sales for salesperson " + (i+1) + ": ");
      sales[i] = scan.nextInt();
    }
  }
  
  public void provideSalesOutput() {
    System.out.println("\nSalesperson   Sales");
    System.out.println("------------------------");
    sum = 0;
    for (int i = 0; i < sales.length; i++) {
      System.out.println("     " + (i+1) + "      " + sales[i]);
      sum += sales[i];
    }
    System.out.println("\nTotal sales: " + sum);
  }
  
  public void findMax() {
    int max = sales[0];
    int who = 0;
    for (int i = 0; i < sales.length; i++) {
      if (max < sales[i]) {
        max = sales[i];
        who = i;
      }
    }
    System.out.println("\nSalesPerson " + (who+1) + " had the highest sales with $" + max);
  }
}
