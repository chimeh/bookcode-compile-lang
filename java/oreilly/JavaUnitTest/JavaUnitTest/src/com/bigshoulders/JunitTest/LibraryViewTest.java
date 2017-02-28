package com.bigshoulders.JunitTest;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryViewTest {
	LibraryView libView;
	Library library;

	@Before
	public void setUp() throws Exception {
		library = new Library();
		 libView = new LibraryView(library);

	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testControls(){
		assertEquals("Title failed","Library",libView.getTitle());
		assertEquals("MenuName failed","Menu",libView.menu.getText());
		assertEquals("MenuItem failed","Find a Book",libView.menuItem.getText());
		
	}
	@Test
	public void testFindABook(){
		libView.menuItem.doClick();
		
		
	}

}
