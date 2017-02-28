import java.applet.*;
import java.awt.*;

public class Waitress extends Applet {

	public Food[] myMeal = new Food[3];
	
	public void paint(Graphics g) {
		// instantiate the objects, giving a position and Color
		  //store them in the myMeal array
		  
		myMeal[0] = new Cake(0, 0, Color.yellow);
		myMeal[1] = new Pie(0, 100, Color.blue);
		myMeal[2] = new Donut();
		
		// call the bake() in ALL of the Cake and Pie objects
		for (int x = 0; x < myMeal.length; x++) {
			myMeal[x].bake(g);
		}
		
		g.drawString(myMeal[2].whatAmI(), 125, 125);
		
	}
}