import java.applet.*;
import java.awt.*;

public class Lesson10 extends Applet {
	
	public void paint(Graphics g){
	
	
		float x = 15;
		
		x = x + 5;
		x--;
		x *= 2;
	
		String y = Float.toString(x);
		g.drawString(y, 10, 10);
		
	}
	
}
	
