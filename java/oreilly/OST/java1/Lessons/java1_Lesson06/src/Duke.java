import java.applet.Applet;
import java.awt.*;

public class Duke extends Applet {
  
  Image action;
  Color noseColor = Color.red;
  
  public void paint(Graphics g) {
    // Next line randomly picks just to show that different noses are possible
    int rint = (int)(Math.random() *2); //Gives either a 0 or a 1.
    
    if(rint == 0) {
      noseColor = Color.red;
    }
    else {
      noseColor = Color.blue;
    }
    // Randomly let this duke do something - one of 3 choices.
    switch ((int)(Math.random() * 3)) // Gives a number between 0 and 2 inclusive
    {
      case 0: action = this.write(g); break;
      case 1: action= this.think(g); break;
      case 2: action= this.wave(g); break;
    }
    
    resize(300,300); //Resize the applet window.
    g.drawImage(action, 10, 10, Color.white, this);
    
    if (noseColor != Color.red) {
      g.drawString("My nose feels funny", 10, 145);
    }
  }
  
  public Image write(Graphics graph) {
    graph.drawString("I am a writing Duke", 10, 130);
    if (noseColor == Color.red) {
     action = getImage(getDocumentBase(), "../../images/duke/penduke.gif");
    }
    else
    {
      action = getImage(getDocumentBase(), "../../images/duke/penduke2.gif");
    }
    return action;
  }
  
  public Image think(Graphics graph) {
    graph.drawString("I am a thinking Duke", 10, 130);
    if (noseColor == Color.red) {
      action = getImage(getDocumentBase(), "../../images/duke/thinking.gif");
     }
     else
     {
       action = getImage(getDocumentBase(), "../../images/duke/thinking2.gif");
     }
     return action;
  }

  public Image wave(Graphics graph) {
    graph.drawString("I am a waving Duke", 10, 130);
    if (noseColor == Color.red) {
      action = getImage(getDocumentBase(), "../../images/duke/dukeWave.gif");
     }
     else
     {
       action = getImage(getDocumentBase(), "../../images/duke/dukeWave2.gif");
     }
     return action;
  }
}
