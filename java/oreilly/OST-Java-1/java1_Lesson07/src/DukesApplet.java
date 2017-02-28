import java.awt.*;
import java.applet.Applet;

public class DukesApplet extends Applet {
	Dukes myDuke;
	
	public void init() {
		myDuke = new Dukes();
	}
	
	public void paint(Graphics g) {
		String action = "";
		switch ((int)(Math.random()*3)) {
			case 0: action = myDuke.write(); break;
			case 1: action = myDuke.think(); break;
			case 2: action = myDuke.wave(); break;		
		}
		Image myAction = getImage(getDocumentBase(), action);
		g.drawString(myDuke.getAction(), 10, 130);
		g.drawString(myDuke.getMessage(), 10, 145);
		g.drawImage(myAction, 10, 10, Color.white, this);
	}
}
