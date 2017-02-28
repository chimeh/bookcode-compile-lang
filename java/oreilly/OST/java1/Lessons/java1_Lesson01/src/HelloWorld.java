import java.applet.Applet;
import java.awt.Graphics;

public class HelloWorld extends Applet{
  public void paint(Graphics g) {
    g.drawRect(0,0,getSize().width-50, getSize().height-100);
    g.drawString("I'm not really impressed yet", 5, 15);
    
  }

}
