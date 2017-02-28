package shapes;

import interfaces.ComparableShape;
import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape implements ComparableShape {
	private Color fillColor;
	private int width, height;
	private boolean fill;
	private int area;
	
	public Rectangle(int x, int y, int w, int h, Color lineColor, Color fillColor, boolean fill) {
		super(x, y, lineColor);
		this.width = w;
		this.height = h;
		this.fillColor = fillColor;
		this.fill = fill;
		setArea();
	}
	
	public void draw(Graphics g) {
		Color oldColor = g.getColor();
		if (isFill()) {
			g.setColor(getFillColor());
			g.fillRect(getX(), getY(), getWidth(), getHeight());
		}
		g.setColor(getLineColor());
		g.drawRect(getX(), getY(), getWidth(), getHeight());
		g.setColor(oldColor);
		setArea();
	}
	
	private void setArea() {
		int width = getWidth();
		int height = getHeight();
		area = (int)(width*height);
	}
	
	public int getArea() {
		return area;
	}
	
	public boolean containsLocation(int x, int y) {		
		if ((getX() <= x) && (getY() <= y) && ((getX() + getWidth()) >= x) && ((getY() + getHeight()) >= y)) {
			return true;
		}       
		return false;
	} 

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isFill() {
		return fill;
	}

	public void setFill(boolean fill) {
		this.fill = fill;
	}
	
	 public String toString() {
		/* return "Rectange: \n\tx = " + getX() + "\n\ty = " + getY() +
				"\n\tw = " + getWidth() + "\n\th = " + getHeight() +
				"\n\tline color = " + getLineColor(); */
		 return "Rectangle";
	} 
	
}
