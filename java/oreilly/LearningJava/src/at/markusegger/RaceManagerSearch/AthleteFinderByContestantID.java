/**
 * 
 */
package at.markusegger.RaceManagerSearch;

import at.markusegger.RaceManagerObjects.RacingAthlete;

/**
 * Athlete search strategy by contestant ID
 * 
 * @author MarkusME
 *
 */
public class AthleteFinderByContestantID implements AthleteFinder
{
	final private int _searchedID;
	
	/**
	 * Default parameterless constructor.
	 */
	public AthleteFinderByContestantID(int searchedID)
	{
		_searchedID = searchedID;
	}

	/* (non-Javadoc)
	 * @see at.markusegger.RaceManagerSearch.AthleteFinder#searchForAthlete(at.markusegger.RaceManagerObjects.RacingAthlete)
	 */
	@Override
	public boolean searchForAthlete(RacingAthlete athlete)
	{
		return athlete.getContestantID() == _searchedID;
	}
}
