package compare;

import javax.swing.*;

public class HelloAppSwing extends JFrame {
  public HelloAppSwing() {
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    add(new JLabel("Hello, world!"));
    pack();
  }
  
  public static void main(String[] args) {
    new HelloAppSwing().setVisible(true);
  }
}
