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
    chkDraw = new Checkbox(Model.DRAW, actionGroup, true);
    chkMove = new Checkbox(Model.MOVE, actionGroup, false);
    chkResize = new Checkbox(Model.RESIZE, actionGroup, false);
    chkRemove = new Checkbox(Model.REMOVE, actionGroup, false);
    chkChange = new Checkbox(Model.CHANGE, actionGroup, false);
    chkFill = new Checkbox(Model.FILL, false);
    
    chkDraw.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        model.setAction(Model.DRAW);
      }
    });
    
    chkMove.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        model.setAction(Model.MOVE);
      }
    });
    
    chkResize.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        model.setAction(Model.RESIZE);
      }
    });
    
    chkRemove.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        model.setAction(Model.REMOVE);
      }
    });
    
    chkChange.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        model.setAction(Model.CHANGE);
      }
    });
    
    chkFill.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        model.setFill(chkFill.getState());
      }
    });
    
    setLayout(new GridLayout(1,6));
    
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
