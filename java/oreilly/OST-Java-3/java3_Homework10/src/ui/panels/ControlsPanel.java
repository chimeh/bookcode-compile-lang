package ui.panels;

import java.awt.Panel;
import interfaces.Resettable;
import model.Model;
import ui.panels.ButtonPanel;

public class ControlsPanel extends Panel implements Resettable {
	private ButtonPanel btnPanel;
	
	public ControlsPanel (Model model) {
		btnPanel = new ButtonPanel(model);
		add(btnPanel);
	}
	
	public void resetComponents() {
		
	}
}


