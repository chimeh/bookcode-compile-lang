import java.awt.*;

public class Bill extends Payment implements DeliverableItem {

	public Bill() { 
		//a constructor that doesn't do anything
	}
	
	public void printItem(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(100, 100, 50, 50);
		g.setColor(Color.black);
		g.drawLine(110, 110, 140, 110);
		g.drawLine(110, 120, 140, 120);
		g.drawLine(110, 110, 140, 130);
	}
	
	public void deliver(Graphics g) {
		printItem(g);
	}

}