import java.applet.Applet;
import java.awt.Graphics;

public class MyName extends Applet {
	public void paint(Graphics g) {
		g.drawRect(50, 50, 200, 200);
		g.drawString("Hi!  My name is Kelly.", 55, 75);
		g.drawString("Saw your profile on Linkin.", 55, 100);
		g.drawString("Glad you are my instructor :)", 55, 115);
	}
}
