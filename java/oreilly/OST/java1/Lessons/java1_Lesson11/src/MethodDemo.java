import java.awt.*;
import java.applet.Applet;

public class MethodDemo extends Applet{
  
  public void start() {
    resize(400,200); //make it bigger so we do not have to expand
  }
  
  public void paint(Graphics g) {
    drawHouse(g, 50, 50, 70, 30);
    drawHouse(g, Color.red, 100, 50, 60, 20);
    drawHouse(g, Color.cyan, 150, 100, 160, 50);
  }
  
  private void drawTriangle(Graphics g, int bottomX, int bottomY, int base, int height) {
    int rightX = bottomX + base;
    int topX = bottomX + base/2;
    int topY = bottomY - height;
    
    //easier to read drawLine calls
    g.drawLine(bottomX, bottomY, rightX, bottomY);
    g.drawLine(rightX, bottomY, topX, topY);
    g.drawLine(topX, topY, bottomX, bottomY);
  }
    private void drawHouse(Graphics g, int bottomX, int bottomY, int width, int height) {
      int rightX = bottomX + width;
      int topX = bottomX + width/2;
      int topY = bottomY - height;
      int halfHeight = height/2;
      
      g.drawRect(bottomX, topY, width, height);
      this.drawTriangle(g, bottomX, topY, width, halfHeight);
    }
    
    private void drawHouse(Graphics g, Color paintMe, int bottomX, int bottomY, int width, int height) {
      int topY = bottomY - height;
      drawHouse(g, bottomX, bottomY, width, height);
      g.setColor(paintMe);
      g.fillRect(bottomX, topY, width, height);
    }
}
