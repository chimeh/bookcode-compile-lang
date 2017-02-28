import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Craps extends Applet implements ActionListener{
  private Button die;
  private int value1 = 0, value2 = 0;
  
  public void init() {
    die = new Button("Roll");
    add(die);
    die.addActionListener(this);
  }
  
  public void paint(Graphics g) {
    int total;
    total = value1 + value2;
    g.drawString("Die 1 is " + value1 + "    Die 2 is " + value2, 40, 50);
    g.drawString("Total is " + total, 40, 65);
  
    if(total != 2 && total !=4 && total !=0 && total != 8)
      g.drawString("Roll again", 50, 120);
    else {
         if((total == 2)&&(value1==value2))
           g.drawString("Snake Eyes!", 50, 120);
    
         if((total == 4)&&(value1==value2))
           g.drawString("Hard Four!", 50, 120);
         
         if ((total == 4)&&(value1!=value2))
           g.drawString("Roll again", 50, 120);
    
         if(total == 8) {
           if(value1==5||value2==5) 
             g.drawString("Easy eight!", 50, 120);
           if(value1==4&&value2==4)
             g.drawString("Hard eight!", 50, 120);
           if(value1==6 || value2 ==6)
             g.drawString("Roll again", 50, 120);
         }
     }

     
  }
  
  public void actionPerformed(ActionEvent event) {
      value1 = (int)(Math.random()*6) + 1;
      value2 = (int)(Math.random()*6) + 1;    
      repaint();
  }
}
