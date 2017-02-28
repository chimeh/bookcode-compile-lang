package ui.panels;

import interfaces.Resettable;
import java.awt.GridLayout;
import java.awt.Panel;
import model.Model;

public class MainPanel extends Panel implements Resettable {
	ActionPanel actionPanel;
	ChoicePanel choicePanel;
	
	public MainPanel(Model model) {
		actionPanel = new ActionPanel(model);
		setLayout (new GridLayout(2,1));
		choicePanel = new ChoicePanel(model);     
        add(choicePanel);
		add(actionPanel);
	}
	
	public void resetComponents() {
		actionPanel.resetComponents();
		choicePanel.resetComponents();
	}

}
