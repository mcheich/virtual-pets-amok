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

	public Robotic(String name, String description, int health, int boredom, int oilLevel) {
		super(name, description, health, boredom);
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

	@Override
	public int tick() {
		
		checkHealthConditions();
		this.oilLevel++;

		if (this.oilLevel > 20) {
			this.oilLevel = 20;
		}

		return 0; // Robots do not create waste ...HMM :QMIKE: Is this kosher?
	}
	
	@Override
	public void checkHealthConditions() {
		super.checkHealthConditions();
		
		if(this.oilLevel >= 15) {
			this.adjustHealth(1);
		}
	}

}
