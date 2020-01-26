package main;

public class pet {
	
	private int health = 10;
	private int boredom = 10;
	
	public pet(int health, int boredom) {
		this.health = health;
		this.boredom = boredom;
	}

	public int getHealth() {
		return this.health;
	}
	
	public int getBoredom() {
		return this.boredom ;
	}

	public void play() {
		// TODO Auto-generated method stub
		this.boredom -= 3;
	}

}
