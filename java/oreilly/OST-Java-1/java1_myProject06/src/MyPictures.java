import java.applet.Applet;
import java.awt.*;

public class MyPictures extends Applet {
	int rint = 0;
	Image action;
	
	public void start() {
		rint = (int)(Math.random()*3);
	}
	
	public void paint(Graphics g) {
		switch (rint) 
		{
			case 0: action= this.bunch(g); break;
			case 1: action= this.rose(g); break;
			case 2: action= this.pink(g); break;
		}
		
		resize(325,330); //Resize the applet window.
		g.drawImage(action, 10, 10, Color.white, this);
	}
	
	public Image bunch(Graphics graph) {
		graph.drawString("A bunch of pretty flowers", 10, 280);
		Image myAction = getImage(getDocumentBase(), "images/flower1.jpg");
		return myAction;
	}
	
	public Image rose(Graphics graph) {
		graph.drawString("A rose", 10, 280);
		Image myAction = getImage(getDocumentBase(), "images/flower2.jpg");	
		return myAction;
	}
	
	public Image pink(Graphics graph) {
		graph.drawString("A pretty pink flower", 10, 280);
		Image myAction = getImage(getDocumentBase(), "images/flower3.jpg");
		return myAction;
	}
}

