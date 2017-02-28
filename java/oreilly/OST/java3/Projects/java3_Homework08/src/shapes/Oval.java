package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Oval extends Rectangle {
  
  public Oval(int x, int y, int w, int h, Color lineColor, Color fillColor, boolean fill) {
    super(x, y, w, h, lineColor, fillColor, fill);
  }
  
  public void draw(Graphics g) {
    //Be nice. Save the state of the object before changing it.
    Color oldColor = g.getColor();
    if(isFill()) {
      g.setColor(getFillColor());
      g.fillOval(getX(), getY(), getWidth(), getHeight());
    }
    
    g.setColor(getLineColor());
    g.drawOval(getX(), getY(), getWidth(), getHeight());
    g.setColor(oldColor);
  }
  
  public String toString() {
    return "Oval: \n\t x = " + getX() + "\n\ty = " + getY() +
            "\n\tw = " + getWidth() + "\n\th = " + getHeight();
  }
  
}
