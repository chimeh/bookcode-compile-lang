import java.applet.Applet;
import java.awt.*;
import java.text.DecimalFormat;

public class NumberDemo extends Applet {
  
  public void start() {
    resize(300,200);
  }
  public void paint(Graphics g) {
    DecimalFormat myFormat1 = new DecimalFormat("###,###.##");
    DecimalFormat myFormat2 = new DecimalFormat("###,###");
    DecimalFormat df1 = new DecimalFormat("###.00");
    
    double area;
    double radius = 12;
    double amountOwed = 12.00;
    
    g.drawString("Area of a circle = (radius)^2*Pi", 10, 20);
    g.drawString("If radius = " + radius, 10, 40);
    g.drawString("The circle's area = " + myFormat1.format(Math.pow(radius, 2)*Math.PI), 10, 70);
    g.drawString("An alertnate formatting without decimals", 10, 95);
    g.drawString("The circle's area = " + myFormat2.format(Math.pow(radius, 2)*Math.PI), 10, 110);
    g.drawString("The money owed is " + df1.format(amountOwed), 10, 130);
  }
}
