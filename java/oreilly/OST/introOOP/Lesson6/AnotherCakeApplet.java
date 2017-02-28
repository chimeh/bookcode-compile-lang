import java.applet.*;
import java.awt.*;

public class AnotherCakeApplet extends Applet {

//	Cake myCake;
	
	public void init() {
//		myCake = new Cake(0,0);
	}
	
	public void paint(Graphics g) {
		String cakeType = Cake.combine("Angel","Food");
		double x =  Math.sqrt(9);
		String y = Double.toString(x);
		
		g.setColor(Color.black);
		g.drawString(cakeType, 10, 10);
		g.drawString(y, 10, 30);
	}
	
	
	
	
}