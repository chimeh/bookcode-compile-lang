import java.awt.*;
import java.applet.Applet;

public class TriangleClassDemo extends Applet { 
  
  private void drawTriangle(Graphics g, int bottomX, int bottomY, int base, int height) {
    g.drawLine(bottomX, bottomY, bottomX+base, bottomY);
    g.drawLine(bottomX+base, bottomY, bottomX+base/2, bottomY-height);
    g.drawLine(bottomX+base/2, bottomY-height, bottomX, bottomY);
  }
  
  public void paint(Graphics g) {
    this.drawTriangle(g, 80, 120, 100, 110);
    drawTriangle(g, 125, 140, 60, 70);
    // demonstrating we don't really NEED "this"
  }
}
