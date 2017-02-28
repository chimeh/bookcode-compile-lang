import java.applet.*;
import java.awt.*;

public class ScoreApplet extends Applet {

	public int quizScore = 3;

	public void paint(Graphics g) {
	
		g.drawString(Integer.toString(quizScore), 10, 10);
	}
}