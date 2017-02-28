import java.applet.*;
import java.awt.*;

public class UsingArrays extends Applet {

	public String[] names = {"Debra","Keith","Amy","Josh","Ken","Ron","Jan"};
	
	public void init() {
	}
	
	public void paint(Graphics g) {
		
		for (int x = 0; x < names.length; x++) {
			g.drawString(names[x], 10, 20* x + 10);
		}
	}
}
	