import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class DukesAppletGUI extends Applet implements ActionListener{ 
  
  Dukes myDuke; // Instance Variable giving the instance name "myDuke'
  String action; // Instance Variable telling what action is being done.

  public void init() {
    List actionList = new List(3); //makes a list to choose from
    actionList.add("wave");
    actionList.add("think");
    actionList.add("write");
    
    actionList.addActionListener(this); // tell Java to listen for user input
    add(actionList);
    
    myDuke = new Dukes(); // make an instance of Duke
    action = myDuke.getActionImage(); // see what Duke's current action is
  }
  
  public void paint(Graphics g) { // paint method
    Image myAction = getImage(getDocumentBase(), action);
    g.drawString(myDuke.getAction(), 10,165);
    g.drawString(myDuke.getMessage(), 10, 180);
    g.drawImage(myAction, 20, 50, Color.white, this);
  }
  
  public void actionPerformed(ActionEvent evt) {
    String userChoice = evt.getActionCommand();
    if(userChoice == "write") action = myDuke.write();
    else if (userChoice == "think") action = myDuke.think();
    else if (userChoice == "wave") action = myDuke.wave();
    
    repaint(); // if a different choice has been made, call our paint through repaint()
  }
  
  
}
