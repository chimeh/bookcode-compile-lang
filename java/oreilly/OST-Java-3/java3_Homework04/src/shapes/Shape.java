package shapes;
import java.awt.Color;

public class Shape {
	private Color lineColor;
	private int x, y;
	
	public Shape(int x, int y, Color lineColor) {
		this.x = x;
		this.y = y;
		this.lineColor = lineColor;
	}
	
	public void removeShape() {
		
	}
	
	public void changeShapeAttributes() {
		
	}

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
