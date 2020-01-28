package main;

public class Cat extends Organic {


	private static final int _SOIL_AMOUNT = 2; // Value to return when soil is called

	public Cat(int health, int boredom) {
		super(health, boredom);
	}

	public Cat(int health, int boredom, int thirst, int hunger) {
		super(health, boredom, thirst, hunger);
	}

	/**
	 * Returns an integer representing amount of waste
	 * @return int - amount of soiling
	 */
	@Override
	public int soil() {
		return _SOIL_AMOUNT;
	}

	/**
	 * Simulates passage of time.
	 * With each tick, the animals stats change and it returns waste
	 */
	@Override
	public int tick() {
		super.tick();
		return soil();
	}

}
