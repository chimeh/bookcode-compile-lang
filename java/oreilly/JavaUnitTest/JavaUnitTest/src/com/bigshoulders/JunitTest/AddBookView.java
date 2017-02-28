package com.bigshoulders.JunitTest;

import java.awt.Container;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddBookView extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7226989680961122802L;
	protected JTextField titleField;
	protected JTextField authorField;
	protected JButton addButton;
	protected JButton cancelButton;
	protected JPanel panel;
	final private AddBook addBook;
	
	
	public AddBookView(final AddBook addBook){
		 this.addBook= addBook;
		addControls();
		addButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String cmd= e.getActionCommand();
				System.out.println(cmd);
				if(cmd.equals("Add")){
					addBook.add(titleField.getText(), authorField.getText());
				}
				else
					System.out.println("cmd not handled: "+cmd);
				
			}
		});
	}
	private void addControls(){
		final JFrame view = new JFrame("Add Book");
		view.setTitle("Add Book");
		//System.out.println("Title"+view.getTitle());
		panel= new JPanel();
		titleField = new JTextField(40);
		authorField= new JTextField(40);
		addButton = new JButton("Add");
		cancelButton = new JButton("Cancel");
		JLabel authorLabel = new JLabel("Author", Label.RIGHT);
		JLabel titleLabel = new JLabel("Title", Label.RIGHT);
		panel.add(titleLabel);
		panel.add(titleField);
		panel.add(authorLabel);
		panel.add(authorField);
		panel.add(addButton);
		panel.add(cancelButton);
		view.getContentPane().add(panel);
		view.setVisible(true);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
	}

}
