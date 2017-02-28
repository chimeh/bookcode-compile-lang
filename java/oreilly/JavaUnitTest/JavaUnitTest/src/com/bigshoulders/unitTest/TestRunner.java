package com.bigshoulders.unitTest;

public class TestRunner {

	/**
	 * @param args
	 */
	public TestRunner(){
		try {
			UnitTest test = new BookTest();
			test.runTest();
			UnitTest test2= new LibraryTest();
			test2.runTest();
			System.out.println("Success!");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Failure");
			e.printStackTrace();
			
		}
		System.out.println("Num of Successes:"+UnitTest.num_test_success);


	}
	
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestRunner testRunner= new TestRunner();
		
		

}
}
