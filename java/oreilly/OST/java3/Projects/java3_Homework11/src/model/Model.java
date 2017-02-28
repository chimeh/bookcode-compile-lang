package model;

import java.awt.Color;
import shapes.*;

import java.awt.Container;
import interfaces.Resettable;
import java.util.*;

public class Model implements Resettable {

  private Container container;
  
  private List<Shape> shapeArrayList = new ArrayList<Shape>();
  
  public final static String DRAW = "Draw";
  public final static String MOVE = "Move";
  public final static String RESIZE = "Resize";
  public final static String REMOVE = "Remove";
  public final static String CHANGE = "Change";
  public final static String FILL = "Fill";
  
  public final static String RECTANGLE = "Rectangle";
  public final static String OVAL = "Oval";
  public final static String TRIANGLE = "Triangle";
  
  public final static String BLACK = "Black";
  public final static String RED = "Red";
  public final static String GREEN ="Green";
  public final static String BLUE = "Blue";
  public final static String YELLOW = "Yellow";
  public final static String MAGENTA = "Magenta";
  public final static String ORANGE = "Orange";
  public final static String GRAY = "Gray";
  
  private String currentShapeType = RECTANGLE;
  private String action = DRAW;
  private boolean fill = false;
 
  private Shape currentShape;
  
  private String currentLineColor, currentFillColor;
  
  private Color lnColor, flColor;
  
  public Shape createShape() {
    
    if(currentShapeType == RECTANGLE) {
      currentShape = new Rectangle(0, 0, 0, 0, lineColor(currentLineColor), fillColor(currentFillColor), fill);
    }
    
    if(currentShapeType == OVAL) {
      currentShape = new Oval(0, 0, 0, 0, lineColor(currentLineColor), fillColor(currentFillColor), fill);
    }
    
    if(currentShapeType == TRIANGLE) {
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
    action = DRAW;
    fill = false;
    currentShape = null;
    currentShapeType = RECTANGLE;
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
  
  public String getCurrentShapeType() {
    return currentShapeType;
  }

  public void setCurrentShapeType(String currentShapeType) {
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
