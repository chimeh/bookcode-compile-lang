import java.applet.Applet;
import java.awt.*;

public class ThreeDukesApplet extends Applet {
	Dukes myDuke, yourDuke, thirdDuke; //three declarations for Duke instances
	String myAction, yourAction, thirdAction; //each will have their own action
	int rint = 0;
	
	public void init() {
		myDuke = new Dukes(); //instantiate first Duke
		rint = (int)(Math.random()*3);
		switch (rint) 
		{
			case 0: myAction = myDuke.wave(); break;
			case 1: myAction = myDuke.think(); break;
			case 2: myAction = myDuke.write(); break;
		}
		
		yourDuke = new Dukes(); //instantiate second Duke
		rint = (int)(Math.random()*3);
		switch (rint) 
		{
			case 0: yourAction = yourDuke.wave(); break;
			case 1: yourAction = yourDuke.think(); break;
			case 2: yourAction = yourDuke.write(); break;
		}
		
		thirdDuke = new Dukes(); //instantiate second Duke
		rint = (int)(Math.random()*3);
		switch (rint) 
		{
			case 0: thirdAction = thirdDuke.wave(); break;
			case 1: thirdAction = thirdDuke.think(); break;
			case 2: thirdAction = thirdDuke.write(); break;
		}
		
		resize(500,200); //resize the applet window so that we can see both dukes
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
		
		Image thirdChoice = getImage(getDocumentBase(), thirdAction); //get and show image for third Duke
		g.drawString(thirdDuke.getAction(), 350, 165);
		g.drawString(thirdDuke.getMessage(), 350, 180);
		g.drawImage(thirdChoice, 350, 50, Color.white, this);
	}
}

