import java.applet.Applet;
import java.awt.*;


public class TestApplet extends Applet {
  public void paint (Graphics g) {
    
    int myNumber = 0;
    
    if (myNumber == 1) {
        g.drawString("My number matches",10,20);
    }
    else {
        g.drawString("My number doesn't match", 10, 20);
    }
  }
}
