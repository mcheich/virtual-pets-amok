package main;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	private Map<Integer, Pet> shelter = new HashMap<Integer, Pet>();

	public void intake(String petType, String name, String description) {

		int key = shelter.size() + 1;

		switch (petType.toLowerCase()) {
		case "dog":
			Dog newDog = new Dog(name, description, 10, 10, 10, 10);
			shelter.put(key, newDog);
			break;
		case "cat":
			Cat newCat = new Cat(name, description, 10, 10, 10, 10);
			shelter.put(key, newCat);
			break;
		case "robodog":
			RoboDog newRoboDog = new RoboDog(name, description, 10, 10, 10);
			shelter.put(key, newRoboDog);
			break;
		case "robocat":
			RoboCat newRoboCat = new RoboCat(name, description, 10, 10, 10);
			shelter.put(key, newRoboCat);
			break;
		default:
			Pet undefinedPet = new Pet(name, description, 10, 10);
			shelter.put(key, undefinedPet);
		}
	}

	public Collection<Pet> getRoster() {
		return this.shelter.values();
	}

	public Map<Integer, Pet> getShelter() {
		// TODO Auto-generated method stub
		return this.shelter;
	}

}
