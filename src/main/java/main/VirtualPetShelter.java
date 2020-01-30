package main;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class VirtualPetShelter {

	private Map<Integer, Pet> shelter = new HashMap<Integer, Pet>();
	private Map<String, Integer> cages = new HashMap<String, Integer>();
	
	private int litterBox = 10;
	

	public int getLitterBox() {
		return litterBox;
	}
	
	public Collection<Pet> getRoster() {
		return this.shelter.values();
	}
	
	public Map<Integer, Pet> getShelter() {
		return this.shelter;
	}
	
	public void intake(String petType, String name, String description) {

		int key = shelter.size() + 1;

		switch (petType.toLowerCase()) {
		case "dog":
			Dog newDog = new Dog(name, description, 10, 10, 10, 10);
			this.shelter.put(key, newDog);
			break;
		case "cat":
			Cat newCat = new Cat(name, description, 10, 10, 10, 10);
			this.shelter.put(key, newCat);
			break;
		case "robodog":
			RoboDog newRoboDog = new RoboDog(name, description, 10, 10, 10);
			this.shelter.put(key, newRoboDog);
			break;
		case "robocat":
			RoboCat newRoboCat = new RoboCat(name, description, 10, 10, 10);
			this.shelter.put(key, newRoboCat);
			break;
		default:
			Pet undefinedPet = new Pet(name, description, 10, 10);
			this.shelter.put(key, undefinedPet);
		}
	}


	public Pet getPetByName(String name) {
		Set<Entry<Integer, Pet>> pets = shelter.entrySet();
		for (Entry<Integer, Pet> pet : pets) {

			if (pet.getValue().getName().equals(name)) {
				return pet.getValue();
			}

		}
		Pet notInSystem = new Pet("Not in system", "Not in System");
		return notInSystem;
	}

	/**
	 * :MIKE NOT TO SELF -> DUDE - please remember why you have return statements!
	 * Otherwise, the remove screws up the for loop interation.
	 * 
	 * @param namePara
	 * @return
	 */
	public boolean adoptOut(String name) {

		for (Map.Entry<Integer, Pet> pet : shelter.entrySet()) {
			if (pet.getValue().getName().equals(name)) {
				this.shelter.remove(pet.getKey());
				return true;
			}
		}
		return false;
	}

	public void feed() {

		for (Pet pet : shelter.values()) {
			if (pet instanceof Organic) {
				((Organic) pet).feed();
			}
		}
	}

	public void water() {

		for (Pet pet : shelter.values()) {
			if (pet instanceof Organic) {
				((Organic) pet).water();
			}
		}
	}

	public void play() {

		for (Pet pet : shelter.values()) {
			pet.play();
		}
	}

	public void oil() {

		for (Pet pet : shelter.values()) {
			if (pet instanceof Robotic) {
				((Robotic) pet).oil();
			}
		}
	}

	public void tick() {

		for (Pet pet : shelter.values()) {
			pet.tick();

			// Check litterBox
			if ((pet instanceof Cat) && (litterBox  > 10)) {
				((Cat) pet).adjustHealth(1);
			}
			if (pet instanceof Cat) {
				litterBox += ((Cat) pet).soil();
			}
		}	
	}

	public void cleanLitterBox() {
		this.litterBox = 0;
	}

	public int getCageCleanlinessByName(String name) {

		for (Map.Entry<String, Integer> cage : cages.entrySet()) {
			if (cage.getKey().equals(name)) {
				return cage.getValue();
			}
		}
		return 0;
	}

}
