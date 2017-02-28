package model;

import java.awt.Color;
import shapes.*;

import java.awt.Container;
import interfaces.Resettable;
import java.util.*;

public class Model implements Resettable {

  private Container container;
  
  private List<Shape> shapeArrayList = new ArrayList<Shape>();
  
  public enum Action  {DRAW, MOVE, RESIZE, REMOVE, CHANGE, FILL};
  public enum ShapeSelect {RECTANGLE, OVAL, TRIANGLE};
  
  public final static String BLACK = "Black";
  public final static String RED = "Red";
  public final static String GREEN ="Green";
  public final static String BLUE = "Blue";
  public final static String YELLOW = "Yellow";
  public final static String MAGENTA = "Magenta";
  public final static String ORANGE = "Orange";
  public final static String GRAY = "Gray";
  
  private ShapeSelect currentShapeType = ShapeSelect.RECTANGLE;
  private Action action = Action.DRAW;
  private boolean fill = false;
 
  private Shape currentShape;
  
  private String currentLineColor, currentFillColor;
  
  private Color lnColor, flColor;
  
  public Shape createShape() {
    
    if(currentShapeType == ShapeSelect.RECTANGLE) {
      currentShape = new Rectangle(0, 0, 0, 0, lineColor(currentLineColor), fillColor(currentFillColor), fill);
    }
    
    if(currentShapeType == ShapeSelect.OVAL) {
      currentShape = new Oval(0, 0, 0, 0, lineColor(currentLineColor), fillColor(currentFillColor), fill);
    }
    
    if(currentShapeType == ShapeSelect.TRIANGLE) {
      currentShape = new Triangle(0, 0, 0, 0, lineColor(currentLineColor), fillColor(currentFillColor), fill);
    }
    
    shapeArrayList.add(currentShape);
    
    return currentShape;
  }
  
  public Shape returnSelectedShape(int xClick, int yClick) {
    
    for(Shape element : shapeArrayList) {
      if(element.containsLocation(xClick, yClick)) {
        return element;
      }
    }
    return null;
  }
  
  public Color lineColor(String currentLineColor) {
    if(currentLineColor == BLACK) {
      lnColor = Color.black;
    }
 
    if(currentLineColor == RED) {
      lnColor = Color.red;
    }
    
    if(currentLineColor == GREEN) {
      lnColor = Color.green;
    }
    
    if(currentLineColor == BLUE) {
      lnColor = Color.blue;
    }
    
    if(currentLineColor == YELLOW) {
      lnColor = Color.yellow;
    }
 
    if(currentLineColor == MAGENTA) {
      lnColor = Color.magenta;
    }
    
    if(currentLineColor == ORANGE) {
      lnColor = Color.orange;
    }
    
    if(currentLineColor == GRAY) {
      lnColor = Color.gray;
    }
    
    return lnColor;
  }
  
  public Color fillColor(String currentFillColor) {
    if(currentFillColor == BLACK) {
      flColor = Color.black;
    }
 
    if(currentFillColor == RED) {
      flColor = Color.red;
    }
    
    if(currentFillColor == GREEN) {
      flColor = Color.green;
    }
    
    if(currentFillColor == BLUE) {
      flColor = Color.blue;
    }
    
    if(currentFillColor == YELLOW) {
      flColor = Color.yellow;
    }
 
    if(currentFillColor == MAGENTA) {
      flColor = Color.magenta;
    }
    
    if(currentFillColor == ORANGE) {
      flColor = Color.orange;
    }
    
    if(currentFillColor == GRAY) {
      flColor = Color.gray;
    }
    
    return flColor;
  }
  
  public void resetComponents() {
    action = Action.DRAW;
    fill = false;
    currentShape = null;
    currentShapeType = ShapeSelect.RECTANGLE;
    currentLineColor = BLACK;
    currentFillColor = BLACK;
    shapeArrayList.clear();
    
    if(container instanceof Resettable) {
      ((Resettable)container).resetComponents();
    }

  }
  
  public Model (Container container) {
    this.container = container;
  }
  
  public void repaint() {
    container.repaint();
  }

  public Action getAction() {
    return action;
  }
  
  public void setAction(Action action) {
    this.action = action;
  }

  public boolean isFill() {
    return fill;
  }

  public void setFill(boolean fill) {
    this.fill = fill;
  }
  
  public ShapeSelect getCurrentShapeType() {
    return currentShapeType;
  }

  public void setCurrentShapeType(ShapeSelect currentShapeType) {
    this.currentShapeType = currentShapeType;
  }

  public Shape getCurrentShape() {
    return currentShape;
  }

  public void setCurrentShape(Shape currentShape) {
    this.currentShape = currentShape;
  }
  
  public Color getLnColor() {
    return lnColor;
  }

  public void setLnColor(Color lnColor) {
    this.lnColor = lnColor;
  }

  public Color getFlColor() {
    return flColor;
  }

  public void setFlColor(Color flColor) {
    this.flColor = flColor;
  }
  
  public String getCurrentLineColor() {
    return currentLineColor;
  }

  public void setCurrentLineColor(String currentLineColor) {
    this.currentLineColor = currentLineColor;
  }

  public String getCurrentFillColor() {
    return currentFillColor;
  }

  public void setCurrentFillColor(String currentFillColor) {
    this.currentFillColor = currentFillColor;
  }

  public List<Shape> getShapeArrayList() {
    return shapeArrayList;
  }

  public void setShapeArrayList(List<Shape> shapeArrayList) {
    this.shapeArrayList = shapeArrayList;
  }

  public String toString() {
    return "Model: \n\tAction: " +action + "\n\tFill: " + fill + "\n\tShape: \n\t" + currentShape
        + "\n\tLineColor: " + currentLineColor + "\n\tFillColor: " + currentFillColor;
  }

}
