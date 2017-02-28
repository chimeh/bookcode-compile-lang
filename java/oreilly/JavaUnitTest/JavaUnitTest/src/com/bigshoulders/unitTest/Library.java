package com.bigshoulders.unitTest;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private Book book= new Book("null");
	List<Book> library = new ArrayList<Book>();
	public Library(){
		
	}
	public void addBook(Book book){
		library.add(book);
	}
	public Book getBook(String title){
		for(Book book : library){
			if(book.getTitle() == title){
				return book;
			}
			
		}
		return this.book;
	}

}
