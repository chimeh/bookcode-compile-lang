import java.awt.*;

public abstract class Food implements DeliverableItem{

	public Food() {
	
	}
	
	public abstract void bake(Graphics g);
	
	public void deliver(Graphics g) {
		bake(g);
	}
	
}