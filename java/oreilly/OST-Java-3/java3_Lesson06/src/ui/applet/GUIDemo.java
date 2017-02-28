package ui.applet;

import interfaces.Resettable;
import java.applet.Applet;
import ui.panels.MainPanel;
import model.Model;
import java.awt.Graphics;

public class GUIDemo extends Applet implements Resettable{
    MainPanel mainPanel;
    Model model;
  
    public void init() {
        resize(600,400);
        model = new Model(this);
        mainPanel = new MainPanel(model);
        add(mainPanel);
    }
    
    public void paint(Graphics g){
        System.out.println(model);
    }
    
    public void resetComponents() {
        mainPanel.resetComponents();
    }
}
