package ui.panels;

import interfaces.Resettable;
import java.awt.GridLayout;
import java.awt.Panel;
import model.Model;

public class MainPanel extends Panel implements Resettable {

  ActionPanel actionPanel;
  ShapePanel shapePanel;
  
  public MainPanel(Model model) {
    actionPanel = new ActionPanel(model);
    shapePanel = new ShapePanel(model);
    
    setLayout(new GridLayout(2,1));
    add(shapePanel);
    add(actionPanel);
    
  }
  
  public void resetComponents() {
    actionPanel.resetComponents();
    shapePanel.resetComponents();

  }

}
