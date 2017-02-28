import java.applet.Applet;
import java.awt.*;

public class DukeProject extends Applet {

    public void paint(Graphics graph) {
        Image action = getImage(getDocumentBase(),"images/duke/dukeWave.gif");
        graph.drawImage(action, 10, 100, Color.white, this);

        graph.drawString("Hi. I am Duke...down below!", 10, 20);
    }      
}
