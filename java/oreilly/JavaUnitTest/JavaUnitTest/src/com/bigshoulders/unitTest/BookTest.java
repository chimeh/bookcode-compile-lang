package com.bigshoulders.unitTest;

public class BookTest extends UnitTest {

	@Override
	public void runTest() throws Exception {
		// TODO Auto-generated method stub
		Book book = new Book("Dune");
		
		assertTrue(book.getTitle().equals("Dune"),"checking title");

	}

}
