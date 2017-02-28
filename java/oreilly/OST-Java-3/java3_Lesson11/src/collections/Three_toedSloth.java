package collections;

public class Three_toedSloth extends Mammal {
	private double runningSpeed = 0.15;
	private double height = 0.58;
	
	public Three_toedSloth(String who) {
		super(who);
	}
	
	public double getHeight() {
		return height;
	}

	public double getSpeed() {
		return runningSpeed;
	}

}
