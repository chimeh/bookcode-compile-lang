package games;

import java.util.List;
import javax.swing.*;

class CardDemo extends JFrame {
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
		for (ImageIcon each : aVisualDeck) {
			RealCards card = new RealCards(each);
			card.moveTo(xPos, yPos);
			_deck[n] = card;
			
			xPos += 5;
			yPos += 4;
			n++;
		}
	}
}
