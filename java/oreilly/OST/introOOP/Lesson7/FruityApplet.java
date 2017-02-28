import java.applet.*;
import java.awt.*;
import fruit.*;

public class FruityApplet extends Applet {

	public void paint(Graphics g) {
		AnOrange anOrangeObject = new AnOrange(g);
		Pear aPearObject = new Pear(g);
	}
	
}