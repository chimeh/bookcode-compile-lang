package com.bigshoulders.JunitTest;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FindABookViewTest {
	FindABookView view;
	AddBook addBook;
	Library library;
	

	@Before
	public void setUp() throws Exception {
		library= new Library();
		view = new FindABookView(library);
		
		addBook= new AddBook(library);
		addBook.add("The Dragons of Eden", "Carl Sagan");
		addBook.add("Jimmy Carter", "Jimmy Carter");
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testControlValues(){
		assertEquals("Failed Title", "Find A Book", view.getTitle());
		assertEquals("Failed Title","Enter The Title",view.titleField.getText());
		assertEquals("Failed Find Button","Find",view.findButton.getText());
		assertEquals("Failed Cancel Button","Cancel",view.cancelButton.getText());
		assertEquals("Failed Results Label","Results",view.resultsLabel.getText());
		
		
	}
	@Test
	public void testFindButton(){
		System.out.println("FindABookView Test");
		System.out.println("NumBooks:"+library.getNumBooks());
		System.out.println("BookList:");
		library.printAllTitles();
		view.titleField.setText("Jimmy Carter");
		view.findButton.doClick();
		//assertEquals("Failed to Find Correct Title","The Dragons of Eden",view.resultsLabel.getText());
		assertEquals("Failed to Find Correct Title","Jimmy Carter,Jimmy Carter",view.resultsLabel.getText());
		System.out.println("FindABookView Test End");

		
		
	}

}
