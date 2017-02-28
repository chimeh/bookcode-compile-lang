package event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Model;
import shapes.*;

public class ShapeMouseHandler extends MouseAdapter {

  private Model model;
  private int startX, startY;
  private Shape shape;
  
  /*
   * The constructor for this class takes a Model object and assigns it so that it may persist throughout
   * the life of the class.
   */

  public ShapeMouseHandler(Model model) {
    this.model = model;
  }
  
  /*
   * When the mousePressed() method is triggered, it gets the (x,y) coordinates of the mouse and then determines what
   * parameters are set in the model. Depending on the parameters, a different action will be performed and then
   * the repaint() method will be invoked.
   */

  public void mousePressed(MouseEvent e) {
    startX = e.getX();
    startY = e.getY();

    if (model.getAction() == Model.Action.DRAW) {
      shape = model.createShape();
      shape.setX(startX);
      shape.setY(startY);

      if (shape instanceof Rectangle) {
        ((Rectangle) shape).setWidth(50);
        ((Rectangle) shape).setHeight(50);
      }

      if (shape instanceof Oval) {
        ((Oval) shape).setWidth(50);
        ((Oval) shape).setHeight(50);
      }

      if (shape instanceof Triangle) {
        ((Triangle) shape).setWidth(50);
        ((Triangle) shape).setHeight(50);
      }

      if (shape instanceof Rhombus) {
        ((Rhombus) shape).setWidth(50);
        ((Rhombus) shape).setHeight(50);
      }
    }

    if (model.getAction() == Model.Action.MOVE) {
      shape = model.returnSelectedShape(e.getX(), e.getY());
      shape.setLineColor(model.getCurrentLineColor().darker());

      if (shape instanceof Rectangle && model.isFill()) {
        ((Rectangle) shape).setFillColor(model.getCurrentFillColor().darker());
      }

      if (shape instanceof Oval && model.isFill()) {
        ((Oval) shape).setFillColor(model.getCurrentFillColor().darker());
      }

      if (shape instanceof Triangle && model.isFill()) {
        ((Triangle) shape).setFillColor(model.getCurrentFillColor().darker());
      }

      if (shape instanceof Rhombus && model.isFill()) {
        ((Rhombus) shape).setFillColor(model.getCurrentFillColor().darker());
      }
    }

    if (model.getAction() == Model.Action.RESIZE) {
      shape = model.returnSelectedShape(e.getX(), e.getY());
      shape.setLineColor(model.getCurrentLineColor().darker());

      if (shape instanceof Rectangle && model.isFill()) {
        ((Rectangle) shape).setFillColor(model.getCurrentFillColor().darker());
      }

      if (shape instanceof Oval && model.isFill()) {
        ((Oval) shape).setFillColor(model.getCurrentFillColor().darker());
      }

      if (shape instanceof Triangle && model.isFill()) {
        ((Triangle) shape).setFillColor(model.getCurrentFillColor().darker());
      }

      if (shape instanceof Rhombus && model.isFill()) {
        ((Rhombus) shape).setFillColor(model.getCurrentFillColor().darker());
      }
    }

    if (model.getAction() == Model.Action.REMOVE) {
      shape = model.returnSelectedShape(e.getX(), e.getY());
      model.getShapeArrayList().remove(shape);
    }

    if (model.getAction() == Model.Action.CHANGE) {
      shape = model.returnSelectedShape(e.getX(), e.getY());
      shape.setLineColor(model.getCurrentLineColor());

      if (shape instanceof Rectangle) {
        ((Rectangle) shape).setFill((model.isFill()));
        ((Rectangle) shape).setFillColor(model.getCurrentFillColor());
      }

      if (shape instanceof Oval) {
        ((Oval) shape).setFill((model.isFill()));
        ((Oval) shape).setFillColor(model.getCurrentFillColor());
        ;
      }

      if (shape instanceof Triangle) {
        ((Triangle) shape).setFill((model.isFill()));
        ((Triangle) shape).setFillColor(model.getCurrentFillColor());
        ;
      }

      if (shape instanceof Rhombus) {
        ((Rhombus) shape).setFill((model.isFill()));
        ((Rhombus) shape).setFillColor(model.getCurrentFillColor());
        ;
      }

    }

    model.repaint();
  }
  
  /*
   * When the mouseDragged() method is triggered, it gets the (x,y) coordinates of the mouse and then determines what
   * parameters are set in the model. Depending on the parameters, a different action will be performed and then
   * the repaint() method will be invoked.
   */

  public void mouseDragged(MouseEvent e) {

    if (model.getAction() == Model.Action.DRAW) {
      shape = model.getCurrentShape();
      shape.setX(Math.min(startX, e.getX()));
      shape.setY(Math.min(startY, e.getY()));

      if (shape instanceof Rectangle) {
        ((Rectangle) shape).setWidth(Math.abs(startX - e.getX()));
        ((Rectangle) shape).setHeight(Math.abs(startY - e.getY()));
      }

      if (shape instanceof Oval) {
        ((Oval) shape).setWidth(Math.abs(startX - e.getX()));
        ((Oval) shape).setHeight(Math.abs(startY - e.getY()));
      }

      if (shape instanceof Triangle) {
        ((Triangle) shape).setWidth(Math.abs(startX - e.getX()));
        ((Triangle) shape).setHeight(Math.abs(startY - e.getY()));
      }

      if (shape instanceof Rhombus) {
        ((Rhombus) shape).setWidth(Math.abs(startX - e.getX()));
        ((Rhombus) shape).setHeight(Math.abs(startY - e.getY()));
      }
    }

    if (model.getAction() == Model.Action.MOVE) {
      shape.setX(e.getX());
      shape.setY(e.getY());

        shape.setLineColor(model.getCurrentLineColor().brighter());

        if (shape instanceof Rectangle && model.isFill()) {
          ((Rectangle) shape).setFillColor(model.getCurrentFillColor().brighter());
        }

        if (shape instanceof Oval && model.isFill()) {
          ((Oval) shape).setFillColor(model.getCurrentFillColor().brighter());
        }

        if (shape instanceof Triangle && model.isFill()) {
          ((Triangle) shape).setFillColor(model.getCurrentFillColor().brighter());
        }

        if (shape instanceof Rhombus && model.isFill()) {
          ((Rhombus) shape).setFillColor(model.getCurrentFillColor().brighter());
        }
   
    }

    if (model.getAction() == Model.Action.RESIZE) {
      shape.setX(Math.min(shape.getX(), e.getX()));
      shape.setY(Math.min(shape.getY(), e.getY()));
      shape.setLineColor(model.getCurrentLineColor().brighter());

      if (shape instanceof Rectangle) {
        ((Rectangle) shape).setWidth(Math.abs(shape.getX() - e.getX()));
        ((Rectangle) shape).setHeight(Math.abs(shape.getY() - e.getY()));
        ((Rectangle) shape).setFillColor(model.getCurrentFillColor().brighter());
      }

      if (shape instanceof Oval) {
        ((Oval) shape).setWidth(Math.abs(shape.getX() - e.getX()));
        ((Oval) shape).setHeight(Math.abs(shape.getY() - e.getY()));
        ((Oval) shape).setFillColor(model.getCurrentFillColor().brighter());
      }

      if (shape instanceof Triangle) {
        ((Triangle) shape).setWidth(Math.abs(shape.getX() - e.getX()));
        ((Triangle) shape).setHeight(Math.abs(shape.getY() - e.getY()));
        ((Triangle) shape).setFillColor(model.getCurrentFillColor().brighter());
      }

      if (shape instanceof Rhombus) {
        ((Rhombus) shape).setWidth(Math.abs(shape.getX() - e.getX()));
        ((Rhombus) shape).setHeight(Math.abs(shape.getY() - e.getY()));
        ((Rhombus) shape).setFillColor(model.getCurrentFillColor().brighter());
      }
    }

    model.repaint();
  }
}
