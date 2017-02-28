import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.*;

public class FrameTest extends Frame {

  
  public FrameTest() {
   super("FrameTest");
  }
 
  public void paint(Graphics g) {
    byte byte1 = -128;
    short short1 = -32768;
    int integer1 = -2147483648;
    long long1 = -9223372036854775808L;
    char char1 = 'a';
    boolean boolean1 = true;
    float float1 = 1.4e-45f;
    double double1 = 4.9e-324;
    
    g.drawString("byte1 = " + byte1, 50, 50);
    g.drawString("short1 = " + short1 , 50, 75);
    g.drawString("integer1 = " + integer1, 50, 100);
    g.drawString("long1 = " + long1, 50, 125);
    g.drawString("char1 = " + char1, 50, 150);
    g.drawString("boolean1 = " + boolean1, 50, 175);
    g.drawString("float1 = " + float1, 50, 200);
    g.drawString("double1 = " + double1, 50, 225);
    
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
    byte byte2 = 127;
    short short2 = 32767;
    int integer2 = 2147483647;
    long long2 = 9223372036854775807L;
    char char2 = 'z';
    boolean boolean2 = false;
    float float2 = 3.4e38f;
    double double2 = 1.7e308;
    
    System.out.println("byte2 = " + byte2);
    System.out.println("short2 = " + short2);
    System.out.println("integer2 = " + integer2);
    System.out.println("long2 = " + long2);
    System.out.println("char2 = " + char2);
    System.out.println("boolean2 = " + boolean2);
    System.out.println("float2 = " + float2);
    System.out.println("double2 = " + double2);
    
    FrameTest f = new FrameTest();
    f.start();
    
   
  }

}
