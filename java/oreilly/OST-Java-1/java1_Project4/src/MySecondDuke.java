import java.applet.Applet;
import java.awt.*;

public class MySecondDuke extends Applet {
	public void init(){
		setBackground(Color.green);
	}
	
	public void paint(Graphics graph) {
		Image action = think(graph);
		//get the action image for Duke
		graph.drawImage(action, 10, 10, Color.white, this);
	}
	
	public Image think(Graphics graph){
		graph.drawString("I am a waving Duke", 10, 130);
		Image myAction = getImage(getDocumentBase(), "../../images/duke/dukeWave.gif");
		return myAction;
	}
}
