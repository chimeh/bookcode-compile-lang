import java.applet.*;
import java.awt.*;

public class Waitress extends Applet {

	public Food[] myMeal = new Food[2];
	
	public void paint(Graphics g) {
		// instantiate the objects, giving a position and Color
		myMeal[0] = new Cake(0, 0, Color.yellow);
		myMeal[1] = new Pie(0, 100, Color.blue);
		
		// call the bake() in ALL of the Cake and Pie objects
		for (int x = 0; x < myMeal.length; x++) {
			myMeal[x].bake(g);
		}
		
	}
}