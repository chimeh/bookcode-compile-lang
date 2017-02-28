package shapes;

public class Rectangle extends Shape {

  private int height;
  private int width;
  private boolean fillColor;
  
  public void Rectangle() {
    
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

  public boolean isFillColor() {
    return fillColor;
  }

  public void setFillColor(boolean fillColor) {
    this.fillColor = fillColor;
  }
  
  
}
