package main;

public class Robotic extends Pet {

	private int oilLevel = 10;

	public Robotic(int health, int boredom) {
		super(health, boredom);
	}

	public Robotic(int health, int boredom, int oilLevel) {
		super(health, boredom);
		this.oilLevel = oilLevel;
	}

	public int getOilLevel() {
		return oilLevel;
	}

	/**
	 * Reduce oil level
	 */
	public void oil() {
		this.oilLevel--;

		if (this.oilLevel < 0) {
			this.oilLevel = 0;
		}

	}

}
