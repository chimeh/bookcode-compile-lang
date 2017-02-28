package bomb;

import java.awt.event.*;
import java.awt.*;
import java.applet.Applet;

public class TypeOrDie extends Applet implements ActionListener {
    World myWorld;
    Button start_btn;
    Button slow_fast_btn;
    boolean started = false;
    Producer p1;
    Consumer c1;
  
    public void init(){
        setSize(560,400);

        start_btn = new Button("Start");   // add the buttons and listeners
        slow_fast_btn = new Button("Slower");
        start_btn.addActionListener(this);
        slow_fast_btn.addActionListener(this);
        this.add(start_btn);
        this.add(slow_fast_btn);
        myWorld = new World();             // instantiate everyone
        p1 = new Producer(myWorld, this);
        c1 = new Consumer(myWorld, this);
    }
  
    public void paint(Graphics g) {
        Dimension dim = getSize();         // set up double buffer 
        Image offscreen = createImage(dim.width, dim.height);         
        Graphics bufferGraphics = offscreen.getGraphics();
        bufferGraphics.clearRect(0,0, dim.width, dim.height);
  
        myWorld.draw(bufferGraphics);

        g.drawImage(offscreen, 0, 0, this);
    }

    public void update (Graphics g){
        paint(g);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getActionCommand() == "Slower")
        {
            p1.toggleBombRate();
            slow_fast_btn.setLabel("Faster");
        }
        else if(e.getActionCommand() == "Faster")
        {
            p1.toggleBombRate();
            slow_fast_btn.setLabel("Slower");
        }
        else
        {
            myWorld.clearBombs();
            if (!started)                   // start the word creation
            {
                p1.start();
                started = true;
                start_btn.setLabel("Again");
            }
        }
        this.requestFocus();
    }
}

