
class Employee {
  
  private static int topSalary = 195000;
  private int hoursPerWeek;
  
  public void addMoreHours() {
    hoursPerWeek++; // won't work (CM, IV)
  }
  public static void main(String[] args) {
    Employee e1, e2;
    e1 = new Employee();
    e2 = new Employee();
    
    Employee.setTopSalary(199000);
    // calling by class; can we do this?
    Employee.setTopSalary(199001);
    // calling by instance; can we do this?
    e1.hoursPerWeek = 40;
    e2.hoursPerWeek = 45;
    
    System.out.println("e1.hoursPerWeek: " + e1.hoursPerWeek);
    System.out.println("e2.hoursPerWeek: " + e2.hoursPerWeek);
    System.out.println("topSalary: " + Employee.getTopSalary());
  }

  public static void setTopSalary (int s) {
    if (s > topSalary)
      topSalary = s;
  }
  
  public int getHoursPerWeek() {
    return hoursPerWeek;
  }

  public void setHoursPerWeek(int hoursPerWeek) {
    this.hoursPerWeek = hoursPerWeek;
  }

  public static int getTopSalary() {
    return topSalary;
  }

}
