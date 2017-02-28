package com.bigshoulders.JunitTest;

public class AddBook {
	private Library library;
	public AddBook(Library library){
		this.library = library;
	}
	public void add(String title, String author){
		Book book = new Book(title,author);
		try {
			library.addBook(book);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
