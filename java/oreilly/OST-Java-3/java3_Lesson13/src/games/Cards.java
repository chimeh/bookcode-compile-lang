package games;

import java.util.*;

public class Cards {   // a class with two enum specifications

    public enum Face { TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE }

    public enum Suit { HEARTS, DIAMONDS, CLUBS, SPADES }

    private final Face face;
    private final Suit suit;
    private static final List<Cards> theDeck = new ArrayList<Cards>();   // declares theDeck 

    private Cards(Face face, Suit suit) {
        this.face = face;
        this.suit = suit;
        // remove (or  comment out) the initializeDeck call from within the constructor    
    }

    static {                                    // initializes theDeck into the class variable
    for (Suit suit : Suit.values())
         for (Face face : Face.values())
         theDeck.add(new Cards(face, suit));
    }

    public Face getFace() { 
       return face; 
    }

    public Suit getSuit() { 
       return suit; 
    }

    public String toString() { 
       return face + " of " + suit; 
    }

    // remove demo() method
    public static ArrayList<Cards> newDeck() {
        return new ArrayList<Cards>(theDeck); // Return a copy of the deck
    }

    public static void main(String [] args){
     	System.out.println(theDeck);
    }
}