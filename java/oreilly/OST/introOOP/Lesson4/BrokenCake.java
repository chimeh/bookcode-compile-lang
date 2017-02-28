import java.awt.*;

public class BrokenCake {
	
	int topLocation;
	int leftLocation;
	String cakeFlavor;
	String lostVariable;
	
	public BrokenCake(int top, int left) {
		topLocation = top;
		leftLocation = left;
		cakeFlavor = "";
	}
	
	public BrokenCake(int top, int left, String flavor) {
		lostVariable = "WONDERFUL";
		topLocation = top;
		leftLocation = left;
		cakeFlavor = flavor;
	}
	
	public void frostCake(Color myColor, Graphics g) {
		g.setColor(myColor);
		g.fillRect(leftLocation, topLocation, 50, 50);
		
		g.setColor(Color.black);
		g.drawString("I am a " + lostVariable + " Cake.", leftLocation + 50, topLocation + 50);
	}
	
}
		