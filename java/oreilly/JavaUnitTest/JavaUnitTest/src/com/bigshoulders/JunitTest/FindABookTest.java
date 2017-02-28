package com.bigshoulders.JunitTest;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class FindABookTest {
	Library library;
	AddBook addBook;
	FindABook findABook;
	

	@Before
	public void setUp() throws Exception {
		library = new Library();
		addBook = new AddBook(library);
		addBook.add("The Dragons of Eden","Carl Sagan");
		addBook.add("Jimmy Carter Bio", "Jimmy Carter");
		addBook.add("Jimmy Carter", "Jimmy Carter");
		findABook=new FindABook(library);

	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testFindABook(){
		
		Book book = findABook.getBookByTitle("The Dragons of Eden");
		assertEquals("The Dragons of Eden", book.getTitle());
		assertEquals("Jimmy Carter fails","Jimmy Carter",library.getBooksByTitle("Jimmy Carter").getTitle());
		
		
	}
	@Test
	public void testFindABook2(){
		assertEquals("Jimmy Carter Bio fails","Jimmy Carter Bio",library.getBooksByTitle("Jimmy Carter Bio").getTitle());

	}

}
