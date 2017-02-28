import java.applet.Applet;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonTest extends Applet {
	String msg = "";
	public void init() {
		Button okButton = new Button("Click Here");
		
		//add an anonymous inner class as an ActionListener.
		okButton.addActionListener(new ActionListener() {
			//Create the actionPerformed method.
			public void actionPerformed(ActionEvent e) {
				//Whatever you want to happen when the button is pressed
				//goes in this method.
				msg = "Button Pressed";
				repaint();
			}
		});
		add(okButton);
	}
	public void paint(Graphics g) {
		g.drawString(msg, 20, 60);
	}
}
