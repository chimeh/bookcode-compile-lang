import java.applet.Applet;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NestTest5 extends Applet {
	private static int count = 0;
	public void init() {
		final Button myButton = new Button("I've been pressed " + count + " times.");
		myButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				myButton.setLabel("I've been pressed " + count + " times.");
			}
		});
		add(myButton);
	}
}
