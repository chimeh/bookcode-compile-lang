
public class Testing {

  public static void main(String[] args) {
    
    String stringLiteral = "are they the same";
    String stringObject = new String("are they the same");
    System.out.println("stringLiteral == stringObject? " + (stringLiteral == stringObject));
    System.out.println("The sequence of characters is the same is " + stringLiteral.equals(stringObject));
  }

}
