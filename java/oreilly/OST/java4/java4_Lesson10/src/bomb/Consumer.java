package bomb;

import java.applet.Applet;
import java.awt.event.*;

public class Consumer extends KeyAdapter {
  private World myWorld;
  private Applet apl;
  
  public Consumer (World myWorld, Applet apl) {
    this.myWorld = myWorld;
    this.apl = apl;
    apl.addKeyListener(this);
  }
  
  public void keyTyped(KeyEvent e) {
    myWorld.type(e.getKeyChar());
    apl.repaint();
  }

}
