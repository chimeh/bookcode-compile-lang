import java.applet.Applet;
import java.awt.*;

public class IfStatement extends Applet {
  public void paint (Graphics g) {
    Color instructorColor = Color.blue;
    Color myColor = Color.green;
    
    if (instructorColor == myColor) {
      g.drawString("We like the same color!", 50, 50);
    }
    else {
      g.drawString("Looks like we don't agree.", 50, 90);
    }
  }
}
