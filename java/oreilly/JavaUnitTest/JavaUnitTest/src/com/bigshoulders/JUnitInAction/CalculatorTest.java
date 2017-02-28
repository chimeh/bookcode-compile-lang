package com.bigshoulders.JUnitInAction;

import junit.framework.TestSuite;

import  org.junit.Test;
import static org.junit.Assert.*;
public class CalculatorTest {
	@Test
	public void testAdd(){
		Calculator calculator = new Calculator();
		assertEquals("Fails 1+2",3.2,calculator.add(1.0, 2.0),.5);
	}
	

}
