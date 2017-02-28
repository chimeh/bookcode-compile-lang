package utilities;

public class Test {
	public static void main(String[] args) {
		Test testMe = new Test();
		testMe.tryTypes();
	}
	
	public void tryTypes() {
		Rectangle rect1 = new Rectangle(60, 30, 160, 100);
		Sortable rect2 = new Rectangle(10, 120, 40, 150);
		Rectangle rect3 = (Rectangle)rect2;
		Oval oval1 = new Oval(60, 30, 160, 100);
		Sortable oval2 = new Oval(10, 120, 40, 150);
		Oval oval3 = (Oval)oval2;
		
		System.out.println("rect1 Area: " + rect1.getArea());
		System.out.println("rect3 Area: " + rect3.getArea());
		System.out.println("oval1 Area: " + oval1.getArea());
		System.out.println("oval3 Area: " + oval3.getArea());
		System.out.println();
		
		Sortable [] figures = {rect1, rect3, oval1, oval3};
		
		System.out.println("Before shellSort:");
		for (int i = 0; i < figures.length; i++) {
            Shape current = null;
            if (figures[i] instanceof Rectangle)
            	current = (Rectangle)figures[i];
            else
            	current = (Oval)figures[i];
            
            System.out.println("Area is " + current.getArea());
	}
	Sorts.shellSort(figures);	
	
	System.out.println("\nAfter shellSort:");
	for (int i = 0; i < figures.length; i++) {
		Shape current = null;
		if (figures[i] instanceof Rectangle)
			current = (Rectangle)figures[i];
		else
			current = (Oval)figures[i];
		System.out.println("Area is " + current.getArea());
	}
	}
}
