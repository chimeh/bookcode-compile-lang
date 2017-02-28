package shapes;

import java.awt.Graphics;
import java.awt.Color;

public class Rhombus extends Shape {

  private Color fillColor;
  private int width, height, points;
  private int[] xArray = new int[4];
  private int[] yArray = new int[4];
  private boolean fill;

  public Rhombus(int x, int y, int width, int height, Color lineColor, Color fillColor, boolean fill) {
    super(x, y, lineColor);
    this.width = width;
    this.height = height;
    this.fillColor = fillColor;
    this.fill = fill;
  }
  
  /*
   * The draw() method is obtaining all the needed values to draw the shape and using them draw the shape.
   */

  public void draw(Graphics g) {

    xArray[0] = getX();
    xArray[1] = getX() + getWidth();
    xArray[2] = getX() + getWidth() + (getWidth() / 2);
    xArray[3] = getX() + (getWidth() / 2);

    yArray[0] = getY();
    yArray[1] = getY();
    yArray[2] = getY() + getHeight();
    yArray[3] = getY() + getHeight();

    Color oldColor = g.getColor();
    if (isFill()) {
      g.setColor(getFillColor());
      g.fillPolygon(getxArray(), getyArray(), 4);
    }
    g.setColor(getLineColor());
    g.drawPolygon(getxArray(), getyArray(), 4);
    g.setColor(oldColor);

  }

  public int getArea() {
    int area;

    area = width * height;
    return area;
  }

  /*
   * The containsLocation() method is determining if a x,y coordinate is located within the object created and returning a boolean value
   */
  public boolean containsLocation(int x, int y) {
    if (getX() <= x && getY() <= y && getX() + getWidth() >= x && getY() + getHeight() >= y) {
      return true;
    }
    return false;
  }

  public Color getFillColor() {
    return fillColor;
  }

  public void setFillColor(Color fillColor) {
    this.fillColor = fillColor;
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

  public int getPoints() {
    return points;
  }

  public void setPoints(int points) {
    this.points = points;
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

}
