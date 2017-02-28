package model;

import java.awt.Color;
import shapes.Rectangle;
import shapes.Oval;
import shapes.Triangle;
import shapes.Shape;
import java.awt.Container;
import interfaces.Resettable;

public class Model implements Resettable {
	private Container container;
	public final static String DRAW = "Draw";
    public final static String MOVE = "Move";
    public final static String REMOVE = "Remove";
    public final static String RESIZE = "Resize";
    public final static String CHANGE = "Change";
    public final static String FILL = "Fill";
    public final static String[] selections = {"Rectangle", "Oval", "Triangle"};
    
    public final static String RECTANGLE = "Rectangle";
    public final static String OVAL = "Oval";
    public final static String TRIANGLE = "Triangle";
    
    private String action = DRAW;
    private boolean fill = false;
    
    private String currentShapeType = RECTANGLE;
    private Color selectedLineColor = Color.black;
    private Color selectedFillColor = Color.black;
    
    private Shape currentShape;
    
    private int[] xPoints = {0, 0, 0};
    private int[] yPoints = {0, 0, 0};
    
    public Shape createShape() {
    	if (currentShapeType == RECTANGLE) {
    		currentShape = new Rectangle(0, 0, 0, 0, selectedLineColor, selectedFillColor, fill);
    	}
    	if (currentShapeType == OVAL) {
    		currentShape = new Oval(0, 0, 0, 0, selectedLineColor, selectedFillColor, fill);
    	}
    	if (currentShapeType == TRIANGLE) {
    		currentShape = new Triangle(xPoints, yPoints, selectedLineColor, selectedFillColor, fill);
    	}
    	return currentShape;
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
    
    public String getCurrentShapeType() {
    	return currentShapeType;
    }
    
    public void setCurrentShapeType(String shapeType) {
    	currentShapeType = shapeType;
    }
    
    public Model (Container container) {
    	this.container = container;
    }
    
    public void repaint() {
    	container.repaint();
    }
    
	public void resetComponents() {
		action = DRAW;
		fill = false;
		currentShape = null;
		selectedLineColor = Color.black;
	    selectedFillColor = Color.black;
		if (container instanceof Resettable) {
			((Resettable)container).resetComponents();
		}
	}
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	public boolean isFill() {
		return fill;
	}
	
	public void setFill(boolean fill) {
		this.fill = fill;
	}
    	
	public String toString() {
		return "Model:\n\tAction: " + action + "\n\tFill: " + fill + "\n\tCurrent Shape Type: " + currentShapeType;
	}
}