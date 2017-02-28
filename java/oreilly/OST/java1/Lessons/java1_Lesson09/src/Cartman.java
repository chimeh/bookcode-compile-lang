import java.awt.*;

public class Cartman {

  Graphics g; // make the Graphics area an instance variable so the methods can use it
  
  public Cartman(Graphics graph) { // the class Constructor
    this.g = graph; // give the graph instance to the Instance Variable we named g
  }
  
  public void drawMe() {
    
    g.setColor(Color.PINK);     //Cartman's face
    g.fillOval(10, 30, 180, 150);
    
    g.setColor(Color.white);      //Carman's eyes
    g.fillOval(50,66,35,53);
    g.fillOval(78, 66, 35, 53);
    
    g.setColor(Color.black); //Cartman's mouth
    int [] xValues = {56,89,109};
    int [] yValues = {140,150,140};
    Polygon shapeThing = new Polygon(xValues, yValues, 3);
    g.fillPolygon(shapeThing);
    
    
  } // end drawMe method
}  // end Cartman class
