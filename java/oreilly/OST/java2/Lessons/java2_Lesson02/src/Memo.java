import java.awt.event.*;
import java.awt.*;

public class Memo extends Frame{

  public String message;
  
  public Memo() {
    super("This is a Memo Title");
    message = "This is the content of the Memo";
  }
  
  public void paint(Graphics g) {
    g.drawString(message, 50, 50);
    
    g.drawString("Click anywhere to Exit", 50, 70);
    System.out.println("What's this then?");
  }
  
  public void start() {
    setSize(300,300);
    setVisible(true);
    this.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        setVisible(false);
        dispose(); // free up system resources
        System.exit(0);
      }
    });
    // Quit the app.
  }
  
  public static void main(String[] args) {
    Memo m;
   
    m = new Memo();
    m.start();
  }

}
