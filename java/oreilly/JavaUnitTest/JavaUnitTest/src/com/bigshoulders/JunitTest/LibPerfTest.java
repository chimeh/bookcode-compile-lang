package com.bigshoulders.JunitTest;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LibPerfTest {
   private Library library;
	@Before
	public void setUp() throws Exception {
		library= new Library();
		for(int i=0; i<100000;i++){
			String title="title"+i;
			String author="author"+i;
			library.addBook(new Book(title,author));
			
		}
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testGetBookPerf(){
		double maxTime=50;
		long startTime=System.currentTimeMillis();
		Book book = library.getBooksByTitle("title99999");
		long endTime=System.currentTimeMillis();
		long time= endTime-startTime;
		assertTrue("too long:"+time+"ms", time<maxTime);
		assertTrue("not 100k books", library.getNumBooks()==100000);
		assertEquals("Title mismatch","title99999", book.getTitle());
	}

}
