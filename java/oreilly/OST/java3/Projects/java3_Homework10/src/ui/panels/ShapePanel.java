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
    
    selection.add(Model.RECTANGLE);
    selection.add(Model.OVAL);
    selection.add(Model.TRIANGLE);
    
    selection.addItemListener(new ItemListener (){
      public void itemStateChanged(ItemEvent e) {
        model.setCurrentShapeType(selection.getSelectedItem());
      }
    });
    add(shapeLabel);
    add(selection);
  }
  
  
  public void resetComponents() {
    selection.select(0);
  }

}
