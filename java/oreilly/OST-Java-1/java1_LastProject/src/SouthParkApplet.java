import java.applet.Applet;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SouthParkApplet extends Applet implements ItemListener {
	private int whichOne = 0;
	
	public void init() {
		Choice actionList = new Choice();
		actionList.add("Cartman");    
		actionList.add("Stan");
		actionList.add("Kyle");
		
		actionList.addItemListener(this);  
		add(actionList); 
		
		setBackground(Color.white);
		resize(350,280);
	}
	
	public void paint(Graphics g) {
		SouthPark myCharacter = new SouthPark(g);
		if (whichOne == 0) {
			myCharacter.drawCartman();
			myCharacter.setQuote("I'm not fat!  I'm just big boned.");
			g.drawString(myCharacter.getQuote(), 90, 230);
		} else if (whichOne == 1) {
			myCharacter.drawStan();
			myCharacter.setQuote("Dolphins are intelligent and friendly.");
			g.drawString(myCharacter.getQuote(), 70, 230);
		} else if (whichOne == 2) {
			myCharacter.drawKyle();
			myCharacter.setQuote("I said rabbits eat lettuce.");
			g.drawString(myCharacter.getQuote(), 100, 230);
		}
	}
	
	public void itemStateChanged(ItemEvent evt) {	
		whichOne = ((Choice)evt.getItemSelectable()).getSelectedIndex();
		repaint();
	}
}
