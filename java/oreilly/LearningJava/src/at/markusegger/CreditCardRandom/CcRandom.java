/**
 * 
 */
package at.markusegger.CreditCardRandom;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import at.markusegger.CreditCardBase.CreditCard;
import at.markusegger.Utilities.ConsoleBase;

/**
 * Demo for random file access under Java.
 * 
 * @author MarkusME
 * @version 1.0
 */
public final class CcRandom extends ConsoleBase
{
	static final private String FILE_PATH = "C:\\Users\\MarkusME\\workspace\\LearningJava\\src\\at\\markusegger\\CreditCardRandom\\ccdata.bin";
	static final private String FILE_MODE = "rw";
	static final private int RECORD_LENGTH = 16;
	
	static final private ConsoleBase instance = new CcRandom();
	static private RandomAccessFile dataFile;
	
	/**
	 * The main entry point for the credit card manager program.
	 * 
	 * @param args		The command-line arguments to the program
	 */
	public static void main(String[] args)
	{
		try
		{
			dataFile = new RandomAccessFile(FILE_PATH, FILE_MODE);
			
			instance.setTitle("Credit Card Manager 1");
			instance.mainLoop();
			
			try
			{
				dataFile.close();
			}
			catch (IOException e)
			{
				System.out.println("There was an error closing the credit card data file.");
				System.out.println();
				e.printStackTrace();
			}
			finally
			{
				dataFile = null;
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("There was an error accessing the credit card data file. Program will exit.");
			System.out.println();
			e.printStackTrace();
		}
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
		System.out.println("Enter 6 to exit the program");
		System.out.println(getStars());
		
		setMinMenuID(1);
		setMaxMenuID(6);
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
	 * (i. e. {@link RandomAccessFile} is not empty).
	 * 
	 * @return True when there are any cards saved in the system otherwise false
	 */
	private boolean checkCards()
	{
		try
		{
			if (dataFile.length() == 0L)
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
		catch (IOException e)
		{
			return false;
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
		
		long pos = 0L;
		
		try
		{
			dataFile.seek(pos);
			
			while (pos < dataFile.length())
			{
				long number = dataFile.readLong();
				
				double balance = dataFile.readDouble();
				
				String output = (new CreditCard(number, balance)).toString();
				
				System.out.println(output);
				
				pos += RECORD_LENGTH;
			}
		}
		catch (IOException ioex)
		{
			System.out.println("There was an error reading the card data from file: " + ioex.getMessage());
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
		
		try
		{
			long cardPosition = findCardIndex(cardNumber);
			
			if (cardPosition == -1L)
			{
				System.out.println("The credit card with number " + cardNumber + " could not be found in the system.");
			}
			else
			{
				CreditCard cc = readCardByIndex(cardPosition);
				
				System.out.println(cc.toString());
			}
		}
		catch (IOException ioex)
		{
			System.out.println("There was an error searching/reading the credit card: " + ioex.getMessage());
		}
		
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
		
		try
		{
			addCardToFile(new CreditCard(number, balance));
			
			System.out.println("Card added.");
		}
		catch (IOException ioex)
		{		
			System.out.println("There was an error adding the card: " + ioex.getMessage());
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
		
		try
		{
			long cardPosition = findCardIndex(cardNumber);
			
			if (cardPosition == -1L)
			{
				System.out.println("The credit card with number " + cardNumber + " could not be found in the system.");
			}
			else
			{
				double newBalance = getBalanceInput();
				
				System.out.println();
				
				CreditCard cc = new CreditCard(cardNumber, newBalance);
				
				setCardByIndex(cardPosition, cc);

				System.out.println("Credit card " + cardNumber + " successfully updated.");
			}
		}
		catch (IOException ioex)
		{
			System.out.println("There was an error while searching and updating the card: " + ioex.getMessage());
		}
		
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
		
		try
		{
			long cardPosition = findCardIndex(cardNumber);
			
			if (cardPosition == -1L)
			{
				System.out.println("The credit card with number " + cardNumber + " could not be found in the system.");
			}
			else
			{
				boolean removeSuccessful = removeCardByIndex(cardPosition);
				
				if (removeSuccessful)
				{
					System.out.println("Credit card " + cardNumber + " removed from system.");
				}
				else
				{
					System.out.println("Unknown error - card could not be removed from system.");
				}
			}
		}
		catch (IOException ioex)
		{
			System.out.println("There was an error while searching and removing the card: " + ioex.getMessage());
		}
		
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
	 * Internal method to save a card into the {@link RandomAccessFile}.
	 * 
	 * @param newCard			The credit card data to be saved
	 * @throws IOException
	 */
	private void addCardToFile(CreditCard newCard)
		throws IOException
	{
		dataFile.seek(dataFile.length());
		
		dataFile.writeLong(newCard.getNumber());
		dataFile.writeDouble(newCard.getBalance());
	}
	
	/**
	 * Removes a card from the {@link RandomAccessFile} store.
	 * Deletion will be accomplished by moving the last record to the
	 * position of the card to be removed (overwriting it) then
	 * truncating the file by one record {@link RECORD_LENGTH}.
	 * 
	 * @param cardPosition	The file index (position) of the card to be removed
	 * @return				True if the card could be removed otherwise false
	 * @throws IOException 
	 */
	private boolean removeCardByIndex(long cardPosition)
			throws IOException
	{
		long fileLength = dataFile.length();
		
		if (cardPosition < 0 || fileLength == 0)
		{
			return false;
		}
		
		long lastRecordPosition = fileLength - RECORD_LENGTH;
		
		// If the card data is not in the last record, we need to move data
		if (cardPosition != lastRecordPosition)
		{
			// Read the last record in the file ...
			dataFile.seek(lastRecordPosition);
			
			// ... saving to temporary variables
			long tempNumber = dataFile.readLong();
			double tempBalance = dataFile.readDouble();
			
			// Go to the position of the card to be removed ...
			dataFile.seek(cardPosition);
			
			// ... and overwrite its data with the last record
			dataFile.writeLong(tempNumber);
			dataFile.writeDouble(tempBalance);
		}
		
		// Finally, truncate the file by one record length
		dataFile.setLength(lastRecordPosition);
		
		return true;
	}

	/**
	 * Search and find the index (position) of a specific
	 * credit card number record in the {@link RandomAccessFile}.
	 * 
	 * @param cardNumber		The credit card number being searched for 
	 * @return The position of the card record in the file or -1 when there was no match
	 * @throws IOException
	 */
	private long findCardIndex(long cardNumber)
		throws IOException
	{
		long startPos = 0L;
		long fileLength = dataFile.length();
		
		dataFile.seek(startPos);
		
		while (startPos < fileLength)
		{
			long currentNumber = dataFile.readLong();
			
			if (currentNumber == cardNumber)
			{
				return startPos;
			}
			
			startPos += (Double.SIZE / 8);
		}
		
		return -1L;
	}
	
	/**
	 * Read in credit card data from a {@link RandomAccessFile} record.
	 *  
	 * @param index		The index (position) in the {@link RandomAccessFile} containing the card data
	 * @return 			A credit card object made from the file data
	 */
	private CreditCard readCardByIndex(long index)
		throws IOException
	{
		dataFile.seek(index);

		long number = dataFile.readLong();
		double balance = dataFile.readDouble();
		
		return new CreditCard(number, balance);
	}
	
	/**
	 * Sets a credit card file record according to position in the file and
	 * the {@link CreditCard} object specified.
	 * 
	 * @param cardPosition		The position of the record to be updated in the file
	 * @param cc				The credit card data to update the record with
	 * @return					True if update successful otherwise false
	 * @throws IOException
	 */
	private void setCardByIndex(long cardPosition, CreditCard cc)
		throws IOException
	{
		dataFile.seek(cardPosition);
		
		dataFile.writeLong(cc.getNumber());
		dataFile.writeDouble(cc.getBalance());
	}
}
