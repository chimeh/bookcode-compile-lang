import java.applet.*;
import java.awt.*;

public class DataTypeConverter extends Applet {

	private int xPosition = 125;
	private String somethingToAdd = "5.12345";
	
	public void paint(Graphics g) {
		float xPositionFloatValue = new Integer(xPosition).floatValue();
		float somethingToAddFloatValue = new Float.valueOf(somethingToAdd);
		float answerFloatValue = somethingToAddFloatValue + xPositionFloatValue;
		
		g.drawString("Before Conversion: " + Integer.toString(xPosition) + " + " + somethingToAdd + " = " + Integer.toString(xPosition) + somethingToAdd, 10, 10);
		
		g.drawString("After Data Conversion: " + Float.toString(xPositionFloatValue) + " + " + Float.toString(somethingToAddFloatValue) + " = " + Float.toString(answerFloatValue), 10, 50);
		
	}
}