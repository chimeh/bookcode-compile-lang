import java.applet.Applet;
import java.awt.*;

public class ArrayTest extends Applet {
  Color [] colorArray = new Color[9];
  
  public void generateColors() {
    colorArray[1] = Color.blue;
    colorArray[2] = Color.green;
    colorArray[3] = Color.orange;
    colorArray[4] = Color.gray;
    colorArray[5] = Color.pink;
    colorArray[6] = Color.black;
    colorArray[7] = Color.white;
    colorArray[8] = Color.red;
  }
  
  public void init() {
    resize(200,100);
    generateColors();
  }
  
  public void paint(Graphics g) {
    for(int x = 1; x < colorArray.length; x++) {
      g.setColor(colorArray[x]);
      if(x<=4)
        g.fillRect(x*30, 30, 30, 30 );
      else
        g.fillRect((x*30)-120, 60, 30, 30 );
      
    }
  }
  
}
