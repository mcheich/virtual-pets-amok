package main;

public class Cat extends Pet implements Organic {

	private int thirst = 10;
	private int hunger = 10;

	public Cat(int health, int boredom) {
		super(health, boredom);
	}

	public Cat(int health, int boredom, int thirst, int hunger) {
		super(health, boredom);
		this.thirst = thirst;
		this.hunger = hunger;
	}

	@Override
	public int getThirst() {
		return this.thirst;
	}

	@Override
	public int getHunger() {
		return this.hunger;
	}

	@Override
	public void water() {
		this.thirst -= 3;
		super.adjustHealth(1);

		// Enforce thirst 0 or greater
		if (this.thirst < 0) {
			this.thirst = 0;
		}
	}

	@Override
	public void feed() {
		this.hunger -= 3;
		super.adjustHealth(1);
		
		// Enforce hunger 0 or greater
		if (this.hunger < 0) {
			this.hunger = 0;
		}
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
