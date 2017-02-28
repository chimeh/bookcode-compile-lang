package com.bigshoulders.unitTest;

public abstract class UnitTest {
	protected static int num_test_success =0;
	public abstract void runTest() throws Exception;
	public static int getNumSuccess(){
		return num_test_success;
	}
	protected void assertTrue(boolean condition, String msg)
	throws Exception {
		if(!condition) throw new Exception(msg);
		num_test_success++;
		}
	}
	
	


