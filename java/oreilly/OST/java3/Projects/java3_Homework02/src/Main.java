public class Main {

  public static void main(String[] args) {
    if (args.length > 0) {
      int argIn = Integer.parseInt(args[0]);
      SalesReport mySalesInfo = new SalesReport(argIn);
      mySalesInfo.testMe();
    }
    else {
      SalesReport mySalesInfo = new SalesReport();
      mySalesInfo.testMe();
    }
  }
}
