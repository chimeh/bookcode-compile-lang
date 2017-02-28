import java.awt.*;

public class Cake {

	int topLocation;
	int leftLocation;
	String cakeFlavor;
	
	public Cake(int top, int left) {
		topLocation = top;
		leftLocation = left;
		cakeFlavor = " ";
	}
	
	public Cake(int top, int left, String flavor) {
		topLocation = top;
		leftLocation = left;
		cakeFlavor = flavor;
	}
	
	public void frostCake(Color myColor, Graphics g) {
		g.setColor(myColor);
		g.fillRect(leftLocation, topLocation, 50, 50);
		
		g.setColor(Color.black);
		g.drawString(" I am a " + cakeFlavor + " Cake.", leftLocation + 50, topLocation +50);
	}
}