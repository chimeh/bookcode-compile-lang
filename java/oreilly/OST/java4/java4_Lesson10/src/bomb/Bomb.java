package bomb;

import java.awt.*;
import java.applet.Applet;

public class Bomb extends Thread {
  String word;
  int x, y, ticker;
  int width = 62;
  int height = 65;
  Applet apl;
  boolean being_disarmed = false;
  boolean disarmed = false;
  boolean exploded = false;
  int amount_disarmed = 0;
  Image bomb;
  
  public Bomb(String word, int x, int y, Applet apl) {
    super(word);
    this.word = word;
    this.x = x;
    this.y = y;
    this.ticker = word.length()*6;
    this.apl = apl;
    bomb = apl.getImage(this.apl.getDocumentBase(), "../images/bomb.png");
  }
  
  public void run() {
    while (ticker > 0) {
      
      try {
        sleep(600);
      }
      catch (InterruptedException e) {}
      ticker--;
      if(disarmed) {
        break;
      }
      apl.repaint();
    }
    exploded = true;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getWidth() {
    return width;
  }


  public int getHeight() {
    return height;
  }

  public void draw(Graphics g) {
    if (!exploded) {
      g.drawImage(bomb, x, y, Color.WHITE, apl);
      g.setFont(new Font("Monospaced", Font.PLAIN, 12));
      g.setColor(Color.RED);
      g.drawChars(word.toCharArray(), 0, amount_disarmed, x, y+60);
      g.setColor(Color.BLACK);
      if(amount_disarmed != word.length()) {
        g.drawChars(word.toCharArray(), amount_disarmed, word.length()-amount_disarmed, x+(amount_disarmed*7), y+60);
      }
      if(being_disarmed) {
        g.setColor(Color.BLUE);
        g.drawRoundRect(x-2, y+49, word.length()*9, 14, 10, 10);
      }
      
      g.setColor(Color.RED);
      double bar = (double)ticker/(word.length()*5);
      g.fillRect(x, y+64, (int)(word.length()*7*bar), 5);
    }
    else {
      g.setColor(Color.RED);
      g.setFont(new Font("Courier Bold", Font.PLAIN, 12));
      g.drawString("KABOOM!!!", x, y+30);
    }
  }
  
  public boolean startsWith(char c) {
    if (word.charAt(0) == c) {
      return true;
    }
    return false;
  }
  
  public boolean exploded() {
    return exploded;
  }
  
  public boolean hasPoint(int x, int y){                    
    if ( (this.x <= x && x <= (this.x + this.width)) && (this.y <= y && y <= (this.y + this.height)) )
        return true;
    else
        return false; 
}

public void setdisarming(){   
    being_disarmed = true;                                  
}

public void setarming(){  
    being_disarmed = false;                               
}

public boolean attemptDisarm(char c){  
    assert amount_disarmed < word.length();             
    if (word.charAt(amount_disarmed) == c)                 
    {                                                      
        amount_disarmed++;
                                                         
        if (amount_disarmed == word.length())
        {
            disarmed = true;
            return true;
        }
        return false;
    }
    return false;
}

}
