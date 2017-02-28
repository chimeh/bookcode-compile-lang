package ui.panels;

import java.awt.Panel;

import interfaces.Resettable;
import model.Model;
import ui.panels.ButtonPanel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Choice;
import java.awt.Label;

public class ControlsPanel extends Panel implements Resettable {
  
  private ButtonPanel btnPanel;
  private ColorPanel clrPanel;
  private ShapePanel shpPanel;
  
  private Label lineLabel;
  private Label fillLabel;
  
  private static Choice lineColor = new Choice();
  private static Choice fillColor = new Choice();
  
  private static String[] colorList = {"Black", "Red", "Blue", "Green", "Yellow", "Magenta", "Orange", "Gray"};
  
  public ControlsPanel (final Model model) {
    btnPanel = new ButtonPanel(model);
    clrPanel = new ColorPanel();
    shpPanel = new ShapePanel(model);
    lineLabel = new Label("Line: ");
    fillLabel = new Label("Fill: ");
    
    add(shpPanel);
    add(lineLabel);
    add(clrPanel.getLineColor());
    add(fillLabel);
    add(clrPanel.getFillColor());
    add(btnPanel);
    
    lineColor.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        model.setCurrentLineColor(lineColor.getSelectedItem());
      }
    });
    
    fillColor.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        model.setCurrentFillColor(fillColor.getSelectedItem());
      }
    });
  }
  
public static class ColorPanel {
    
    public ColorPanel(){
      for(String choices : colorList) {
        lineColor.add(choices);
        fillColor.add(choices);
      }
    }
    
    public Choice getLineColor() {
      return lineColor;
    }

    public Choice getFillColor() {
      return fillColor;
    }
    
    public static String[] getColorList() {
      return colorList;
    }

  }

  public void resetComponents() {
    shpPanel.resetComponents();
    lineColor.select(0);
    fillColor.select(0);
  }

  public ButtonPanel getBtnPanel() {
    return btnPanel;
  }

  public void setBtnPanel(ButtonPanel btnPanel) {
    this.btnPanel = btnPanel;
  }
  
}
