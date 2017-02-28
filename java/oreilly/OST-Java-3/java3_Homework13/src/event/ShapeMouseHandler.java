package event;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Model;
import shapes.Rectangle;
import shapes.Triangle;
import shapes.Line;
import shapes.Shape;
import interfaces.ComparableShape;

/*
 * Handles mouse interactions.
 */
public class ShapeMouseHandler extends MouseAdapter {
	private Model model;
	private int startX;
	private int startY;
	private Shape shape;
	private Shape selectedInstance;
	private int startX2;
	private int startY2;
	private int startX3;
	private int startY3;
	private int startX4;
	private int startY4;
	private int startX5;
	private int startY5;
	private int[] r = {};
	private int[] m = {};
	private String selectedAction;
	private Color oldColor;

	/*
	 * Constructor. Sets the model for this listener.
	 */
	public ShapeMouseHandler(Model model) {
		this.model = model;
	}

	/*
	 * Method to determine the action selected by user
	 */
	public String getSelectedAction() {
		switch (model.getAction()) {
		case DRAW:
			selectedAction = "Draw";
			break;
		case MOVE:
			selectedAction = "Move";
			break;
		case REMOVE:
			selectedAction = "Remove";
			break;
		case RESIZE:
			selectedAction = "Resize";
			break;
		case CHANGE:
			selectedAction = "Change";
			break;
		case FILL:
			selectedAction = "Fill";
			break;
		default:
			break;
		}
		return selectedAction;
	}

	/*
	 * This method deals with the mouse pressed event
	 */
	public void mousePressed(MouseEvent e) {
		// User presses on the mouse and selects the Draw action.
		if (getSelectedAction() == "Draw") {
			startX = e.getX();
			startY = e.getY();
			shape = model.createShape();
			if (shape != null) {
				shape.setX(e.getX());
				shape.setY(e.getY());
				// User selects to draw Rectangle. Set default Rectangle
				// dimensions.
				if (shape instanceof Rectangle) {
					((Rectangle) shape).setWidth(50);
					((Rectangle) shape).setHeight(50);
				}
				// User selects to draw Triangle. Set default Triangle
				// dimensions.
				if (shape instanceof Triangle) {
					int[] a = { e.getX(), e.getX() + 40, e.getX() + 10 };
					int[] b = { e.getY(), e.getY(), e.getY() + 30 };
					((Triangle) shape).setX_array_shape(a);
					((Triangle) shape).setY_array_shape(b);
				}
				// User selects to draw Line. Set default Line dimensions.
				if (shape instanceof Line) {
					((Line) shape).setX2(50);
					((Line) shape).setY2(50);
				}
			}
		}

		// User presses on the mouse and selects the Remove action.
		if (getSelectedAction() == "Remove") {
			selectedInstance = model.findShapes(e.getX(), e.getY());
			if (selectedInstance != null) {
				// Remove selected shape from Shape Vector.
				model.getVectorShapes().remove(selectedInstance);
			}
		}

		// User presses on the mouse and selects the Change action.
		if (getSelectedAction() == "Change") {
			selectedInstance = model.findShapes(e.getX(), e.getY());
			if (selectedInstance != null) {
				// Change Line color of selected shape.
				selectedInstance.setLineColor(model.getSelectedLineColor());
				if (selectedInstance instanceof ComparableShape) {
					// Change fill color or do not fill color of closed shapes.
					((ComparableShape) selectedInstance)
							.setFill(model.isFill());
					((ComparableShape) selectedInstance).setFillColor(model
							.getSelectedFillColor());
				}
			}
		}

		// User presses on the mouse and selects the Move action.
		if (getSelectedAction() == "Move") {
			selectedInstance = model.findShapes(e.getX(), e.getY());
			if (selectedInstance != null) {

				/*
				 * Temporarily change visual appearance of selected shape. First
				 * save old line color. Then change line color of selected shape
				 * to pink.
				 */
				oldColor = selectedInstance.getLineColor();
				selectedInstance.setLineColor(Color.decode("#ffc0cb"));
				// Get starting points of shapes.
				startX = selectedInstance.getX() - e.getX();
				startY = selectedInstance.getY() - e.getY();
			}

			// Get the two starting points for Line.
			if (selectedInstance instanceof Line) {
				startX2 = ((Line) selectedInstance).getX2() - e.getX();
				startY2 = ((Line) selectedInstance).getY2() - e.getY();
			}

			// Get the three starting points for Triangle.
			if (selectedInstance instanceof Triangle) {
				r = ((Triangle) selectedInstance).getX_array_shape();
				m = ((Triangle) selectedInstance).getY_array_shape();

				startX3 = r[0] - e.getX();
				startX4 = r[1] - e.getX();
				startX5 = r[2] - e.getX();

				startY3 = m[0] - e.getY();
				startY4 = m[1] - e.getY();
				startY5 = m[2] - e.getY();
			}
		}

		// User presses on the mouse and selects the Resize action.
		if (getSelectedAction() == "Resize") {
			selectedInstance = model.findShapes(e.getX(), e.getY());
			if (selectedInstance != null) {

				/*
				 * Temporarily change visual appearance of selected shape. First
				 * save old line color. Then change line color of selected shape
				 * to pink.
				 */
				oldColor = selectedInstance.getLineColor();
				selectedInstance.setLineColor(Color.decode("#ffc0cb"));

				// Get starting points of shapes.
				startX = selectedInstance.getX();
				startY = selectedInstance.getY();
			}
		}

		// Repaint the shapes on the screen to reflect the changes made.
		model.repaint();
	}

	/*
	 * This method deals with the mouse dragged event
	 */
	public void mouseDragged(MouseEvent e) {
		if (shape != null) {
			// User drags with the mouse and selects the Draw action.
			if (getSelectedAction() == "Draw") {
				shape.setX(Math.min(startX, e.getX()));
				shape.setY(Math.min(startY, e.getY()));
				// Set new dimensions of Rectangle.
				if (shape instanceof Rectangle) {
					((Rectangle) shape).setWidth(Math.abs(startX - e.getX()));
					((Rectangle) shape).setHeight(Math.abs(startY - e.getY()));
				}

				// Set new dimensions of Triangle.
				if (shape instanceof Triangle) {
					int[] c = {
							Math.min(startX, e.getX()),
							Math.min(startX, e.getX())
									+ Math.abs(startX - e.getX()),
							Math.min(startX, e.getX())
									+ Math.abs(startX - e.getX()) };
					int[] d = {
							Math.min(startY, e.getY()),
							Math.min(startY, e.getY()),
							Math.min(startY, e.getY())
									+ Math.abs(startY - e.getY()) };
					((Triangle) shape).setX_array_shape(c);
					((Triangle) shape).setY_array_shape(d);
				}

				// Set new dimensions of Line.
				if (shape instanceof Line) {
					((Line) shape).setX2(Math.max(startX, e.getX()));
					((Line) shape).setY2(Math.max(startY, e.getY()));
				}
			}
		}

		// User drags with the mouse and selects the Move action.
		if (getSelectedAction() == "Move") {
			if (selectedInstance != null) {
				// Calculate and set new position of shape.
				selectedInstance.setX(e.getX() + startX);
				selectedInstance.setY(e.getY() + startY);
				// Calculate and set new position of Line.
				if (selectedInstance instanceof Line) {
					((Line) selectedInstance).setX2(e.getX() + startX2);
					((Line) selectedInstance).setY2(e.getY() + startY2);
				}

				// Calculate and set new position of Triangle.
				if (selectedInstance instanceof Triangle) {
					int startX6 = e.getX() + startX3;
					int startX7 = e.getX() + startX4;
					int startX8 = e.getX() + startX5;

					int startY6 = e.getY() + startY3;
					int startY7 = e.getY() + startY4;
					int startY8 = e.getY() + startY5;

					int[] s = { startX6, startX7, startX8 };
					int[] w = { startY6, startY7, startY8 };
					((Triangle) selectedInstance).setX_array_shape(s);
					((Triangle) selectedInstance).setY_array_shape(w);
				}
			}
		}

		// User drags with the mouse and selects the Resize action.
		if (getSelectedAction() == "Resize") {
			if (selectedInstance != null) {
				// Calculate and set new size of shape.
				selectedInstance.setX(Math.min(startX, e.getX()));
				selectedInstance.setY(Math.min(startY, e.getY()));
				// Calculate and set new size of Rectangle.
				if (selectedInstance instanceof Rectangle) {
					((Rectangle) selectedInstance).setWidth(Math.abs(startX
							- e.getX()));
					((Rectangle) selectedInstance).setHeight(Math.abs(startY
							- e.getY()));
				}

				// Calculate and set new size of Triangle.
				if (selectedInstance instanceof Triangle) {
					int[] c = {
							Math.min(startX, e.getX()),
							Math.min(startX, e.getX())
									+ Math.abs(startX - e.getX()),
							Math.min(startX, e.getX())
									+ Math.abs(startX - e.getX()) };
					int[] d = {
							Math.min(startY, e.getY()),
							Math.min(startY, e.getY()),
							Math.min(startY, e.getY())
									+ Math.abs(startY - e.getY()) };
					((Triangle) selectedInstance).setX_array_shape(c);
					((Triangle) selectedInstance).setY_array_shape(d);
				}

				// Calculate and set new size of Line.
				if (selectedInstance instanceof Line) {
					((Line) selectedInstance).setX2(Math.max(startX, e.getX()));
					((Line) selectedInstance).setY2(Math.max(startY, e.getY()));
				}
			}
		}

		// Repaint the shapes on the screen to reflect the changes made.
		model.repaint();
	}

	/*
	 * This method deals with the mouse released event
	 */
	public void mouseReleased(MouseEvent e) {
		if (selectedInstance != null) {
			// Once mouse is released. Set shape back to old Line color.
			selectedInstance.setLineColor(oldColor);
		}

		// Repaint the shapes on the screen to reflect the changes made.
		model.repaint();
	}
}
