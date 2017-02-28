import java.awt.*;

public class Donut extends Food {

	public Donut() {
	
	}
	
	public void bake(Graphics g) {
		g.setColor(Color.pink);
		g.fillOval(0, 100, 50, 50);
		g.setColor(Color.gray);
		g.fillOval(15, 115, 20, 20);
	}
}



