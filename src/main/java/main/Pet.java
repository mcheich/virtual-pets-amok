package main;

public class Pet {

	protected int health = 10;
	protected int boredom = 10;

	public Pet(int health, int boredom) {
		this.health = health;
		this.boredom = boredom;
	}

	public int getHealth() {
		return this.health;
	}

	public int getBoredom() {
		return this.boredom;
	}
	
	public void checkHealth();

	public void play() {
		this.boredom -= 3;
		adjustHealth(1);

		// Enforce boredom 0 or greater
		if (this.boredom < 0) {
			this.boredom = 0;
		}

	}

	public int tick() {
		return 0;
	}

	/**
	 * Increases or decreases health of pet
	 * 
	 * @param healthChange
	 */
	public void adjustHealth(int healthChange) {

		this.health += healthChange;

		// Enforce boredom 0 or greater
		if (this.health < 0) {
			this.health = 0;
		}
		// Enforce health 20 or less
		if (this.health > 20) {
			this.health = 20;
		}
	}

}
