package ui.panels;

import java.awt.Button;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;

public class ButtonPanel extends Panel {

  private Button btnClear;
  
  public ButtonPanel(final Model model) {
    
    class clearListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
        model.resetComponents();
        model.repaint();
      }
    }
    
    btnClear = new Button("Clear");
    btnClear.addActionListener(new clearListener());
    
    
    add(btnClear);
  }
}

