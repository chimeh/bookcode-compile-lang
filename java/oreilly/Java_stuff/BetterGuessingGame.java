import java.util.Scanner;

public class BetterGuessingGame {
	
	public static void main(String[] args) {
		System.out.println("Welcome to the guessing game.");

		Scanner input = new Scanner(System.in);
		System.out.println("What is the secret number?");
		int number = input.nextInt();		
		
		System.out.println("Guess my secret number: ");
		int guess = input.nextInt();
		
		while (guess != number) {
			if (guess < number)
				System.out.println("You were too low.");
			else
				System.out.println("You were too high."); 
				
			System.out.println("Guess again: ");
			guess = input.nextInt();
		}
		
		System.out.println("You Win!");
		
		System.out.println("Game over.");
		input.close();
		}
	}