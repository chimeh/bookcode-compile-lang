package shapes;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {
	private Color lineColor;
	private int x, y;
	
	public Shape(int x, int y, Color lineColor) {
		this.x = x;
		this.y = y;
		this.lineColor = lineColor;
	}
	
	//All the subclasses would need to draw the shape - but differently in their own way
	public abstract void draw(Graphics g);
	
	//All the subclasses has a toString function - but differently in their own way
	public abstract String toString();
	
	//All the subclasses will have to be able to remove themselves - but differently in their own way
	public abstract void removeShape();
	
	//All the subclasses will have to be able to change line color and/or fill color - but differently in their own way
	public abstract void changeShapeAttributes();
	
	//All the subclasses will have to be able to move - but differently in their own way
	public abstract void move();
	
	//All the subclasses will have to be able to resize - but differently in their own way
	public abstract void resize();

	public Color getLineColor() {
		return lineColor;
	}

	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
