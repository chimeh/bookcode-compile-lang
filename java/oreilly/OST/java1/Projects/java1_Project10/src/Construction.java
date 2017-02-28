import java.awt.*;
import java.applet.Applet;

public class Construction extends Applet{
  
  public void paint(Graphics g) {
    resize(400,250);
    drawHouse(g, 10,100,100,100);
    drawHouse(g, 110,100,200,100);
    drawHouse(g, 210,100,300,100);
  }
  
  private void drawHouse(Graphics graph, int xLeft, int yLeft, int xRight, int yRight) {
    drawTriangle(graph, xLeft, yLeft, xRight, yRight);
    graph.drawRect(xLeft, yLeft, xRight - xLeft, yLeft);
  }
  
  private void drawTriangle(Graphics graph, int xLeft, int yLeft, int xRight, int yRight) {
    graph.drawLine(xLeft, yLeft, xLeft+50, yLeft - 50);
    graph.drawLine(xRight, yRight, xLeft+50, yLeft - 50);
  }
}
