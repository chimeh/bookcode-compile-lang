import java.util.Scanner;
import java.util.Calendar;

public class Potentials {

  public static void main(String[] args) {

    int yob, age=0, decades;
    Scanner scan = new Scanner(System.in);
    Calendar rightNow = Calendar.getInstance();
    System.out.println("What is your birth year?: ");
    yob = scan.nextInt();
    
    if((yob>1900) && yob<rightNow.get(Calendar.YEAR)) {
      age = rightNow.get(Calendar.YEAR) - yob;
    }
    else
      System.out.println("Not a valid entry");
    
    if(age > 0) {
      
      decades = age / 10;
      
      System.out.println("Your age is " + age);
      System.out.println("You have been alive for " + decades + " decades");
      
      if(age <10)
        System.out.println("Have fun, you're a kid.");
      if((age > 9)&& (age <20))
        System.out.println("Do good in school.");
      if((age > 19)&& (age <30))
        System.out.println("Find a job doing what you love, and enjoy your youth");
      if((age > 29)&& (age <40))
        System.out.println("Make sure you're investing for retirement");
      if((age > 39)&& (age <50))
        System.out.println("Don't have a midlife crisis");
      if((age > 49)&& (age <60))
        System.out.println("Keep in touch with your kids");
      if((age > 59)&& (age <70))
        System.out.println("Enjoy retirement");
      if((age > 69)&& (age <80))
        System.out.println("Stay healthy and keep friends and family close");
      if((age > 79)&& (age <90))
        System.out.println("You can do whatever you want at this age");
      if((age > 89)&& (age <100))
        System.out.println("Share your wisdom, the young ones will need it");
      }
    
  }

}
