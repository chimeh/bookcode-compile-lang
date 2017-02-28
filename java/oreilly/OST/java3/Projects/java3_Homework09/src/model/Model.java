package model;

import java.awt.Color;
import shapes.*;
import java.awt.Container;
import interfaces.Resettable;

public class Model implements Resettable {

  private Container container;
  
  private Shape[] shapeArray = new Shape[2];
  
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
  
  private String action = DRAW;
  private boolean fill = false;
  
  private String currentShapeType = RECTANGLE;
  
  private Shape currentShape;
  
  private String currentLineColor;
  private String currentFillColor;
  
  private Color lnColor;
  private Color flColor;
  
 
  
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
  
  public Shape createShape() {
    
    if(currentShapeType == RECTANGLE) {
      lnColor = lineColor(currentLineColor);
      flColor = fillColor(currentFillColor);
      currentShape = new Rectangle(0, 0, 0, 0, getLnColor(), getFlColor(), fill);
    }
    
    if(currentShapeType == OVAL) {
      lnColor = lineColor(currentLineColor);
      flColor = fillColor(currentFillColor);
      currentShape = new Oval(0, 0, 0, 0, getLnColor(), getFlColor(), fill);
    }
    
    if(currentShapeType == TRIANGLE) {
      lnColor = lineColor(currentLineColor);
      flColor = fillColor(currentFillColor);
      currentShape = new Triangle(0, 0, 0, 0, getLnColor(), getFlColor(), fill);
    }
    
    for(int i =0; i < shapeArray.length; i++) {
      if(shapeArray[i] == null) {
        shapeArray[i] = currentShape;
        break;
      }
      
      if((shapeArray[i] != null) && (shapeArray[i+1] != null)) {
        for (int j=0; j < shapeArray.length; j++) {
          shapeArray[j] = null;
        }
        i =0;
      }
      
    }
      
    return currentShape;
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
    currentShapeType = RECTANGLE;
    currentLineColor = BLACK;
    currentFillColor = BLACK;
    
    for(int i =0; i <shapeArray.length; i++)
      shapeArray[i] = null;
    
    if(container instanceof Resettable) {
      ((Resettable)container).resetComponents();
    }

  }
  
  public int compareShapes() {
      if(shapeArray[0].getArea() > shapeArray[1].getArea()) return 1;
      if(shapeArray[0].getArea() < shapeArray[1].getArea()) return 2;
      if(shapeArray[0].getArea() == shapeArray[1].getArea()) return 0;
    return -1;
  }
  

  public Shape[] getShapeArray() {
    return shapeArray;
  }

  public void setShapeArray(Shape[] shapeArray) {
    this.shapeArray = shapeArray;
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

  public String toString() {
    return "Model: \n\tAction: " +action + "\n\tFill: " + fill + "\n\tShape: " + currentShapeType
        + "\n\tLineColor: " + currentLineColor + "\n\tFillColor: " + currentFillColor;
  }

}
