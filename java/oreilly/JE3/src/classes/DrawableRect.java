package classes;

import java.awt.Graphics;

public class DrawableRect extends Rect {

    public DrawableRect(int x1, int y1, int x2, int y2) { super(x1, y1, x2, y2); }

    public void draw(Graphics g) {
        g.drawRect(x1, y1, (x2 - x1), (y2 - y1));
    }

}
