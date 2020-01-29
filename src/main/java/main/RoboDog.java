package main;

public class RoboDog extends Robotic implements DogStuff {

	public RoboDog(int health, int boredom) {
		super(health, boredom);
	}

	public RoboDog(int health, int boredom, int oilLevel) {
		super(health, boredom, oilLevel);
	}

	public RoboDog(String name, String description, int health, int boredom, int oilLevel) {
		super(name, description, health, boredom, oilLevel);
	}

	@Override
	public void walk() {
		super.adjustHealth(-1);
	}

}
