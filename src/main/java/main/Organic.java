package main;

public class Organic extends Pet {

	private static final int _HEALTH_REDUCTION = -1; // Amount to reduce health by when feed() or water() are called
	private static final int _FIELD_THRESHOLD_FOR_ADVERSE_HEALTH = 15; // Field Threshold used by checkHealth to
																		// determine if health should increase (get
																		// worse).
	private static final int _SOIL_AMOUNT = 1; // Value to return when soil is called
	private static final int _TICK_INCREASE_FIELD_AMOUNT = 1; // amount to increase field values during tick
	private static final int _MAX_ORGANIC_FIELD_VALUE = 20; // Max value for thirst and hunger
	private static final int _MIN_ORGANIC_FIELD_VALUE = 0; // Min value for thirst and hunger
	private static final int _HUNGER_REDUCTION = 3; // Amount to reduce hunger when feed is called
	private static final int _THIRST_REDUCTION = 3; // Amount to reduce thirst when water is called
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

	public Organic(String name, String description, int health, int boredom, int thirst, int hunger) {
		super(name, description, health, boredom);
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
		this.thirst -= _THIRST_REDUCTION;
		super.adjustHealth(_HEALTH_REDUCTION);

		// Enforce thirst 0 or greater
		if (this.thirst < _MIN_ORGANIC_FIELD_VALUE) {
			this.thirst = _MIN_ORGANIC_FIELD_VALUE;
		}
	}

	public void feed() {
		this.hunger -= _HUNGER_REDUCTION;
		super.adjustHealth(_HEALTH_REDUCTION);

		// Enforce hunger 0 or greater
		if (this.hunger < _MIN_ORGANIC_FIELD_VALUE) {
			this.hunger = _MIN_ORGANIC_FIELD_VALUE;
		}
	}

	public int soil() {
		return _SOIL_AMOUNT;
	}

	@Override
	public int tick() {
		
		checkHealthConditions();
		super.tick(); // increase Boredom
		
		this.thirst += _TICK_INCREASE_FIELD_AMOUNT;
		this.hunger += _TICK_INCREASE_FIELD_AMOUNT;

		// Enforce 20 or less
		if (this.thirst > _MAX_ORGANIC_FIELD_VALUE) {
			this.thirst = _MAX_ORGANIC_FIELD_VALUE;
		}
		if (this.hunger > _MAX_ORGANIC_FIELD_VALUE) {
			this.hunger = _MAX_ORGANIC_FIELD_VALUE;
		}
		
		return soil();
	}

	@Override
	public void checkHealthConditions() {
		
		super.checkHealthConditions();

		if (this.thirst >= _FIELD_THRESHOLD_FOR_ADVERSE_HEALTH) {
			super.adjustHealth(1);
		}
		if (this.hunger >= _FIELD_THRESHOLD_FOR_ADVERSE_HEALTH) {
			super.adjustHealth(1);
		}
	}

}
