import java.applet.*;
import java.awt.*;

public class EmployeeApplet extends Applet {
  
   Employee e3 = new Employee();
   Employee e4 = new Employee();
  
  public void init() {
    e3.setHoursPerWeek(33);
    e4.setHoursPerWeek(45);
    Employee.setTopSalary(200000);
  }
  
  public void paint(Graphics g) {
    g.drawString("e3.hoursPerWeek: " + Integer.toString(e3.getHoursPerWeek()), 15, 15);
    g.drawString("e4.hoursPerWeek: " +Integer.toString(e4.getHoursPerWeek()), 15, 30);
    g.drawString("topSalary: " +Integer.toString(Employee.getTopSalary()), 15, 45);
  }
}
