package at.markusegger.RaceManagerTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import at.markusegger.RaceManagerObjects.*;

/**
 * Tests for the Biker class.
 * 
 * @author MarkusME
 *
 */
public class BikerTest extends RacingAthleteTest
{
	private Biker biker1;
	private String activity = "Biking";
	private boolean usingClips = true;
	
	/**
	 * Set-up before each test case.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		super.setUp();
		
		biker1 = (Biker) getDefaultRacingAthlete();
	}

	/**
	 * Clean-up after each test case.
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception
	{
		biker1 = null;
		
		super.tearDown();
	}

	/**
	 * Test the constructors of the Biker class.
	 */
	@Test
	public void testConstructors()
	{
		super.testConstructors();
				
		//Biker biker2 = new Biker(...);
	}
		
	/**
	 * Tests the performRaceActivity() method.
	 */
	@Override
	public void testPerformRaceActivity()
	{
		super.testPerformRaceActivity(activity);
	}
	
	/**
	 * Tests the setter/getter for usingClips.
	 */
	@Test
	public void testUsingClips()
	{
		biker1.setUsingClips(usingClips);
		
		assertEquals("Using clips setter/getter not working"
						, usingClips
						, biker1.getUsingClips());
	}
	
	/**
	 * Tests the toString() method.
	 */
	@Test
	public void testToString()
	{
		super.testToString();
		
		assertTrue("Biker.toString() does not contain activity"
						, biker1.toString().contains(activity));
		
		assertTrue("Biker.toString() does not contain clips"
						, biker1.toString().contains("clips"));
	}
	
	/**
	 * Tests the toDataString() method.
	 */
	@Test
	public void testToDataString()
	{
		super.testToDataString();
		
		assertTrue("Biker.toDataString() does not contain usingClips property"
						, biker1.toDataString().contains("usingClips="));
	}
	
	@Override
	protected RacingAthlete getDefaultRacingAthlete()
	{
		return new Biker();
	}

	@Override
	protected RacingAthlete getSpecificRacingAthlete()
	{
		return new Biker(_name, _age, _id);
	}
}
