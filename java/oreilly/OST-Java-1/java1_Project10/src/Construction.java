import java.applet.Applet;
import java.awt.Graphics;

public class Construction extends Applet {
	public void init() {
		resize(450,280);
	}
	
	private void drawTriangle(Graphics g, int bottomX, int bottomY, int base, int height) {
		g.drawLine(bottomX, bottomY, bottomX+base, bottomY);
		g.drawLine(bottomX+base, bottomY, bottomX+base/2, bottomY-height);
		g.drawLine(bottomX+base/2, bottomY-height, bottomX, bottomY);
	}
	
	private void drawHouse(Graphics g, int bottomX, int bottomY, int base, int height) {
		//call drawTriangle and other Graphics methods
		this.drawTriangle(g, bottomX, bottomY, base, height);
		g.drawRect(bottomX, bottomY, base, height);
	}
	
	public void paint(Graphics g) {
		//three calls to a method named drawHouse
		this.drawHouse(g, 30, 120, 80, 60);
		this.drawHouse(g, 170, 120, 80, 60);
		this.drawHouse(g, 300, 120, 80, 60);
	}
}
