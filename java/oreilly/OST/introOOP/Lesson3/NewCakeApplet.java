import java.applet.*;
import java.awt.*;

public class NewCakeApplet extends Applet {
	
	Cake myCake;
	Cake yourCake;
	Cake anotherCake;
	
	public void init() {
		myCake = new Cake(0,0);
		yourCake = new Cake(100,0);
		anotherCake = new Cake(0,150,"lemon");
	}
	
	public void paint(Graphics g) {
		myCake.frostCake(Color.red, g);
		yourCake.frostCake(Color.blue, g);
		anotherCake.frostCake(Color.yellow,g);
	}
}
	