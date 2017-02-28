package ui.panels;

import interfaces.Resettable;
import java.awt.GridLayout;
import java.awt.Panel;
import model.Model;

public class MainPanel extends Panel implements Resettable {

  ActionPanel actionPanel;
  
  public MainPanel(Model model) {
    actionPanel = new ActionPanel(model);
    setLayout(new GridLayout(2,1));
    add(actionPanel);
  }
  
  public void resetComponents() {
    actionPanel.resetComponents();

  }

}
