import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessingGame extends Applet {
    private final int START_X = 20;
    private final int START_Y = 40;
    private final int ROWS = 4;
    private final int COLS = 4; 
    private final int BOX_WIDTH = 20;
    private final int BOX_HEIGHT = 20;
    
    private Color boxColors[][];
    
    private Button resetButton;
    private MaskableBox boxes[][];
    
    private boolean matchedBoxes[][];
    private MaskableBox chosenBoxes[];
    
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
    				boxes[row][col].setClicked(false);
    				if (!matchedBoxes[row][col]) {
    					gameLogic(boxes[row][col]);
    				}
    			}
    		}
    	 }
    	 for (int row = 0; row < boxes.length; row++) {
    		 for (int col = 0; col < boxes[row].length; col++) {
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
    	chosenBoxes = new MaskableBox[2];
    	matchedBoxes = new boolean [ROWS][COLS];

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
    												this, true); 
    			addMouseListener(boxes[row][col]);
    			boxes[row][col].setMask(true);
    		}
    	}
    }
    
    public void gameLogic(MaskableBox box) {
    	if ((chosenBoxes[0] != null) && (chosenBoxes[1] != null)) {
    		//we need to check to see if their colors match.
    		if (chosenBoxes[0].getBackColor().equals(chosenBoxes[1].getBackColor())) {
    			//we need to set each of their corresponding matchedBoxes elements
    			//to true so game logic won't be called if those boxes are clicked
    			//again.
    			for (int i = 0; i < chosenBoxes.length; i++) {
    				for (int row = 0; row < boxes.length; row++) {
    		    		for (int col = 0; col < boxes[row].length; col++) {
    		    			if (boxes[row][col] ==  chosenBoxes[i]) {
    		    				matchedBoxes[row][col] = true;
    		    				break;
    		    			}
    		    		}
    				}
    			}
    		} else {
    			//the background colors do not match
    			chosenBoxes[0].setMask(true);
    			chosenBoxes[1].setMask(true);
    		}
    		//we need to reset the chosenBoxes array elements to null.
    		chosenBoxes = new MaskableBox[2]; 
    	}
    	
    	if (chosenBoxes[0] == null) {
    		//we have no boxes already chosen.
    		chosenBoxes[0] = box;
       	 	chosenBoxes[0].setMask(false);	
       	 	return;
    	} else {
    		if (chosenBoxes[1] == null) {
    			chosenBoxes[1] = box;
      	  		chosenBoxes[1].setMask(false);
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

