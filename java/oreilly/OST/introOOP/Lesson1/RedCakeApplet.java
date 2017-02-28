import java.applet.*;
import java.awt.*;

public class RedCakeApplet extends CakeApplet {
	
	public void paint(Graphics g) {
		frostCake(Color.red, g);
		g.setColor(Color.black);
		g.drawString("I am a RED cake.",25,25);
	}
}