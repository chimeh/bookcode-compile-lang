import java.applet.Applet;
import java.awt.Graphics;

public class JarExampleApplet extends Applet {
  public void paint(Graphics g) {
    g.drawString("This Applet was read from a .jar file", 0, 25);
  }
}
