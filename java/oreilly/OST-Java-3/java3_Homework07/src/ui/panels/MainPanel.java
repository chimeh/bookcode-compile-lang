package ui.panels;

import interfaces.Resettable;
import java.awt.GridLayout;
import java.awt.Panel;
import model.Model;

public class MainPanel extends Panel implements Resettable {
	ActionPanel actionPanel;
	ChoicePanel choicePanel;
	ControlsPanel controlsPanel;
	
	public MainPanel(Model model) {
		actionPanel = new ActionPanel(model);
		controlsPanel = new ControlsPanel(model);
		setLayout (new GridLayout(3,1));
		choicePanel = new ChoicePanel(model);     
        add(choicePanel);
		add(controlsPanel);
		add(actionPanel);
	}
	
	public void resetComponents() {
		actionPanel.resetComponents();
		choicePanel.resetComponents();
		controlsPanel.resetComponents();
	}

}
