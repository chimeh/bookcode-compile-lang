package event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Model;
import shapes.*;

public class ShapeMouseHandler extends MouseAdapter {
  
  private Model model;
  //Start x and y location used to mark where the upper left corner of a
  
  private int startX, startY;
  private Shape shape;
  
  public ShapeMouseHandler(Model model) {
    //persist local variable model to this.model
    this.model = model;
  }
  
  public void mousePressed(MouseEvent e) {
    startX=e.getX();
    startY=e.getY();
    
    if(model.getAction() == Model.DRAW) {
      shape = model.createShape();
      shape.setX(startX);
      shape.setY(startY);
      
        if(shape instanceof Rectangle) {
          ((Rectangle)shape).setWidth(50);
          ((Rectangle)shape).setHeight(50);
        }
        
        if(shape instanceof Oval) {
          ((Oval)shape).setWidth(50);
          ((Oval)shape).setHeight(50);
        }
        
        if(shape instanceof Triangle) {
          ((Triangle)shape).setWidth(50);
          ((Triangle)shape).setHeight(50);
        }
      }
    
    if(model.getAction() == Model.MOVE) {
        shape = model.returnSelectedShape(e.getX(),e.getY());
    }
    
    if(model.getAction() == Model.RESIZE) {
      shape = model.returnSelectedShape(e.getX(),e.getY());
    }
    
    if(model.getAction() == Model.REMOVE) {
      shape = model.returnSelectedShape(e.getX(), e.getY());
      model.getShapeArrayList().remove(shape);
    }
    
    if (model.getAction() == Model.CHANGE) {
      shape = model.returnSelectedShape(e.getX(), e.getY());
      shape.setLineColor(model.lineColor(model.getCurrentLineColor()));
      
      if(shape instanceof Rectangle) {
        ((Rectangle)shape).setFill((model.isFill()));
        ((Rectangle)shape).setFillColor(model.fillColor(model.getCurrentFillColor()));
      }
    
      if(shape instanceof Oval) {
        ((Oval)shape).setFill((model.isFill()));
        ((Oval)shape).setFillColor(model.fillColor(model.getCurrentFillColor()));;
      }
    
      if(shape instanceof Triangle) {
        ((Triangle)shape).setFill((model.isFill()));
        ((Triangle)shape).setFillColor(model.fillColor(model.getCurrentFillColor()));;
      }
      
    }
    
    model.repaint();
  }
  
  public void mouseDragged(MouseEvent e) {
   
      if(model.getAction() == Model.DRAW) {
        shape = model.getCurrentShape();
        shape.setX(Math.min(startX, e.getX()));
        shape.setY(Math.min(startY, e.getY()));
        
        if(shape instanceof Rectangle) {
          ((Rectangle)shape).setWidth(Math.abs(startX - e.getX()));
          ((Rectangle)shape).setHeight(Math.abs(startY - e.getY()));
        }
      
        if(shape instanceof Oval) {
          ((Oval)shape).setWidth(Math.abs(startX - e.getX()));
          ((Oval)shape).setHeight(Math.abs(startY - e.getY()));
        }
      
        if(shape instanceof Triangle) {
          ((Triangle)shape).setWidth(Math.abs(startX - e.getX()));
          ((Triangle)shape).setHeight(Math.abs(startY - e.getY()));
        }
      }
    
    if(model.getAction() == Model.MOVE) {
        shape.setX(e.getX());
        shape.setY(e.getY());
    }
      
    if(model.getAction() == Model.RESIZE) {
      shape.setX(Math.min(shape.getX(), e.getX()));
      shape.setY(Math.min(shape.getY(), e.getY()));
      
      if(shape instanceof Rectangle) {
        ((Rectangle)shape).setWidth(Math.abs(shape.getX() - e.getX()));
        ((Rectangle)shape).setHeight(Math.abs(shape.getY() - e.getY()));
      }
    
      if(shape instanceof Oval) {
        ((Oval)shape).setWidth(Math.abs(shape.getX() - e.getX()));
        ((Oval)shape).setHeight(Math.abs(shape.getY() - e.getY()));
      }
    
      if(shape instanceof Triangle) {
        ((Triangle)shape).setWidth(Math.abs(shape.getX() - e.getX()));
        ((Triangle)shape).setHeight(Math.abs(shape.getY() - e.getY()));
      }
    }
    
    if(model.getAction() == Model.REMOVE) {
      
    }
    
    if (model.getAction() == Model.CHANGE) {
      
    }
    
    model.repaint();
  }
}
