import java.applet.Applet;
import java.awt.*;

public class MyPicture extends Applet {
  
  public void init() {
    this.setBackground(Color.lightGray.darker());  
  }
  
  public void paint(Graphics g) {
    g.drawLine(0,0,100,100);
    g.setColor(Color.RED.darker()); // make a red ball
    g.fillOval(45, 15, 40, 40);
    
    g.setColor(Color.green); // a couple of support beams
    g.fillRect(5, 5, 4, 95);
    g.fillRect(65, 65, 4, 35);
    
    g.setColor(Color.black); // a landing strip
    g.drawLine(100, 100, 200, 100);
  }
}
