package games;

import java.util.List;
import javax.swing.*;
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

public class CardDemoApplet extends Applet {
	Graphics bufferGraphics;
	Image doubleBuffer;
	private static RealCards[] _deck = new RealCards[52];
	CardTable table;
	
	public void init() {
		resize(400,400);
		makeCards();
		table = new CardTable(_deck);
		add(table);
	}
	
	public void makeCards() {
		int n = 0;
		int xPos = 0;
		int yPos = 0;
		
		Deck myDeck = new Deck();
		List<ImageIcon> aVisualDeck = myDeck.getVisualDeck();
		for (ImageIcon each: aVisualDeck) {
			RealCards card = new RealCards(each);
			card.moveTo(xPos, yPos);
			_deck[n] = card;
			
			xPos += 5;
			yPos += 4;
			n++;
		}
	}
	
	public void update (Graphics g) {
		if (doubleBuffer == null) {
			doubleBuffer = createImage(this.getSize().width, this.getSize().height);
			bufferGraphics = doubleBuffer.getGraphics();
		}
		
		bufferGraphics.setColor(getBackground());
		bufferGraphics.fillRect(0, 0, this.getSize().width, this.getSize().height);
		
		bufferGraphics.setColor(getForeground());
		
		table.paintComponent(bufferGraphics);
		g.drawImage(doubleBuffer, 0, 0, this);
	}
	
	public void paint(Graphics g) {
		update(g);
	}
}
