package com.bigshoulders.JUnitInAction;

public class AddNumbers {
	Calculator calculator;

	public AddNumbers(Calculator calculator){
		this.calculator = calculator;
		
	}
	public double addNumbers(double number1, double number2){
		return calculator.add(number1, number2);
	}
}
