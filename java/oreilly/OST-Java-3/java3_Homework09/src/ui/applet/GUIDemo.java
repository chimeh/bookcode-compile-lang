package ui.applet;

import interfaces.ComparableShape;
import interfaces.Resettable;
import java.applet.Applet;
import java.awt.Graphics;
import event.ShapeMouseHandler;
import shapes.Shape;
import ui.panels.MainPanel;
import model.Model;

public class GUIDemo extends Applet implements Resettable {
    MainPanel mainPanel;
    Model model;
  
    public void init() {
        resize(800,400);
        model = new Model(this);
        mainPanel = new MainPanel(model);
        add(mainPanel);
        ShapeMouseHandler mouseHandler = new ShapeMouseHandler(model);
        addMouseListener(mouseHandler);
        addMouseMotionListener(mouseHandler);
    }
  
    public void paint(Graphics g) {
        Shape shape;
        shape = model.getCurrentShape();
        if(shape != null) {
          shape.draw(g);
        }
        System.out.println(model);
        System.out.println(shape); 
        
        Shape[] arrayShape;
        arrayShape = model.getStoreShapes();
        if (arrayShape[1] != null) {
        	arrayShape[0].draw(g);
        	arrayShape[1].draw(g);     	
        	//Be sure to look for instances of ComparableShapes 
        	if ((arrayShape[0] instanceof ComparableShape) && (arrayShape[1] instanceof ComparableShape)){
        		System.out.println("Compare results: " + model.compareShapes());
        	} else {
        		System.out.println("Cannot compare closed shapes to Lines.");
        	}  	
        }
    }
  
    public void resetComponents() {
        mainPanel.resetComponents();
    }
}
