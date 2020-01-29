package main;

public class Pet {

	private static final int _MIN_HEALTH = 0;
	private static final int _MAX_HEALTH = 20;
	private static final int _HEALTH_REDUCTION = 1; //Amount to reduce health by when play() is called
	private static final int _MAX_BOREDOM = 20; // Highest amount boredom can be
	private static final int _MIN_BOREDOM = 0; // Lowest amount boredom can be
	private static final int _BOREDOM_REDUCTION = 3; // Amount to reduce boredom when play() is called
	private static final int _FIELD_THRESHOLD_FOR_ADVERSE_HEALTH = 15; // Field Threshold used by checkHealth to
																		// determine if health should increase (get // worse).
	private String name;
	private String description;
	protected int health = 10;
	protected int boredom = 10;

	public Pet(int health, int boredom) {
		this.health = health;
		this.boredom = boredom;
	}
	
	public Pet(String name, String description, int health, int boredom) {
		this.name = name;
		this.description = description;
		this.health = health;
		this.boredom = boredom;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	public int getHealth() {
		return this.health;
	}

	public int getBoredom() {
		return this.boredom;
	}

	/**
	 * :MIKEQ: I want this method to be implemented by every child. But if I make
	 * this method abstract, then the entire class must be abstract and I want some
	 * implementation in this class. Is there a way to make a contract for this
	 * method without the entire class being abstract?
	 */
	public void checkHealthConditions() {
		if (this.boredom >= _FIELD_THRESHOLD_FOR_ADVERSE_HEALTH) {
			adjustHealth(1);
		}
	}

	public void play() {
		this.boredom -= _BOREDOM_REDUCTION;
		adjustHealth(_HEALTH_REDUCTION);

		// Enforce boredom 0 or greater
		if (this.boredom < _MIN_BOREDOM) {
			this.boredom = _MIN_BOREDOM;
		}

	}

	/**
	 * 
	 * @return
	 */
	public int tick() {
		this.boredom++;

		// Enforce boredom 20 or less
		if (this.boredom > _MAX_BOREDOM) {
			this.boredom = _MAX_BOREDOM;
		}

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
		if (this.health < _MIN_HEALTH) {
			this.health = _MIN_HEALTH;
		}
		// Enforce health 20 or less
		if (this.health > _MAX_HEALTH) {
			this.health = _MAX_HEALTH;
		}
	}

}
