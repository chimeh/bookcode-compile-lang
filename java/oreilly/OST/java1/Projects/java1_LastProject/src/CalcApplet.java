import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;

public class CalcApplet extends Applet implements ItemListener, ActionListener{
  Calculator calc = new Calculator(0,0, false);
  Button b;
  Choice operatorList;
  TextField tf1, tf2;
  int num1,num2,answer;
  boolean showAnswer;
 
  public void init() {
   this.setLayout(null);
   resize(500,100);

   b = new Button("Calculate");
   b.setBounds(10, 50, 75, 25);
   b.addActionListener(this);
   add(b);
   
   operatorList = new Choice();
   operatorList.setBounds(10, 12, 100, 25);
   operatorList.add("Select One");
   operatorList.add("Add");
   operatorList.add("Subtract");
   operatorList.add("Multiply");
   operatorList.addItemListener(this);
   add(operatorList);
   
   tf1 = new TextField(); 
   tf2 = new TextField();  
   tf1.setBounds(130, 10, 100, 25);
   tf2.setBounds(250, 10, 100, 25);
   add(tf1); 
   add(tf2); 
   
   
  }
  
  public void paint(Graphics g) {
    if (calc.isReady() == true) {
      g.drawString("Your Answer: " + Integer.toString(calc.getAnswer()), 350, 25);
    }
  }
  
  public void itemStateChanged(ItemEvent e) {
    int which = ((Choice)e.getItemSelectable()).getSelectedIndex();
    
    num1 = Integer.parseInt(tf1.getText());
    num2 = Integer.parseInt(tf2.getText());
    
    switch (which) {
      case 1: calc.setReady(false);calc.setAnswer(Plus.add(num1, num2)); break;
      case 2: calc.setReady(false);calc.setAnswer(Minus.subtract(num1, num2)); break;
      case 3: calc.setReady(false);calc.setAnswer(Multiply.multiply(num1, num2)); break;
    }
    
    repaint();
   }

  public void actionPerformed(ActionEvent e) {
   calc.setReady(true);
   repaint();
  }


 
}
