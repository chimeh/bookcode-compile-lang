import java.awt.*;
import javax.swing.*;

public class HelloWorld2 extends JApplet {
	public void init() {
		Container contentPane = getContentPane();
		JLabel label = new JLabel("Hello Again, World!", SwingConstants.CENTER);
		contentPane.add(label);
	}
}
