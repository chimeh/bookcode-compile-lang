package examples;

public class Main {
	public static void main(String [] args) {
		Dog myDog = new Dog("male");
		System.out.println("I am domesticated: " + myDog.isDomesticated());
		myDog.feedYoung();
		if (myDog.gender == "male")
			System.out.print("My offspring come: ");
		else
			System.out.print("I give birth: ");
		myDog.liveBirth();
	}
}
