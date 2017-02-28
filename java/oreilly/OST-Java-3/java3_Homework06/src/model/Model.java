package model;

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
     
    private String action = DRAW;
    private boolean fill = false;
    private String currentShapeType = selections[0];
    
    public Model (Container container) {
    	this.container = container;
    }
    
    public void repaint() {
    	container.repaint();
    }
    
	public void resetComponents() {
		action = DRAW;
		fill = false;
		currentShapeType = selections[0];
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
	
	public String getCurrentShapeType() {
		return currentShapeType;
	}

	public void setCurrentShapeType(String currentShapeType) {
		this.currentShapeType = currentShapeType;
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