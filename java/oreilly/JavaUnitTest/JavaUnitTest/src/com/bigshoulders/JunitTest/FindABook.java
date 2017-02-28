package com.bigshoulders.JunitTest;

public class FindABook {
	 Library library;
	 
	public FindABook(Library library){
		this.library = library;
		
	}
	
	public Book getBookByTitle(String title){
		return library.getBooksByTitle(title);
		//return new Book(title);
	}

}
