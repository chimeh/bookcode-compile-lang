package com.bigshoulders.JUnitInAction;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AddNumbersTest {
	Calculator calculator;
	AddNumbers addNumbers;

	@Before
	public void setUp() throws Exception {
		calculator = new Calculator();
		addNumbers = new AddNumbers(calculator);
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testAdd(){
		assertEquals("AddNumbers fails Add"	, 3.0,addNumbers.addNumbers(1.0,2.0),.1);
		
	}

}
