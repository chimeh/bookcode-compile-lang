import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;

public class Craps extends Applet implements ActionListener {
	private Button die1, die2, roll;
	private int value1 = 0, value2 = 0;
	
	public void init() {
		die1 = new Button("Die1");
		add(die1);
		die1.addActionListener(this);
		
		die2 = new Button("Die2");
		add(die2);
		die2.addActionListener(this);
		
		roll = new Button("Roll");
		add(roll);
		roll.addActionListener(this);
		
		resize(400,300);
	}
	
	public void paint(Graphics g) {
		int total;
		total = value1 + value2;
		g.drawString("Die 1 is " + value1 + " Die 2 is " + value2, 40, 50);
		g.drawString("Total is " + total, 40, 65);
		
		if ((value1 == 1) && (value2 == 1))
			g.drawString("snake eyes!", 50, 110);
		else if ((value1 == 2) && (value2 == 2))
			g.drawString("hard four!", 50, 110);
		else if (((value1 == 5) && (value2 == 3)) || ((value1 == 3) && (value2 == 5)))
			g.drawString("easy eight!", 50, 110);
		else
			g.drawString("Please roll again.  Better luck next time!", 50, 110);
	}
	
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().toString() == "Die1")
			value1 = (int)(Math.random() * 6) + 1;
		else if (event.getActionCommand().toString() == "Die2")
			value2 = (int)(Math.random() * 6) + 1;
		else {
			value1 = (int)(Math.random() * 6) + 1;
			value2 = (int)(Math.random() * 6) + 1;
		}
		repaint();
	}
}
