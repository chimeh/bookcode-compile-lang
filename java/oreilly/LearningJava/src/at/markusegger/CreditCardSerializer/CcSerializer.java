/**
 * 
 */
package at.markusegger.CreditCardSerializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import at.markusegger.CreditCardBase.CreditCard;
import at.markusegger.Utilities.ConsoleBase;
import at.markusegger.Utilities.Utilities;

/**
 * Demo for object serialization under Java.
 * 
 * @author MarkusME
 * @version 1.2
 */
public final class CcSerializer extends ConsoleBase
{
	static final private String FILE_PATH = "C:\\Users\\MarkusME\\workspace\\LearningJava\\src\\at\\markusegger\\CreditCardRandom\\ccserialized.bin";
	static final private ConsoleBase instance = new CcSerializer();
	static private ArrayList<CreditCard> creditCards = new ArrayList<CreditCard>();
	
	/**
	 * The main entry point for the credit card manager program.
	 * 
	 * @param args		The command-line arguments to the program
	 */
	public static void main(String[] args)
	{
		instance.setTitle("Credit Card Manager 2");
		instance.mainLoop();
	}

	/* (non-Javadoc)
	 * @see at.markusegger.Utilities.ConsoleBase#printMenu()
	 */
	@Override
	public void printMenu()
	{
		System.out.println(getStars());
		System.out.println("Enter 1 to view all cards");
		System.out.println("Enter 2 to view a specific card");
		System.out.println("Enter 3 to add a card");
		System.out.println("Enter 4 to update a card");
		System.out.println("Enter 5 to remove a card");
		System.out.println("Enter 6 to remove all cards");
		System.out.println("Enter 7 to load cards from file");
		System.out.println("Enter 8 to save cards to file");
		System.out.println("Enter 9 to exit the program");
		System.out.println(getStars());
		
		setMinMenuID(1);
		setMaxMenuID(9);
	}

	/* (non-Javadoc)
	 * @see at.markusegger.Utilities.ConsoleBase#handleInput(int)
	 */
	@Override
	public void handleInput(int choice)
	{
		System.out.println();
		
		switch (choice)
		{
			case 1:
				viewCards();
				break;
			
			case 2:
				viewCard();
				break;
				
			case 3:
				addCard();
				break;
				
			case 4:
				updateCard();
				break;
				
			case 5:
				removeCard();
				break;
			
			case 6:
				removeCards();
				break;
				
			case 7:
				loadCards();
				break;
				
			case 8:
				saveCards();
				break;
				
			case 9:
				setQuitFlag(true);
				System.out.println();
				System.out.println("Thanks for using the program! Bye!");
				System.out.println();
				break;
			
			default:
				throw new IllegalArgumentException("Unexpected menu choice " + choice);
		}
	}

	/**
	 * Helper method to check for a valid list of credit cards in the system
	 * (i. e. the {@link ArrayList} is not empty).
	 * 
	 * @return True when there are any cards saved in the system otherwise false
	 */
	private boolean checkCards()
	{
		if (creditCards.isEmpty())
		{
			System.out.println("No cards were saved in the system.");
			System.out.println();
			
			return false;
		}
		else
		{
			return true;
		}
	}

	/**
	 * List all credit cards saved in the system so far.
	 */
	private void viewCards()
	{
		if (!checkCards())
		{
			return;
		}
		
		printSubheader("View Cards");
		
		for (CreditCard cc : creditCards)
		{
			System.out.println(cc.toString());
		}
		
		System.out.println();
	}

	/**
	 * View the infos of a specific credit card.
	 */
	private void viewCard()
	{
		if (!checkCards())
		{
			return;
		}
		
		printSubheader("View Card");
		
		long cardNumber = getNumberInput();
		
		System.out.println();
		
		for (CreditCard cc : creditCards)
		{
			if (cc.getNumber() == cardNumber)
			{
				System.out.println(cc.toString());
				
				System.out.println();
				
				return;
			}
		}
		
		// No match
		System.out.println("The credit card with number " + cardNumber + " could not be found in the system.");
		
		System.out.println();
	}

	/**
	 * Add a credit card to the sytem.
	 */
	private void addCard()
	{
		printSubheader("Add Card");
		
		long number = getNumberInput();
		double balance = getBalanceInput();
		
		System.out.println();
		
		CreditCard cc = new CreditCard(number, balance);
		
		boolean addedSuccessfully = creditCards.add(cc);
		
		if (addedSuccessfully)
		{
			System.out.println("Card added.");
		}
		else
		{		
			System.out.println("There was an error adding the card!");
		}
		
		System.out.println();
	}

	/**
	 * Update the data of a specific credit card.
	 */
	private void updateCard()
	{
		if (!checkCards())
		{
			return;
		}
		
		printSubheader("Update Card");
				
		long cardNumber = getNumberInput();
		
		System.out.println();
		
		for (CreditCard cc : creditCards)
		{
			if (cc.getNumber() == cardNumber)
			{
				double newBalance = getBalanceInput();
				
				System.out.println();
				
				cc.setBalance(newBalance);
				
				System.out.println("Credit card " + cardNumber + " successfully updated.");
				
				System.out.println();
				
				return;
			}
		}
		
		// No match found
		System.out.println("The credit card with number " + cardNumber + " could not be found in the system.");
		
		System.out.println();
	}

	/**
	 * Remove a credit card from the system.
	 */
	private void removeCard()
	{
		if (!checkCards())
		{
			return;
		}
		
		printSubheader("Remove Card");
		
		long cardNumber = getNumberInput();
		
		System.out.println();
		
		for (CreditCard cc : creditCards)
		{
			if (cc.getNumber() == cardNumber)
			{
				boolean removedSuccessfully = creditCards.remove(cc);
				
				if (removedSuccessfully)
				{
					System.out.println("Credit card " + cardNumber + " removed from system.");
				}
				else
				{
					System.out.println("Unknown error - card could not be removed from system.");
				}
				
				System.out.println();
				
				return;
			}
		}
		
		// No match found
		System.out.println("The credit card with number " + cardNumber + " could not be found in the system.");
		
		System.out.println();
	}

	/**
	 * Remove all credit cards from the system
	 */
	private void removeCards()
	{
		if (!checkCards())
		{
			return;
		}
		
		printSubheader("Remove All Cards");
		
		creditCards.clear();
		
		System.out.println("All credit cards have been removed from system.");
		
		System.out.println();
	}

	/**
	 * Retrieve a valid credit card number from keyboard input.
	 * In our toy example valid card numbers consist of 16 consecutive digits.
	 * 
	 * @return	The credit card number as a {@link long} value
	 */
	private long getNumberInput()
	{
		long number = Long.MIN_VALUE;
		boolean validInput = false;
		
		while (!validInput)
		{
			//number = at.markusegger.Utilities.Utilities.readLongFromKeyboard("Enter the credit card number: ", Long.MIN_VALUE, Long.MAX_VALUE);
			
			System.out.print("Enter the credit card number (16 digits): ");
			
			String line = scanner.nextLine().trim();
			
			if (line.matches("\\d{16}"))
			{
				number = Long.parseLong(line);
				
				validInput = true;
			}
			else
			{
				System.out.println("Invalid card number!");
			}
		}
		
		return number;
	}

	/**
	 * Retrieve an account balance value from keyboard input.
	 * 
	 * @return	The card's balance as a {@link double} value
	 */
	private double getBalanceInput()
	{
		return at.markusegger.Utilities.Utilities.readDoubleFromKeyboard("Enter the card's balance: ", Double.MIN_VALUE, Double.MAX_VALUE);
	}

	/**
	 * Load (de-serialize) credit cards from file.
	 */
	@SuppressWarnings("unchecked")
	private void loadCards()
	{
		printSubheader("Load Cards");
		
		File ccFile = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try
		{
			ccFile = new File(FILE_PATH);
			
			if (!ccFile.exists())
			{
				System.out.println("No cards have been saved yet.");
				
				System.out.println();
				
				return;
			}
			
			fis = new FileInputStream(ccFile);
			
			ois = new ObjectInputStream(fis);
			
			creditCards = (ArrayList<CreditCard>) ois.readObject();
			
			System.out.println("Credit cards successfully loaded from file.");
		}
		catch (NullPointerException npex)
		{
			System.out.println("There was a programmer error: " + npex.getMessage());
		}
		catch (FileNotFoundException fnfex)
		{
			System.out.println("Could not find file: " + fnfex.getMessage());
		}
		catch (IOException ioex)
		{
			System.out.println("There was an error in the loading stream: " + ioex.getMessage());
		}
		catch (ClassNotFoundException cnfe)
		{
			System.out.println("The data in the save file was invalid and did not contain credit card data: " + cnfe.getMessage());
		}
		finally
		{
			Utilities.closeHelper(ois);
			
			Utilities.closeHelper(fis);
			
			ccFile = null;
		}
		
		System.out.println();
	}

	/**
	 * Save (serialize) credit cards to file.
	 */
	private void saveCards()
	{
		if (!checkCards())
		{
			return;
		}
		
		printSubheader("Save Cards");
		
		File ccFile = null;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try
		{
			ccFile = new File(FILE_PATH);
			
			fos = new FileOutputStream(ccFile);
			
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(creditCards);
						
			System.out.println("Credit cards successfully saved to file.");
		}
		catch (NullPointerException npex)
		{
			System.out.println("There was a programmer error: " + npex.getMessage());
		}
		catch (FileNotFoundException fnfex)
		{
			System.out.println("Could not find file: " + fnfex.getMessage());
		}
		catch (IOException ioex)
		{
			System.out.println("There was an error in the saving stream: " + ioex.getMessage());
		}
		finally
		{
			Utilities.closeHelper(oos);
			
			Utilities.closeHelper(fos);
			
			ccFile = null;
		}
		
		System.out.println();
	}
}
