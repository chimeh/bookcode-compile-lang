import java.awt.Graphics;

import javax.swing.WindowConstants;
import javax.swing.JFrame;


public class JarExampleApplication extends JFrame {
  public JarExampleApplication() {
    //Make the X close the application.
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setSize(400, 400);
  }
  
  public void paint(Graphics g) {
    //A good idea to call super.paint() to make sure all components get repainted.
    super.paint(g);
    g.drawString("This Application ran from a jar file", 10, 150);
  }
  
  public static void main(String[] args) {
    JarExampleApplication app = new JarExampleApplication();
    app.setVisible(true);
  }
}
