package prodcons;

import java.applet.Applet;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyTableSetting extends Applet {
  Soup s;
  Producer p, p2;
  Consumer c, c2;
  MyTableSetting thisTable = this;
  int bowlLength = 150;
  int bowlWidth = 220;
  int bowlX = 60;
  int bowlY = 10;
  
  public void init() {
    s = new Soup();
    c = new Consumer(this, s);
    p = new Producer(this, s);
    Button start = new Button("Start");
    Button stop = new Button("Stop");
    Panel bottom = new Panel();
    
    setSize(400,250);
    setLayout(new BorderLayout());
    bottom.add(stop);
    bottom.add(start);
    add("South", bottom);
    
    p.start();
    c.start();
    
    stop.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        s.emptyBuffer();
        
        if(c.getState() == Thread.State.RUNNABLE) {
          c.stopThread();   
          p.stopThread();
          repaint();
        }       
      }
    });
    
    start.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
       p = new Producer(thisTable, s);
       c = new Consumer(thisTable, s);
       
       p.start();
       c.start();
      }
    });
    
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
    
    ArrayList <String> contents = s.getContents();
    for(String each : contents) {
      x = bowlX + bowlWidth/4 + (int)(Math.random()*(bowlWidth/2));
      y = bowlY + bowlLength/4 + (int)(Math.random()*(bowlLength/2));
      Font bigFont = new Font("Helvetica", Font.BOLD, 20);
      g.setFont(bigFont);
      g.drawString(each, x, y);
    }
    
  }
  
  
}
