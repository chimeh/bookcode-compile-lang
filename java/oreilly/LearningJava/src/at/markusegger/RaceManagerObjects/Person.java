/**
 * 
 */
package at.markusegger.RaceManagerObjects;

/**
 * Interface specifying a person through name and age.
 * 
 * @author MarkusME
 * @version 1.0
 */
public interface Person
{
	/**
	 * Retrieve the name of the person.
	 * 
	 * @return The person's name
	 */
	String getName();
	
	/**
	 * Set the person's name.
	 * 
	 * @param newName	The (new) name of the person.
	 */
	void setName(String newName);
	
	/**
	 * Get the age of the person.
	 * 
	 * @return The person's age
	 */
	int getAge();
	
	/**
	 * Set the person's age.
	 * 
	 * @param newAge	The (new) age of the person.
	 */
	void setAge(int newAge);
}

