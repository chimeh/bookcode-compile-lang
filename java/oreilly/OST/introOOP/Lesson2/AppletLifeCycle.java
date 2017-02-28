import java.applet.*;
import java.awt.*;

public class AppletLifeCycle extends Applet {
	
	StringBuffer buffer;
	
	public void init() {
	buffer = new StringBuffer();
		addItem("initializing the Applet");
	}
	
	public void start() {
		addItem("starting the Applet ");
	}
	
	public void stop() {
		addItem("stopping the Applet ");
	}
	
	public void destroy() {
		addItem("preparing for unloading");
	}
	
	void addItem (String newWord) {
		System.out.println(newWord);
		buffer.append(newWord);
		repaint();
	}
	
	public void paint(Graphics g) {
		g.drawRect(0, 0, getSize().width - 1, getSize().height - 1);
		
		g.drawString(buffer.toString(), 5, 15);
	}
}

	
	
	