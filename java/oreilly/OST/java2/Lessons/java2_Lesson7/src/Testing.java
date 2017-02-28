
import java.util.Scanner;

public class Testing {
 
  public static void main(String[] args) {
  
    int year;
    boolean leap;
    Scanner scan = new Scanner(System.in);
    
    System.out.print("Enter a year to test: ");
    year = scan.nextInt();
    
    if (year % 4 == 0)
      if (year % 100 == 0) // if divisible by 100 must be divisible by 400  
        leap = (year % 400 == 0); // i.e., if year is divisible by 400 this is true
      else
        leap = true;
    else
      leap = false;
    
    System.out.println("It is " + leap + " that " + year + " is a leap year.");
  }
  
}
