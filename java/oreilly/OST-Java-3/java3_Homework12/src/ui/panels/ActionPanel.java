package ui.panels;

import interfaces.Resettable;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import model.Model;
import enumerable.ActionEnum;

public class ActionPanel extends Panel implements Resettable {

    private CheckboxGroup actionGroup;
    private Checkbox chkDraw, chkMove, chkResize, chkRemove, chkChange, chkFill;
  
    public ActionPanel(final Model model) {
        actionGroup = new CheckboxGroup();
        chkDraw = new Checkbox(ActionEnum.DRAW.toString(), actionGroup, true);
        chkMove = new Checkbox(ActionEnum.MOVE.toString(), actionGroup, false);
        chkResize = new Checkbox(ActionEnum.RESIZE.toString(), actionGroup, false);
        chkRemove = new Checkbox(ActionEnum.REMOVE.toString(), actionGroup, false);
        chkChange = new Checkbox(ActionEnum.CHANGE.toString(), actionGroup, false);
        chkFill = new Checkbox(ActionEnum.FILL.toString(), false);
        
        chkDraw.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                model.setAction(ActionEnum.DRAW);
            }
        });
        chkMove.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                model.setAction(ActionEnum.MOVE);
            }
        });
        chkResize.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                model.setAction(ActionEnum.RESIZE);
            }
        });
        chkRemove.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                model.setAction(ActionEnum.REMOVE);
            }
        });
        chkChange.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                model.setAction(ActionEnum.CHANGE);
            }
        });
        chkFill.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                model.setFill(chkFill.getState());
            }
        });
        
        setLayout(new GridLayout(1, 6));
        add(chkDraw);
        add(chkMove);
        add(chkResize);
        add(chkRemove);
        add(chkChange);
        add(chkFill);
    }
  
    public void resetComponents() {
        chkDraw.setState(true);
        chkMove.setState(false);
        chkResize.setState(false);
        chkRemove.setState(false);
        chkChange.setState(false);
        chkFill.setState(false);
    }
}

