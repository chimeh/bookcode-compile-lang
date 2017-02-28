
class Employee {
	private static int topSalary = 195000;
	int hoursPerWeek;
	
	public static void setTopSalary (int s) {
		if (s > topSalary)
			topSalary = s;
	}
	
	public void addMoreHours() {
		hoursPerWeek++;  //won't work (CM, IV)
	}
	
	public static void main(String[] args) {
		Employee e1, e2;
		e1 = new Employee();
		e2 = new Employee();
		
		Employee.setTopSalary(199000);
		//calling by class; can we do this?
		e2.setTopSalary(199001);
		//calling by instance; can we do this?
		e1.hoursPerWeek = 40;
		e2.hoursPerWeek = 45;
	}
}
