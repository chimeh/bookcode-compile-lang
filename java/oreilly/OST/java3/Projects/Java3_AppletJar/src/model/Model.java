package model;

import java.awt.Color;
import shapes.*;

import java.awt.Container;
import interfaces.Resettable;
import java.util.*;

public class Model implements Resettable {

  private Container container;

  private List<Shape> shapeArrayList = new ArrayList<Shape>();

  public enum Action {
    DRAW, MOVE, RESIZE, REMOVE, CHANGE, FILL
  };

  public enum ShapeSelect {
    RECTANGLE, OVAL, TRIANGLE, RHOMBUS
  };

  private ShapeSelect currentShapeType = ShapeSelect.RECTANGLE;
  private Action action = Action.DRAW;
  private boolean fill = false;

  private Shape currentShape;

  private Color currentLineColor = Color.black, currentFillColor;
  
  /*
   * createShape() will instantiate a shape depending on the currently selected shape, add it to the shapeArrayList, and then return the shape 
   */

  public Shape createShape() {

    if (currentShapeType == ShapeSelect.RECTANGLE) {
      currentShape = new Rectangle(0, 0, 0, 0, currentLineColor, currentFillColor, fill);
    }

    if (currentShapeType == ShapeSelect.OVAL) {
      currentShape = new Oval(0, 0, 0, 0, currentLineColor, currentFillColor, fill);
    }

    if (currentShapeType == ShapeSelect.TRIANGLE) {
      currentShape = new Triangle(0, 0, 0, 0, currentLineColor, currentFillColor, fill);
    }

    if (currentShapeType == ShapeSelect.RHOMBUS) {
      currentShape = new Rhombus(0, 0, 0, 0, currentLineColor, currentFillColor, fill);
    }

    shapeArrayList.add(currentShape);

    return currentShape;
  }

  /*
   * returnSelectedShape() will take (x,y) coordinates and determine if they are within the area of any shapes in the shapeArrayList, if they are,
   * the shape is returned.
   */
  public Shape returnSelectedShape(int xClick, int yClick) {

    for (Shape element : shapeArrayList) {
      if (element.containsLocation(xClick, yClick)) {
        return element;
      }
    }
    return null;
  }

  /*
   * resetComponents resets all values to what they were initially upon start of the applet
   */
  public void resetComponents() {
    action = Action.DRAW;
    fill = false;
    currentShape = null;
    currentShapeType = ShapeSelect.RECTANGLE;
    currentLineColor = Color.BLACK;
    currentFillColor = Color.BLACK;
    shapeArrayList.clear();

    if (container instanceof Resettable) {
      ((Resettable) container).resetComponents();
    }

  }

  public Model(Container container) {
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

  public Color getCurrentLineColor() {
    return currentLineColor;
  }

  public void setCurrentLineColor(Color currentLineColor) {
    this.currentLineColor = currentLineColor;
  }

  public Color getCurrentFillColor() {
    return currentFillColor;
  }

  public void setCurrentFillColor(Color currentFillColor) {
    this.currentFillColor = currentFillColor;
  }

  public List<Shape> getShapeArrayList() {
    return shapeArrayList;
  }

  public void setShapeArrayList(List<Shape> shapeArrayList) {
    this.shapeArrayList = shapeArrayList;
  }

  public String toString() {
    return "Model: \n\tAction: " + action + "\n\tFill: " + fill + "\n\tShape: \n\t" + currentShape + "\n\tLineColor: "
        + currentLineColor + "\n\tFillColor: " + currentFillColor;
  }

}
