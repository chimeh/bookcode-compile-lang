/**
 * 
 */
package at.markusegger.Utilities;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the methods of the Utilities class.
 * 
 * @author MarkusME
 * @version 0.2
 */
public class UtilitiesTest
{
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
	}

	/**
	 * Tests the nullSafeEquals() method.
	 */
	@Test
	public void testNullSafeEquals()
	{
	   Object obj1 = new Object();
	   Object obj2 = new Object();
	   Object obj1ref = obj1;
	   Object objNull = null;
	   
	   String str1 = "Abc";
	   String str2 = "Def";
	   String str3eq1 = "Abc";
	   
	   assertTrue("Equal objects did not compare"
			   		, Utilities.nullSafeEquals(obj1, obj1ref)
			   		);
	   
	   assertFalse("Unequal objects were found equal"
			   		, Utilities.nullSafeEquals(obj1,  obj2)
			   		);
	   
	   assertFalse("Null compare 1 failed"
			   		, Utilities.nullSafeEquals(null, obj1)
			   		);
	   
	   assertFalse("Null compare 2 failed"
			   		, Utilities.nullSafeEquals(obj1, null)
			   		);
	   
	   assertTrue("Two nulls should be equal (1)"
			   		, Utilities.nullSafeEquals(null,  objNull)
			   		);
	   
	   assertTrue("Two nulls should be equal (2)"
			   		, Utilities.nullSafeEquals(objNull,  null)
			   		);
	   
	   assertFalse("Unequal strings should not be equal"
			   		, Utilities.nullSafeEquals(str1, str2)
			   		);
	   
	   assertTrue("Strings with equal contents should be equal"
			   		, Utilities.nullSafeEquals(str1, str3eq1)
			   		);
	}
	
	/**
	 * Test the repeat character method repeatChar().
	 */
	@Test
	public void testRepeatChar()
	{
		char ch1 = 'x';
		int times1 = 7;
		
		String result1 = Utilities.repeatChar(ch1, times1);
		
		assertEquals(String.format("%c's not repeated %d times ", ch1, times1)
				, "xxxxxxx"
				, result1
				);
		
		char ch2 = '*';
		int times2 = 28;
		
		String result2 = Utilities.repeatChar(ch2, times2);
		
		assertEquals(String.format("%c's not repeated %d times ", ch2, times2)
				, "****************************"
				, result2
				);
	}
	
	/**
	 * Test the repeat string method repeatString().
	 */
	@Test
	public void testRepeatString()
	{
		String str1 = "AbA";
		int times1 = 5;
		
		String result1 = Utilities.repeatString(str1, times1);
		
		assertEquals(String.format("'%s' not repeated %d times", str1, times1)
				, "AbAAbAAbAAbAAbA"
				, result1
				);
		
		String str2 = ",-*";
		int times2 = 7;
		
		String result2 = Utilities.repeatString(str2, times2);
		
		assertEquals(String.format("'%s' not repeated %d times", str2, times2)
				, ",-*,-*,-*,-*,-*,-*,-*"
				, result2
				);
	}
	
	/**
	 * Test the repeat character method repeatStar().
	 */
	@Test
	public void testRepeatStar()
	{
		int times1 = 5;
		
		String result1 = Utilities.repeatStar(times1);
		
		assertEquals(String.format("Star not repeated %d times ", times1)
				, "*****"
				, result1
				);
		
		int times2 = 32;
		
		String result2 = Utilities.repeatStar(times2);
		
		assertEquals(String.format("Star not repeated %d times ", times2)
				, "********************************"
				, result2
				);
	}

	/**
	 * Test the repeat character method repeatDash().
	 */
	@Test
	public void testRepeatDash()
	{
		int times1 = 9;
		
		String result1 = Utilities.repeatDash(times1);
		
		assertEquals(String.format("Dash not repeated %d times ", times1)
				, "---------"
				, result1
				);
		
		int times2 = 26;
		
		String result2 = Utilities.repeatDash(times2);
		
		assertEquals(String.format("Dash not repeated %d times ", times2)
				, "--------------------------"
				, result2
				);
	}
	
	/**
	 * Test the repeat character method repeatEqualSign().
	 */
	@Test
	public void testRepeatEqualSign()
	{
		int times1 = 8;
		
		String result1 = Utilities.repeatEqualSign(times1);
		
		assertEquals(String.format("Equal sign not repeated %d times ", times1)
				, "========"
				, result1
				);
		
		int times2 = 27;
		
		String result2 = Utilities.repeatEqualSign(times2);
		
		assertEquals(String.format("Equal sign not repeated %d times ", times2)
				, "==========================="
				, result2
				);
	}
	
	// **************************************************************************************
	
	/**
	 * Test the validateNumberInRange() methods.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testValidateNumberInRange_Int_ThrowsOnLower_2arg()
	{
		Utilities.validateNumberInRange(7, 10, 3728);
	}
	
	/**
	 * Test the validateNumberInRange() methods.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testValidateNumberInRange_Int_ThrowsOnLower_1arg()
	{
		Utilities.validateNumberInRange(-5, 12);
	}
	
	/**
	 * Test the validateNumberInRange() methods.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testValidateNumberInRange_Int_ThrowsOnHigher()
	{
		Utilities.validateNumberInRange(4727, 11, 3728);
	}
	
	/**
	 * Test the validateNumberInRange() methods.
	 */
	@Test
	public void testValidateNumberInRange_Int_DoesntThrowInRange()
	{
		Utilities.validateNumberInRange(2845, 9, 3618);
	}
	
	/**
	 * Test the validateNumberInRange() methods.
	 */
	@Test
	public void testValidateNumberInRange_Int_DoesntThrowOnMIN_VALUE()
	{
		Utilities.validateNumberInRange(Integer.MIN_VALUE, Integer.MIN_VALUE, 3618);
	}
	
	/**
	 * Test the validateNumberInRange() methods.
	 */
	@Test
	public void testValidateNumberInRange_Int_DoesntThrowOnMAX_VALUE()
	{
		Utilities.validateNumberInRange(Integer.MAX_VALUE, 9, Integer.MAX_VALUE);
	}
	
	// **************************************************************************************
	
	/**
	 * Test the validateNumberInRange() methods.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testValidateNumberInRange_Dbl_ThrowsOnLower_2arg()
	{
		Utilities.validateNumberInRange(7.0, 10.0, 3728.0);
	}
	
	/**
	 * Test the validateNumberInRange() methods.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testValidateNumberInRange_Dbl_ThrowsOnLower_1arg()
	{
		Utilities.validateNumberInRange(-5.01, 12.17);
	}
	
	/**
	 * Test the validateNumberInRange() methods.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testValidateNumberInRange_Dbl_ThrowsOnHigher()
	{
		Utilities.validateNumberInRange(4727.713, 11.7, 3728.91);
	}
	
	/**
	 * Test the validateNumberInRange() methods.
	 */
	@Test
	public void testValidateNumberInRange_Dbl_DoesntThrowInRange()
	{
		Utilities.validateNumberInRange(2845.01, 2845.0, 2845.02);
	}
	
	/**
	 * Test the validateNumberInRange() methods.
	 */
	@Test
	public void testValidateNumberInRange_Dbl_DoesntThrowOnMIN_VALUE()
	{
		Utilities.validateNumberInRange(Double.MIN_VALUE, Double.MIN_VALUE, 3618.0);
	}
	
	/**
	 * Test the validateNumberInRange() methods.
	 */
	@Test
	public void testValidateNumberInRange_Dbl_DoesntThrowOnMAX_VALUE()
	{
		Utilities.validateNumberInRange(Double.MAX_VALUE, 9.0, Double.MAX_VALUE);
	}
	
	/**
	 * Test the validateStringNotNullOrEmpty() method.
	 * Case 1: Throws on string is null.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValidateStringNotNullOrEmpty_Throws_OnNull()
	{
		Utilities.validateStringNotNullOrEmpty(null);
	}
	
	/**
	 * Test the validateStringNotNullOrEmpty() method.
	 * Case 2: Throws on empty string.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValidateStringNotNullOrEmpty_Throws_OnEmpty()
	{
		Utilities.validateStringNotNullOrEmpty("");
	}
}
