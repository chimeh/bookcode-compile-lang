package bomb;

import java.awt.*;

public class World {
    private final int MAX_BOMBS = 5;
    private Bomb bombs[] = new Bomb[MAX_BOMBS];  // shared resource - 5 bombs shown at a time
    private int typeNext = -1;
    private int addNext = 0;
    private int num_bombs = 0;
    private boolean isFull = false;
    private boolean isEmpty = true;
    private boolean gameOver = false;

    public synchronized void type(char c) {
        while (isEmpty == true)                   // if no words/bombs in buffer, wait for some
        {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
                                                  // check if three bombs have already blown up
        int num_exploded = 0;
        for(int i = 0; i < MAX_BOMBS; i++)     // check bombs in current value of shared resource
        {   
            if (bombs[i] != null && bombs[i].exploded)
                num_exploded++;
        }
        if (num_exploded >= 3)
        {
            gameOver = true;
            return;
        }
                                                             // check if entered char matches a bomb and if its fully disarmed
        if (typeNext < 0 || (bombs[typeNext].exploded) )  // no current diffusing bomb or current bomb blew up
        {
            for(int i = 0;i<MAX_BOMBS; i++)
            {
                if (bombs[i] != null && !bombs[i].exploded && bombs[i].startsWith(c) )
                {
                     typeNext = i;
                     bombs[typeNext].setdisarming();
                     break;
                }
            }
        }
        if (typeNext > -1 && !bombs[typeNext].exploded && bombs[typeNext].attemptDisarm(c) )
        {
            bombs[typeNext] = null;
            num_bombs--;
            typeNext = -1;
            if (num_bombs == 0 ) 
            {
                isEmpty = true;
            }
            isFull=false;
            notifyAll();
        }
    }

    public synchronized boolean overlaps(Bomb b){  // cannot put bombs on top of each other
       for (int i = 0; i<MAX_BOMBS; i++)
       {
           if (bombs[i] != null && (bombs[i].hasPoint(b.getX(), b.getY()) || 
            bombs[i].hasPoint(b.getX()+b.getWidth(), b.getY()) || 
            bombs[i].hasPoint(b.getX(), b.getY()+b.getHeight()) || 
            bombs[i].hasPoint(b.getX()+b.getWidth(), b.getY()+b.getHeight()) ) )
           {
               return true;
           }
       }  
       return false;
    }

    public synchronized void clearBombs(){   // clear bombs to reset
        for (int i = 0; i<MAX_BOMBS; i++)
        {
            bombs[i] = null;  
        }
        typeNext = -1;
        addNext = 0;
        num_bombs = 0;
        isFull = false;
        isEmpty = true;
        gameOver = false;
        notifyAll();
    }

    public synchronized void add(Bomb b) {  // add a bomb
        while (isFull == true)              // cannot add if full
        {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        //check for empty bomb spot
        int i;
        for (i = 0; i<MAX_BOMBS; i++)
        {
            if (bombs[i] == null)           // find empty space in array
            {
                bombs[i] = b; 
                break;                      // once find space, get out of for loop
            }
        }
        assert bombs[i] == b;
        num_bombs++;
        bombs[i].start();                   // light the fuse baby!

        if (num_bombs == MAX_BOMBS) 
        {
            isFull = true;
        }
        isEmpty = false;
        notifyAll();
    }

    public void draw(Graphics g){           // draw all of the bombs--called from Applet
        for (int i=0; i<MAX_BOMBS; i++)
        {
            if (bombs[i] != null)
                bombs[i].draw(g);
        }
        if (gameOver)
        {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Monospaced", Font.PLAIN, 23));
            g.drawString("GAME OVER", 10, 390);
        }
    }
}
