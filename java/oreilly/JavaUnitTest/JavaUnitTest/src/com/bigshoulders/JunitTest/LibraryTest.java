package com.bigshoulders.JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;


public class LibraryTest {
	private Library library;
	private Book book1, book2,book3;
	@Before
	public void setUp(){
		library = new Library();
		book1=new Book("Dune","Frank Herbert");
		book2=new Book("Solaris","Stanislaw Lem");
		book3=new Book("Jimmy Carter Bio","Jimmy Carter");
		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
		
	}
	@After
	public void tearDown(){
		
	}

	

	@Test
	public void testGetBooks() {
		
		Book book = library.getBooksByTitle("Dune");
		BookTest.assertEquals(book1, book);
		//assertTrue("Dune not gotten",book.getTitle().equals("Dune"));
		book=library.getBooksByTitle("Solaris");
		BookTest.assertEquals(book2, book);
		//assertTrue("Solaris not gotten",book.getTitle().equals("Solaris"));

		
	}
	@Test 
	public void testGetBooksByTitle(){
		assertEquals("Jimmy Carter Fail","Jimmy Carter Bio",book3.getTitle());
		assertEquals("Dune fails","Dune", library.getBooksByTitle("Dune").getTitle());
		//assertEquals("Jimmy Carter Should Fail!","James Carter",library.getBooksByTitle("Jimmy Carter Bio").getTitle());
	}
	@Test
	public void testLibrarySize(){
		assertTrue(library.getNumBooks() ==3);
	}
	@Test
	public void testRemoveBook(){
		try{
		library.removeBook("Dune");
		Book book = library.getBooksByTitle("Dune");
		assertTrue("book is not removed",book== null);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	@Ignore
	public void testRemoveNonexistentBook(){
		try {
			library.removeBook("Nonexistent");
			
		} catch (Exception e) {
			// TODO: handle exception
			fail(e.getMessage());
		}
	}
	

}
