package prodcons;

import java.applet.Applet;
import java.awt.*;

public class MyTableSetting extends Applet {
  Soup s;
  Producer p1;
  Consumer c1;
  int bowlLength = 150;
  int bowlWidth = 220;
  int bowlX = 60;
  int bowlY = 10;
  String justAte;
  
  public void init() {
    setSize(400,200);
    s = new Soup();
    p1 = new Producer(this, s);
    //System.out.println("Producer is in state " + p1.getState());
    c1 = new Consumer(this, s);
    
    p1.start();
    c1.start();
   //System.out.println("Consumer is in state " + c1.getState());
  }
  
  public void paint(Graphics g) {
    int x;
    int y;
    g.setColor(Color.orange);
    g.fillOval(bowlX, bowlY, bowlLength, bowlLength);
    g.setColor(Color.cyan);
    g.fillOval(10, 25, 40, 55);
    g.fillOval(25, 80, 8, 75);
    g.setColor(Color.black);
    g.drawOval(10, 25, 40, 55);
    g.drawOval(25, 80, 8, 75);
    g.drawOval(bowlX, bowlY, bowlWidth, bowlLength);
    Font standardFont = getFont();
    Font bigFont = new Font("Helvetica", Font.BOLD, 20);
    g.setFont(bigFont);
    if(justAte != null) {
      g.drawString(justAte, 25, 55);
    }
    else {
      g.setFont(standardFont);
      g.drawString("waiting", 13, 55);
      g.setFont(bigFont);
    }
    Object[] contents = s.getContents();
    for(Object each : contents) {
      x = bowlX + bowlWidth / 4 + (int)(Math.random() * (bowlWidth / 2));
      y = bowlY + bowlLength / 4 + (int)(Math.random() * (bowlLength / 2));
      g.drawString((String)each, x, y);
    }
    //System.out.println("Producer is in state " + p1.getState());
    //System.out.println("Consumer is in state " + c1.getState());
    if(c1.getState() == Thread.State.TIMED_WAITING);{
      checkState();
    }
  }
  
  public void recentlyAte(String morsel) {
    justAte = morsel;
  }
  
  public void checkState() {
    try {Thread.sleep(1000);
  }catch(InterruptedException e) {}
    repaint();
  }
}
