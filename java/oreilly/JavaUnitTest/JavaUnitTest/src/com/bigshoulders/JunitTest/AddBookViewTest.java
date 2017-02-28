package com.bigshoulders.JunitTest;


import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class AddBookViewTest {
	private Library library;
	private AddBook addBook;
	private AddBookView view;
	@Before
	public void setUp() throws Exception {
		library= new Library();
		addBook=new AddBook(library);
		view = new AddBookView(addBook);
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testControlValues(){
		//AddBookView view = new AddBookView(addBook);
		//System.out.println("TitleTest:"+view.getTitle());
		//System.out.println("buttonAddTest"+view.addButton.getText());
		//assertEquals("Add Book", view.getTitle());
		assertEquals("", view.titleField.getText());
		assertEquals("",view.authorField.getText());
		assertEquals("Add",view.addButton.getText());
		assertEquals("Cancel",view.cancelButton.getText());
	}
	@Test
	public void testAddButton(){
		view.titleField.setText("The Dragons of Eden");
		view.authorField.setText("Carl Sagan");
		view.addButton.doClick();
		assertEquals(1, library.getNumBooks());
		
	}

}
