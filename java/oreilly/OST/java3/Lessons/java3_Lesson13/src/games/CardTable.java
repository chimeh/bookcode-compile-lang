// File   : GUI-lowlevel/cards1/cards/CardTable.java
// Purpose: This is just a JComponent for drawing the cards that are
//          showing on the table.
//
// Author : Fred Swartz - February 19, 2007 - Placed in public domain.
//
// Enhancements:
//        * Use model. Currently, it is initialized with a whole deck of cards,
//          but instead it should be initialized with a "model" which
//          it should interrogate (calling model methods) to find out what
//          should be displayed.
//        * Similarly, actions by the mouse might be used to set things in the
//          model, Perhaps by where it's dragged to, or double-clicked, or
//          with pop-up menu, or ...

package games;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CardTable extends JComponent implements MouseListener, MouseMotionListener {
  
  private static final Color BACKGROUND_COLOR=Color.green;
  private static final int TABLE_SIZE = 400;
  
  private int dragFromX=0;
  private int dragFromY=0;
  
  private RealCards[] deck;
  private RealCards currentCard = null;
  
  public CardTable(RealCards[] deck) {
    this.deck = deck;
    
    setPreferredSize(new Dimension(TABLE_SIZE, TABLE_SIZE));
    setBackground(Color.blue);
    
    addMouseListener(this);
    addMouseMotionListener(this);
  }
  
  @Override
  public void paintComponent(Graphics g) {
    //...Paint background
    int width = getWidth();
    int height = getHeight();
    g.setColor(BACKGROUND_COLOR);
    g.fillRect(0, 0, width, height);
    
    for(RealCards c : this.deck) {
      System.out.println(c.toString());
        c.draw(g, this);
    }
  }
  
  public void mousePressed(MouseEvent e) {
    int x = e.getX();
    int y = e.getY();
    
    this.currentCard = null;
    for(int crd=this.deck.length-1; crd>=0; crd--) {
      RealCards testCard = this.deck[crd];
        if(testCard.contains(x, y)) {
          //...Found, remeber this card for dragging.
          dragFromX = x - testCard.getX();
          dragFromY = x - testCard.getY();
          currentCard = testCard;
          break;
        }
    }
  }

  public void mouseDragged(MouseEvent e) {
    if(this.currentCard != null) {
      
      int newX = e.getX() - dragFromX;
      int newY = e.getY() - dragFromY;
      
      newX = Math.max(newX, 0);
      newX = Math.min(newX, getWidth() - currentCard.getWidth());
      
      newY = Math.max(newY, 0);
      newY = Math.min(newY, getHeight()-currentCard.getHeight());
      
      this.currentCard.moveTo(newX, newY);
      
      this.repaint();
    }
  }
  
  public void mouseExited(MouseEvent e) {
    currentCard = null;
  }
  
  public void mouseMoved (MouseEvent e) {}
  public void mouseEntered (MouseEvent e) {}
  public void mouseClicked (MouseEvent e) {}
  public void mouseReleased (MouseEvent e) {}
}
