package bomb;

import java.applet.Applet;

public class Producer extends Thread {
    private World myWorld;
    private String bank = "qwertyuiopasdfghjklzxcvbnm";  // alphabet characters from standard keyboard
    private Applet apl;
    private int bombRate = 2000;                         // rate can be fast or slow
    
    public Producer(World myWorld, Applet apl) {
        this.myWorld = myWorld;
        this.apl = apl;
    }

    public void toggleBombRate(){                        // user can change speed with GUI button
       if (bombRate == 2000)
           bombRate = 4000;
       else
           bombRate = 2000;
    }
  
    public void run() {
        String str;
        while (true)
        {
            int length = (int)Math.ceil(Math.random() * 6 );             // random length
            char []str_arry = new char[length];
            for (int i = 0; i < length; i++)
            {
                str_arry[i] = bank.charAt((int)(Math.random() * bank.length() ));   // random placement in string
            }
            str = new String(str_arry);
            //str = bank[((int)(Math.random() * 10))];
            int x = ((int)(Math.random() * 500));                        // random location
            int y = ((int)(Math.random() * 335));
            Bomb b = new Bomb(str, x, y, apl);
            while (myWorld.overlaps(b) )
            {
                b = new Bomb(str, b.getX()+10, y, apl);                   // prevent bomb overlaps
            }
            myWorld.add(b);
            System.out.println("Added bomb " + str + " to the world at "+b.getX()+", "+b.getY() );
            apl.repaint();
            try {
                sleep(bombRate);                                         // put up new words at speed of rate
            }
            catch (InterruptedException e) { }
        }
    }
}

