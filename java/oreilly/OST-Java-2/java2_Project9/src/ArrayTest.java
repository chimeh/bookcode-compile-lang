import java.applet.Applet;
import java.awt.*;

public class ArrayTest extends Applet {
	  // Create an instance variable, say colorArray that is an array that will hold 8 Color references.
	  private Color colorArray[];
	
	  public void init() {
		  // calls the generateColors() method 
		  generateColors();
		  
		  resize(250,250);
	  }

	  public void paint(Graphics g) {
		  // fills 8 rectangles, each at least 30x30 pixels and each with a different Color from the array.
		  //change the color of the Graphics object before each g.fillRect() method call.
		  g.setColor(colorArray[0]);  
		  g.fillRect(45, 15, 40, 40);
		  
		  g.setColor(colorArray[1]);  
		  g.fillRect(85, 15, 40, 40);
		  
		  g.setColor(colorArray[2]);  
		  g.fillRect(125, 15, 40, 40);
		  
		  g.setColor(colorArray[3]);  
		  g.fillRect(165, 15, 40, 40);
		  
		  g.setColor(colorArray[4]);  
		  g.fillRect(45, 55, 40, 40);
		  
		  g.setColor(colorArray[5]);  
		  g.fillRect(85, 55, 40, 40);
		  
		  g.setColor(colorArray[6]);  
		  g.fillRect(125, 55, 40, 40);
		  
		  g.setColor(colorArray[7]);  
		  g.fillRect(165, 55, 40, 40);
	  }

	  public void generateColors() {
		  colorArray = new Color[8];
		  
		  // fills the colorArray with 8 Color objects of your choice.
		  colorArray[0] = Color.blue;
		  colorArray[1] = Color.cyan;
		  colorArray[2] = Color.darkGray;
		  colorArray[3] = Color.gray;
		  colorArray[4] = Color.green;
		  colorArray[5] = Color.lightGray;
		  colorArray[6] = Color.magenta;
		  colorArray[7] = Color.orange;
	  }
}
