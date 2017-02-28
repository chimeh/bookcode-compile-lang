import java.applet.*;
import java.awt.*;

public class Loops extends Applet {

	public void paint(Graphics g) {
		int leftLocation = 10;
		int topLocation = 10;
		
		for (int count=1; count<=5; count++) {
			g.drawString("the value is " + count, leftLocation+(count*100), topLocation);
		}
		
	}
}