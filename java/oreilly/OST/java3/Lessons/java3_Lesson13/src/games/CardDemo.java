
//File   : GUI-lowlevel/cards1/cards/CardDemo
//Purpose: Basic GUI to show dragging cards.
//       Illustrates how to load images from files.
//Author : Fred Swartz - 2007-02-19 - Placed in public domain.
//
//Enhancements:
//     * This really doesn't have a user interface beyond dragging.
//       It doesn't do anything, and therefore has no model.
//       Make it play a game.
//     * Needs to have a Deck class to shuffle, deal, ... Cards.
//       Presumably based on ArrayList<Card>.
//     * Perhaps a Suit and Face class would be useful.
//     * Like Deck, there would also be a class for Hand.
//     * May need Player class too.

package games;

import java.util.List;
import javax.swing.*;

public class CardDemo extends JFrame {
  
  private static RealCards[] _deck = new RealCards[52];
  
  public static void main(String[] args) {
    CardDemo window = new CardDemo();
    window.setTitle("Card Demo");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setContentPane(new CardTable(_deck));
    window.pack();
    window.setLocationRelativeTo(null);
    window.setVisible(true);
  }
  
  public CardDemo() {
    
    int n = 0;
    int xPos = 0;
    int yPos = 0;
    
    Deck myDeck = new Deck();
    List<ImageIcon> aVisualDeck = myDeck.getVisualDeck();
    for(ImageIcon each : aVisualDeck) {
      RealCards card = new RealCards(each);
      card.moveTo(xPos, yPos);
      _deck[n] = card;
      
      xPos += 5;
      yPos += 4;
      n++;
    }
  }

}
