import java.applet.*;
import java.awt.*;

public class ImageMaker extends Applet {
  
  PinImages demo;
  
  public void init() {
    setBackground(Color.black);
    demo = new PinImages();
  }
  
  public void paint(Graphics g) {
    demo.drawHeart(g, Color.pink, 10, 10, 25);
    demo.upArrow(g, Color.orange, 10, 70, 30);
    
    // an example Pin using a PinImage shape
    g.setColor(Color.red);
    g.fillOval(100, 100, 80, 80);
    g.setColor(Color.white);
    g.drawString("I", 135, 120);
    demo.drawHeart(g, Color.pink, 125, 125, 25);
    g.setColor(Color.white);
    g.drawString("Duke!", 125, 170);
  }
  
}
