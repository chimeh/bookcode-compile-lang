import java.applet.*;
import java.awt.*;

public class AnotherCakeApplet extends Applet {

	Cake myCake;
	
	public void init() {
		myCake = new Cake(0,0,"chocolate");
	}
	
	public void paint(Graphics g) {
	
		g.setColor(Color.black);
		g.drawString(myCake.cakeFlavor, 10, 10);
	}
	
}