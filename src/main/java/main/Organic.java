package main;

public interface Organic {
	
	/*
	 * Should I have these?
	 * 
	 *  int thirst = 10;
	 *  int hunger = 10;
	 *  int waste = 10;
	 *  
	 *  Seems to work fine without them...
	 */
	
	public int getThirst();
	public int getHunger();
	void water();
	void feed();
	int soil();
}
