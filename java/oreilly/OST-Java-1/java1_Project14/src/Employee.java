
class Employee {
	private static int topSalary = 195000;
	private int hoursPerWeek;
	
	public static void setTopSalary (int s) {
		if (s > topSalary)
			topSalary = s;
	}
	
	public void addMoreHours() {
		hoursPerWeek++;  
	}
	
	public static void main(String[] args) {
		Employee e1, e2;
		e1 = new Employee();
		e2 = new Employee();
		
		Employee.setTopSalary(199000);
		Employee.setTopSalary(199001);
		e1.hoursPerWeek = 40;
		e2.hoursPerWeek = 45;
		
		//display names and values of all the instance variables in each instance of the Employee class
		System.out.println("e1 hoursPerWeek instance variable is " + e1.hoursPerWeek);
		System.out.println("e2 hoursPerWeek instance variable is " + e2.hoursPerWeek);
		//value of any static variables
		System.out.println("Employee static variable is " + Employee.topSalary);
	}

	public static int getTopSalary() {
		return topSalary;
	}
	
	public int getHoursPerWeek() {
		return hoursPerWeek;
	}

	public void setHoursPerWeek(int hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}
}
