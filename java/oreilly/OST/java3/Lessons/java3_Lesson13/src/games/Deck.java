package games;

import java.util.*;
import javax.swing.*;

public class Deck {

  private List<Cards> thisDeck;
  private List<ImageIcon> visualDeck;
  private Cards [][] dealtHands;
  private ImageIcon [][] visualHands;
  private CardImage makeImages;
  private Hashtable<Cards, ImageIcon>myMap;
  
  public Deck() {
    thisDeck = Cards.newDeck();
    visualDeck = new ArrayList<ImageIcon>();
    makeImages = new CardImage();
    myMap = makeImages.getTable();
    for(Cards each: thisDeck) {
      visualDeck.add(myMap.get(each));
    }
  }

  public List<Cards> getDeck() {
    return thisDeck;
  }

  public List<ImageIcon> getVisualDeck() {
    return visualDeck;
  }

  public Cards[] getHand(int player) {
    return dealtHands[player];
  }
  
  public ImageIcon [] getVisualHand(int player) {
    return visualHands[player];
  }
  
  public void shuffle() {
    Collections.shuffle(thisDeck);
    visualDeck.clear();
    myMap = makeImages.getTable();
    for(Cards each: thisDeck) {
      visualDeck.add(myMap.get(each));
    }
  }
  
  public void dealAllPlayers(int howManyPlayers, int cardsToDeal) {
    dealtHands = new Cards[howManyPlayers][cardsToDeal];
    visualHands = new ImageIcon[howManyPlayers][cardsToDeal];
    this.shuffle();
    
    System.out.println("We have " + howManyPlayers + " fine Players tonight");
    for(int i=0; i < howManyPlayers; i++) {
      System.out.println("Player " + (i+1) + " is dealt an interesting hand of");
      List<Cards> thisHand = dealHand(cardsToDeal);
      for(int j=0; j < cardsToDeal; j++) {
        dealtHands[i][j] = thisHand.get(j);
        visualHands[i][j] = myMap.get(thisHand.get(j));
      }
      for(Cards each: thisHand) {
        System.out.println(each);
      }
    }
  }
  
  public List<Cards> dealHand(int numCards){
    int deckSize = thisDeck.size();
    List<Cards> aHand = thisDeck.subList(deckSize-numCards, deckSize);
    List<ImageIcon> visualHand = visualDeck.subList(deckSize-numCards, deckSize);
    List<Cards> hand = new ArrayList<Cards>(aHand);
    
    aHand.clear();
    visualHand.clear();
    return hand;
  }
  
  public static void main(String[] args) {
    Deck myDeck = new Deck();
    int numPlayers = 2;
    int numCards = 5;
    myDeck.dealAllPlayers(numPlayers, numCards);
  }
}
