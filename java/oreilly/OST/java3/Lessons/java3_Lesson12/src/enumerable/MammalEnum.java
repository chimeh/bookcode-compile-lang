package enumerable;

public enum MammalEnum {
  CHEETAH(70.00, 1.25),
  HUMAN(27.89, 1.6),
  THREETOED_SLOTH(0.15, 0.58);
  
  private double speed;
  private double height;
  
  MammalEnum(double howFast, double howTall){
    speed = howFast;
    height = howTall;
  }
  
  public double getSpeed() {
    return speed;
  }
  
  public double getHeight() {
    return height;
  }
  
  public static void main(String [] args) {
    for (MammalEnum each : MammalEnum.values())
      System.out.println("Mammal " + each + ":Speed " + each.getSpeed() + " and Height " + each.getHeight());
  }
}
