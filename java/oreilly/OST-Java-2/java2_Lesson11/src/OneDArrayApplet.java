import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
     
public class OneDArrayApplet extends Applet {
    private final int START_X = 25;
    private final int START_Y = 70;
    private final int BOX_WIDTH = 60;
    private final int BOX_HEIGHT = 20;
     
    private ClickableBox[] boxes = new ClickableBox[6];
    
    private Color[] boxColors = { Color.blue, Color.red, Color.green, Color.cyan,
         Color.magenta, Color.yellow };
    
    private Button resetColors = new Button("Reset Colors");
         
    public void init() {
        for (int i = 0; i < boxes.length; i++) {
            boxes[i] = new ClickableBox(START_X, START_Y + i * BOX_HEIGHT, BOX_WIDTH,
             BOX_HEIGHT, Color.black, Color.red, true, this);
            this.addMouseListener(boxes[i]);
        }
        defaultBoxColors();
        resetColors.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		defaultBoxColors();
        		repaint();
        	}
        });
        this.add(resetColors);
    }
    
    public void paint(Graphics g) {
        for(int i = 0; i < boxes.length; i++) {
            if (boxes[i].isClicked()) {
            	boxes[i].setBackColor(new Color(
            			(int)(Math.random() * 256),
            			(int)(Math.random() * 256),
            			(int)(Math.random() * 256)));
            	boxes[i].setClicked(false);
            }
        	boxes[i].draw(g);
        }
    }
    
    public void defaultBoxColors() {
        for(int i = 0; i < boxes.length; i++) {
            boxes[i].setBackColor(boxColors[i]);
        }
    }
}

