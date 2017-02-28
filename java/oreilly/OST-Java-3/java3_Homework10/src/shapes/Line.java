package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {
	private int x2, y2;
	
	public Line(int x1, int y1, int x2, int y2, Color lineColor) {
		super(x1, y1, lineColor);
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public void draw(Graphics g) {
		Color oldColor = g.getColor();
		g.setColor(getLineColor());
		g.drawLine(getX(), getY(), getX2(), getY2());
		g.setColor(oldColor);
	}
	
	public boolean containsLocation(int x, int y) {
		if (x <= x && y <= y) {
			return true;
		}
		return false;
	} 
	
	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public String toString() {
		/* return "Line: \n\tx1 = " + getX() + "\n\ty1 = " + getY() +
				"\n\tx2 = " + getX2() + "\n\ty2 = " + getY2() +
				"\n\tline color = " + getLineColor(); */
		return "Line";
	} 
	
}
