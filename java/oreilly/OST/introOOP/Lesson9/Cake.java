import java.awt.*;

public class Cake {

	int topLocation;
	int leftLocation;
	String theMessage;
	
	public Cake(int top, int left, String msg) {
		topLocation = top;
		leftLocation = left;
		theMessage = msg;
	}
	
	public void frostCake(Color myColor, Graphics g) {
		g.setColor(myColor);
		g.fillRect(leftLocation, topLocation, 100, 50);
		
		g.setColor(Color.black);
		g.drawString(theMessage, leftLocation, topLocation +25);
	}
	
	
	public static String combine(String firstString, String secondString) {
		String combinedString = firstString + secondString;
		return combinedString;
	}
		
}