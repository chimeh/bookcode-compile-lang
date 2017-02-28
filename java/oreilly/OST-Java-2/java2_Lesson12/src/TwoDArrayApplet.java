import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TwoDArrayApplet extends Applet {
    private final int START_X = 20;
    private final int START_Y = 40;
    private final int ROWS = 4;
    private final int COLS = 4; 
    private final int BOX_WIDTH = 20;
    private final int BOX_HEIGHT = 20;
    
    private Color boxColors[][];
    
    private Button resetButton;
    private MaskableBox boxes[][];
    
    public void init() {
    	boxes = new MaskableBox[ROWS][COLS];
    	boxColors = new Color[ROWS][COLS];
    	resetButton = new Button("Reset Colors");
    	resetButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			randomizeColors();
    			buildBoxes();
    			repaint();
    		}
    	});
    	add(resetButton);
    	randomizeColors();
    	buildBoxes();
    }
    
    public void paint(Graphics g) {
    	for (int row = 0; row < boxes.length; row++) {
    		for (int col = 0; col < boxes[row].length; col++) {
    			if (boxes[row][col].isClicked()) {
    				boxes[row][col].setMaskColor(Color.black);
    				boxes[row][col].setMask(!boxes[row][col].isMask());
    				boxes[row][col].setClicked(false);
    			}
    			boxes[row][col].draw(g);
    		}
    	}
    }
    
    private void removeMouseListeners() {
    	for (int row = 0; row < boxes.length; row++) {
    		for (int col = 0; col < boxes[row].length; col++) {
    			removeMouseListener(boxes[row][col]);
    		}
    	}
    }
    
    private void buildBoxes() {
    	removeMouseListeners();
    	for (int row = 0; row < boxes.length; row++) {
    		for (int col = 0; col < boxes[row].length; col++) {
    			boxes[row][col] = new MaskableBox(START_X + col * BOX_WIDTH,
    												START_Y + row * BOX_HEIGHT,
    												BOX_WIDTH,
    												BOX_HEIGHT,
    												Color.gray,
    												boxColors[row][col],
    												true,
    												this); 
    			addMouseListener(boxes[row][col]);
    		}
    	}
    }
    
    private void randomizeColors() {
    	int[] chosenColors = {0,0,0,0,0,0,0,0};
    	Color[] availableColors = {Color.red, Color.blue, Color.green, Color.yellow, Color.cyan, Color.magenta, Color.pink, Color.orange};
    	for (int row = 0; row < boxes.length; row++) {
    		for (int col = 0; col < boxes[row].length; col++) {
    			for (;;) {
    				int rnd = (int)(Math.random() * 8);
    				if (chosenColors[rnd] < 2) {
    					chosenColors[rnd]++;
    					boxColors[row][col] = availableColors[rnd];
    					break;
    				}
    			}
    		}
    	}
    }   
}

