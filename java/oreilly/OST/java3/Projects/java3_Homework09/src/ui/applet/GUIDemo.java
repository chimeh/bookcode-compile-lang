package ui.applet;

import interfaces.Resettable;
import java.applet.Applet;
import java.awt.Graphics;

import event.ShapeMouseHandler;

import shapes.Shape;

import ui.panels.MainPanel;
import model.Model;



public class GUIDemo extends Applet implements Resettable{

  MainPanel mainPanel;
  Model model;
  
  public void init() {
    resize(600,400);
    model = new Model(this);
    mainPanel = new MainPanel(model);
    add(mainPanel);
    ShapeMouseHandler mouseHandler = new ShapeMouseHandler(model);
    addMouseListener(mouseHandler);
    addMouseMotionListener(mouseHandler);
  }
  
  public void paint(Graphics g) {
    Shape[] shapes;
    shapes = model.getShapeArray();
    
    for(Shape element : shapes) {
      if(element != null) {
        element.draw(g);
        System.out.println(element);
      }
    }
    
    if((shapes[0] != null) && (shapes[1] != null)) {
      if(model.compareShapes() == 1) {
        System.out.println("Shape 1 has larger area than shape 2.");
      }
    
      if(model.compareShapes() == 2) {
        System.out.println("Shape 2 has larger area than shape 1.");
      }

      if(model.compareShapes() == 0) {
        System.out.println("The shapes have equal area.");
      }
      
      if(model.compareShapes() == -1) {
        System.out.println("The shapes are not comparable");
      }
    }
    
    System.out.println(model);
  }

  public void resetComponents() {
    mainPanel.resetComponents();
  }
  
}
