
public class Player {
  
  private boolean isTurn = false;
  private boolean[][] chosenBoxes = new boolean[3][3];

  public boolean isTurn() {
    return isTurn;
  }

  public void setTurn(boolean isTurn) {
    this.isTurn = isTurn;
  }

  public boolean [][] getChosenBoxes() {
    return chosenBoxes;
  }

  public void setChosenBoxes(int i, int j, boolean val) {
    this.chosenBoxes[i][j] = val;
  }
  
  public void resetChosenBoxes() {
    for(int i=0;i <chosenBoxes.length; i++) {
      for(int j=0; j < chosenBoxes[i].length; j++) {
        this.setChosenBoxes(i,j, false);
      }
    }
  }
}
