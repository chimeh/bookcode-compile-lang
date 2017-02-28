package com.bigshoulders.JunitTest;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class AddBookTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testAddBook(){
		System.out.println("StartAddBookTest");
		Library library = new Library();
		AddBook addBook = new AddBook(library);
		addBook.add("The Dragons of Eden","Carl Sagan");
		assertNotNull(library.getBooksByTitle("The Dragons of Eden"));
	}

}
