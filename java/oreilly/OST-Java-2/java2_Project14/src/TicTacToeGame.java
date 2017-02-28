import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGame extends Applet {
    private final int START_X = 70;
    private final int START_Y = 60;
    private final int ROWS = 3;
    private final int COLS = 3; 
    private final int BOX_WIDTH = 20;
    private final int BOX_HEIGHT = 20;
    private String currentChar;
    
    private Button resetButton;
    private TicTacToeBox boxes[][];
    
    public void init() {
    	boxes = new TicTacToeBox[ROWS][COLS];
    	resetButton = new Button("New Game");
    	resetButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			buildBoxes();
    			currentChar = "O";
    			repaint();
    		}
    	});
    	add(resetButton);
    	buildBoxes();
    	currentChar = "O";
    }
    
    public void paint(Graphics g) {
    	for (int row = 0; row < boxes.length; row++) {
    		for (int col = 0; col < boxes[row].length; col++) {
    			if (boxes[row][col].isClicked()) {
    				boxes[row][col].setMask(!boxes[row][col].isMask());
    				boxes[row][col].setClicked(false);
    				boxes[row][col].setBoardChar(changeChar());
    			}
    		}
    	 }
    	 g.setColor(Color.black);
    	 g.drawString(gameLogic(), 15, 50);
    	 for (int row = 0; row < boxes.length; row++) {
    		 for (int col = 0; col < boxes[row].length; col++) {
    			 boxes[row][col].draw(g);
    		 }
    	 }
    } 
    
    public String gameLogic() {
    	String gameMessage = "";
    	//win from rows
    	for (int row = 0; row < boxes.length; row++) {
    		if ((boxes[row][0].getBoardChar() != "") && (boxes[row][0].getBoardChar() == boxes[row][1].getBoardChar()) 
    				&& (boxes[row][1].getBoardChar() == boxes[row][2].getBoardChar())) {
    			gameMessage = "You win!!";
    		}	
    	}
    	//win from cols
    	for (int row = 0; row < boxes.length; row++) {
    		for (int col = 0; col < boxes[row].length; col++) {
    			if ((boxes[0][col].getBoardChar() != "") && (boxes[0][col].getBoardChar() == boxes[1][col].getBoardChar()) 
    					&& (boxes[1][col].getBoardChar() == boxes[2][col].getBoardChar())) {
    				gameMessage = "You win!!";
    			}	
    		}
    	}
    	//win diagonal	
    	if ((boxes[0][0].getBoardChar() != "") && (boxes[0][0].getBoardChar() == boxes[1][1].getBoardChar()) 
    			&& (boxes[1][1].getBoardChar() == boxes[2][2].getBoardChar()) || 
    			(boxes[0][2].getBoardChar() != "") && (boxes[0][2].getBoardChar() == boxes[1][1].getBoardChar()) 
    			&& (boxes[1][1].getBoardChar() == boxes[2][0].getBoardChar())) {
    		gameMessage = "You win!!";
    	}
    	return gameMessage;
    }
    
    public String changeChar() {
    	if (currentChar == "X") {
    		currentChar = "O";
    	} else {
    		currentChar = "X";
    	}
    	return currentChar;
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
   				boxes[row][col] = new TicTacToeBox(START_X + col * BOX_WIDTH,
   												START_Y + row * BOX_HEIGHT,
   												BOX_WIDTH,
   												BOX_HEIGHT,
   												Color.gray,
   												Color.cyan,
   												true,
   												this,""); 
   				addMouseListener(boxes[row][col]);
   			}
   		}
   	}
}


