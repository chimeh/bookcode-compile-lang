package salesGUI;

public class SalesPeople {

  public static void main(String[] args) {
    String[] salesPeople;
    salesPeople = new String[4];
    
    salesPeople[0] = "John";
    salesPeople[1] = "Paul";
    salesPeople[2] = "George";
    salesPeople[3] = "Ringo";
    
    for(int i=0; i <= salesPeople.length; i++) {
      System.out.println("Element at index " + i + " : " + salesPeople[i]);
    }
    
    System.out.println("Size of the salesPeople array is " + salesPeople.length);
  }
}
