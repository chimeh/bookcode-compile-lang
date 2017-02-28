package collections;

public abstract class Mammal {
	protected String name;
	
	public Mammal (String who) {
		name = who;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract double getHeight();
	public abstract double getSpeed();
}
