import java.applet.*;
import java.awt.*;

public class Lab12 extends Applet {
	
	public String[] names = {"Mom","Dad","Amy","Josh","Ally"};
	
	public void paint(Graphics g) {
	
		for (int i=0; i < names.length; i++){
			g.drawString(names[i], 10, 20 * i + 10); 
		}
	}
	
}