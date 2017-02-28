package ui.applet;

import interfaces.Resettable;
import java.applet.Applet;
import java.awt.Graphics;
import java.util.Vector;

import event.ShapeMouseHandler;
import shapes.Shape;
import ui.panels.MainPanel;
import model.Model;

/*
 * Handles the applet initialization and the paint process.
 */
public class GUIDemo extends Applet implements Resettable {
	MainPanel mainPanel;
	Model model;

	/*
	 * Declares the window size and instantiates all objects needed to start the
	 * applet Create an instance of model. Create an instance of the main panel.
	 * Initialize the mouse handler and add the mouse listeners.
	 */
	public void init() {
		resize(800, 400);
		model = new Model(this);
		mainPanel = new MainPanel(model);
		add(mainPanel);
		ShapeMouseHandler mouseHandler = new ShapeMouseHandler(model);
		addMouseListener(mouseHandler);
		addMouseMotionListener(mouseHandler);
	}

	/*
	 * Draw all the shapes in the model. Print String of what shape is drawn and
	 * at what position of the Vector.
	 */
	public void paint(Graphics g) {
		Vector<Shape> arrayShape;
		arrayShape = model.getVectorShapes();
		for (int i = 0; i < arrayShape.size(); i++) {
			arrayShape.elementAt(i).draw(g);
			System.out.println("Element " + i + " is a "
					+ arrayShape.elementAt(i));
		}
	}

	/*
	 * Resets components in Main panel.
	 */
	public void resetComponents() {
		mainPanel.resetComponents();
	}
}
