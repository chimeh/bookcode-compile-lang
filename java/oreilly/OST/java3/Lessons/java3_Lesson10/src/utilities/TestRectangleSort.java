package utilities;

public class TestRectangleSort {

  public static void main (String[] args) {
    TestRectangleSort newExample = new TestRectangleSort();
    newExample.sortRectangles();
  }
  
  public void sortRectangles() {
    Rectangle[] figures = new Rectangle[3];
    
    figures[0] = new Rectangle(60,30,169,100);
    figures[1] = new Rectangle(10,120,40,150);
    figures[2] = new Rectangle(90,125,143,163);
    
    System.out.println("Before shellSort:");
    for (int i =0; i < figures.length; i ++)
      System.out.println("Area is " + figures[i].getArea());
    
    Sorts.shellSort(figures);
    
    System.out.println("\nAfter shellSort:");
    for ( int i = 0; i < figures.length; i++)
      System.out.println("Area is " + figures[i].getArea());
  }
}
