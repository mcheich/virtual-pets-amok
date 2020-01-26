package main;

public class Cat extends pet implements organic {

	private int thirst = 10;
	private int hunger = 10;
	private int waste = 10;
	
	public Cat(int health, int boredom) {
		super(health, boredom);
	}

	public Cat(int health, int boredom, int thirst, int hunger, int waste) {
		super(health, boredom);
		this.thirst = thirst;
		this.hunger = hunger;
		this.waste = waste;
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
	public int getWaste() {
		return this.waste ;
	}	

}
