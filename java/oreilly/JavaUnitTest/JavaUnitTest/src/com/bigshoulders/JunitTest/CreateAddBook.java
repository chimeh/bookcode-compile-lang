package com.bigshoulders.JunitTest;

public class CreateAddBook {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreateAddBook create = new CreateAddBook();

	}
	public CreateAddBook(){
		Library library = new Library();
		AddBook addBook = new AddBook(library);
		AddBookView view = new AddBookView(addBook);
		
	}

}
