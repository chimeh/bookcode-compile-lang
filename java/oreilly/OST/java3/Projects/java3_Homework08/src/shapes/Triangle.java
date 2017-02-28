package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends Shape {

  private int width, height;
  private int[] xArray = new int[3];
  private int[] yArray = new int[3];
  private Color fillColor;
  private boolean fill;
  
  public Triangle(int x, int y, int w, int h, Color lineColor, Color fillColor, boolean fill) {
    super(x, y, lineColor);
    this.width = w;
    this.height = h;
    this.fillColor = fillColor;
    this.fill = fill;
  }
  
  public void draw(Graphics g) {
   
    xArray [0]= getX(); 
    xArray [1] = getX() + getWidth();
    xArray [2] = getX(); 
    
    yArray [0]= getY(); 
    yArray [1] = getY() + getHeight();
    yArray [2] = getY() + getHeight();
    
    Color oldColor = g.getColor();
    if(isFill()) {
      g.setColor(getFillColor());
      g.fillPolygon(getxArray(), getyArray(), 3);
    }
    g.setColor(getLineColor());
    g.drawPolygon(getxArray(), getyArray(), 3);
    g.setColor(oldColor);

  }
  
  public boolean containsLocation(int x, int y) {
    if (getX() <= x && getY() <= y && getX() + getWidth() >= x && getY() + getHeight() >=y) {
      return true;
    }
    return false;
  }
  
  public String toString() {
    return "Triangle: \n\t x = " + getX() + "\n\ty = " + getY() +
            "\n\tw = " + getWidth() + "\n\th = " + getHeight();
  }

  public Color getFillColor() {
    return fillColor;
  }

  public void setFillColor(Color fillColor) {
    this.fillColor = fillColor;
  }

  public boolean isFill() {
    return fill;
  }

  public void setFill(boolean fill) {
    this.fill = fill;
  }

  public int[] getxArray() {
    return xArray;
  }

  public void setxArray(int[] xArray) {
    this.xArray = xArray;
  }

  public int[] getyArray() {
    return yArray;
  }

  public void setyArray(int[] yArray) {
    this.yArray = yArray;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  
  
}
