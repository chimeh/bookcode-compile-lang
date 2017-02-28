import java.applet.Applet;
import java.awt.*;

public class Duke extends Applet {
	int test = 0;
	Image action;
	
	public void paint(Graphics g) {
		switch (test%3) {
			case 0: action= this.write(g); break;
			case 1: action= this.think(g); break;
			case 2: action= this.wave(g); break;
		}
		
		g.drawImage(action, 10, 10, Color.white, this);
		
		test = test + 1;
		// Show that Restart repaints to make a new action
	}
	
	public Image write(Graphics graph) {
		graph.drawString("I am a writing Duke", 10, 130);
		Image myAction = getImage(getDocumentBase(), "../../images/duke/penduke.gif");
		return myAction;
	}
	
	public Image think(Graphics graph) {
		graph.drawString("I am a thinking Duke", 10, 130);
		Image myAction = getImage(getDocumentBase(), "../../images/duke/thinking.gif");	
		return myAction;
	}
	
	public Image wave(Graphics graph) {
		graph.drawString("I am a waving Duke", 10, 130);
		Image myAction = getImage(getDocumentBase(), "../../images/duke/dukeWave.gif");
		return myAction;
	}
}
