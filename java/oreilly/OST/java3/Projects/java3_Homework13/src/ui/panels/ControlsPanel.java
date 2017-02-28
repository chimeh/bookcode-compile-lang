package ui.panels;

import java.awt.Panel;

import interfaces.Resettable;
import model.Model;
import ui.panels.ButtonPanel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Choice;
import java.awt.Label;
import java.awt.Color;

public class ControlsPanel extends Panel implements Resettable {

  private ButtonPanel btnPanel;
  private ColorPanel clrPanel;
  private ShapePanel shpPanel;

  private Label lineLabel;
  private Label fillLabel;

  private static Choice lineColor = new Choice();
  private static Choice fillColor = new Choice();

  private static String[] colorList = { "Black", "Red", "Blue", "Green", "Yellow", "Magenta", "Orange", "Gray" };

  public ControlsPanel(final Model model) {
    btnPanel = new ButtonPanel(model);
    clrPanel = new ColorPanel();
    shpPanel = new ShapePanel(model);
    lineLabel = new Label("Line: ");
    fillLabel = new Label("Fill: ");
    
    /*
     * The objects that make up the ControlPanel are added. In this case, a ButtonPanel, ColorPanel, ShapePanel, and two Label objects.
     */

    add(shpPanel);
    add(lineLabel);
    add(clrPanel.getLineColor());
    add(fillLabel);
    add(clrPanel.getFillColor());
    add(btnPanel);
    
    /*
     * Listeners are added for different line color values. Upon changing the value, it is adjusted in the model.
     */

    lineColor.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        if (lineColor.getSelectedItem() == "Black") {
          model.setCurrentLineColor(Color.black);
        }

        if (lineColor.getSelectedItem() == "Red") {
          model.setCurrentLineColor(Color.red);
        }

        if (lineColor.getSelectedItem() == "Blue") {
          model.setCurrentLineColor(Color.blue);
        }

        if (lineColor.getSelectedItem() == "Green") {
          model.setCurrentLineColor(Color.green);
        }

        if (lineColor.getSelectedItem() == "Yellow") {
          model.setCurrentLineColor(Color.yellow);
        }

        if (lineColor.getSelectedItem() == "Magenta") {
          model.setCurrentLineColor(Color.magenta);
        }

        if (lineColor.getSelectedItem() == "Orange") {
          model.setCurrentLineColor(Color.orange);
        }

        if (lineColor.getSelectedItem() == "Gray") {
          model.setCurrentLineColor(Color.gray);
        }
      }
    });
    
    /*
     * Listeners are added for different fill color values. Upon changing the value, it is adjusted in the model.
     */

    fillColor.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        if (fillColor.getSelectedItem() == "Black") {
          model.setCurrentFillColor(Color.black);
        }

        if (fillColor.getSelectedItem() == "Red") {
          model.setCurrentFillColor(Color.red);
        }

        if (fillColor.getSelectedItem() == "Blue") {
          model.setCurrentFillColor(Color.blue);
        }

        if (fillColor.getSelectedItem() == "Green") {
          model.setCurrentFillColor(Color.green);
        }

        if (fillColor.getSelectedItem() == "Yellow") {
          model.setCurrentFillColor(Color.yellow);
        }

        if (fillColor.getSelectedItem() == "Magenta") {
          model.setCurrentFillColor(Color.magenta);
        }

        if (fillColor.getSelectedItem() == "Orange") {
          model.setCurrentFillColor(Color.orange);
        }

        if (fillColor.getSelectedItem() == "Gray") {
          model.setCurrentFillColor(Color.gray);
        }
      }
    });
  }

  public static class ColorPanel {

    /*
     * The constructor adds all the different choices for line and fill colors. 
     */
    public ColorPanel() {
      for (String choices : colorList) {
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
