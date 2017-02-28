package shapes;

import java.awt.*;
import interfaces.ComparableShape;

public abstract class Shape implements ComparableShape{

  private int x,y;
  private Color lineColor;
  
  public Shape(int x, int y, Color lineColor) {
    this.x = x;
    this.y = y;
    this.lineColor = lineColor;
  }
  
  // The drawShape method will graphically display the instance of the shape using given parameters
  public abstract void draw(Graphics g);
  
  public abstract boolean containsLocation(int x, int y);
  
  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public Color getLineColor() {
    return lineColor;
  }

  public void setLineColor(Color lineColor) {
    this.lineColor = lineColor;
  }  
  
}
