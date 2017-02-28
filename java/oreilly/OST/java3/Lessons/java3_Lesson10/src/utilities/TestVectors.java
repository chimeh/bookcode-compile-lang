package utilities;

import java.awt.*;
import java.util.*;

public class TestVectors {

  public static void main(String[] args) {
    TestVectors testMe = new TestVectors();
    testMe.tryVectors();
  }
  
  public void tryVectors() {
    Rectangle rect1 = new Rectangle(60,30,160,100);
    Sortable rect2 = new Rectangle(10,120,40,150);
    Rectangle rect3 = (Rectangle)rect2;
    
    Oval oval1 = new Oval(60,30,160,100);
    Sortable oval2 = new Oval(10,120,40,150);
    Oval oval3 = (Oval)oval2;
    
    Point myPoint = new Point(55,55);
    
    Sortable[] figures = {rect1, rect3, oval1, oval3};
    Vector <Point> moreFigures = new Vector<Point>(2);
    
    moreFigures.add(myPoint);
    
    for (int i = 0; i < moreFigures.size(); i++) {
      System.out.println("Element " + i + " is " + moreFigures.elementAt(i));
      Point myBad = moreFigures.elementAt(i);
      System.out.println("Vector Element " + myBad);
    }
    
    System.out.println();
    
    for (int i = 0; i < figures.length; i++) {
      System.out.println("Array Element " + i + " is " + figures[i]);
      Shape myBad = (Shape)figures[i];
      System.out.println("Array Element " + myBad);
    }
    
  }
}
