package collections;

public class Cheetah extends Mammal {
	private double runningSpeed = 70.00;
	private double height = 1.25;
	
	public Cheetah (String who) {
		super(who);
	}
	
	public double getHeight() {
		return height;
	}

	public double getSpeed() {
		return runningSpeed;
	}
}
