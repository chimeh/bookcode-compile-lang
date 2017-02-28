package com.bigshoulders.JunitTest;

public class CreateFindABook {
	
		/**
		 * @param args
		 */
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			CreateFindABook create = new CreateFindABook();

		}
		public CreateFindABook(){
			Library library = new Library();
			FindABook findABook = new FindABook(library);
			AddBook addBook = new AddBook(library);
			addBook.add("Dragon's Tale", "Noone Famous");
			addBook.add("Jimmy Carter","Jimmy Carter");
			System.out.println("Printing all Books");
			library.printAllTitles();
			System.out.println("Print Number of Books"+library.getNumBooks());
			
			FindABookView view = new FindABookView(library);
			
		}

	}



