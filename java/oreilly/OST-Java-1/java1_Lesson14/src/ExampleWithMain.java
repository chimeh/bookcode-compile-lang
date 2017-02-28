
public class ExampleWithMain {
	private int testInstanceVariable = 42;
	
	public static void main(String[] args) {
		ExampleWithMain myExample = new ExampleWithMain();
		System.out.println("The value of the instance variable is " + myExample.testInstanceVariable);
	}
}
