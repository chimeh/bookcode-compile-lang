import java.applet.Applet;
import java.awt.Graphics;

public class EmployeeApplet extends Applet {
	Employee e1, e2;
	
	public void init() {
		e1 = new Employee();
		e2 = new Employee();
		
		Employee.setTopSalary(199001);
		e1.setHoursPerWeek(40);
		e2.setHoursPerWeek(45);
		
		resize(450,280);
	}
	
	public void paint(Graphics g) {
		//names and values of all instance variables in each instance of the class
		g.drawString("Instance variable:", 30, 30);
		g.drawString("e1 hoursPerWeek is " + e1.getHoursPerWeek(), 30, 50);
		g.drawString("e2 hoursPerWeek is " + e2.getHoursPerWeek(), 30, 70);
		//name and value of static variables
		g.drawString("Static variable:", 30, 110);
		g.drawString("Employee topSalary is " + Employee.getTopSalary(), 30, 130);
	}
}
