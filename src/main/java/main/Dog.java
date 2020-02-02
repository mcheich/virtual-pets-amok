package main;

import java.util.Random;

public class Dog extends Organic implements DogStuff {
	
	boolean needsToSoil = true;

	private static final int _HEALTH_REDUCTION_FOR_WALKING = -1; //Reduce health by this much when walking dog

	public Dog(int health, int boredom) {
		super(health, boredom);
	}
	
	public Dog(int health, int boredom, int thirst, int hunger) {
		super(health, boredom);
		this.thirst = thirst;
		this.hunger = hunger;
	}

	public Dog(String name, String description, int health, int boredom, int thirst, int hunger) {
		super(name, description, health, boredom, thirst, hunger);	
	}

	/**
	 * Walking the dog reduces health value (which is good!)
	 * and reduces soil amount.
	 */
	@Override
	public void walk() {
		super.adjustHealth(_HEALTH_REDUCTION_FOR_WALKING);
		Random rand = new Random();
		needsToSoil = rand.nextInt(2) == 0; // 50% chance of being false		
	}
	
	@Override
	public int soil() {
		return (needsToSoil ? 1:0 ) * 2;
	}
	
	@Override
	public int tick() {
		super.tick();
		return soil();
	}

}
