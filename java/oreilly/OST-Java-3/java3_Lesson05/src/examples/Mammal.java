package examples;

public abstract class Mammal {
	boolean hasHair = true;
	String breathes = "oxygen";
	String skeletalStructure = "backbone";
	String gender;
	
	public Mammal(String sex) {
		gender = sex;
		System.out.println("I am a " + gender + " dog");
	}
	
	public abstract void move();
	
	public abstract void liveBirth();
	
	public void feedYoung() {
		String food = "milk";
		System.out.println("Since I am " + gender + ", ");
		if (gender == "female")
			System.out.println("I provide my young with " + food);
		else
			System.out.println("I need assistance to feed my young " + food);
	}
	
	public boolean hasMammaryGlands() {
		return true;
	}
	
	public abstract void eat();
}
