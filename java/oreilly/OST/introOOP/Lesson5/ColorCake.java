import java.awt.*;

public class ColorCake {

	int topLocation;
	int leftLocation;
	static Color cakeColor;
	
	public ColorCake(int top, int left, Color fillcolor) {
		topLocation = top;
		leftLocation = left;
		cakeColor = fillcolor;
	}
	
	public void frostCake(Graphics g) {
		g.setColor(cakeColor);
		g.fillRect(leftLocation, topLocation, 50, 50);
		
	}
	
}
	
	