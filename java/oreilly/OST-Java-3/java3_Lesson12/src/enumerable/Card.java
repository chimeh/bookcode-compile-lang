package enumerable;

import java.util.*;
import java.awt.Color;

public class Card {
	public enum Face {TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE}
	public enum Suit {HEARTS, DIAMONDS, CLUBS, SPADES}
	
	private final Face face;
	private final Suit suit;
	private static final List<Card> theDeck = new ArrayList<Card>();
	
	private Card (Face face, Suit suit) {
		this.face = face;
		this.suit = suit;
	}
	
	static {
		for (Suit suit : Suit.values())
			for (Face face : Face.values())
				theDeck.add(new Card(face, suit));	
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
	
	public static ArrayList<Card> newDeck() {
		return new ArrayList<Card>(theDeck);
	}
	
	public Color testSwitch() {
		Color result = null;
		switch(suit) {
			case SPADES:
			case CLUBS: result = Color.black; break;
			case HEARTS:
			case DIAMONDS: result = Color.red; break;
		}
		return result;
	}
	
	public static void main(String [] args) {
		List<Card> deck = Card.newDeck();
		Card myCard = deck.get(20);
		if (myCard.testSwitch() == Color.black)
			System.out.println(myCard + " is black");
		else System.out.println(myCard + " is red");
	}
}
