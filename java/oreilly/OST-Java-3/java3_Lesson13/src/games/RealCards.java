package games;

import javax.swing.*;
import java.awt.*;

class RealCards {
	private ImageIcon image;
	private int x;
	private int y;
	
	public RealCards(ImageIcon image) {
		this.image = image;
	}

	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean contains(int x, int y) {
		return (x > this.x && x < (this.x + getWidth()) &&
				y > this.y && y < (this.y + getHeight()));
	}
	
	public int getWidth() {
		return image.getIconWidth();
	}
	
	public int getHeight() {
		return image.getIconHeight();
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void draw(Graphics g, Component c) {
		image.paintIcon(c, g, this.x, this.y);
	}
}
