package com.bigshoulders.JUnitInAction;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import junit.framework.TestSuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AddNumbersViewTest {
	AddNumbersView view;
	Calculator calculator;
	AddNumbers addNumbers;
	JTextField number1;
	JTextField number2;
	JLabel result;
	JButton addButton;
	JButton clearButton;

	@Before
	public void setUp() throws Exception {
		this.calculator=new Calculator();
		this.addNumbers=new AddNumbers(calculator);
		view = new AddNumbersView(addNumbers);
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testValues(){
		assertEquals("Title failed","CalculatorAdd",view.getTitle());
		assertEquals("number1 fails","number1",view.number1.getText());
		assertEquals("number2 fails","number2",view.number2.getText());
		assertEquals("addButton fails","Add",view.addButton.getText());
		assertEquals("clearButton fails","Clear",view.clearButton.getText());
		

	}
	@Test
	public void testAdd(){
		view.number1.setText("1.0");
		view.number2.setText("2.0");
		view.addButton.doClick();
		assertEquals("Add fail 1+2", "3.0",view.result.getText());
	}
	

}
