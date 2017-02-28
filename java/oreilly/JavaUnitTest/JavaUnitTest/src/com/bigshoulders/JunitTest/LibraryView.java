package com.bigshoulders.JunitTest;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class LibraryView extends JFrame{
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem menuItem;
	FindABookView findABookView;
	AddBookView addBookView;
	 Library library;
	
	public LibraryView(final Library library){
		super("Library");
		 this.library = library;
		
		Container content = this.getContentPane();
		
		final AddBook addBook = new AddBook(library);
		
		menuBar = new JMenuBar();
		menu = new JMenu("Menu");
		menuBar.add(menu);
		menuItem= new JMenuItem("Add a Book");
		menuItem.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("You clicked Add a Book");
				addBookView= new AddBookView(addBook );
				
			}
		});
		menu.add(menuItem);
		menuItem = new JMenuItem("Find a Book");
		menuItem.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("You clicked Find a Book");
				findABookView = new FindABookView(library);
				
			}
		});
		menu.add(menuItem);
		this.setJMenuBar(menuBar);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	
		
		
	}
	private void setControls(){
		
	}

}
