//This class will be used by DukesMood which will inherit from Dukes
//It will give a Duke who can make Pins using hearts, crowns, stars, triangles, etc.

import java.awt.*;

public class PinImages {
	public void drawHeart(Graphics g, Color col, int x, int y, int width) {
		//I "heart" Duke
		g.setColor(col);
		g.fillArc(x, y, width/2, width/2, 0, 180);
		g.fillArc(x+width/2, y, width/2, width/2, 0, 180);
		int [] xTriangle = {x, x+width, x+width/2};
		int [] yTriangle = {y+width/4, y+width/4, y+width};
		g.fillPolygon(xTriangle, yTriangle, 3);
	}
	
	public void fillTriangle(Graphics g, int bottomX, int bottomY, int base, int height) {
		//isosceles base at bottom
		g.drawLine(bottomX, bottomY, bottomX+base, bottomY);
		g.drawLine(bottomX+base, bottomY, bottomX+base/2, bottomY-height);
		g.drawLine(bottomX+base/2, bottomY-height, bottomX, bottomY);
		int [] xTriangle = {bottomX, bottomX+base, bottomX+base/2};
		int [] yTriangle = {bottomY, bottomY, bottomY-height};
		g.fillPolygon(xTriangle, yTriangle, 3);
	}
	
	public void upArrow(Graphics g, Color col, int x, int y, int arrowbase) {
		//Duke is movin' on UP
		g.setColor(col);
		fillTriangle(g, x, y, arrowbase, arrowbase/2);
		g.fillRect(x+ 3*arrowbase/8, y, arrowbase/4, arrowbase);
	}
}
