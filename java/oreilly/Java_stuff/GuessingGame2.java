import java.util.Scanner;

public class GuessingGame2 {
	
	public static void main(String[] args) {
		System.out.println("Welcome to the guessing game.");

		Scanner input = new Scanner(System.in);
		System.out.println("What is the secret number?");
		int number = input.nextInt();		
		
		System.out.println("Guess my secret number: ");
		int guess = input.nextInt();
		
		if (guess == number)
		System.out.println("You Win!");
		else
		System.out.println("Sorry, you missed it.");
		
		System.out.println("Game over.");
		input.close();
		}
	}