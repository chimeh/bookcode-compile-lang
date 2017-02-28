import java.awt.*;
import java.applet.Applet;

public class ReturnDemo extends Applet {
	public void paint(Graphics g) {
		g.drawString("area of rectangle is " + areaRectangle(30, 40), 20, 20);
	}
	
	private int areaRectangle(int side1, int side2) {
		int area = side1 * side2;
		return area;
	}
}
