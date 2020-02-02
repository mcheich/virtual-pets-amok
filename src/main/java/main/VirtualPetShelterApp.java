package main;

import java.util.ArrayList;
import java.util.Iterator;
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
				adoptOutByKey(shelter, input);
				break;
			case "5":
				intakePet(shelter, input);
				break;
			case "6":
				playWithSinglePet(shelter, input);
				break;
			case "7":
				shelter.oil();
				oilMessage();
				break;
			case "8":
				shelter.cleanCages();
				cleanCagesMessage();
				break;
			case "9":
				shelter.cleanLitterBox();
				cleanLitterBoxMessage();
				break;
			default:
				errorMessage(selection);
					
			}

			// "Time Passes"...
			shelter.tick();

		} while (!selection.equals("10"));

		input.close();

		System.out.println("Goodbye now!");
		System.exit(0);
	}

	private static void cleanLitterBoxMessage() {
		System.out.println("#################################");
		System.out.println("## You cleaned the litter box! ##");
		System.out.println("#################################\n");
	}

	private static void cleanCagesMessage() {
		System.out.println("############################");
		System.out.println("## You cleaned the cages! ##");
		System.out.println("############################\n");
	}

	private static void errorMessage(String selection) {
		System.out.println("##################################################################");
		System.out.println("Your last entry " + selection + " is NOT an option.  Try again! ##");
		System.out.println("##################################################################\n");
	}

	private static void oilMessage() {
		System.out.println("#################################");
		System.out.println("## You oiled the robotic pets! ##");
		System.out.println("#################################\n");
	}
	

	/**
	 * Prints watered acknowledgement to console
	 */
	private static void wateredMessage() {
		System.out.println("###################################");
		System.out.println("## You watered the organic pets! ##");
		System.out.println("###################################\n");
	}

	/**
	 * Prints fed acknowledgement to console
	 */
	private static void fedMessage() {
		System.out.println("###############################");
		System.out.println("## You fed the organic pets! ##");
		System.out.println("###############################\n");
	}

	private static void playMessage() {
		System.out.println("#################################");
		System.out.println("## You played w/ all the pets! ##");
		System.out.println("#################################\n");
	}
	
	/**
	 * Remove Virtual Pet by name from shelter
	 */
	private static void adoptOutByKey(VirtualPetShelter shelter, Scanner input) {

		// Get name of pet from user
		System.out.println("** What is the ID# of the animal that is being adopted? **\n");
		int adoptee = input.nextInt();
		input.nextLine(); //Clear Inputs
		
		String adopteeName = shelter.getPetByKey(adoptee).getName();
		boolean match = shelter.adoptOutByID(adoptee);

		// Remove pet is in system, otherwise advise not in system.
		if (match) {
			System.out.println(adopteeName + " has been adopted!\n");
		} else {
			System.out.println(adopteeName + " does not match our records.\n");
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
		String petName = input.nextLine();

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
		
		ArrayList<String> optionList = new ArrayList<String>();
		optionList.add("Feed organic pets");
		optionList.add("Water organic pets");
		optionList.add("Play with pets");
		optionList.add("Adopt a pet");
		optionList.add("Admit a pet");
		optionList.add("Play with a specific pet");
		optionList.add("Oil robitic pets");
		optionList.add("Clean dog cages");
		optionList.add("Clean the litterbox");
		optionList.add("Quit");
		
		System.out.println("## What would you like to do with your pets? ##\n");
		for(int option = 0; option <optionList.size(); option++) {
			System.out.println((option + 1 ) + " " + optionList.get(option));
		}	
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
		System.out.println("ID# |  Name        |Health |Boredom|Thirst |Hunger | Oil Level | Dog Cage Waste | Litter Box Waste");
		System.out.println("----|--------------|-------|-------|-------|-------|-----------|----------------|------------------");

		
		/* List Pets */
		Iterator<?> iterator = shelter.getKeys().iterator();  
		
		while(iterator.hasNext()) {
		//for (Pet pet : shelter.getRoster()) {
			int nextPet = (Integer)iterator.next();
			Pet pet = shelter.getShelter().get(nextPet);
			String petName = pet.getName();//pet.getName();
			int petBoredom = pet.getBoredom();
			int petHealth = pet.getHealth();			
			int petID = nextPet;
			//int petID = shelter.getKeyByName(petName);// int petHealth = pet.health; // :MIKEQ: Why can I use this?! I thought it
											          // was private

			System.out.print(String.format("%1$-4s|%2$-14s|%3$-7s|%4$-7s|", petID, petName, petHealth, petBoredom));

			if (pet instanceof Organic) {

				int petThirst = ((Organic) pet).getThirst();
				int petHunger = ((Organic) pet).getHunger();
				System.out.print(String.format("%1$-7s|%2$-7s|", petThirst, petHunger));
			}
			if (pet instanceof Robotic) {

				int petOilLevel = ((Robotic) pet).getOilLevel();
				System.out.println(String.format("%1$-7s|%2$-7s|%3$-7s", "NA", "NA", petOilLevel));
			}
			if (pet instanceof Dog) {

				int cageWaste = shelter.getCageCleanlinessByKey(nextPet);
				System.out.println(String.format("%1$-11s|%2$-16s|%3$-16s", "NA", cageWaste, "NA"));
			}
			if (pet instanceof Cat) {

				int litterBoxWaste = shelter.getLitterBox();
				System.out.println(String.format("%1$-11s|%2$-16s|%3$-16s", "NA", "NA", litterBoxWaste));
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