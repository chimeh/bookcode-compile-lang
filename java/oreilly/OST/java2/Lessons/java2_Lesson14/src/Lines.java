import java.applet.*;
import java.awt.*;

public class Lines extends Applet {

  public void paint(Graphics g) {
    int count;
    for(count=1; count<=12; count++) {
      switch(count % 3) {
        case 0:
          g.setColor(Color.red);
          break;
        case 1:
          g.setColor(Color.blue);
          break;
        case 2:
          g.setColor(Color.green);
          break;
      }
    g.drawLine(10, count*10, 80, count*10);
    }
  }
}
