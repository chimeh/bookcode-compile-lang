/**
 * 
 */
package at.markusegger.RaceManagerTests;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import at.markusegger.RaceManagerObjects.*;

/**
 * Tests the RacingAthlete class.
 * 
 * @author MarkusME
 * @version 0.8
 */
abstract public class RacingAthleteTest
{
	// Tested Class
	private RacingAthlete defaultAthlete;
	private RacingAthlete specificAthlete;
	
	// Person
	private String _defaultName = "Tony";
	private int _defaultAge = 39;
	protected String _name = "Hugo";
	protected int _age = 97;
	
	// RaceParticipant
	private int _defaultID = 83019;
	protected int _id = 47179;
	
	abstract protected RacingAthlete getDefaultRacingAthlete();
	abstract protected RacingAthlete getSpecificRacingAthlete();
	
	/**
	 * Default parameterless constructor.
	 */
	public RacingAthleteTest()
	{
		defaultAthlete = getDefaultRacingAthlete();
		
		specificAthlete = getSpecificRacingAthlete();
	}
	
	/**
	 * Initial set-up before each test.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception
	{
	}
	
	/**
	 * Clean-up after each test.
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception
	{
	}
	
	/**
	 * Tests the constructors.
	 */
	@Test
	public void testConstructors()
	{
		assertNotNull("Default RacingAthlete is null", defaultAthlete);
		
		assertEquals("Specific RacingAthlete: Name not matching"
						, _name
						, specificAthlete.getName()
						);
		
		assertEquals("Specific RacingAthlete: Age not matching"
						, _age
						, specificAthlete.getAge()
						);
		
		assertEquals("Specific RacingAthlete: Contestant ID not matching"
						, _id
						, specificAthlete.getContestantID()
						);
	}
		
	/**
	 * Person: Test the name setter/getter.
	 */
	@Test
	public void testSetGetName()
	{
		defaultAthlete.setName(_defaultName);
		
		assertEquals("Name is not set properly"
						, _defaultName
						, defaultAthlete.getName()
						);
	}
	
	/**
	 * Person: Test that name throws on null.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetName_Throws_OnNull()
	{
		defaultAthlete.setName(null);
	}
	
	/**
	 * Person: Test that name throws on empty string.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetName_Throws_OnEmpty()
	{
		defaultAthlete.setName("");
	}
	
	/**
	 * Person: Test the age setter/getter.
	 */
	@Test
	public void testSetGetAge()
	{
		defaultAthlete.setAge(_defaultAge);
		
		assertEquals("Age is not set properly"
						, _defaultAge
						, defaultAthlete.getAge()
						);
	}
	
	/**
	 * Person: Test that age is in sensible bounds.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testSetAge_Throws_OnTooLow()
	{
		defaultAthlete.setAge(-1);
	}
	
	/**
	 * Person: Test that age is in sensible bounds.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testSetAge_Throws_OnTooHigh()
	{
		defaultAthlete.setAge(301);
	}
	
	/**
	 * RaceParticipant: Test the contestantID setter/getter.
	 */
	@Test
	public void testSetGetContestantID()
	{
		defaultAthlete.setContestantID(_defaultID);
		
		assertEquals("ID is not set properly"
						, _defaultID
						, defaultAthlete.getContestantID()
						);
	}
	
	/**
	 * RaceParticipant: Test that the contestantID remains in sensible bounds.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testSetContestantID_Throws_OnTooLow()
	{
		// < 1
		defaultAthlete.setContestantID(0);
	}
	
	/**
	 * RaceParticipant: Test that the contestantID remains in sensible bounds.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testSetContestantID_Throws_OnTooHigh()
	{
		// > 100.000
		defaultAthlete.setContestantID(100001);
	}
	
	/**
	 * RaceParticipant: Wrapper to test the (abstract) peformRaceActivity() method.
	 */
	public void testPerformRaceActivity(String expectedActivityName)
	{
		// Make sure the athlete is re-set (not injured)
		defaultAthlete = getDefaultRacingAthlete();
		
		assertEquals("Race activity is not set properly"
						, expectedActivityName
						, defaultAthlete.performRaceActivity()
						);
	}
	
	/**
	 * RaceParticipant: Test the performRaceActivity() method.
	 * To be implemented in subclass using the wrapper.
	 */
	@Test
	abstract public void testPerformRaceActivity();

	/**
	 * Test the injury status getter/setter
	 */
	@Test
	public void testSetGetIsInjured()
	{
		boolean isInjured = true;
		
		defaultAthlete.setIsInjured(isInjured);
		
		assertEquals("Injury state was not set properly"
						, isInjured
						, defaultAthlete.getIsInjured()
						);
	}
	
	/**
	 * Ascertain that performRaceActivity() throws an AthleteInjuredException
	 * when injured.
	 */
	@Test(expected = AthleteInjuredException.class)
	public void testPerformRaceActivity_Throws_OnInjury()
	{
		defaultAthlete.setIsInjured(true);
		
		defaultAthlete.performRaceActivity();
	}
	
	/**
	 * Tests the RacingAthlete.toString() method.
	 */
	@Test
	public void testToString()
	{
		// Preparations
		
		defaultAthlete.setName(_defaultName);
		defaultAthlete.setAge(_defaultAge);
		
		defaultAthlete.setContestantID(_defaultID);
		
		String athleteString = defaultAthlete.toString();
		
		// Class
		
		assertTrue("Does not contain class name"
						, athleteString.contains(defaultAthlete.getClass().getSimpleName())
						);
		
		// Person Interface
				
		assertTrue("Does not contain name"
						, athleteString.contains(_defaultName));
		
		assertTrue("Does not contain age"
						, athleteString.contains(Integer.toString(_defaultAge))
						);
		
		// RaceParticipant Interface
				
		assertTrue("Does not contain ID"
						, athleteString.contains(Integer.toString(_defaultID))
						);
	}
	
	/**
	 * Tests the toDataString() method.
	 */
	@Test
	public void testToDataString()
	{
		String athleteDataString = defaultAthlete.toDataString();
		
		assertTrue("RacingAthlete.toDataString() does not contain name property"
						, athleteDataString.contains("name=")
						);
		
		assertTrue("RacingAthlete.toDataString() does not contain age property"
						, athleteDataString.contains("age=")
						);
		
		assertTrue("RacingAthlete.toDataString() does not contain contestantID property"
						, athleteDataString.contains("contestantID=")
						);
		
		assertTrue("RacingAthlete.toDataString() does not contain isInjured property"
						, athleteDataString.contains("isInjured=")
						);
	}
}
