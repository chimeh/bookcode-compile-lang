package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Oval extends Rectangle {
	//fillOval(int x, int y, int width, int height)
	public Oval(int x, int y, int width, int height, Color lineColor, Color fillColor, boolean fill) {
		super(x, y, width, height, lineColor, fillColor, fill);
	}
	
	public void draw(Graphics g) {
		
	}	
	
	public String toString() {
		return "Oval: x = " + getX() + " y = " + getY() + " w = " + getWidth() + " h = " + getHeight();
	}

}
