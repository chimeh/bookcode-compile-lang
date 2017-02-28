package games;

import javax.swing.*;
import java.util.*;
import java.net.URL;

public class CardImage {

  private Hashtable<Cards, ImageIcon> cardIcons = new Hashtable<Cards, ImageIcon>(52);
  private ClassLoader cldr;
  
  public CardImage() {
    cldr = this.getClass().getClassLoader();
    cardIcons = makeTable(Cards.newDeck());
  }
  
  private Hashtable<Cards, ImageIcon> makeTable(List<Cards> theDeck){
    for (Cards each : theDeck) {
      
      String mySuit = suitMap(each.getSuit());
      String myFace = faceMap(each.getFace());
      String imagePath = "games/images/" + myFace + mySuit + ".gif";
      URL imageURL = cldr.getResource(imagePath);
      ImageIcon img = new ImageIcon(imageURL);
      cardIcons.put(each, img);
    }
    return cardIcons;
  }
  
  private String suitMap(Cards.Suit cardSuit) {
    return cardSuit.toString().toLowerCase().substring(0,1);
  }
  
  private String faceMap(Cards.Face cardFace) {
    String result = null;
    switch(cardFace) {
    
      case TWO: result = "2"; break;
      case THREE: result = "3"; break;
      case FOUR: result = "4"; break;
      case FIVE: result = "5"; break;
      case SIX: result = "6"; break;
      case SEVEN: result = "7"; break;
      case EIGHT: result = "8"; break;
      case NINE: result = "9"; break;
      case TEN: result = "t"; break;
      case JACK: result = "j"; break;
      case QUEEN: result = "q"; break;
      case KING: result = "k"; break;
      case ACE: result = "a"; break;
    }
    return result;
  }
  
  public Hashtable<Cards, ImageIcon> getTable(){
    return cardIcons;
  }
  
  public static void main(String[] args) {
    CardImage testMe = new CardImage();
    List<Cards> myDeck = Cards.newDeck();
    for(Cards each : myDeck) {
      System.out.print(each + ": ");
      System.out.println(testMe.cardIcons.get(each));
    }
  }
  
}
