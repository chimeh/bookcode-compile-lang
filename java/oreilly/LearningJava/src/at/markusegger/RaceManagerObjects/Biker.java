/**
 * 
 */
package at.markusegger.RaceManagerObjects;

/**
 * @author MarkusME
 *
 * Biker is another type of athlete.
 */
public class Biker extends RacingAthlete
{
	private boolean _usingClips;
	
	/**
	 * Parameterless constructor
	 */
	public Biker()
	{
		super();
	}
	
	/**
	 * Parameterized constructor.
	 * 
	 * @param name				Athlete's name
	 * @param age				Athlete's age
	 * @param contestantID		Athlete's ID
	 */
	public Biker(String name, int age, int contestantID)
	{
		super(name, age, contestantID);
	}
	
	/* (non-Javadoc)
	 * @see at.markusegger.AthletesBasic.RaceParticipant#performRaceActivity()
	 */
	@Override
	public String performRaceActivity()
	{
		if (getIsInjured())
		{
			throw new AthleteInjuredException("The biker crashed their bike.");
		}
		
		return "Biking";
	}
		
	/**
	 * Getter for using clips property.
	 * 
	 * @return	Does the biker use clips?
	 */
	public boolean getUsingClips()
	{
		return _usingClips;
	}
	
	/**
	 * Setter for clip usage.
	 * 
	 * @param usingClips	Biker is using clips?
	 */
	public void setUsingClips(boolean usingClips)
	{
		_usingClips = usingClips;
	}
	
	/**
	 * Human-readable output of the Biker instance.
	 * 
	 * @return A String describing the Biker instance.
	 */
	@Override
	public String toString()
	{		
		return String.format("%s using clips: %b"
								, super.toString()
								, getUsingClips());
	}
	
	@Override
	public String toDataString()
	{
		return String.format("%s;usingClips=%s"
								, super.toDataString()
								, getUsingClips()
								);
	}
}
