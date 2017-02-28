package games;

import java.applet.Applet;
import java.awt.*;
import javax.swing.*;

public class DisplayHandDemo extends Applet{

  private Deck myDeck = new Deck();
  int n;
  int x, y;
  int numPlayers;
  int numCards;
  
  public void init() {
    numPlayers = 3;
    numCards = 5;
    myDeck.dealAllPlayers(numPlayers, numCards);
  }
  
  public void paint(Graphics g) {
    int x = 0;
    int y = 0;
    
    int width = getWidth();
    int height = getHeight();
    g.setColor(Color.blue);
    g.fillRect(0, 0, width, height);
    
    for(int i = 0; i<numPlayers; i++) {
      for(ImageIcon each: myDeck.getVisualHand(i)) {
        Image justAWTimage = each.getImage();
        g.drawImage(justAWTimage, x, y, this);
        x += 15;
        y += 15;
      }
      x = x +75;
      y = 0;
    }
  }
}
