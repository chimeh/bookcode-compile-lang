package ui.panels;

import interfaces.Resettable;
import java.awt.Panel;
import model.Model;
import java.awt.Choice;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Label;

public class ShapePanel extends Panel implements Resettable {

  private Choice selection;
  private Label shapeLabel;

  public ShapePanel(final Model model) {
    selection = new Choice();
    shapeLabel = new Label("Shape:");

    /*
     * The selection.add() method adds the String values to the Choice object to visually represent the different options in a dropdown
     */
    selection.add("Rectangle");
    selection.add("Oval");
    selection.add("Triangle");
    selection.add("Rhombus");
    
    /*
     * The selection.addItemListener method is adding an anonymous inner class to perform actions when the 'selection' dropdown is switched to a certain option 
     */

    selection.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        if (selection.getSelectedItem() == "Rectangle")
          model.setCurrentShapeType(Model.ShapeSelect.RECTANGLE);
        if (selection.getSelectedItem() == "Oval")
          model.setCurrentShapeType(Model.ShapeSelect.OVAL);
        if (selection.getSelectedItem() == "Triangle")
          model.setCurrentShapeType(Model.ShapeSelect.TRIANGLE);
        if (selection.getSelectedItem() == "Rhombus")
          model.setCurrentShapeType(Model.ShapeSelect.RHOMBUS);
      }
    });
    /*
     * The add() method is adding objects to the panel, in this case a Label object and a Choice object
     */
    add(shapeLabel);
    add(selection);
  }

  /*
   * This resetComponents() method chooses the first option in the 'selection' list when called
   */
  public void resetComponents() {
    selection.select(0);
  }

}
