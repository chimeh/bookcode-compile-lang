package ui.panels;

import java.awt.Panel;
import java.awt.Choice;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import model.Model;
import interfaces.Resettable;

public class ChoicePanel extends Panel implements Resettable {
	Model model;
	Choice selection;
	
	public ChoicePanel(final Model mdl) {
		model = mdl;
		selection = new Choice();
		for(String msg : Model.selections) {
			selection.add(msg);
		}
		selection.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				model.setCurrentShapeType(selection.getSelectedItem());
				model.repaint();
			}
		});
		this.add(selection);
	}
	
	public void resetComponents() {
		selection.select(0);
	}
}
