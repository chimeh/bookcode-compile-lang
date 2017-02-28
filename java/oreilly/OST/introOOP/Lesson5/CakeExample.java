import java.awt.*;

public class CakeExample {

	int topLocation;
	int leftLocation;
	public String cakeFlavor;
	
	public CakeExample(int top, int left) {
		topLocation = top;
		leftLocation = left;
		cakeFlavor = "";
	}
	
	public CakeExample(int top, int left, String flavor) {
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