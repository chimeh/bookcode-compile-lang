import java.applet.Applet;
import java.awt.*;

public class ArrayTest extends Applet {
  Color [] colorArray = new Color[9];
  final int START_X = 10;
  final int START_Y = 10;
  final int BOX_WIDTH = 30;
  final int BOX_HEIGHT = 30;
  
  public void generateColors() {
    colorArray[1] = Color.blue;
    colorArray[2] = Color.green;
    colorArray[3] = Color.orange;
    colorArray[4] = Color.gray;
    colorArray[5] = Color.pink;
    colorArray[6] = Color.black;
    colorArray[7] = Color.yellow;
    colorArray[8] = Color.red;
  }
  
  public void init() {
    resize(300,300);
    generateColors();
  }
  
  public void paint(Graphics g) {
    for(int i = 1; i < colorArray.length; i++) {
      g.setColor(colorArray[i]);
      g.fillRect(START_X + i * BOX_WIDTH, START_Y + i *BOX_HEIGHT, BOX_WIDTH, BOX_HEIGHT);
    }
    for(int i = 8; i >=1; i--) {
      g.setColor(colorArray[i]);
      g.fillRect( START_X + i * BOX_WIDTH, 280 - i * BOX_HEIGHT, BOX_WIDTH, BOX_HEIGHT);
    }
  }
  
}
