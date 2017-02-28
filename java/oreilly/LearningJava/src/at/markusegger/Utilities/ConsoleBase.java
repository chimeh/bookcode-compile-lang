/**
 * 
 */
package at.markusegger.Utilities;

import java.util.Scanner;

import at.markusegger.Utilities.Utilities;

/**
 * Abstract base class for Console UIs.
 * 
 * @author MarkusME
 * @version 0.7
 */
abstract public class ConsoleBase
{
	static final protected Scanner scanner = new Scanner(System.in);
	
	private int lineWidth = 80;
	private int minMenuID;
	private int maxMenuID;	
	private boolean quitFlag = false;
	private String title = "Basic Console UI";
	
	/**
	 * The main loop for the console UI.
	 */
	public void mainLoop()
	{
		printHeader();
		
		while (!getQuitFlag())
		{
			printMenu();
			handleInput(getInput());			
		}
	}
	
	/**
	 * Retrieves the line width in number of characters.
	 * 
	 * @return The number of characters fitting in a line
	 */
	public int getLineWidth()
	{
		return lineWidth;
	}
	
	/**
	 * Set the number of characters that fit in a line.
	 * 
	 * @param newLineWidth		Number of characters fitting a line
	 */
	public void setLineWidth(int newLineWidth)
	{
		lineWidth = newLineWidth;
	}
	
	/**
	 * Get the minimum ID for the menu system.
	 * This is relevant for {@link getInput} to determine the allowed range of numeric values.
	 * 
	 * @return The minimum menu ID (inclusive)
	 */
	public int getMinMenuID()
	{
		return minMenuID;
	}
	
	/**
	 * Set the minimum ID of the menu system.
	 * This is relevant for {@link getInput} to determine the allowed range of numeric values.
	 * 
	 * @param newMinMenuID		The minimum menu ID (inclusive)
	 */
	public void setMinMenuID(int newMinMenuID)
	{
		minMenuID = newMinMenuID;
	}
	
	/**
	 * Get the maximum ID for the menu system.
	 * This is relevant for {@link getInput} to determine the allowed range of numeric values.
	 * 
	 * @return The maximum menu ID (inclusive)
	 */
	public int getMaxMenuID()
	{
		return maxMenuID;
	}
	
	/**
	 * Set the maximum ID of the menu system.
	 * This is relevant for {@link getInput} to determine the allowed range of numeric values.
	 * 
	 * @param newMaxMenuID		The maximum menu ID (inclusive)
	 */
	public void setMaxMenuID(int newMaxMenuID)
	{
		maxMenuID = newMaxMenuID;
	}
	
	/**
	 * Return a flag that shows whether to quit the application or not.
	 * 
	 * @return True if the application should be closed, false otherwise
	 */
	public boolean getQuitFlag()
	{
		return quitFlag;
	}
	
	/**
	 * Sets the flag whether to quit the application or not.
	 * 
	 * @param quitApplication		Quit the application?
	 */
	public void setQuitFlag(boolean quitApplication)
	{
		quitFlag = quitApplication;
	}
	
	/**
	 * Return the application title.
	 * 
	 * @return The application title
	 */
	public String getTitle()
	{
		return title;
	}
	
	/**
	 * Set the application title.
	 * 
	 * @param newTitle		The new application title
	 */
	public void setTitle(String newTitle)
	{
		title = newTitle;
	}
	
	/**
	 * Produces a line of stars ('*') with lineWidth.
	 * 
	 * @return	A line of *
	 */
	public String getStars()
	{
		return Utilities.repeatStar(getLineWidth());
	}
	
	/**
	 * Retrieves a menu choice from keyboard.
	 * Menu items are unsigned integers, e. g. 1 to 7.
	 * 
	 * @return The choice of the user as an integer
	 */
	public int getInput()
	{
		return Utilities.readIntFromKeyboard("Your choice: ", getMinMenuID(), getMaxMenuID());
	}


	/**
	 * Prints the application's title.
	 */
	public void printHeader()
	{
		System.out.println(getStars());
		
		System.out.println(String.format("*** %-" + (getLineWidth() - 8) + "s ***", getTitle().toUpperCase()));
	}
	
	/**
	 * Print a sub-header.
	 * 
	 * @param caption	The sub-header's name
	 */
	public void printSubheader(String caption)
	{
		System.out.println(getStars());
		System.out.println(caption.trim().toUpperCase());
		System.out.println(getStars());
		System.out.println();
	}
	
	/**
	 * Print the application menu/available choices.
	 */
	abstract public void printMenu();
		
	/**
	 * This method handles the choice the user made.
	 * 
	 * @param choice		The number of the menu item chosen
	 */
	abstract public void handleInput(int choice);
}
