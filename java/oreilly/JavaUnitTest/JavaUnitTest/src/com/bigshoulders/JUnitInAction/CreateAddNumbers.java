package com.bigshoulders.JUnitInAction;

public class CreateAddNumbers {

	/**
	 * @param args
	 */
	AddNumbersView addNumbersView;
	AddNumbers addNumbers;
	Calculator calculator= new Calculator();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreateAddNumbers can= new CreateAddNumbers();
		

	}
	public CreateAddNumbers(){
		this.calculator= new Calculator();
		this.addNumbers= new AddNumbers(calculator);
		this.addNumbersView= new AddNumbersView(addNumbers);
	}

}
