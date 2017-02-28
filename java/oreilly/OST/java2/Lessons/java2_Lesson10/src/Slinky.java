import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Slinky extends Applet  implements ActionListener {
  private TextField countInput;
  private int howManyCircles = 0;
  
  public void init() {
    
    Label l = new Label("How many circles?");
    add(l);
    
    countInput = new TextField(3);
    add(countInput);
    countInput.addActionListener(this);
    
    Button reset = new Button("Reset");
    add(reset);
    reset.addActionListener(this);
  }
  
  public void paint(Graphics g) {
    int x = 20, y = 20;
    int count = 1;
    do {
      g.drawOval(x+count*5, y+count*5, 50, 50);
      count++;
    }while(count<= howManyCircles);
  }
  
  public void actionPerformed(ActionEvent event) {
    if(event.getSource() instanceof Button) {
      howManyCircles = 0;
      countInput.setText("");
    }
    else if (event.getSource() instanceof TextField) {
      if(countInput.getText().length() == 0)
        howManyCircles = 0;
      else
        howManyCircles = Integer.parseInt(countInput.getText());
        repaint();
    }
  }
}
