import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.*;

public class FrameTest extends Frame {

  
  public FrameTest() {
   super("FrameTest");
  }
 
  public void paint(Graphics g) {
    int num7 = 7;
    int num8 = 8;
    int num9 = 9;
    int num10 = 10;
    int num11 = 11;
    int num12 = 12;
    
    g.drawString("num7 = " + num7, 50, 50);
    g.drawString("num8 = " + num8, 50, 75);
    g.drawString("num9 = " + num9, 50, 100);
    g.drawString("num10 = " + num10, 50, 125);
    g.drawString("num11 = " + num11, 50, 150);
    g.drawString("num12 = " + num12, 50, 175);
    
  }
  
  public void start() {
    setSize(300,300);
    setVisible(true);
    this.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        setVisible(false);
        dispose();
        System.exit(0);
      }
    });
    
  }
  
  public static void main(String[] args) {
    int num1 = 1;
    int num2 = 2;
    int num3 = 3;
    int num4 = 4;
    int num5 = 5;
    int num6 = 6;
    
    System.out.println("num1 = " + num1);
    System.out.println("num2 = " + num2);
    System.out.println("num3 = " + num3);
    System.out.println("num4 = " + num4);
    System.out.println("num5 = " + num5);
    System.out.println("num6 = " + num6);
    
    FrameTest f = new FrameTest();
    f.start();
    
   
  }

}
