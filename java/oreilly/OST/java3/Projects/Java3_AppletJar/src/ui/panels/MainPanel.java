package ui.panels;

import interfaces.Resettable;
import java.awt.GridLayout;
import java.awt.Panel;
import model.Model;

public class MainPanel extends Panel implements Resettable {

  ActionPanel actionPanel;
  ControlsPanel controlsPanel;
  
  public MainPanel(Model model) {
    actionPanel = new ActionPanel(model);
    controlsPanel = new ControlsPanel(model);
    
    /*
     * The setLayout method is creating a visual grid containing 2 rows and 1 column. Then the controlsPanel and actionPanel instances are added to the panel.
     */
    setLayout(new GridLayout(2,1));
    add(controlsPanel);
    add(actionPanel);
    
  }
  
  /*
   * When this resetComponents() method is called, it resets the panels to their initial state on loading.
   */
  public void resetComponents() {
    controlsPanel.resetComponents();
    actionPanel.resetComponents();
  }

}
