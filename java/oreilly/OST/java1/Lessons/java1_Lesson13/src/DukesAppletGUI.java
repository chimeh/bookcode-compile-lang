import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class DukesAppletGUI extends Applet implements ItemListener{ 
  
  Dukes myDuke; // Instance Variable giving the instance name "myDuke'
  String action; // Instance Variable telling what action is being done.

  public void init() {
    Choice actionList = new Choice();
    actionList.add("wave");
    actionList.add("think");
    actionList.add("write");
    
    actionList.addItemListener(this);
    add(actionList);
    
    myDuke = new Dukes(); // make an instance of Duke
    action = myDuke.getActionImage(); // see what Duke's current action is
    
    Checkbox isAngry = new Checkbox("angry", myDuke.isAngry());
      add(isAngry);
    isAngry.addItemListener(this);
  }
  
  public void paint(Graphics g) { // paint method
    Image myAction = getImage(getDocumentBase(), action);
    g.drawString(myDuke.getAction(), 10,165);
    g.drawString(myDuke.getMessage(), 10, 180);
    g.drawImage(myAction, 20, 50, Color.white, this);
    g.drawString(myDuke.getAngryMessage(), 110, 110);
  }
  
  public void itemStateChanged(ItemEvent evt) {
    if (evt.getItem().toString() == "angry")
        myDuke.setMood();
    else {
      int whichOne = ((Choice)evt.getItemSelectable()).getSelectedIndex();
      switch (whichOne) {
        case 0: action= myDuke.wave(); break;
        case 1: action= myDuke.think(); break;
        case 2: action= myDuke.write(); break;
      }
    }
    
    repaint(); // if a different choice has been made, call our paint through repaint()
    
  }
  
}
