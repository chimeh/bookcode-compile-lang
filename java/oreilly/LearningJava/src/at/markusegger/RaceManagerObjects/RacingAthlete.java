/**
 * 
 */
package at.markusegger.RaceManagerObjects;

import at.markusegger.Utilities.Utilities;

/**
 * This is the racing athlete base class.
 * 
 * @author MarkusME
 * @version 0.8
 */
abstract public class RacingAthlete implements Person, RaceParticipant
{
	// Person
	private String _name;
	private int _age;
	// RaceParticipant
	private int _contestantID;
	// Handle injuries
	private boolean _isInjured;
	
	/**
	 * Default parameterless constructor.
	 */
	public RacingAthlete()
	{
	}
	
	/**
	 * Explicit constructor.
	 * 
	 * @param contestantID		The contestant ID.
	 * @param name				The name of the athlete.
	 * @param age				The age of the athlete.
	 */
	public RacingAthlete(String name, int age, int contestantID)
	{
		// Person
		_name = name;
		_age = age;
		
		// RaceParticipant
		_contestantID = contestantID;
	}
	
	/**
	 * Retrieves the athlete's name.
	 * 
	 * @return The name of the athlete.
	 */
	public String getName()
	{
		return _name;
	}
	
	/**
	 * Sets the athlete's name.
	 * 
	 * @param newName	The athlete's name.
	 */
	public void setName(String newName)
		throws IllegalArgumentException
	{
		Utilities.validateStringNotNullOrEmpty(newName);
		
		_name = newName;
	}
	
	/**
	 * Retrieves the athlete's age.
	 * 
	 * @return The age of the athlete.
	 */
	public int getAge()
	{
		return _age;
	}
	
	/**
	 * Sets the athlete's age.
	 * 
	 * @param newAge	The athlete's age.
	 */
	public void setAge(int newAge)
		throws IndexOutOfBoundsException
	{
		Utilities.validateNumberInRange(newAge, 0, 300);
		
		_age = newAge;
	}
	
	/**
	 * Retrieves the contestant ID.
	 * 
	 * @return Returns the contestant ID.
	 */
	public int getContestantID()
	{
		return _contestantID;
	}
	
	/**
	 * Sets the contestant ID.
	 * 
	 * @param newContestantID	The contestant ID of the athlete. 
	 */
	public void setContestantID(int newContestantID)
	{
		Utilities.validateNumberInRange(newContestantID, 1, 100000);
		
		_contestantID = newContestantID;
	}
	
	/**
	 * Gets the injury status.
	 * 
	 * @return True if injured otherwise false
	 */
	public boolean getIsInjured()
	{
		return _isInjured;
	}
	
	/**
	 * Sets the injury status of the athlete.
	 * 
	 * @param isInjured		Is the athlete injured?
	 */
	public void setIsInjured(boolean isInjured)
	{
		_isInjured = isInjured;
	}
	
	@Override
	public String toString()
	{
		return String.format("%-10s] Name: %-10s Age: %3d ID: %6d Discipline: %s"
								, getClass().getSimpleName()
								, getName()
								, getAge()
								, getContestantID()
								, performRaceActivity()
								);
	}
	
	/**
	 * Helper method for data persistence. Serializes the athlete to a text string.
	 * 
	 * @return A textual and parseable representation of a {@link RacingAthlete}
	 */
	public String toDataString()
	{
		return String.format("%s|name=%s;age=%d;contestantID=%d;isInjured=%b"
								, getClass().getSimpleName().toUpperCase()
								, getName()
								, getAge()
								, getContestantID()
								, getIsInjured()
								);
	}
}
