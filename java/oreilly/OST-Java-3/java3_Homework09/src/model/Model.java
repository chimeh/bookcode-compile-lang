package model;

import java.awt.Color;
import shapes.Rectangle;
import shapes.Oval;
import shapes.Triangle;
import shapes.Shape;
import shapes.Line;
import java.awt.Container;
import java.util.Arrays;
import interfaces.ComparableShape;

import interfaces.Resettable;

public class Model implements Resettable {
	private Container container;
	public final static String DRAW = "Draw";
    public final static String MOVE = "Move";
    public final static String REMOVE = "Remove";
    public final static String RESIZE = "Resize";
    public final static String CHANGE = "Change";
    public final static String FILL = "Fill";
    public final static String[] selections = {"Rectangle", "Oval", "Triangle", "Line"};
    
    public final static String RECTANGLE = "Rectangle";
    public final static String OVAL = "Oval";
    public final static String TRIANGLE = "Triangle";
    public final static String LINE = "Line";
    
    private String action = DRAW;
    private boolean fill = false;
    
    private String currentShapeType = RECTANGLE;
    private Color selectedLineColor = Color.black;
    private Color selectedFillColor = Color.black;
    
    private Shape currentShape;
    private Shape[] storeShapes = new Shape[2];
    
    private int[] xPoints = {0, 0, 0};
    private int[] yPoints = {0, 0, 0};
    
    private int shapeOneArea;
    private int shapeTwoArea;
    
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
    	if (currentShapeType == LINE) {
    		currentShape = new Line(0, 0, 0, 0, selectedLineColor);
    	}
    	
    	//if array is filled then reset to null
    	if (storeShapes[1] != null) {
    		Arrays.fill(storeShapes, null);
    	}
    	//Fill array with the next shape
    	for (int i = 0; i < storeShapes.length; i++) {
    	    if (storeShapes[i] == null) {
    	    	storeShapes[i] = currentShape;
    	    	break;
    	    }
    	}
    	
    	return currentShape;   	
    }

    public int compareShapes() {
    	//cast shapes to ComparableShape interface to call getArea()              
    	System.out.println("Area of shape 1: " + ((ComparableShape)storeShapes[0]).getArea());
    	System.out.println("Area of shape 2: " + ((ComparableShape)storeShapes[1]).getArea());	
    	
    	if (((ComparableShape)storeShapes[0]).getArea() < ((ComparableShape)storeShapes[1]).getArea()) return 2;  
    	if (((ComparableShape)storeShapes[0]).getArea() > ((ComparableShape)storeShapes[1]).getArea()) return 1;
    	return 0;  	
    }
    
    public Shape[] getStoreShapes() {
		return storeShapes;
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
		Arrays.fill(storeShapes, null);
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