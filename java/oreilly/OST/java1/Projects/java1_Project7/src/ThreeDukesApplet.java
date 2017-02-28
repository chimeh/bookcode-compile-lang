import java.applet.Applet;
import java.awt.*;

public class ThreeDukesApplet extends Applet {

  Dukes duke_1, duke_2, duke_3 ; // three declarations for Duke instances
  String duke1Action, duke2Action, duke3Action; // each will have their own action
  
  public void init() {
    
    duke_1= new Dukes(); // instantiate first Duke
    duke1Action= duke_1.getActionImage(); // his first action
    
    duke_2= new Dukes(); // instantiate second Duke
    duke2Action= duke_2.getActionImage(); //his first action
    
    duke_3= new Dukes(); // instantiate third Duke
    duke3Action= duke_3.getActionImage(); //his first action
    
    resize(600,200); //resize the applet window so that we can see both dukes
  }
  
  public void paint(Graphics g) {
     
    Image duke1Choice = getImage(getDocumentBase(), duke1Action); // get and show image for first Duke
    g.drawString(duke_1.getAction(), 10,165);
    g.drawString(duke_1.getMessage(), 10, 180);
    g.drawImage(duke1Choice, 20, 50, Color.white, this);
    
    Image duke2Choice = getImage(getDocumentBase(), duke2Action); // get and show image for second Duke
    g.drawString(duke_2.getAction(), 200,165);
    g.drawString(duke_2.getMessage(), 200, 180);
    g.drawImage(duke2Choice, 200, 50, Color.white, this);
    
    Image duke3Choice = getImage(getDocumentBase(), duke3Action); // get and show image for third Duke
    g.drawString(duke_3.getAction(), 390,165);
    g.drawString(duke_3.getMessage(), 390, 180);
    g.drawImage(duke3Choice, 380, 50, Color.white, this);
  }
}
