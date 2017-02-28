/**
 * 
 */
package at.markusegger.RaceManagerObjects;

/**
 * @author MarkusME
 *
 */
public interface RaceParticipant
{
	/**
	 * Retrieves the contestant ID.
	 * @return Returns the contestant ID.
	 */
	int getContestantID();
	
	/**
	 * Sets the contestant ID.
	 * @param newContestantID	The contestant ID of the athlete. 
	 */
	void setContestantID(int newContestantID);
	
	String performRaceActivity();
}
