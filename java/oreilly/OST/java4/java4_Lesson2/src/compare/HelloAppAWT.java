package compare;

import java.awt.*;
import java.awt.event.*;

public class HelloAppAWT extends Frame {
  public HelloAppAWT() {
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    add(new Label("Hello, world!"));
    pack();
  }
  
  public static void main(String[] args) {
    new HelloAppAWT().setVisible(true);
  }
}
