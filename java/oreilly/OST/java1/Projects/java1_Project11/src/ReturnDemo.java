import java.awt.*;
import java.applet.Applet;

public class ReturnDemo extends Applet{
  
  int height = 60;
  int width = 42;
  
  public void paint(Graphics g) {
    g.drawRect(25, 25, width, height);
    g.drawString("area of rectangle is " + areaRectangle(width, height), 25, height +50);
    g.drawString("perimeter of rectangle is " + perimeterRectangle(width, height), 25, height +70);
    g.drawString("rectangle center is (" + centerX(width, height) + "," + centerY(width, height) + ")", 25, height +90);
  }
  
  private int areaRectangle(int width, int height) {
    int area = width * height;
    return area;
  }
  
  private int perimeterRectangle(int width, int height) {
    int perim = (width*2) + (height*2);
    return perim;
  }
  
  private int centerX(int width, int height) {
    int x = (width/2) + 25;
    return x;
  }
  
  private int centerY(int width, int height) {
    int y = (height/2) + 25;
    return y;
  }
}
