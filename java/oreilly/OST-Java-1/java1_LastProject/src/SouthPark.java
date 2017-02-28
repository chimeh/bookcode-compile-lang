import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class SouthPark {
	private String quote = "";
	private Graphics g;
	
	public SouthPark(Graphics graph) {
		this.g = graph;
	}
	
	public String getQuote() {
		return quote;
	}
	
	public void setQuote(String newMessage) {
		quote = newMessage;
	}
	
	public void drawCartman() {
		g.setColor(new Color(255, 229, 204));
		g.fillOval(80, 60, 180, 150);  //Cartman's face
		
		g.setColor(Color.cyan.darker());
		g.fillArc(80, 60, 180, 130, 0, 180);  //Cartman's hat
		
		g.setColor(Color.yellow);
		g.fillRect(80, 115, 180, 10);  //bottom part of hat
		
		g.setColor(Color.yellow); 
		int [] xHat = {146,152,180,192};
		int [] yHat = {50,70,80,60};
		g.fillPolygon(xHat, yHat, 4);  //top of hat
		
		g.setColor(Color.white);
		g.fillOval(145, 126, 35, 53);  //Cartman's eyes
		g.fillOval(173, 126, 35, 53);
		
		g.setColor(Color.black);  //Cartman's eyeballs
		g.fillOval(158, 146, 8, 8);
		g.fillOval(185, 146, 8, 8);
		
		g.setColor(Color.black);  //Cartman's mouth
		int [] xValues = {146,179,199};
		int [] yValues = {190,200,190};

		Polygon shapeThing = new Polygon(xValues, yValues, 3);
		g.fillPolygon(shapeThing);
	}
	
	public void drawStan() {
		g.setColor(new Color(255, 229, 204));
		g.fillOval(90, 60, 160, 150);  //face
		
		g.setColor(new Color(15, 97, 183));
		g.fillArc(90, 60, 160, 130, 0, 180);  //hat
		
		g.setColor(Color.red);
		g.fillRect(90, 115, 160, 10);  //bottom part of hat
		
		g.setColor(Color.red); 
		int [] xHat = {146,152,180,192};
		int [] yHat = {50,70,80,60};
		g.fillPolygon(xHat, yHat, 4);  //top of hat
		
		g.setColor(Color.white);
		g.fillOval(145, 126, 35, 53);  //eyes
		g.fillOval(173, 126, 35, 53);
		
		g.setColor(Color.black);  //eyeballs
		g.fillOval(158, 146, 8, 8);
		g.fillOval(185, 146, 8, 8);
		
		g.setColor(Color.black);  //mouth
		int [] xValues = {146,179,199};
		int [] yValues = {190,200,190};

		Polygon shapeThing = new Polygon(xValues, yValues, 3);
		g.fillPolygon(shapeThing);
	}
	
	public void drawKyle() {
		g.setColor(new Color(255, 229, 204));
		g.fillOval(90, 60, 160, 150);  //face
		
		g.setColor(Color.green);
		g.fillRoundRect(85, 60, 180, 50, 10, 10);  //hat
		
		g.setColor(Color.green);
		g.fillOval(70, 106, 45, 80);  //ear flaps
		g.fillOval(235, 106, 45, 80);
		
		g.setColor(Color.green.darker());
		g.fillRect(95, 85, 160, 35);  //bottom part of hat
		
		g.setColor(Color.white);
		g.fillOval(145, 126, 35, 53);  //eyes
		g.fillOval(173, 126, 35, 53);
		
		g.setColor(Color.black);  //eyeballs
		g.fillOval(158, 146, 8, 8);
		g.fillOval(185, 146, 8, 8);
		
		g.setColor(Color.black);  //mouth
		int [] xValues = {146,179,199};
		int [] yValues = {190,200,190};

		Polygon shapeThing = new Polygon(xValues, yValues, 3);
		g.fillPolygon(shapeThing);
	}
}
