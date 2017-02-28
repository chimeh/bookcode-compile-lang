import java.awt.*;

public abstract class Food {

	public Food() {
	
	}
	
	public abstract void bake(Graphics g);
	
	public String whatAmI() {
		return "I am a Food";
	}
}