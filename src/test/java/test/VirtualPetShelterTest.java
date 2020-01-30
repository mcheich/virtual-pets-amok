package test;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Map;

import org.junit.Test;

import main.Cat;
import main.Dog;
import main.Pet;
import main.RoboCat;
import main.RoboDog;
import main.VirtualPetShelter;

public class VirtualPetShelterTest {

	@Test
	public void intakeAddsACat() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("cat", "cat_test", "cat description");
		// Act
		Map<Integer, Pet> result = underTest.getShelter();
		// Assert
		assertEquals("class main.Cat", result.get(2).getClass().toString());
	}

	@Test
	public void intakeAddsADog() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("cat", "cat_test", "cat description");
		// Act
		Map<Integer, Pet> result = underTest.getShelter();
		// Assert
		assertEquals("class main.Dog", result.get(1).getClass().toString());
	}

	@Test
	public void intakeAddsARoboDog() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("cat", "cat_test", "cat description");
		underTest.intake("roboDog", "roboDog_test", "roboDog description");
		// Act
		Map<Integer, Pet> result = underTest.getShelter();
		// Assert
		assertEquals("class main.RoboDog", result.get(3).getClass().toString());
	}

	@Test
	public void intakeAddsARoboCat() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("cat", "cat_test", "cat description");
		underTest.intake("roboDog", "roboDog_test", "roboDog description");
		underTest.intake("roboCat", "roboCat_test", "roboCat description");
		// Act
		Map<Integer, Pet> result = underTest.getShelter();
		// Assert
		assertEquals("class main.RoboCat", result.get(4).getClass().toString());
	}

	@Test
	public void intakeAddsUndefinedPet() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("cat", "cat_test", "cat description");
		underTest.intake("roboDog", "roboDog_test", "roboDog description");
		underTest.intake("roboCat", "roboCat_test", "roboCat description");
		underTest.intake("undefined", "undefined_test", "undefined description");
		// Act
		Map<Integer, Pet> result = underTest.getShelter();
		// Assert
		assertEquals("class main.Pet", result.get(5).getClass().toString());
	}

	@Test
	public void getPetByNameReturnsCorrectPet() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("cat", "cat_test", "cat description");
		underTest.intake("roboDog", "roboDog_test", "roboDog description");
		underTest.intake("roboCat", "roboCat_test", "roboCat description");
		underTest.intake("undefined", "undefined_test", "undefined description");
		// Act
		Pet result = underTest.getPetByName("cat_test");
		// Assert
		assertEquals("cat_test", result.getName());
	}
	
	@Test
	public void getPetByNameReturnsNotInSystemForIncorrectPetName() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("cat", "cat_test", "cat description");
		underTest.intake("roboDog", "roboDog_test", "roboDog description");
		underTest.intake("roboCat", "roboCat_test", "roboCat description");
		underTest.intake("undefined", "undefined_test", "undefined description");
		// Act
		Pet result = underTest.getPetByName("at_test");
		// Assert
		assertEquals("Not in system", result.getName());
	}
	
	@Test
	public void adoptOutRemovesCat() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("cat", "cat_test", "cat description");
		underTest.intake("roboDog", "roboDog_test", "roboDog description");
		underTest.intake("roboCat", "roboCat_test", "roboCat description");
		underTest.intake("undefined", "undefined_test", "undefined description");
		// Act
		underTest.adoptOut("cat_test");
		int result = underTest.getShelter().size();
		// Assert
		assertEquals(4, result);
	}
	
	@Test
	public void feedDecreasesHungerOfOrganicDogBy3() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("cat", "cat_test", "cat description");
		underTest.intake("roboDog", "roboDog_test", "roboDog description");
		underTest.intake("roboCat", "roboCat_test", "roboCat description");
		underTest.intake("undefined", "undefined_test", "undefined description");
		// Act
		underTest.feed();
		Dog test = (Dog) underTest.getShelter().get(1);
		int result = test.getHunger();
		// Assert
		assertEquals(7, result);		
	}

	@Test
	public void feedDecreasesHungerOfOrganicCatBy3() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("cat", "cat_test", "cat description");
		underTest.intake("roboDog", "roboDog_test", "roboDog description");
		underTest.intake("roboCat", "roboCat_test", "roboCat description");
		underTest.intake("undefined", "undefined_test", "undefined description");
		// Act
		underTest.feed();
		Cat test = (Cat) underTest.getShelter().get(2);
		int result = test.getHunger();
		// Assert
		assertEquals(7, result);		
	}
	
	@Test
	public void waterDecreasesThirstOfOrganicDogBy3() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("cat", "cat_test", "cat description");
		underTest.intake("roboDog", "roboDog_test", "roboDog description");
		underTest.intake("roboCat", "roboCat_test", "roboCat description");
		underTest.intake("undefined", "undefined_test", "undefined description");
		// Act
		underTest.water();
		Dog test = (Dog) underTest.getShelter().get(1);
		int result = test.getThirst();
		// Assert
		assertEquals(7, result);		
	}
	
	@Test
	public void feedDecreasesThirstOfOrganicCatBy3() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("cat", "cat_test", "cat description");
		underTest.intake("roboDog", "roboDog_test", "roboDog description");
		underTest.intake("roboCat", "roboCat_test", "roboCat description");
		underTest.intake("undefined", "undefined_test", "undefined description");
		// Act
		underTest.water();
		Cat test = (Cat) underTest.getShelter().get(2);
		int result = test.getThirst();
		// Assert
		assertEquals(7, result);		
	}

	@Test
	public void playDecreasesBoredomOfOrganicCatBy3() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("cat", "cat_test", "cat description");
		underTest.intake("roboDog", "roboDog_test", "roboDog description");
		underTest.intake("roboCat", "roboCat_test", "roboCat description");
		underTest.intake("undefined", "undefined_test", "undefined description");
		// Act
		underTest.play();
		Cat test = (Cat) underTest.getShelter().get(2);
		int result = test.getBoredom();
		// Assert
		assertEquals(7, result);		
	}
	
	@Test
	public void playDecreasesBoredomOfRoboticDogBy3() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("cat", "cat_test", "cat description");
		underTest.intake("roboDog", "roboDog_test", "roboDog description");
		underTest.intake("roboCat", "roboCat_test", "roboCat description");
		underTest.intake("undefined", "undefined_test", "undefined description");
		// Act
		underTest.play();
		RoboDog test = (RoboDog) underTest.getShelter().get(3);
		int result = test.getBoredom();
		// Assert
		assertEquals(7, result);		
	}

	@Test
	public void oilDecreasesOilLevelOfRoboticDogBy1() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("cat", "cat_test", "cat description");
		underTest.intake("roboDog", "roboDog_test", "roboDog description");
		underTest.intake("roboCat", "roboCat_test", "roboCat description");
		underTest.intake("undefined", "undefined_test", "undefined description");
		// Act
		underTest.oil();
		RoboDog test = (RoboDog) underTest.getShelter().get(3);
		int result = test.getOilLevel();
		// Assert
		assertEquals(9, result);		
	}

	@Test
	public void oilDecreasesOilLevelOfRoboticCatBy1() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("cat", "cat_test", "cat description");
		underTest.intake("roboDog", "roboDog_test", "roboDog description");
		underTest.intake("roboCat", "roboCat_test", "roboCat description");
		underTest.intake("undefined", "undefined_test", "undefined description");
		// Act
		underTest.oil();
		RoboCat test = (RoboCat) underTest.getShelter().get(4);
		int result = test.getOilLevel();
		// Assert
		assertEquals(9, result);		
	}

	@Test
	public void tickIncreasesBoredomOfRoboticCatBy1() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("cat", "cat_test", "cat description");
		underTest.intake("roboDog", "roboDog_test", "roboDog description");
		underTest.intake("roboCat", "roboCat_test", "roboCat description");
		underTest.intake("undefined", "undefined_test", "undefined description");
		// Act
		underTest.tick();
		RoboCat test = (RoboCat) underTest.getShelter().get(4);
		int result = test.getBoredom();
		// Assert
		assertEquals(11, result);		
	}

	@Test
	public void tickIncreasesOilLevelOfRoboticCatBy1() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("cat", "cat_test", "cat description");
		underTest.intake("roboDog", "roboDog_test", "roboDog description");
		underTest.intake("roboCat", "roboCat_test", "roboCat description");
		underTest.intake("undefined", "undefined_test", "undefined description");
		// Act
		underTest.tick();
		RoboCat test = (RoboCat) underTest.getShelter().get(4);
		int result = test.getOilLevel();
		// Assert
		assertEquals(11, result);		
	}
	
	@Test
	public void tickIncreasesHungerDogBy1() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("cat", "cat_test", "cat description");
		underTest.intake("roboDog", "roboDog_test", "roboDog description");
		underTest.intake("roboCat", "roboCat_test", "roboCat description");
		underTest.intake("undefined", "undefined_test", "undefined description");
		// Act
		underTest.tick();
		Dog test = (Dog) underTest.getShelter().get(1);
		int result = test.getHunger();
		// Assert
		assertEquals(11, result);		
	}

	@Test
	public void ifLitterBoxIsGreaterThan10IncreaseOrganicCatHealthBy1() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("cat", "cat_test", "cat description");
		underTest.intake("cat", "cat2_test", "cat2 description");
		underTest.intake("roboDog", "roboDog_test", "roboDog description");
		underTest.intake("roboCat", "roboCat_test", "roboCat description");
		underTest.intake("undefined", "undefined_test", "undefined description");
		// Act
		underTest.tick();
		underTest.tick();
		Cat test = (Cat) underTest.getShelter().get(2);
		int result = test.getHealth();
		// Assert
		assertEquals(11, result);		
	}
	
	@Test
	public void ifLitterBoxIsGreaterThan10IncreaseOrganicCat2HealthBy1() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("cat", "cat_test", "cat description");
		underTest.intake("cat", "cat2_test", "cat2 description");
		underTest.intake("roboDog", "roboDog_test", "roboDog description");
		underTest.intake("roboCat", "roboCat_test", "roboCat description");
		underTest.intake("undefined", "undefined_test", "undefined description");
		// Act
		underTest.tick();
		Cat test = (Cat) underTest.getShelter().get(3);
		int result = test.getHealth();
		// Assert
		assertEquals(11, result);		
	}
	
	@Test
	public void ifLitterBoxIsGreaterThan10DoNotIncreaseOrganicDogHealthBy1() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("cat", "cat_test", "cat description");
		underTest.intake("cat", "cat2_test", "cat2 description");
		underTest.intake("roboDog", "roboDog_test", "roboDog description");
		underTest.intake("roboCat", "roboCat_test", "roboCat description");
		underTest.intake("undefined", "undefined_test", "undefined description");
		// Act
		underTest.tick();
		Dog test = (Dog) underTest.getShelter().get(1);
		int result = test.getHealth();
		// Assert
		assertEquals(10, result);		
	}

	@Test
	public void tickIncreasesLitterBoxBy4() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("cat", "cat_test", "cat description");
		underTest.intake("cat", "cat2_test", "cat2 description");
		underTest.intake("roboDog", "roboDog_test", "roboDog description");
		underTest.intake("roboCat", "roboCat_test", "roboCat description");
		underTest.intake("undefined", "undefined_test", "undefined description");
		// Act
		underTest.tick();
		int result = underTest.getLitterBox();
		// Assert
		assertEquals(14, result);		
	}
	
	@Test
	public void cleanLitterBoxStesLitterBoxTo0() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("cat", "cat_test", "cat description");
		underTest.intake("cat", "cat2_test", "cat2 description");
		underTest.intake("roboDog", "roboDog_test", "roboDog description");
		underTest.intake("roboCat", "roboCat_test", "roboCat description");
		underTest.intake("undefined", "undefined_test", "undefined description");
		// Act
		underTest.cleanLitterBox();
		int result = underTest.getLitterBox();
		// Assert
		assertEquals(0, result);		
	}
	
	@Test
	public void tickIncreasesDogCageWasteBy2() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("cat", "cat_test", "cat description");
		underTest.intake("cat", "cat2_test", "cat2 description");
		underTest.intake("roboDog", "roboDog_test", "roboDog description");
		underTest.intake("roboCat", "roboCat_test", "roboCat description");
		underTest.intake("undefined", "undefined_test", "undefined description");
		// Act
		underTest.tick();
		int result = underTest.getCageCleanlinessByName("dog_test");
		// Assert
		assertEquals(2, result);		
	}

}
