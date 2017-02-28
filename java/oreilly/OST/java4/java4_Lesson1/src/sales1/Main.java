//*************************************
// Main.java
//
// Instantiates and starts the SalesReport class
//
//*****************************************
package sales1;

public class Main {

  public static void main(String[] args) {
    try {
      
      int argIn = Integer.parseInt(args[0]);
      SalesReport mySalesInfo = new SalesReport(argIn);
      mySalesInfo.testMe();
    }
    catch (ArrayIndexOutOfBoundsException exception) {
      SalesReport mySalesInfo = new SalesReport();
      mySalesInfo.testMe();
    }
  }
}
