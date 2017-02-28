package com.bigshoulders.unitTest;

public class LibraryTest extends UnitTest {

	@Override
	public void runTest() throws Exception {
		// TODO Auto-generated method stub
		try{
		Library library = new Library();
		Book expectedBook = new Book("Dune");
		Book secondBook = new Book("Envy");
		library.addBook(expectedBook);
		library.addBook(secondBook);

	
		Book actualBook = library.getBook("Envy");
		assertTrue(actualBook.getTitle().equals("Envy"), "Got Book");
		}
		catch(Exception e){
			System.out.println("Failure at libraryTest");
			e.printStackTrace();
		}
		
	}

}
