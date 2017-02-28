import java.applet.*;
import java.awt.*;

public class AnotherCakeApplet extends Applet {

	CakeExample myCake;
	
	public void init() {
		myCake = new CakeExample(0,0);
	}
	
	public void paint(Graphics g) {
	
		g.setColor(Color.black);
		g.drawString(myCake.cakeFlavor, 0, 0);
		myCake.frostCake(Color.black, g);
	}
	
}