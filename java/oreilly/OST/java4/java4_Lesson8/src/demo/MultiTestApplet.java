package demo;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class MultiTestApplet extends Applet implements ActionListener {
  
  TestThread t1, t2, t3;
  
  public void init() {
    Button runUs = new Button("Run Threads");
    add(runUs);
    runUs.addActionListener(this);
    
    t1 = new TestThread("Thread1", (int)(Math.random()*1000));
    t2 = new TestThread("Thread1", (int)(Math.random()*2000));
    t3 = new TestThread("Thread1", (int)(Math.random()*3000));
  }

  public void actionPerformed(ActionEvent e) {
    t1.start();
    t2.start();
    t3.start();
  }
}
