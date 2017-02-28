import java.awt.*;

public class Pie extends Food {

	int topLocation;
	int leftLocation;
	Color myColor;
	
	public Pie(int top, int left, Color thisColor) {
		topLocation = top;
		leftLocation = left;
		myColor = thisColor;
	}
	
	public void bake(Graphics g) {
		g.setColor(myColor);
		g.fillOval(leftLocation, topLocation, 50, 50);
		g.setColor(Color.black);
	}
	
	public void deliver(Graphics g) {
		bake(g);
	}
	
}