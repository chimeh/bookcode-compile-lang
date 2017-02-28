import java.applet.Applet;
import java.awt.*;

public class Driving extends Applet {
	int age = 15;
	
	public void paint(Graphics g) {
		if (age > 15)
		{
			g.drawString("Congratulations!", 50, 50);
			g.drawString("You may drive", 50, 70);
		}
		if (age <= 15) {
			g.drawString("Wait!", 50, 50);
			g.drawString("You may not drive yet", 50, 70);
		}
		g.drawString("Age is " + age, 50, 90);
	}
}
