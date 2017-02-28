import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class MyFirstDuke extends Applet {
	public void paint(Graphics graph) {
		Image action = getImage(getDocumentBase(), "images/duke/dukeWave.gif");
		graph.drawImage(action, 10, 10, Color.white, this);
		
		graph.drawString("I am a waving duke", 10, 130);
	}
}
