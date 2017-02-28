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

	/*
	 * Constructor that creates a Shape drop down field, adds listener to the
	 * drop down field, then adds the field to the panel.
	 */
	public ChoicePanel(final Model mdl) {
		Label shapeLabel = new Label("Shape:");
		model = mdl;
		selection = new Choice();
		for (String msg : Model.selections) {
			selection.add(msg);
		}
		selection.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				model.setCurrentShapeType(ShapeEnum.valueOf(selection
						.getSelectedItem().toString().toUpperCase()));
				model.repaint();
			}
		});
		add(shapeLabel);
		this.add(selection);
	}

	/*
	 * Reset Shape drop down field to default.
	 */
	public void resetComponents() {
		selection.select(0);
	}
}
