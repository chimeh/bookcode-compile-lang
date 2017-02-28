import java.applet.Applet;
import java.awt.*;

public class ArrayTest extends Applet {
	  // Create an instance variable, say colorArray that is an array that will hold 7 Color references.
	  private Color colorArray[];
	  final int START_X = 10;
	  final int START_Y = 10;
	  final int BOX_WIDTH = 30;
	  final int BOX_HEIGHT = 30;
	
	  public void init() {
		  // calls the generateColors() method 
		  generateColors();
		  
		  resize(300,300);
	  }

	  public void paint(Graphics g) {
		  for (int i=0; i < colorArray.length; i++) {
			  g.setColor(colorArray[i]);  
			  g.fillRect(START_X + i * BOX_WIDTH, START_Y + i * BOX_HEIGHT, BOX_WIDTH, BOX_HEIGHT);
		  }
	  }

	  public void generateColors() {
		  colorArray = new Color[7];
		  
		  // fills the colorArray with 7 Color objects of your choice.
		  colorArray[0] = Color.blue;
		  colorArray[1] = Color.cyan;
		  colorArray[2] = Color.orange;
		  colorArray[3] = Color.gray;
		  colorArray[4] = Color.green;
		  colorArray[5] = Color.lightGray;
		  colorArray[6] = Color.magenta;

	  }
}
