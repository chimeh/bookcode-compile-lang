package shapes;

import interfaces.ComparableShape;
import java.awt.Color;
import java.awt.Graphics;

public class Oval extends Rectangle implements ComparableShape {
	private int area;

	/*
	 * Constructor for Oval object.
	 */
	public Oval(int x, int y, int w, int h, Color lineColor, Color fillColor,
			boolean fill) {
		super(x, y, w, h, lineColor, fillColor, fill);
		setArea();
	}

	/*
	 * Code to draw Oval object.
	 */
	public void draw(Graphics g) {
		Color oldColor = g.getColor();
		if (isFill()) {
			g.setColor(getFillColor());
			g.fillOval(getX(), getY(), getWidth(), getHeight());
		}
		g.setColor(getLineColor());
		g.drawOval(getX(), getY(), getWidth(), getHeight());
		g.setColor(oldColor);
		setArea();
	}

	private void setArea() {
		int width = getWidth();
		int height = getHeight();
		area = (int) (Math.PI * width * height);
	}

	public int getArea() {
		return area;
	}

	/*
	 * String value of Oval object.
	 */
	public String toString() {
		/*
		 * return "Oval: \n\tx = " + getX() + "\n\ty = " + getY() + "\n\ty" +
		 * getWidth() + "\n\th = " + getHeight();
		 */
		return "Oval";
	}
}
