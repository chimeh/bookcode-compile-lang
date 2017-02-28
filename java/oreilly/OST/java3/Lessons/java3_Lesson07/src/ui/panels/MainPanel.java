package ui.panels;

import interfaces.Resettable;
import java.awt.GridLayout;
import java.awt.Panel;
import model.Model;

public class MainPanel extends Panel implements Resettable {

  ActionPanel actionPanel;
  ShapePanel shapePanel;
  ControlsPanel controlsPanel;
  
  public MainPanel(Model model) {
    actionPanel = new ActionPanel(model);
    shapePanel = new ShapePanel(model);
    controlsPanel = new ControlsPanel(model);
    
    setLayout(new GridLayout(3,1));
    
    add(controlsPanel);
    add(shapePanel);
    add(actionPanel);
    
  }
  
  public void resetComponents() {
    controlsPanel.resetComponents();
    actionPanel.resetComponents();
    shapePanel.resetComponents();

  }

}
