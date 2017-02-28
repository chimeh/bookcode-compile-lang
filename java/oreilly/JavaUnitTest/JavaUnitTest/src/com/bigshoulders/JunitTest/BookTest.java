package com.bigshoulders.JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;

public class BookTest {
	public void testConstructBook(){
		Book book = new Book("Dune");
		assertTrue(book.getTitle().equals("Dune"));
	}

	@Test
	public void testGetTitle() {
		String title="Jimmy Carter";
		Book book = new Book(title);
		assertTrue(book.getTitle().equals(title));
		
	}
	@Test
	public void testAuthor(){
		String title ="Jimmy Carter Bio";
		String author ="Jimmy Carter";
		Book book = new Book(title,author);
		assertTrue(book.getAuthor().equals(author));
	}
	
	public static void assertEquals(Book expected,Book actual){
		assertTrue(expected.getTitle().equals(actual.getTitle()) && expected.getAuthor().equals(actual.getAuthor()));
		
	}

}
