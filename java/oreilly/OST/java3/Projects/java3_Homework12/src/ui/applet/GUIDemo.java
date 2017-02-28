package ui.applet;

import interfaces.Resettable;
import java.applet.Applet;
import java.awt.Graphics;
import java.util.*;

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
    List<Shape> shapes;
    shapes = model.getShapeArrayList();
    
    for(Shape element : shapes) {
      if(element != null) {
        element.draw(g);
      }
    }
    System.out.println(model);
  }

  public void resetComponents() {
    mainPanel.resetComponents();
  }
  
}
