package com.bigshoulders.JunitTest;

public class CreateLibView {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreateLibView view = new CreateLibView();

	}
	public CreateLibView(){
		Library library = new Library();
		LibraryView libView = new LibraryView(library);
		
	}

}
