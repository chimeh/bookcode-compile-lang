/**
 * 
 */
package at.markusegger.RaceManagerObjects;

/**
 * Exception raised when an athlete becomes injured during a race.
 * 
 * @author MarkusME
 *
 */
public final class AthleteInjuredException extends RuntimeException
{
	/**
	 * Serialisation version as required by the Java framework.
	 */
	private static final long serialVersionUID = -2067839248708418459L;

	/**
	 * Default parameterless constructor.
	 */
	public AthleteInjuredException()
	{
		super("The athlete was unable to complete the race due to injury.");
	}

	/**
	 * Constructor with configurable message.
	 * 
	 * @param message	The exception message
	 */
	public AthleteInjuredException(String message)
	{
		super(message);
	}
}
