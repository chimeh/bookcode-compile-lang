import java.applet.Applet;
import java.awt.*;

public class TwoDukesApplet extends Applet {
	Dukes myDuke, yourDuke; //two declarations for Duke instances
	String myAction, yourAction; //each will have their own action
	
	public void init() {
		myDuke = new Dukes(); //instantiate first Duke
		myAction = myDuke.getActionImage(); //his first action
		
		yourDuke = new Dukes(); //instantiate second Duke
		yourAction = yourDuke.think(); //his first action is to think
		
		resize(400,200); //resize the applet window so that we can see both dukes
	}
	
	public void paint(Graphics g) {
		Image myChoice = getImage(getDocumentBase(), myAction); //get and show image for first Duke
		g.drawString(myDuke.getAction(), 10, 165);
		g.drawString(myDuke.getMessage(), 10, 180);
		g.drawImage(myChoice, 20, 50, Color.white, this);
		
		Image yourChoice = getImage(getDocumentBase(), yourAction); //get and show image for first Duke
		g.drawString(yourDuke.getAction(), 200, 165);
		g.drawString(yourDuke.getMessage(), 200, 180);
		g.drawImage(yourChoice, 200, 50, Color.white, this);
	}
}
