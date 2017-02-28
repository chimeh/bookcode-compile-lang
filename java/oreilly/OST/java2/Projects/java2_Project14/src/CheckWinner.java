
public class CheckWinner {

  public static boolean checkWin(boolean[][] choices) {
    boolean win = false;
    
    if(choices[0][0] && choices[0][1] && choices[0][2]) {
      win = true;
    }
    else if(choices[1][0] && choices[1][1] && choices[1][2]) {
      win = true;
    }
    else if(choices[2][0] && choices[2][1] && choices[2][2]) {
      win = true;
    }
    else if(choices[0][0] && choices[1][0] && choices[2][0]) {
      win = true;
    }
    else if(choices[0][1] && choices[1][1] && choices[2][1]) {
      win = true;
    }
    else if(choices[0][2] && choices[1][2] && choices[2][2]) {
      win = true;
    }
    else if(choices[0][0] && choices[1][1] && choices[2][2]) {
      win = true;
    }
    else if(choices[0][2] && choices[1][1] && choices[2][0]) {
      win = true;
    }
    else {
      win = false;
    }
    
    return win;
  }
  
}
