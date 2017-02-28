package com.bigshoulders.JunitTest;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FindABookView extends JFrame {
	JTextField titleField;
	JLabel resultsLabel;
	JButton findButton;
	JButton cancelButton;
	JPanel panel;
	FindABook findABook;
	Library library;
	
	public FindABookView(Library library){
		
		super("Find A Book");
			this.library = library;
			findABook = new FindABook(library);
		panel= new JPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 400);
	
		Container content = this.getContentPane();
		
		findButton= new JButton("Find");
		panel.add(findButton,BorderLayout.EAST);
		cancelButton = new JButton("Cancel");
		panel.add(cancelButton);
		titleField= new JTextField("Enter The Title");
		panel.add(titleField);
		JLabel titleLabel = new JLabel("Title");
		panel.add(titleLabel);
		resultsLabel = new JLabel("Results");
		panel.add(resultsLabel);
		findButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String cmd = e.getActionCommand();
				System.out.println("Submitted Text:"+titleField.getText()+":");
				//Book foundBook = findABook.getBookByTitle(titleField.getText());
				String foundBookTitle = findABook.getBookByTitle(titleField.getText()).getTitle();
				String foundBookAuthor = findABook.getBookByTitle(titleField.getText()).getAuthor();
				//String foundBook = library.getBooksByTitle("Jimmy Carter").getTitle();

				//System.out.println("foundbook"+foundBook);

				if (cmd.equals("Find")){
					
						
						resultsLabel.setText(foundBookTitle+","+foundBookAuthor);
					
				}
				else{
					System.out.println("Unsupported Command"+cmd);
				}
				
			}
		});
		content.add(panel);
		this.setVisible(true);
		
		
		
		
		
	}

}
