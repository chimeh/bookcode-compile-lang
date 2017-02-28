package com.bigshoulders.JUnitInAction;

import org.junit.Test;
import static org.junit.Assert.*;

public class OwnerTest {
	@Test
	public void testValues(){
		Owner owner= new Owner("Dave", "8009 Fierro");
		assertEquals("OwnerName Fails","Dave",owner.getName());
	}
	
	

}
