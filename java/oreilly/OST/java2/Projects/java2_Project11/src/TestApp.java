import java.applet.Applet;
import java.awt.*;

public class TestApp extends Applet{
  
  PhoneBook pb = new PhoneBook();
  
  public void init() {
    resize(300,300);
    
    pb.setName("Ben Orban", 0);
    pb.setNumber("123-456-7890", 0);
    
    pb.setName("Lance Lynn", 5);
    pb.setNumber("555-555-5555", 5);
  }
  
  public void paint(Graphics g) {
    
    g.drawString(pb.toString(), 10, 10);
    
  }
  
}
