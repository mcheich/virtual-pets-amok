package main;

public class Cat extends Organic {


	public Cat(int health, int boredom) {
		super(health, boredom);
	}

	public Cat(int health, int boredom, int thirst, int hunger) {
		super(health, boredom, thirst, hunger);
	}

	@Override
	public int soil() {
		return 2;
	}

	@Override
	public int tick() {
		this.boredom += 2;
		this.thirst += 2;
		this.hunger += 2;

		// Enforce boredom 20 or less
		if (this.boredom > 20) {
			this.boredom = 20;
		}
		if (this.thirst > 20) {
			this.thirst = 20;
		}
		if (this.hunger > 20) {
			this.hunger = 20;
		}
		
		return soil();
	}

	public void checkHealth() {
		
	}

}
