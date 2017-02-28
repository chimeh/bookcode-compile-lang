/**
 * 
 */
package at.markusegger.RaceManagerSearch;

import at.markusegger.RaceManagerObjects.RacingAthlete;

/**
 * This interface is the basis for an athlete search
 * strategy pattern.
 * 
 * @author MarkusME
 * @version 1.0
 */
public interface AthleteFinder
{
	boolean searchForAthlete(RacingAthlete athlete);
}
