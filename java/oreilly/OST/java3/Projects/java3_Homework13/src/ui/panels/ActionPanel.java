package ui.panels;

import interfaces.Resettable;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import model.Model;

public class ActionPanel extends Panel implements Resettable {

  private CheckboxGroup actionGroup;
  private Checkbox chkDraw, chkMove, chkResize, chkRemove, chkChange, chkFill;

  public ActionPanel(final Model model) {
    actionGroup = new CheckboxGroup();
    chkDraw = new Checkbox("Draw", actionGroup, true);
    chkMove = new Checkbox("Move", actionGroup, false);
    chkResize = new Checkbox("Resize", actionGroup, false);
    chkRemove = new Checkbox("Remove", actionGroup, false);
    chkChange = new Checkbox("Change", actionGroup, false);
    chkFill = new Checkbox("Fill", false);
    
    /*
     * A ItemListener is being added for each option that can be selected. Upon selection of an item, 
     * the choice is passed to the model and the state changed appropriately.
     */

    chkDraw.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        model.setAction(Model.Action.DRAW);
      }
    });

    chkMove.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        model.setAction(Model.Action.MOVE);
      }
    });

    chkResize.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        model.setAction(Model.Action.RESIZE);
      }
    });

    chkRemove.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        model.setAction(Model.Action.REMOVE);
      }
    });

    chkChange.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        model.setAction(Model.Action.CHANGE);
      }
    });

    chkFill.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        model.setFill(chkFill.getState());
      }
    });
    
    /*
     * A grid layout with 1 row, and 6 columns is made. All of the radio options are added to the panel
     */

    setLayout(new GridLayout(1, 6));

    add(chkDraw);
    add(chkMove);
    add(chkResize);
    add(chkRemove);
    add(chkChange);
    add(chkFill);
  }

  public void resetComponents() {
    // For each component, set the state. Only one of the first five can be true
    chkDraw.setState(true);
    chkMove.setState(false);
    chkResize.setState(false);
    chkRemove.setState(false);
    chkChange.setState(false);
    chkFill.setState(false);

  }

}
