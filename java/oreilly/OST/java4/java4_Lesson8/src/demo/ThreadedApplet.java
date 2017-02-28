package demo;

import java.applet.Applet;
import java.awt.Graphics;

public class ThreadedApplet extends Applet implements Runnable {

  Thread appletThread;
  String messages[] = {"Hello Thread World!", "I'm doing fine.", "Goodbye for now!"};
  int i = 0;
  
  public void paint(Graphics g) {
    g.drawString(messages[i], 15, 50);
  }
  
  public void run() {
    while(appletThread != null) {
      i = (i+1) % messages.length;
      repaint();
      System.out.println("Hey! I'm still here");
      try {
        appletThread.sleep(5000);
      }catch(InterruptedException e) {}
    }
  }
  
  public void start() {
    if (appletThread == null) {
      appletThread = new Thread(this);
      appletThread.start();
    }
  }
  
  public void stop() {
    appletThread = null;
  }
}
