import java.awt.*;
import java.applet.Applet;

public class ReturnDemo extends Applet {
	int height = 60;
	int width = 42;
	
	public void paint(Graphics g) {
		g.drawRect( 25, 25, width, height); // always gives original upper left corner of (25,25)
		g.drawString("area of rectangle is " + areaRectangle(), 25, 100);
		g.drawString("perimeter of rectangle is " + perimeterRectangle(), 25, 115);
		g.drawString("rectangle center is (" + centerX() + "," + centerY() + ")", 25, 130);
	}
	
	private int areaRectangle() {
		int area = height * width;
		return area;
	}
	
	private int perimeterRectangle() {
		int perimeter = (2*height) + (2*width);
		return perimeter;
	}
	
	private int centerX() {
		int topX = 25;
		int cenX = (width/2) + topX;
		return cenX;
	}
	
	private int centerY() {
		int topY = 25;
		int cenY = (height/2) + topY;
		return cenY;
	}
}
