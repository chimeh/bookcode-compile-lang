import java.applet.Applet;
import java.awt.*;

public class DrawTest extends Applet {
	public void init() {
		setBackground(Color.cyan);
	}
	
	public void paint(Graphics g) {
		Cartman myCartman = new Cartman(g);
		myCartman.drawMe();
	}
}
