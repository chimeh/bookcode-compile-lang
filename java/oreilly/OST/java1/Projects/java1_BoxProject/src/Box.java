import java.awt.*;

public class Box {
  
  private int upperLeftX,upperLeftY, height, width;
  private Color boxColor;
  
  public Box(int upperX, int upperY, int h, int w, Color myColor){
     setUpperLeftX(upperX);
     setUpperLeftY(upperY);
     setHeight(h);
     setWidth(w);
     setBoxColor(myColor);
    
  }
  
  public void display(Graphics g) {
    g.setColor(boxColor);
    g.fillRect(upperLeftX, upperLeftY, width, height);
    
  }
  
  public int getUpperLeftX() {
    return upperLeftX;
  }
  public void setUpperLeftX(int upperLeftX) {
    this.upperLeftX = upperLeftX;
  }
  public int getUpperLeftY() {
    return upperLeftY;
  }
  public void setUpperLeftY(int upperLeftY) {
    this.upperLeftY = upperLeftY;
  }
  public int getHeight() {
    return height;
  }
  public void setHeight(int height) {
    this.height = height;
  }
  public int getWidth() {
    return width;
  }
  public void setWidth(int width) {
    this.width = width;
  }
  public Color getBoxColor() {
    return boxColor;
  }
  public void setBoxColor(Color boxColor) {
    this.boxColor = boxColor;
  }
  
  

}
