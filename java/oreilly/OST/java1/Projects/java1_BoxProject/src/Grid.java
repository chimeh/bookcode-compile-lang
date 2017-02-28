import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Grid extends Applet implements ActionListener{
  
  Box box1,box2,box3,box4,box5,box6,box7,box8,box9,box10,box11,box12,box13,box14,box15,box16;
  Color colorVal1,colorVal2,colorVal3,colorVal4,colorVal5,colorVal6,colorVal7,colorVal8,colorVal9,colorVal10,colorVal11,colorVal12,colorVal13;
  Color[] colorList = new Color[14]; // Creating array to store the different color values for the boxes
  Random rand = new Random();
  
  
  public void init() {
    
    Button b = new Button("Click Me");
    b.addActionListener(this);
    
    resize(300,100);
    add(b);
    
    colorList[1] = Color.blue;
    colorList[2] = Color.green;
    colorList[3] = Color.yellow;
    colorList[4] = Color.black;
    colorList[5] = Color.cyan;
    colorList[6] = Color.orange;
    colorList[7] = Color.pink;
    colorList[8] = Color.gray;
    colorList[9] = Color.magenta;
    colorList[10] = Color.white;
    colorList[11]= Color.lightGray;
    colorList[12] = Color.darkGray;
    colorList[13] = Color.red;
    
    colorVal1 = colorList[rand.nextInt(13)];
    colorVal2 = colorList[rand.nextInt(13)];
    colorVal3 = colorList[rand.nextInt(13)];
    colorVal4 = colorList[rand.nextInt(13)];
    colorVal5 = colorList[rand.nextInt(13)];
    colorVal6 = colorList[rand.nextInt(13)];
    colorVal7 = colorList[rand.nextInt(13)];
    colorVal8 = colorList[rand.nextInt(13)];
    colorVal9 = colorList[rand.nextInt(13)];
    colorVal10 = colorList[rand.nextInt(13)];
    colorVal11 = colorList[rand.nextInt(13)];
    colorVal12 = colorList[rand.nextInt(13)];
    colorVal13 = colorList[rand.nextInt(13)];
    
  }
  
  public void actionPerformed(ActionEvent evt) {
    
      colorVal1 = colorList[rand.nextInt(13)];
      colorVal2 = colorList[rand.nextInt(13)];
      colorVal3 = colorList[rand.nextInt(13)];
      colorVal4 = colorList[rand.nextInt(13)];
      colorVal5 = colorList[rand.nextInt(13)];
      colorVal6 = colorList[rand.nextInt(13)];
      colorVal7 = colorList[rand.nextInt(13)];
      colorVal8 = colorList[rand.nextInt(13)];
      colorVal9 = colorList[rand.nextInt(13)];
      colorVal10 = colorList[rand.nextInt(13)];
      colorVal11 = colorList[rand.nextInt(13)];
      colorVal12 = colorList[rand.nextInt(13)];
      colorVal13 = colorList[rand.nextInt(13)];
      repaint();
    
  }
  
  public void paint(Graphics g){
    
    box1 = new Box(10,10,20,20,colorVal1);
    box1.display(g);
    
    box2 = new Box(30,10,20,20,colorVal2);
    box2.display(g);
    
    box3 = new Box(50,10,20,20,colorVal3);
    box3.display(g);
    
    box4 = new Box(70,10,20,20,colorVal4);
    box4.display(g);
    
    box5 = new Box(10,30,20,20,colorVal5);
    box5.display(g);
    
    box6 = new Box(30,30,20,20,colorVal6);
    box6.display(g);
    
    box7 = new Box(50,30,20,20,colorVal7);
    box7.display(g);
    
    box8 = new Box(70,30,20,20,colorVal8);
    box8.display(g);
    
    box9 = new Box(10,50,20,20,colorVal9);
    box9.display(g);
    
    box10 = new Box(30,50,20,20,colorVal10);
    box10.display(g);
    
    box11 = new Box(50,50,20,20,colorVal11);
    box11.display(g);
    
    box12 = new Box(70,50,20,20,colorVal12);
    box12.display(g);
    
    box13 = new Box(10,70,20,20,colorVal13);
    box13.display(g);
    
    box14 = new Box(30,70,20,20,colorVal5);
    box14.display(g);
    
    box15 = new Box(50,70,20,20,colorVal6);
    box15.display(g);
    
    box16 = new Box(70,70,20,20,colorVal7);
    box16.display(g);
    
  }
  
  

  
}
