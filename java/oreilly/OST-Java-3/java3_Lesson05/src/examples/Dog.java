package examples;

public class Dog extends Mammal {
	private boolean domesticated = true;
	
	public Dog(String sex) {
		super(sex);
	}
	
	public void move(){
		System.out.println("We move on all 4 legs.");
	}
	
	public boolean isDomesticated() {
		return domesticated;
	}
	
	public void liveBirth() {
		System.out.println("in litters, very cute");
	}
	
	public void eat(){
		System.out.println("With my sharp teeth.  Anything I can get-except lettuce");
	}
	
}
