package main;

import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class VirtualPetShelterApp {

	public static void main(String[] args) {

		/* Create shelter and add pets */
		VirtualPetShelter shelter = new VirtualPetShelter();

		shelter.intake("dog", "Ruff", "A rough looking dog.");
		shelter.intake("cat", "Meow", "A meowing cat.");
		shelter.intake("cat", "Fifi", "A black and white cat.");
		shelter.intake("roboDog", "RoboRover", "A Robotic Dog");
		shelter.intake("roboCat", "CanCat", "A Robotic Cat.");

		/* Show Welcome Message */
		showWelcomeMessage();

		/* Game Loop */
		Scanner input = new Scanner(System.in);
		String selection;
		do {
			showRosterAndStats(shelter);

			// Update user selection
			showOptions();
			selection = input.nextLine();

			switch (selection) {
			case "1":
				shelter.feed();
				fedMessage();
				break;
			case "2":
				shelter.water();
				wateredMessage();
				break;
			case "3":
				shelter.play();
				playMessage();
				break;
			case "4":
				adoptOut(shelter, input);
				break;
			case "5":
				intakePet(shelter, input);
				break;
			case "6":
				playWithSinglePet(shelter, input);
				break;
			case "7":
				shelter.oil();
				break;
			}

			// "Time Passes"...
			shelter.tick();

		} while (!selection.equals("6"));

		input.close();

		System.out.println("Goodbye now!");
		System.exit(0);

	}

	/**
	 * Prints watered acknowledgement to console
	 */
	private static void wateredMessage() {
		System.out.println("###############################");
		System.out.println("## You watered all the pets! ##");
		System.out.println("###############################\n");
	}

	/**
	 * Prints fed acknowledgement to console
	 */
	private static void fedMessage() {
		System.out.println("###########################");
		System.out.println("## You fed all the pets! ##");
		System.out.println("###########################\n");
	}

	private static void playMessage() {
		System.out.println("#################################");
		System.out.println("## You played w/ all the pets! ##");
		System.out.println("#################################\n");
	}
	
	/**
	 * Remove Virtual Pet by name from shelter
	 */
	private static void adoptOut(VirtualPetShelter shelter, Scanner input) {

		// Get name of pet from user
		System.out.println("** What is the name of the animal that is being adopted? **\n");
		String adoptee = input.nextLine();
		boolean match = shelter.adoptOut(adoptee);

		// Remove pet is in system, otherwise advise not in system.
		if (match) {
			System.out.println(adoptee + " has been adopted!\n");
		} else {
			System.out.println(adoptee + " does not match our records.\n");
		}
	}

	/**
	 * Adds VirtualPet to Shelter
	 * 
	 * @param shelter
	 * @param input
	 */
	private static void intakePet(VirtualPetShelter shelter, Scanner input) {

		/* User Input Name and Description */
		System.out.println("** Enter the type of pet you are intaking: dog, cat, robodog, robocat **");
		String petType = input.nextLine();
		System.out.println("** Enter the name of the pet you are intaking: **");
		String petName = input.nextLine();
		System.out.println("** Give a descripion of the pet you are intaking: **");
		String petDescription = input.nextLine();

		// Add pet to shelter
		shelter.intake(petType, petName, petDescription);

		// User Output
		System.out.println("You have added " + petName + " to the pet shelter.\n");

	}

	/**
	 * Allows user to select a pet by name to play with. If the name given does not
	 * exist, lets user know with message.
	 * 
	 * @param shelterPara
	 * @param input
	 */
	private static void playWithSinglePet(VirtualPetShelter shelter, Scanner input) {
		System.out.println("######################################");

		/* List Pets */
		for (Pet pet : shelter.getRoster()) {

			String petName = pet.getName();
			String petDescription = pet.getDescription();
			System.out.println(String.format("[%1$s] %2$s", petName, petDescription));
		}

		/* User make selection */
		System.out.println();
		System.out.println("## Type the name of the animal you'd like to play with: ##\n");
		String petName = input.nextLine(); // Tried nextLine() here, but wouldn't work

		/* User Output */
		if (shelter.isInShelter(petName)) {
			/* Play with selected animal */
			shelter.getPetByName(petName).play();
			System.out.println("########################################");
			System.out.println("## You played with " + petName);
			System.out.println("########################################\n");
		} else {
			System.out.println("########################################");
			System.out.println("##  " + petName + " does not match an option!");
			System.out.println("########################################\n");
		}
	}


	/**
	 * Prints user options to console.
	 */
	private static void showOptions() {
		System.out.println("## What would you like to do with your pets? ##\n");
		System.out.println("1. Feed the pets\n" + "2. Water the pets\n" + "3. Play with pets\n" + "4. Adopt a pet\n"
				+ "5. Admit a pet\n" + "4. Play with a pet\n" + "6. Quit");
	}

	/**
	 * Lists all the pets in the shelter along with stats.
	 * 
	 * @param shelterPara
	 */
	private static void showRosterAndStats(VirtualPetShelter shelter) {
		System.out.println("#########################################################");
		System.out.println("##                   Pet Status Table                  ##");
		System.out.println("---------------------------------------------------------");
		System.out.println("Name        |Health |Boredom|Thirst |Hunger | Oil Level |");
		System.out.println("------------|-------|-------|-------|-------|-----------|");

		/* List Pets */
		for (Pet pet : shelter.getRoster()) {

			String petName = pet.getName();
			int petBoredom = pet.getBoredom();
			int petHealth = pet.getHealth();// int petHealth = pet.health; // :MIKEQ: Why can I use this?! I thought it
											// was private

			System.out.print(String.format("%1$-12s|%2$-7s|%3$-7s|", petName, petHealth, petBoredom));

			if (pet instanceof Organic) {

				int petThirst = ((Organic) pet).getThirst();
				int petHunger = ((Organic) pet).getHunger();
				System.out.println(String.format("%1$-7s|%2$-7s|", petThirst, petHunger));
			}
			if (pet instanceof Robotic) {

				int petOilLevel = ((Robotic) pet).getOilLevel();
				System.out.println(String.format("%1$-7s|%2$-7s|%3$-7s", "NA", "NA", petOilLevel));
			}

		}

		// Add Spacing for next element
		System.out.println();

	}

	/**
	 * Prints welcome message to console.
	 */
	private static void showWelcomeMessage() {
		System.out.println("###########################################");
		System.out.println("##   Welcome to your local Pet Shelter   ##");
		System.out.println("###########################################");
		System.out.println();
	}

}