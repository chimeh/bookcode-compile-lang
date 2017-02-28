package ui.panels;

import java.awt.Label;
import java.awt.Panel;
import java.awt.Choice;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import model.Model;
import interfaces.Resettable;
import enumerable.ShapeEnum;

public class ChoicePanel extends Panel implements Resettable {
	Model model;
	Choice selection;
	
	public ChoicePanel(final Model mdl) {
		Label shapeLabel = new Label("Shape:");
		model = mdl;
		selection = new Choice();
		for(String msg : Model.selections) {
			selection.add(msg);
		}
		selection.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				model.setCurrentShapeType(ShapeEnum.valueOf(selection.getSelectedItem().toString().toUpperCase()));				
				model.repaint();
			}
		});
		add(shapeLabel);
		this.add(selection);
	}
	
	public void resetComponents() {
		selection.select(0);
	}
}
