package classes;

import java.awt.*;

public class ColoredRect extends DrawableRect {

    protected Color border, fill;

    public ColoredRect(int x1, int y1, int x2, int y2, Color border, Color fill) {
        super(x1, y1, x2, y2);
        this.border = border;
        this.fill = fill;
    }

    public void draw(Graphics g) {
        g.setColor(fill);
        g.fillRect(x1, y1, (x2 - x1), (y2 - y1));
        g.setColor(border);
        g.drawRect(x1, y1, (x2 - x1), (y2 - y1));
    }
}
