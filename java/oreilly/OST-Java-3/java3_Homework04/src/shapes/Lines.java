package shapes;
import java.awt.Color;

public class Lines extends Shape {
	private int xEnd, yEnd;
	
	// drawLine(int x1, int y1, int x2, int y2)
	public Lines(int x, int y, Color lineColor, int xEnd, int yEnd) {
		super(x, y, lineColor);
		this.xEnd = xEnd;
		this.yEnd = yEnd;
	}
	
	public void draw() {
		
	}

	public int getxEnd() {
		return xEnd;
	}

	public void setxEnd(int xEnd) {
		this.xEnd = xEnd;
	}

	public int getyEnd() {
		return yEnd;
	}

	public void setyEnd(int yEnd) {
		this.yEnd = yEnd;
	}
	
}
