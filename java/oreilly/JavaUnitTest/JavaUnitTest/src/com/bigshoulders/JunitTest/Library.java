package com.bigshoulders.JunitTest;

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
	
	public Book getBooksByTitle(String title){
		boolean bookFound=false;
		Book bookFoundIt= new Book("Dave","Dave");
		//System.out.println("Lib Title:"+title);
		for(Book book : library){
			//System.out.println("BooksfromLib:"+book.getTitle());
			
			if(book.getTitle().equals(title)){
				bookFound=true;
				System.out.println("Found book!"+book.getTitle());
				
				
				bookFoundIt=book;
				System.out.println("Searched Title"+title);
				System.out.println("BookFound"+bookFoundIt.getTitle());
				//return book;
			}
			/*
			if(book.getTitle() == title){
				bookFound=true;
				bookFoundIt=book;
			}
			*/
			
		}
		if(bookFound){
			//System.out.println("bookFound true, found book");
			return bookFoundIt;
		
		}else{
			System.out.println("no book"+title+":");
		return bookFoundIt;
		}
			
	}
	public int getNumBooks(){
		return library.size();
	}
	public void removeBook(String title) throws Exception {
		
			if( library.remove(getBooksByTitle(title)))
				throw new Exception("Book not Found");	
	}
	public void printAllTitles(){
		for(Book book : library){
			System.out.println("BookLibPrint:"+book.getTitle());
			
		}
	}

}
