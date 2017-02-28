import java.awt.*;
import java.applet.Applet;

public class StructuredDemo extends Applet {
	public void paint(Graphics g) {
		for (int i=1; i<10; i++)
			g.drawString(i + "squared = " + i*i, 10, 15*i);
		g.drawString("Program Completed", 10, 180);
	}
}
