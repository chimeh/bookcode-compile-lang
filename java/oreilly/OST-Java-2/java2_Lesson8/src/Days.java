import java.applet.Applet;
import java.awt.*;

public class Days extends Applet {
	private int day;
	
	public void start() {
		setSize(200,900);
	}
	
	public void paint(Graphics g) {
		for (day = 1; day < 8; day++) {
			g.drawString("Day is " + day, 50, 100*day);
			
			switch (day) {
				case 1: g.drawString("Monday", 50, 100*day + 10); //break;
				case 2: g.drawString("Tuesday", 50, 100*day + 10); //break;
				case 3: g.drawString("Wednesday", 50, 100*day + 10); //break;
				case 4: g.drawString("Thursday", 50, 100*day + 10); //break;
				case 5: g.drawString("Friday", 50, 100*day + 10); //break;
				case 6: g.drawString("Saturday", 50, 100*day + 10); //break;
				case 7: g.drawString("Sunday", 50, 100*day + 10); //break;
				default: g.drawString("Not a day", 50, 790); 
			}
		}	
	}
}
