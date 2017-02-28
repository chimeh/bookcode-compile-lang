import java.awt.*;

public class Cake extends Food {

	int topLocation;
	int leftLocation;
	Color myColor;
	
	public Cake(int top, int left, Color thisColor) {
		topLocation = top;
		leftLocation = left;
		myColor = thisColor;
	}
	
	
	public void bake(Graphics g) {
		g.setColor(myColor);
		g.fillRect(leftLocation, topLocation, 50, 50);
		g.setColor(Color.black);
		
	}
	
	public void deliver(Graphics g) {
		bake(g);
	}
		
}