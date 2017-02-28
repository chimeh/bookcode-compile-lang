import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Craps extends Applet implements ActionListener{
  private Button die1, die2;
  private int value1 = 0, value2 = 0;
  
  public void init() {
    die1 = new Button("Die1");
    add(die1);
    die1.addActionListener(this);
  
    die2 = new Button("Die2");
    add(die2);
    die2.addActionListener(this);
  }
  
  public void paint(Graphics g) {
    int total;
    total = value1 + value2;
    g.drawString("Die 1 is " + value1 + "    Die 2 is " + value2, 40, 50);
    g.drawString("Total is " + total, 40, 65);
    if(total==7)
      g.drawString("You won!", 50, 90);
    if((value1 == value2)&&(value1 !=0))
      g.drawString("You won again!", 50, 100);
    if((total==2) || (total==7))
      g.drawString("You won in yet another way!" , 50, 110);
  }
  
  public void actionPerformed(ActionEvent event) {
    if(event.getActionCommand().toString() == "Die1")
      value1 = (int)(Math.random()*6) + 1;
    else
      value2 = (int)(Math.random() * 6) + 1;
    repaint();
  }
}
