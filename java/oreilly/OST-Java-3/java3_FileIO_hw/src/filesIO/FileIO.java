package filesIO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class FileIO {
	String userInput;
	Scanner scan = new Scanner(System.in);
	List<String> enteredString = new ArrayList<String>();

	public void DisplayMenu() {
		System.out
				.println("Please enter (E)nter text, (S)ave text, \n(R)ead text, or (Q)uit:");
		userInput = scan.nextLine();
		userSelection(userInput);
	}

	public void userSelection(String userAction) {
		userAction = userAction.toUpperCase();
		if (userAction.charAt(0) == 'E') {
			enterText();
		} else if (userAction.charAt(0) == 'S') {
			saveText();
		} else if (userAction.charAt(0) == 'R') {
			readText();
		} else if (userAction.charAt(0) == 'Q') {
			quit();
		} else {
			System.out
					.println("Invalid selection.  Please choose \n(E)nter text, (S)ave text, (R)ead text, \nor (Q)uit:");
			userInput = scan.nextLine();
			userSelection(userInput);
		}
	}

	public void enterText() {
		/*
		 * Accepts user input as lines of Strings. Each time the user presses
		 * the ENTER key, the String should be added to an array or some type of
		 * List object. If the user enters a blank line of text, the program
		 * should return to its menu and wait for the user to make another
		 * selection.
		 */
		System.out.println("Please enter text:");
		String textEntered = scan.nextLine();
		do {
			enteredString.add(textEntered);
			textEntered = scan.nextLine();
			System.out.println("\n");
		} while ((textEntered != null) && (!textEntered.isEmpty()));
		DisplayMenu();
	}

	public void saveText() {
		/*
		 * Saves the contents of your array or list object to a file named by
		 * the user. Display a message if successful. Return to the menu and
		 * wait for the user to make another selection.
		 */

		System.out.println("Enter file name: ");
		String fileName = scan.nextLine();
		File userFile = new File(fileName + ".txt");

		try {
			FileWriter fWriter = new FileWriter(userFile);
			PrintWriter pWriter = new PrintWriter(fWriter);

			pWriter.println(enteredString);

			pWriter.close();
			fWriter.close();

			File dirFile = userFile.getParentFile();
			if (dirFile != null) {
				dirFile.mkdirs();
			}
			userFile.createNewFile();
		} catch (IOException e) {
			System.err.println("Error - " + e.getMessage());
		}
		System.out.println("Text saved successfully!");
		DisplayMenu();
	}

	public void readText() {

		/*
		 * Reads the contents of a text file named by the user. After the file
		 * has been displayed, display "Press Return Key twice". When the user
		 * hits Enter twice, the program should display the menu again.
		 */
		System.out.println("Enter file name to display:");

		try {
			String fileName = scan.nextLine();
			File userFile = new File(fileName + ".txt");

			FileReader fReader = new FileReader(userFile);
			BufferedReader bReader = new BufferedReader(fReader);

			String txtLine = "";

			while ((txtLine = bReader.readLine()) != null) {
				System.out.println(txtLine);
			}
			bReader.close();
			fReader.close();

		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
		System.out.println("Press Return Key twice");

		String returnPressed = scan.nextLine();
		if (returnPressed.equals("")) {
			String returnSecond = scan.nextLine();
			if (returnSecond.equals("")) {
				DisplayMenu();
			}
		}

	}

	public void quit() {
		System.out.println("Program ended.");
		System.exit(0);
	}
}
