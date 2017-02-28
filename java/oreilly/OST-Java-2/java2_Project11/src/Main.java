public class Main {
  public static void main(String[] args) {
    int x;
    PhoneBook pb = new PhoneBook();
    System.out.println(pb);
    x = pb.nextIndex();
    if(x != -1) {
      pb.setName("Bob", x);
      pb.setNumber("0987654321", x);
    }
    else {
      System.out.println("Error: No empty phone book entries.");
    }
    pb.setName("Mike", 0);
    pb.setNumber("1234567890", 0);
    pb.setName(null, 1);
    pb.setNumber(null, 1);
    System.out.println(pb);
    x = pb.nextIndex();
    if(x != -1) {
      pb.setName("Bob", x);
      pb.setNumber("0987654321", x);
    }
    else {
      System.out.println("Error: No empty phone book entries.");
    }
    System.out.println("Entry for Mike at index: " + pb.getRecord("mike"));
    System.out.println("Entry number 2 (index 1) is: ");
    String temp[] = pb.getRecord(1);
    if(temp != null) {
      System.out.println("\t" + temp[0]);
      System.out.println("\t" + temp[1]);
    }
    else {
      System.out.println("Null entry.");
    }
    System.out.println("\n" + pb);
  }
}
