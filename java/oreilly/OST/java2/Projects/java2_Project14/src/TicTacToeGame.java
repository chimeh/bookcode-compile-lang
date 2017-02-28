import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGame extends Applet {

  private final int START_X = 20;
  private final int START_Y = 40;
  private final int ROWS = 3;
  private final int COLS = 3; 
  private final int BOX_WIDTH = 70;
  private final int BOX_HEIGHT = 70;
  private TicTacToeBox boxes[][];
  private Button resetButton;

  Player p1 = new Player();
  Player p2 = new Player();
  
  public void init() {
    resize((ROWS*BOX_WIDTH)+250, (COLS*BOX_HEIGHT)+50);
    boxes = new TicTacToeBox[ROWS][COLS];
    resetButton = new Button("Reset Game");
    resetButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        buildBoxes();
        repaint();
        p1.resetChosenBoxes();
        p2.resetChosenBoxes();
        p1.setTurn(true);
        p2.setTurn(false);
      }
    });
    add(resetButton);
    buildBoxes();
    p1.setTurn(true);
    
  }
  
  public void paint(Graphics g) {
    
    for(int row = 0; row < boxes.length; row++) {
      for(int col = 0; col < boxes[row].length; col++) {
        if(boxes[row][col].isClicked()) 
            gameLogic(boxes[row][col], row, col);
            
        }
      }
    
    for(int row = 0; row < boxes.length; row++) {
      for(int col =0; col < boxes[row].length; col++) {
        boxes[row][col].draw(g);
      }
    }
    
    if(p1.isTurn()) {
      g.drawString("Player 1's turn", 10, 15);
    }
    
    if(p2.isTurn()) {
      g.drawString("Player 2's turn", 10, 15);
    }
    
    if(CheckWinner.checkWin(p1.getChosenBoxes())){
      g.drawString("Player 1 has won", 10, 15);
      p1.setTurn(false);
      p2.setTurn(false);
    }
    
    if(CheckWinner.checkWin(p2.getChosenBoxes())){
      g.drawString("Player 2 has won", 10, 15);
      p1.setTurn(false);
      p2.setTurn(false);
    }
   }
  
  private void buildBoxes() {
    for(int row = 0; row< boxes.length; row++) {
      for(int col = 0; col <boxes[row].length; col++) {
        boxes[row][col] =
            new TicTacToeBox(START_X + col * BOX_WIDTH,
                             START_Y + row * BOX_HEIGHT,
                             BOX_WIDTH,
                             BOX_HEIGHT,
                             Color.black,
                             Color.white,
                             true,
                             false,
                             this);
            addMouseListener(boxes[row][col]);
      }
    }
  }
  
  public void gameLogic(TicTacToeBox boxes, int row, int col) {
      
      if(p1.isTurn()) {
            if(boxes.isClicked()) {
              boxes.setMarkX(true);
              repaint();
              boxes.setClicked(false);
              removeMouseListener(boxes);
              p1.setChosenBoxes(row, col, true);
              CheckWinner.checkWin(p2.getChosenBoxes());
              p1.setTurn(false);
              p2.setTurn(true);
              
              
            }
      }
      
      if(p2.isTurn()) {
            if(boxes.isClicked()) {
              boxes.setMarkO(true);
              repaint();
              boxes.setClicked(false);
              removeMouseListener(boxes);
              p2.setChosenBoxes(row, col, true);
              CheckWinner.checkWin(p2.getChosenBoxes());
              p2.setTurn(false);
              p1.setTurn(true);
            }
       }
  }
  
  
  
}