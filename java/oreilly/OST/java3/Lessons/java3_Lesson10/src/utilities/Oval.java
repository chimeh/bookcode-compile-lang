package utilities;

public class Oval extends Shape implements Sortable {

  int uLX, uLY, lRX, lRY;
  private int area;
  
  public Oval(int upperLeftX, int upperLeftY, int lowerRightX, int lowerRightY) {
    uLX = upperLeftX;
    uLY = upperLeftY;
    lRX = lowerRightX;
    lRY = lowerRightY;
    setArea();
  }
  
  private void setArea() {
    // not necessarily a circle, so rather than PI*r*r,
    // we have for ellipses PI*a*b where a and b are half of width and height
    int width = lRX - uLX;
    int height = lRY - uLY;
    area = (int)(Math.PI*.5*width*.5*height);
  }
  
  public int getArea() {
    return area;
  }
  
  public int compareTo(Sortable b) {
    Shape oneToCompare = null;
    
    if(b instanceof Shape) {
      oneToCompare = (Shape)b;
      if(getArea() < oneToCompare.getArea()) return -1;
      if (getArea() > oneToCompare.getArea()) return 1;
    }
    return 0;
  }

}
