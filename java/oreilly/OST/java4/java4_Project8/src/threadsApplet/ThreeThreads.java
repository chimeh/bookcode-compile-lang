package threadsApplet;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ThreeThreads extends Applet implements Runnable {

  Thread t1 = new Thread(this);
  Thread t2 = new Thread(this);
  Thread t3 = new Thread(this);
  TextArea textArea1 = new TextArea(10,75);
  TextArea textArea2 = new TextArea(10,75);
  TextArea textArea3 = new TextArea(10,75);
  
  public void init(){
    resize(650,600);
    JFrame mainFrame = new JFrame("Three Threads Applet");
    mainFrame.setLayout(new BorderLayout());
    mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    mainFrame.setPreferredSize(new Dimension(300, 75));
    ButtonPanel bPanel = new ButtonPanel();
    mainFrame.add(bPanel);
    mainFrame.pack();
    mainFrame.setVisible(true);
    add(textArea1);
    add(textArea2);
    add(textArea3);
    
  }
  
  public void run() {
   
  }
  
  private class ButtonPanel extends JPanel {
    public ButtonPanel() {
      JButton threadOneBtn = new JButton("Thread 1");
      JButton threadTwoBtn = new JButton("Thread 2");
      JButton threadThreeBtn = new JButton("Thread 3");
    
      add(threadOneBtn);
      add(threadTwoBtn);
      add(threadThreeBtn);
      
      threadOneBtn.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {
              t1.start();
              textArea1.append("\nThread-1 started at " + new Date().toString());
            for(int i = 0; i < 4; i++) {
              long start = System.currentTimeMillis();
              t1.sleep(2000);
              textArea1.append("\nThread-1 has slept for " + (System.currentTimeMillis() - start) + "ms\nand time is now " + new Date().toString());
            }
            
            }
            catch (IllegalThreadStateException ex) {
              System.out.println("Thread already started");
            }
            catch (InterruptedException ex) {
              ex.printStackTrace();
            }
          
        }
      });
      
      threadTwoBtn.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          try {
            t2.start();
            textArea2.append("\nThread-2 started at " + new Date().toString());
            for(int i = 0; i < 4; i++) {
              long start = System.currentTimeMillis();
              t2.sleep(2000);
              textArea2.append("\nThread-2 has slept for has slept for " + (System.currentTimeMillis() - start) + "ms\nand time is now " + new Date().toString());
            }
          }
          catch (IllegalThreadStateException ex) {
            System.out.println("Thread already started");
          }
          catch (InterruptedException ex) {
            ex.printStackTrace();
          }
        }
      });
      
      threadThreeBtn.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          try {
            t3.start();
            textArea3.append("\nThread-3 started at " + new Date().toString());
            for(int i = 0; i < 4; i++) {
              long start = System.currentTimeMillis();
              t3.sleep(2000);
              textArea3.append("\nThread-3 has slept for has slept for " + (System.currentTimeMillis() - start) + "ms\nand time is now " + new Date().toString());
            }
          }
          catch (IllegalThreadStateException ex) {
            System.out.println("Thread already started");
          }
          catch (InterruptedException ex) {
            ex.printStackTrace();
          }
        }
      });
      
      
    }
  }
  
}
