import java.awt.*;
import java.applet.*;
import java.awt.event.*;

//***********************************************************************
// class that handles mouse events
//
// keeping track of the mouse location and whether 
// or not a button is pressed
//***********************************************************************
class TheMouseHandler extends MouseAdapter 
{
  ComputeFigure theCurrentApplet;

  public  TheMouseHandler(ComputeFigure x)
  {
    theCurrentApplet=x;
  }

  public void mouseEntered(MouseEvent e)
  {
    theCurrentApplet.x=0;
    theCurrentApplet.y=0;
    theCurrentApplet.width=0;
    theCurrentApplet.height=0;
    theCurrentApplet.repaint(); 
    
  }
  
  public void mouseExited(MouseEvent e)
  {
    theCurrentApplet.x=0;
    theCurrentApplet.y=0;
    theCurrentApplet.width=0;
    theCurrentApplet.height=0;  
    theCurrentApplet.repaint();
  }

  public void mouseDragged(MouseEvent e)
  {
    theCurrentApplet.width=e.getX()-theCurrentApplet.x;
    theCurrentApplet.height=e.getY()-theCurrentApplet.y;
    
    theCurrentApplet.repaint(); 
  }
  
  public void mouseMoved(MouseEvent e)
  { 
    //empty on purpose
  }

  public void mousePressed(MouseEvent e)
  { 
    theCurrentApplet.x=e.getX();
    theCurrentApplet.y=e.getY();  
  }
}

//******************************************************************
// class that handles which button has been pushed
//
//
//******************************************************************
class TheButtonHandler implements ActionListener
{
  
  ComputeFigure CurrentApplet;

  public void actionPerformed(ActionEvent e)
  {
    
    System.out.println(e.getActionCommand());
    CurrentApplet.figure=e.getActionCommand();
    
  }
  
  public TheButtonHandler(ComputeFigure x)
  {
    CurrentApplet=x;
  }

}

//*****************************************************************
public class ComputeFigure extends Applet
{
  //gui elements
  Button circleButton;
  Button rectangleButton;
  TheMouseHandler mouseManager;
  TheButtonHandler buttonManager;
  Panel holdbuttons;

  //instance variables
  int x,y,height,width;
  String figure;

  public void init()
  {
    //instanciate classes 
    mouseManager=new TheMouseHandler(this);
    buttonManager=new TheButtonHandler(this);
    holdbuttons=new Panel(); 
    circleButton=new Button("Circle");
    rectangleButton=new Button("Rectangle");
    
    //set initial default values
    figure="Circle";
    x=50;
    y=50;
    width=50;
    height=50;
    
    addMouseMotionListener(mouseManager);
    addMouseListener(mouseManager);
    
    circleButton.addActionListener(buttonManager);
    circleButton.setBackground(Color.red);
    
    rectangleButton.addActionListener(buttonManager);
    rectangleButton.setBackground(Color.green);
    
    setLayout(new BorderLayout());
    holdbuttons.add(circleButton);
    holdbuttons.add(rectangleButton);
    add("North",holdbuttons);
    setBackground(Color.pink);
    
    
  }

  public void paint(Graphics g)
  {
  
    if(figure.equals("Circle") )
    {
      g.drawOval(x,y,width,height);

      //put computations here for circle
      g.drawString("Area is: " + (Math.pow((width/2), 2)*Math.PI), 10, 150);
      g.drawString("Center point is:(" + (x + (width/2)) + "," +(y + (height/2)) + ")",10, 165);
      g.drawString("Top left corner is:("+ x +","+ y + ")", 10, 180);

      //end circle computations

    }
    else
    {
      g.drawRect(x,y,width,height);

      //put computations here for rectangle
      g.drawString("Area is: " + (width*height), 10, 150);
      g.drawString("Center point is:(" + (x + (width/2)) + "," +(y + (height/2)) + ")",10, 165);
      g.drawString("Top left corner is:("+ x +","+ y + ")", 10, 180);

      //end Rectangle computations
    }
  }
}
