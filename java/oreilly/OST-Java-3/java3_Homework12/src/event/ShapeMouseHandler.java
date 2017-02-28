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

	public ShapeMouseHandler(Model model) {
		this.model = model;
	}
	
	public String getSelectedAction() {
		switch(model.getAction()) { 
			case DRAW: selectedAction = "Draw"; 
				break;
			case MOVE: selectedAction = "Move"; 
				break;
			case REMOVE: selectedAction = "Remove"; 
				break;
			case RESIZE: selectedAction = "Resize"; 
				break;
			case CHANGE: selectedAction = "Change"; 
				break;
			case FILL: selectedAction = "Fill"; 
				break;
			default: break;
		}
		return selectedAction;
	}
	
	public void mousePressed(MouseEvent e) {	
		if (getSelectedAction() == "Draw") {
			startX = e.getX();
			startY = e.getY();
			shape = model.createShape();
			if (shape != null) {
				shape.setX(e.getX());
				shape.setY(e.getY());
				if (shape instanceof Rectangle) {
					((Rectangle) shape).setWidth(50);
					((Rectangle) shape).setHeight(50);
				}
				if (shape instanceof Triangle) {
					int[] a = {e.getX(), e.getX()+40, e.getX()+10};
					int[] b = {e.getY(), e.getY(), e.getY()+30};
					((Triangle) shape).setX_array_shape(a);
					((Triangle) shape).setY_array_shape(b);
				}
				if (shape instanceof Line) {
					((Line) shape).setX2(50);
					((Line) shape).setY2(50);
				}
			}
		}		
				
		if (getSelectedAction() == "Remove") {			            
            selectedInstance = model.findShapes(e.getX(), e.getY());
			if (selectedInstance != null) {
				model.getVectorShapes().remove(selectedInstance);
			} 
		 }
		
		if (getSelectedAction() == "Change") {
			selectedInstance = model.findShapes(e.getX(), e.getY());
			if (selectedInstance != null) {            	        
                selectedInstance.setLineColor(model.getSelectedLineColor());
                
                if(selectedInstance instanceof ComparableShape) {        	
                	((ComparableShape) selectedInstance).setFill(model.isFill());
                	((ComparableShape) selectedInstance).setFillColor(model.getSelectedFillColor());
                }                    
            }
        } 
						
		if (getSelectedAction() == "Move") {						
			selectedInstance = model.findShapes(e.getX(), e.getY());
			if (selectedInstance != null) {              
            	startX = selectedInstance.getX() - e.getX();  
            	startY = selectedInstance.getY() - e.getY();             	
            }
			if (selectedInstance instanceof Line) {
				startX2 = ((Line) selectedInstance).getX2() - e.getX();  
				startY2 = ((Line) selectedInstance).getY2() - e.getY();
			}
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
				
		if (getSelectedAction() == "Resize") {            			
			selectedInstance = model.findShapes(e.getX(), e.getY());
	        if (selectedInstance != null) {
	        	startX = selectedInstance.getX();
	        	startY = selectedInstance.getY();                
	        }
        }
		      
		model.repaint();
	}
	
	public void mouseDragged(MouseEvent e) {
		//shape = model.getCurrentShape();
		if (shape != null) {
			if (getSelectedAction() == "Draw") {
				shape.setX(Math.min(startX, e.getX()));
				shape.setY(Math.min(startY, e.getY()));
			
				if (shape instanceof Rectangle) {
					((Rectangle) shape).setWidth(Math.abs(startX - e.getX()));
					((Rectangle) shape).setHeight(Math.abs(startY - e.getY()));
				}
				if (shape instanceof Triangle) {
					int[] c = {Math.min(startX, e.getX()), Math.min(startX, e.getX())+Math.abs(startX - e.getX()), Math.min(startX, e.getX())+Math.abs(startX - e.getX())};
					int[] d = {Math.min(startY, e.getY()), Math.min(startY, e.getY()), Math.min(startY, e.getY())+Math.abs(startY - e.getY())};
					((Triangle) shape).setX_array_shape(c);
					((Triangle) shape).setY_array_shape(d);
				}
				if (shape instanceof Line) {
					((Line) shape).setX2(Math.max(startX, e.getX()));
					((Line) shape).setY2(Math.max(startY, e.getY()));
				}
			}
		}
		
		if (getSelectedAction() == "Move") {			
			if (selectedInstance != null) {
                selectedInstance.setX(e.getX() + startX);
                selectedInstance.setY(e.getY() + startY);
				         	           				   
                if (selectedInstance instanceof Line) {               	                	
                	((Line) selectedInstance).setX2(e.getX() + startX2);
					((Line) selectedInstance).setY2(e.getY() + startY2);
				}
                if (selectedInstance instanceof Triangle) {               	               	
    				int startX6 = e.getX() + startX3;
    				int startX7 = e.getX() + startX4;
    				int startX8 = e.getX() + startX5;
    				
    				int startY6 = e.getY() + startY3;
    				int startY7 = e.getY() + startY4;
    				int startY8 = e.getY() + startY5;
    				
    				int[] s = {startX6, startX7, startX8};
					int[] w = {startY6, startY7, startY8};
					((Triangle) selectedInstance).setX_array_shape(s);
					((Triangle) selectedInstance).setY_array_shape(w);					
				}
			}
		}       
        
		if (getSelectedAction() == "Resize") {               
			if (selectedInstance != null) {
				selectedInstance.setX(Math.min(startX, e.getX()));
				selectedInstance.setY(Math.min(startY, e.getY()));
						
				if (selectedInstance instanceof Rectangle) {
					((Rectangle) selectedInstance).setWidth(Math.abs(startX - e.getX()));
					((Rectangle) selectedInstance).setHeight(Math.abs(startY - e.getY()));
				}
			
				if (selectedInstance instanceof Triangle) {
					int[] c = {Math.min(startX, e.getX()), Math.min(startX, e.getX())+Math.abs(startX - e.getX()), Math.min(startX, e.getX())+Math.abs(startX - e.getX())};
					int[] d = {Math.min(startY, e.getY()), Math.min(startY, e.getY()), Math.min(startY, e.getY())+Math.abs(startY - e.getY())};
					((Triangle) selectedInstance).setX_array_shape(c);
					((Triangle) selectedInstance).setY_array_shape(d);
				}
			
				if (selectedInstance instanceof Line) {
					((Line) selectedInstance).setX2(Math.max(startX, e.getX()));
					((Line) selectedInstance).setY2(Math.max(startY, e.getY()));
				}
			}              
        }    
                         	
		model.repaint();
	} }

