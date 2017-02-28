import java.util.Scanner;

public class BetterGuessingGame2 {
	
	public static void main(String[] args) {
		System.out.println("Welcome to the guessing game.");

		Scanner input = new Scanner(System.in);
		System.out.println("What is the secret number?");
		int number = input.nextInt();		
		
		System.out.println("Guess my secret number: ");
		int guess = input.nextInt();
		int counter = 1;
		
		while (guess != number) {
			if (guess < number) {
				if ((number - guess) < 5)
					System.out.println("You were too low, but you were close!");
				else 
					System.out.println("You were way too low.");
			} else {
				if ((guess - number) < 5)
					System.out.println("You were too high, but you were close!");
				else 
					System.out.println("You were way too high.");
			}
			
			int current_status = (5 - counter);
			System.out.println("You have " + current_status	+ " guesses left.");
			
			if (counter == 5)
				break;
			else
				counter = counter + 1;
			
			System.out.println("Guess again: ");
			guess = input.nextInt();
		}
		
		if (guess == number)
			System.out.println("You Win!");
		else
			System.out.println("Sorry, you missed it.  Please play again.");
		
		System.out.println("Game over.");
		input.close();
		}
	}