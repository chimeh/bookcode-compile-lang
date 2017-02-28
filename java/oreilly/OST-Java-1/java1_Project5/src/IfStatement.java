import java.applet.Applet;
import java.awt.*;

public class IfStatement extends Applet {
	public void paint (Graphics g) {
		Color instructorColor = Color.blue;
		Color myColor = Color.blue;
				
		if (instructorColor == myColor)
		{
			g.drawString("We have the same favorite color!", 10, 20);
		}
		else {
			g.drawString("Our favorite color is different", 10, 20);
		}
	}
}
