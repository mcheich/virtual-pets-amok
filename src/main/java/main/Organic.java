package main;

public class Organic extends Pet {

	protected int thirst = 10;
	protected int hunger = 10;

	public Organic(int health, int boredom) {
		super(health, boredom);
	}

	public Organic(int health, int boredom, int thirst, int hunger) {
		super(health, boredom);
		this.thirst = thirst;
		this.hunger = hunger;
	}

	public int getThirst() {
		return this.thirst;
	}

	public int getHunger() {
		return this.hunger;
	}

	public void water() {
		this.thirst -= 3;
		super.adjustHealth(1);

		// Enforce thirst 0 or greater
		if (this.thirst < 0) {
			this.thirst = 0;
		}
	}

	public void feed() {
		this.hunger -= 3;
		super.adjustHealth(1);

		// Enforce hunger 0 or greater
		if (this.hunger < 0) {
			this.hunger = 0;
		}
	}

	public int soil() {
		return 1;
	}

	@Override
	public int tick() {
		super.tick(); // increase Boredom

		this.thirst += 2;
		this.hunger += 2;

		// Enforce 20 or less
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
