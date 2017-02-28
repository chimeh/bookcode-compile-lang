package model;

import java.awt.Color;
import shapes.Rectangle;
import shapes.Oval;
import shapes.Triangle;
import shapes.Shape;
import shapes.Line;
import java.awt.Container;
import java.util.Collections;
import java.util.Vector;

import enumerable.ActionEnum;
import enumerable.ShapeEnum;
import interfaces.Resettable;

/*
 * A model to keep track of the state of the applet.
 */
public class Model implements Resettable {
	private Container container;

	// String array of possible shape options
	public final static String[] selections = { "Rectangle", "Oval",
			"Triangle", "Line" };

	// Set defaults for action, fill, shape, fill color, and line color.
	private ActionEnum action = ActionEnum.DRAW;
	private boolean fill = false;
	private ShapeEnum currentShapeType = ShapeEnum.RECTANGLE;
	private Color selectedLineColor = Color.black;
	private Color selectedFillColor = Color.black;

	private String selectedShape;
	private Shape currentShape;
	private Vector<Shape> vectorShapes = new Vector<Shape>(5);

	private int[] xPoints = { 0, 0, 0 };
	private int[] yPoints = { 0, 0, 0 };

	/*
	 * Method to create selected shape.
	 */
	public Shape createShape() {
		switch (currentShapeType) {
		case RECTANGLE:
			selectedShape = "Rectangle";
			break;
		case OVAL:
			selectedShape = "Oval";
			break;
		case TRIANGLE:
			selectedShape = "Triangle";
			break;
		case LINE:
			selectedShape = "Line";
			break;
		default:
			break;
		}

		// Constructor to create Rectangle.
		if (selectedShape == "Rectangle") {
			currentShape = new Rectangle(0, 0, 0, 0, selectedLineColor,
					selectedFillColor, fill);
		}

		// Constructor to create Oval.
		if (selectedShape == "Oval") {
			currentShape = new Oval(0, 0, 0, 0, selectedLineColor,
					selectedFillColor, fill);
		}

		// Constructor to create Triangle.
		if (selectedShape == "Triangle") {
			currentShape = new Triangle(xPoints, yPoints, selectedLineColor,
					selectedFillColor, fill);
		}

		// Constructor to create Line.
		if (selectedShape == "Line") {
			currentShape = new Line(0, 0, 0, 0, selectedLineColor);
		}

		// Fill Vector with drawn shapes
		vectorShapes.add(currentShape);

		return currentShape;
	}

	/*
	 * Search Vector for shapes matching coordinates. If no object contains
	 * those coordinates, return null.
	 */
	public Shape findShapes(int x_coor, int y_coor) {
		// Reverse Shape vector so the last drawn is selected.
		Collections.reverse(vectorShapes);
		for (Shape foundShape : vectorShapes) {
			if (foundShape.containsLocation(x_coor, y_coor)) {
				System.out.println("found shape!");
				return foundShape;
			}
		}
		return null;
	}

	public void setAction(ActionEnum action) {
		this.action = action;
	}

	public ActionEnum getAction() {
		return action;
	}

	public Vector<Shape> getVectorShapes() {
		return vectorShapes;
	}

	public Color getSelectedFillColor() {
		return selectedFillColor;
	}

	public void setSelectedFillColor(Color selectedFillColor) {
		this.selectedFillColor = selectedFillColor;
	}

	public Color getSelectedLineColor() {
		return selectedLineColor;
	}

	public void setSelectedLineColor(Color selectedLineColor) {
		this.selectedLineColor = selectedLineColor;
	}

	public Shape getCurrentShape() {
		return currentShape;
	}

	public void setCurrentShapeType(ShapeEnum currentShapeType) {
		this.currentShapeType = currentShapeType;
	}

	public ShapeEnum getCurrentShapeType() {
		return currentShapeType;
	}

	public Model(Container container) {
		this.container = container;
	}

	public void repaint() {
		container.repaint();
	}

	/*
	 * Method to reset panel. Set all options back to their defaults.
	 */
	public void resetComponents() {
		action = ActionEnum.DRAW;
		fill = false;
		currentShape = null;
		selectedLineColor = Color.black;
		selectedFillColor = Color.black;
		if (container instanceof Resettable) {
			((Resettable) container).resetComponents();
		}
		vectorShapes.clear();
	}

	public boolean isFill() {
		return fill;
	}

	public void setFill(boolean fill) {
		this.fill = fill;
	}
}