import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NestTest4 extends Applet {

  int x, y;
  Color myColor = Color.red;
  
  public void init() {
    this.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        repaint();
      }
    });
  }

  public void paint(Graphics g) {
    g.setColor(myColor);
    g.fillOval(x, y, 25, 25);
  }
}
