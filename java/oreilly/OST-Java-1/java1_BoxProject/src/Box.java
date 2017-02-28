import java.awt.Color;
import java.awt.Graphics;

public class Box {
	private int upperLeftX = 100;
	private int upperLeftY = 100;
	private int height = 200;
	private int width = 200;
	private Color boxColor = Color.green;
	
	public Box(int upperX, int upperY, int h, int w, Color myColor) {
		upperLeftX = upperX;
		upperLeftY = upperY;
		height = h;
		width = w;
		boxColor = myColor;
	}
	
	public void display(Graphics g) {
		g.drawRect(upperLeftX, upperLeftY, width, height);
		g.setColor(boxColor);  
		g.fillRect(upperLeftX, upperLeftY, width, height);
	}
	
	public int getUpperLeftX() {
		return upperLeftX;
	}
	public void setUpperLeftX(int upperLeftX) {
		this.upperLeftX = upperLeftX;
	}
	public int getUpperLeftY() {
		return upperLeftY;
	}
	public void setUpperLeftY(int upperLeftY) {
		this.upperLeftY = upperLeftY;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public Color getBoxColor() {
		return boxColor;
	}
	public void setBoxColor(Color boxColor) {
		this.boxColor = boxColor;
	}
	
}
