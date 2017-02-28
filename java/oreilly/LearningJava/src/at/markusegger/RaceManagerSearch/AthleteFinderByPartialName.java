/**
 * 
 */
package at.markusegger.RaceManagerSearch;

import at.markusegger.RaceManagerObjects.RacingAthlete;

/**
 * Athlete search strategy: Match by partial name.
 * 
 * @author MarkusME
 *
 */
public class AthleteFinderByPartialName implements AthleteFinder
{
	final private String _searchPhrase;
	final private String _pattern;
	
	/**
	 * Default parameterless constructor.
	 */
	public AthleteFinderByPartialName(String searchPhrase)
	{
		_searchPhrase = searchPhrase;
	
		_pattern = String.format("(?i).*%s.*", _searchPhrase);
	}

	/* (non-Javadoc)
	 * @see at.markusegger.RaceManagerSearch.AthleteFinder#searchForAthlete(at.markusegger.RaceManagerObjects.RacingAthlete)
	 */
	@Override
	public boolean searchForAthlete(RacingAthlete athlete)
	{
		
		return athlete.getName().matches(_pattern);
	}
}
