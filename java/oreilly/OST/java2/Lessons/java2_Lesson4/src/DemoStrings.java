import java.applet.Applet;
import java.awt.*;

public class DemoStrings extends Applet {
  
  public void start() {
    resize(400,200);
  }
  
  public void paint(Graphics g) {
    int y = 15;
    String str = "Java is Hot"; // normal String
    g.drawString(str, 10, y*1);
    
    String java = str.substring(0,6);
      g.drawString("The method subtring - from index 0 to 6 gives: " +java, 10, y*2);
      
      int len = "HotJava".length();
      g.drawString("The length of the string HotJava is: " + len, 10, y*4);
      
      String obj = new String("A String is an Object");
      g.drawString(obj, 10, y*6); // seeing what it prints when it is accessed as the object
      
      String word = "Mississippi";
      g.drawString(word, 10, y*8);
      g.drawString(word.replace('i', 'a'), 10, y*9);
      g.drawString(word.toUpperCase() , 10, y*10);
      
      g.drawString("The original word is still: " + word, 10, y*12);
  }
}
