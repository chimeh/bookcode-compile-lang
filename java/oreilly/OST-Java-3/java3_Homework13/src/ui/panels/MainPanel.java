package ui.panels;

import interfaces.Resettable;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import model.Model;
import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/*
 * The main panel that consists of the action panel, choice panel, control panel, and color panel.
 */
public class MainPanel extends Panel implements Resettable {
	ActionPanel actionPanel;
	ChoicePanel choicePanel;
	ControlsPanel controlsPanel;
	ColorPanel colorPanel;

	/*
	 * Constructor. Creates instances of the ActionPanel, ControlsPanel,
	 * ColorPanel, and ChoicePanel. Defines the layout and adds it to the main
	 * panel.
	 */
	public MainPanel(Model model) {
		actionPanel = new ActionPanel(model);
		controlsPanel = new ControlsPanel(model);
		colorPanel = new ColorPanel(model);
		choicePanel = new ChoicePanel(model);
		setLayout(new GridLayout(2, 1));
		add(choicePanel); // shape drop down
		add(colorPanel); // line color and fill color drop down
		add(controlsPanel); // clear button
		add(actionPanel); // draw, move, resize, and etc.
	}

	/*
	 * Resetting the Main panel involves resetting all the four panels that made
	 * up the main panel.
	 */
	public void resetComponents() {
		actionPanel.resetComponents();
		choicePanel.resetComponents();
		controlsPanel.resetComponents();
		colorPanel.resetComponents();
	}

	/*
	 * Static inner class that creates the line and fill color drop down fields
	 * and labels.
	 */
	public static class ColorPanel extends Panel {
		public final static String BLACK = "Black";
		public final static String BLUE = "Blue";
		public final static String GREEN = "Green";
		public final static String RED = "Red";
		public final static String YELLOW = "Yellow";
		public final static String ORANGE = "Orange";
		public final static String MAGENTA = "Magenta";
		public final static String CYAN = "Cyan";

		private static String[] color_selections = { "Black", "Blue", "Green",
				"Red", "Yellow", "Orange", "Magenta", "Cyan" };
		String msg = "";

		Model model;
		Choice selectLineColor;
		Choice selectFillColor;

		/*
		 * Method that translates color selection to a Color type.
		 */
		public Color createShapecolor(String selectedColor) {
			if (selectedColor == BLACK) {
				return Color.black;
			}
			if (selectedColor == BLUE) {
				return Color.blue;
			}
			if (selectedColor == GREEN) {
				return Color.green;
			}
			if (selectedColor == RED) {
				return Color.red;
			}
			if (selectedColor == YELLOW) {
				return Color.yellow;
			}
			if (selectedColor == ORANGE) {
				return Color.orange;
			}
			if (selectedColor == MAGENTA) {
				return Color.magenta;
			}
			if (selectedColor == CYAN) {
				return Color.cyan;
			}
			return Color.black;
		}

		/*
		 * Create label for buttons, add listeners, and add both line and fill
		 * color drop down fields to the Color panel.
		 */
		public ColorPanel(final Model md2) {
			model = md2;
			selectLineColor = new Choice();
			selectFillColor = new Choice();
			Label lineLabel = new Label("Line:");
			Label fillLabel = new Label("Fill:");

			for (String msg : color_selections) {
				selectLineColor.add(msg);
				selectFillColor.add(msg);
			}
			selectLineColor.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					model.setSelectedLineColor(createShapecolor(selectLineColor
							.getSelectedItem()));
					model.repaint();
				}
			});

			selectFillColor.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					model.setSelectedFillColor(createShapecolor(selectFillColor
							.getSelectedItem()));
					model.repaint();
				}
			});

			add(lineLabel);
			this.add(selectLineColor);
			add(fillLabel);
			this.add(selectFillColor);
		}

		/*
		 * Method to reset Line and Fill (color) drop down fields.
		 */
		public void resetComponents() {
			selectLineColor.select(0);
			selectFillColor.select(0);
		}
	}
}
