package shapes;

import java.awt.*;

public abstract class Shape {

  private int x,y;
  private boolean displayShape;
  private Color lineColor;
  
  // The drawShape method will graphically display the instance of the shape using given parameters
  public abstract void drawShape();
  
  // The moveShape method will set the x,y value in the Shape superclass
  // and set the remaining coordinate values in the particular subclass.
  public abstract void moveShape();
  
  // The resizeShape method will need to be implemented by subclasses in
  // order to to allow the x,y start coordinate remain constant and modify subclass variables as needed.
  public abstract void resizeShape();
  
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

  public boolean isDisplayShape() {
    return displayShape;
  }

  public void setDisplayShape(boolean displayShape) {
    this.displayShape = displayShape;
  }
  
  
}
