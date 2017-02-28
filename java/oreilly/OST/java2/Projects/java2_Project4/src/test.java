import java.applet.Applet;
import java.awt.*;

public class test extends Applet {
String str = "Java is Hot";

public void paint(Graphics g) {
  g.drawString(str.replace("Java", "Ben"), 10, 10);
}
}
