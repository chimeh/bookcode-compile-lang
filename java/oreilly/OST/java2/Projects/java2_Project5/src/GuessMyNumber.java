import java.text.NumberFormat;
import java.util.Scanner;

public class GuessMyNumber{

  Scanner scan;
	double weight;
	
  public GuessMyNumber(){
      scan = new Scanner(System.in);
  }

  public void testMe(){
      getInput();
      NumberFormat nf = NumberFormat.getInstance();
      nf.setMaximumFractionDigits(0);
      // calls to methods you make
      System.out.println("Calories needed to sustain current weight: " + nf.format(getCalories(weight)));
      System.out.println("Weight in grams: " + nf.format(getWeightInGrams(weight)));
  }

  public void getInput(){
       // prompt the user for input
         System.out.println("Click in the Console");
         System.out.print("Enter your weight in pounds: ");
         weight = scan.nextDouble();
  }
  
  public double getCalories(double weight) {
    weight *= 14;
    return weight;
  }
  
  public double getWeightInGrams(double weight) {
    weight *= 453.59237;
    return weight;
  }

  public static void main(String[] args){
      GuessMyNumber myGame = new GuessMyNumber();
      myGame.testMe();
  }
}