package ui.applet;

import interfaces.ComparableShape;
import interfaces.Resettable;
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Vector;

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
        //Shape shape;
        //shape = model.getCurrentShape();
        //if(shape != null) {
          //shape.draw(g);
        //}
        //System.out.println(model);
        //System.out.println(shape); 
        
        Vector <Shape> arrayShape;
        arrayShape = model.getVectorShapes();
        for (int i = 0; i < arrayShape.size(); i++) {			
        	arrayShape.elementAt(i).draw(g);
        	System.out.println("Element " + i + " is a " + arrayShape.elementAt(i));
		}	        
    }
  
    public void resetComponents() {
        mainPanel.resetComponents();
    }
}
