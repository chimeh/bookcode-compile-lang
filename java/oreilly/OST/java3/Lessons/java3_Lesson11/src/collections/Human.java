package collections;

public class Human extends Mammal {
  
  private double runningSpeed = 10.00;
  private double height = 1.6;
  
  public Human(String who) {
    super(who);
  }

  public double getHeight() {
    return height;
  }

  public double getSpeed() {
    return runningSpeed;
  }

}
