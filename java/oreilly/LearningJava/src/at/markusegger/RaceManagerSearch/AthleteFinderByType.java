/**
 * 
 */
package at.markusegger.RaceManagerSearch;

import at.markusegger.RaceManagerObjects.RacingAthlete;

/**
 * Athlete search strategy by athlete type
 * 
 * @author MarkusME
 *
 */
public class AthleteFinderByType implements AthleteFinder
{
	final private Class<?> _type;
	
	/**
	 * Default parameterless constructor.
	 */
	public AthleteFinderByType(Class<?> type)
	{
		_type = type;
	}

	/* (non-Javadoc)
	 * @see at.markusegger.RaceManagerSearch.AthleteFinder#searchForAthlete(at.markusegger.RaceManagerObjects.RacingAthlete)
	 */
	@Override
	public boolean searchForAthlete(RacingAthlete athlete)
	{
		return athlete.getClass().equals(_type);
	}
}
