import java.applet.*;
import java.awt.*;

public class ColorCakeApplet extends Applet {

	ColorCake myCake, hisCake, herCake;
	
	public void init() {
		myCake = new ColorCake(0,0,Color.orange);
		hisCake = new ColorCake(0,75,Color.red);
		herCake = new ColorCake(0,150,Color.blue);
	}
	
	public void paint(Graphics g) {
		
		ColorCake.cakeColor = Color.green;
		myCake.frostCake(g);
		hisCake.frostCake(g);
		herCake.frostCake(g);
	}
	
}