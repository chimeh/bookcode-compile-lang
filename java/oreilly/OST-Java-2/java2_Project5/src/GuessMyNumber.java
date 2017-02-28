import java.text.DecimalFormat;
import java.util.Scanner;

public class GuessMyNumber{
  Scanner scan;
  int userWeight;
	
  public GuessMyNumber(){
      scan = new Scanner(System.in);
  }

  public void testMe(){
      getInput();
      getCalories();
      getWeighInGrams();
  }
  
  public void getWeighInGrams(){
	  DecimalFormat myFormat1 = new DecimalFormat("###,###,###.##");
	  //1 lb is 453.59237 grams
	  double weightInGrams = userWeight * 453.59237;
	  System.out.println();
	  System.out.println("Your weight in grams is: " + myFormat1.format(weightInGrams));
  }
  
  public void getCalories(){
	  DecimalFormat myFormat2 = new DecimalFormat("###,###,###");
	  //14 calories per pound
	  int needCalories = userWeight * 14;
	  System.out.println();
	  System.out.println("Based on your weight, you need");
      System.out.print("this amount of calories per day: " + myFormat2.format(needCalories));
      System.out.println();
  }

  public void getInput(){
      System.out.println("Click in the Console");
      System.out.print("Type your weight in pounds and hit enter: ");
      userWeight = scan.nextInt();
  }

  public static void main(String[] args){
      GuessMyNumber myGame = new GuessMyNumber();
      myGame.testMe();
  }
}  