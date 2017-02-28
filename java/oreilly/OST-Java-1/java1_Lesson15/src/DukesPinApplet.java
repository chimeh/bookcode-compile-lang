import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class DukesPinApplet extends Applet implements ItemListener {
	DukesPin myDuke;
	String action;
	Checkbox showPin;
	Graphics g;
	
	public void init() {
		Choice actionList = new Choice();
		actionList.add("wave");
		actionList.add("think");
		actionList.add("write");
		
		actionList.addItemListener(this);
		add(actionList);
		
		myDuke = new DukesPin();
		action = myDuke.getActionImage();
		Checkbox changeMood = new Checkbox("Angry", myDuke.isAngry());
		add(changeMood);
		changeMood.addItemListener(this);
		
		showPin = new Checkbox("ShowPin");
		add(showPin);
		showPin.addItemListener(this);	
	}
	
	public void paint(Graphics g) {
		this.g = g;
		Image actionChoice = getImage(getDocumentBase(), action);
		g.drawString(myDuke.getAction(), 10, 165);
		g.drawString(myDuke.getMessage(), 10, 180);
		g.drawImage(actionChoice, 20, 50, Color.white, this);
		
		g.drawString(myDuke.getAngryMessage(), 110, 140);
		if (myDuke.isShowingPin())
			makePin();
		else clearPin();
	}
	
	public void itemStateChanged(ItemEvent evt) {
		if (evt.getItem().toString() == "Angry") {
			myDuke.setMood();
			if (!myDuke.isAngry())
				showPin.setState(false);
		} 
		else if (evt.getItem().toString() == "ShowPin") {
			myDuke.switchShowingPin();
			if (showPin.getState() && !myDuke.isAngry())
				showPin.setState(false);
		}
		else
		{
			int which = ((Choice)evt.getItemSelectable()).getSelectedIndex();
			switch (which) {
			case 0: action = myDuke.wave(); break;
			case 1: action = myDuke.think(); break;
			case 2: action = myDuke.write(); break;
			}
		}
		repaint();
	}
	
	public void makePin() {
		PinImages images = new PinImages();
		//make Pin
		g.setColor(Color.red);
		g.fillOval(120, 50, 80, 80);
		//put something in Pin
		g.setColor(Color.white);
		g.drawString("I", 155, 70);
		images.drawHeart(g, Color.pink, 145, 75, 25);
		g.setColor(Color.white);
		g.drawString("Duke!", 145, 120);
	}
	
	public void clearPin() {
		g.setColor(Color.white);
		g.fillOval(120, 50, 80, 80);
	}
}
