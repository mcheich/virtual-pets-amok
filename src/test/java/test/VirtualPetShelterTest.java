package test;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import main.Cat;
import main.Dog;
import main.Organic;
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
		underTest.adoptOutByName("cat_test");
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
	public void oilDecreasesOilLevelOfRoboticDogBy_OILLEVEL_REDUCTION_AMOUNT() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("cat", "cat_test", "cat description");
		underTest.intake("roboDog", "roboDog_test", "roboDog description");
		underTest.intake("roboCat", "roboCat_test", "roboCat description");
		underTest.intake("undefined", "undefined_test", "undefined description");
		// Act
		RoboDog test = (RoboDog) underTest.getShelter().get(3);
		int expected = test.getOillevelReductionAmount();
		int existingOilLevel = test.getOilLevel();
		underTest.oil();
		int result = test.getOilLevel();
		// Assert
		assertEquals(expected,existingOilLevel-result);
	}
	
	@Test
	public void oilDecreasesOilLevelOfRoboticCatBy_OILLEVEL_REDUCTION_AMOUNT() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("cat", "cat_test", "cat description");
		underTest.intake("roboDog", "roboDog_test", "roboDog description");
		underTest.intake("roboCat", "roboCat_test", "roboCat description");
		underTest.intake("undefined", "undefined_test", "undefined description");
		// Act
		RoboCat test = (RoboCat) underTest.getShelter().get(4);
		int expected = test.getOillevelReductionAmount();
		int existingOilLevel = test.getOilLevel();
		underTest.oil();
		int result = test.getOilLevel();
		// Assert
		assertEquals(expected,existingOilLevel-result);
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
		underTest.intake("dog", "dog2_test", "dog2 description");
		underTest.intake("cat", "cat_test", "cat description");
		underTest.intake("cat", "cat2_test", "cat2 description");
		underTest.intake("roboDog", "roboDog_test", "roboDog description");
		underTest.intake("roboCat", "roboCat_test", "roboCat description");
		underTest.intake("undefined", "undefined_test", "undefined description");
		// Act
		underTest.tick();
		int result = underTest.getCageCleanlinessByKey(1);
		// Assert
		assertEquals(2, result);
	}

	@Test
	public void tickIncreasesDog2CageWasteBy2() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("dog", "dog2_test", "dog2 description");
		underTest.intake("cat", "cat_test", "cat description");
		underTest.intake("cat", "cat2_test", "cat2 description");
		underTest.intake("roboDog", "roboDog_test", "roboDog description");
		underTest.intake("roboCat", "roboCat_test", "roboCat description");
		underTest.intake("undefined", "undefined_test", "undefined description");
		// Act
		underTest.tick();
		int result = underTest.getCageCleanlinessByKey(2);
		// Assert
		assertEquals(2, result);
	}

	@Test
	public void dogWasteAbove10InCageIncreaseHealthBy1() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("dog", "dog2_test", "dog2 description");
		underTest.intake("cat", "cat_test", "cat description");
		underTest.intake("cat", "cat2_test", "cat2 description");
		underTest.intake("roboDog", "roboDog_test", "roboDog description");
		underTest.intake("roboCat", "roboCat_test", "roboCat description");
		underTest.intake("undefined", "undefined_test", "undefined description");
		// Act
		for (int i = 0; i < 6; i++) {
			underTest.tick();
		}
		int result = underTest.getPetByName("dog_test").getHealth();
		// Assert
		assertEquals(14, result);
	}

	@Test
	public void cleanCagesRemocesAllSoilFromCages() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("dog", "dog2_test", "dog2 description");
		underTest.intake("cat", "cat_test", "cat description");
		underTest.intake("cat", "cat2_test", "cat2 description");
		underTest.intake("roboDog", "roboDog_test", "roboDog description");
		underTest.intake("roboCat", "roboCat_test", "roboCat description");
		underTest.intake("undefined", "undefined_test", "undefined description");
		// Act
		underTest.tick();
		underTest.cleanCages();
		int result = underTest.getCageCleanlinessByKey(1);
		// Assert
		assertEquals(0, result);
	}

	@Test
	public void isInShelterIsTrueForDog_Test() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("dog", "dog2_test", "dog2 description");
		underTest.intake("cat", "cat_test", "cat description");
		underTest.intake("cat", "cat2_test", "cat2 description");
		underTest.intake("roboDog", "roboDog_test", "roboDog description");
		underTest.intake("roboCat", "roboCat_test", "roboCat description");
		underTest.intake("undefined", "undefined_test", "undefined description");
		// Act
		boolean result = underTest.isInShelter("dog_test");
		// Assert
		assertEquals(true, result);
	}

	@Test
	public void isInShelterIsFalseForTest() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("dog", "dog2_test", "dog2 description");
		underTest.intake("cat", "cat_test", "cat description");
		underTest.intake("cat", "cat2_test", "cat2 description");
		underTest.intake("roboDog", "roboDog_test", "roboDog description");
		underTest.intake("roboCat", "roboCat_test", "roboCat description");
		underTest.intake("undefined", "undefined_test", "undefined description");
		// Act
		boolean result = underTest.isInShelter("test");
		// Assert
		assertEquals(false, result);
	}

	@Test
	public void getKeyByNameReturnKey() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("dog", "dog2_test", "dog2 description");
		underTest.intake("cat", "cat_test", "cat description");
		underTest.intake("cat", "cat2_test", "cat2 description");
		underTest.intake("roboDog", "roboDog_test", "roboDog description");
		underTest.intake("roboCat", "roboCat_test", "roboCat description");
		underTest.intake("undefined", "undefined_test", "undefined description");
		// Act
		int result = underTest.getKeyByName("dog2_test");
		// Assert
		assertEquals(2, result);
	}

	@Test
	public void getPetByIDReturnsCorrectPet() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("dog", "dog2_test", "dog2 description");
		underTest.intake("cat", "cat_test", "cat description");
		underTest.intake("cat", "cat2_test", "cat2 description");
		underTest.intake("roboDog", "roboDog_test", "roboDog description");
		underTest.intake("roboCat", "roboCat_test", "roboCat description");
		underTest.intake("undefined", "undefined_test", "undefined description");
		// Act
		Pet petUnderTest = underTest.getPetByKey(2);
		String result = petUnderTest.getName();
		// Assert
		assertEquals("dog2_test", result);
	}

	@Test
	public void adoptOutByIDRemovesPetUnderTest() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("dog", "dog2_test", "dog2 description");
		underTest.intake("cat", "cat_test", "cat description");
		underTest.intake("cat", "cat2_test", "cat2 description");
		underTest.intake("roboDog", "roboDog_test", "roboDog description");
		underTest.intake("roboCat", "roboCat_test", "roboCat description");
		underTest.intake("undefined", "undefined_test", "undefined description");
		// Act
		underTest.adoptOutByID(2);
		boolean result = underTest.getShelter().containsKey(2);
		// Assert
		assertEquals(false, result);
	}
	
	@Test
	public void adoptOutByIDReturnsFalseIfPetIdDoesNotExist() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("dog", "dog2_test", "dog2 description");
		underTest.intake("cat", "cat_test", "cat description");
		underTest.intake("cat", "cat2_test", "cat2 description");
		underTest.intake("roboDog", "roboDog_test", "roboDog description");
		underTest.intake("roboCat", "roboCat_test", "roboCat description");
		underTest.intake("undefined", "undefined_test", "undefined description");
		// Act
		boolean result = underTest.adoptOutByID(42); 
		// Assert
		assertEquals(false, result);
	}

	@Test
	public void adoptOutByIDReturnsTrueIfPetIdDoesExist() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("dog", "dog2_test", "dog2 description");
		underTest.intake("cat", "cat_test", "cat description");
		underTest.intake("cat", "cat2_test", "cat2 description");
		underTest.intake("roboDog", "roboDog_test", "roboDog description");
		underTest.intake("roboCat", "roboCat_test", "roboCat description");
		underTest.intake("undefined", "undefined_test", "undefined description");
		// Act
		boolean result = underTest.adoptOutByID(2); 
		// Assert
		assertEquals(true, result);
	}

	@Test
	public void getKeysReturnSetOfKeys() {
		// Arrange
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.intake("dog", "dog_test", "dog description");
		underTest.intake("dog", "dog2_test", "dog2 description");
		underTest.intake("cat", "cat_test", "cat description");
		underTest.intake("cat", "cat2_test", "cat2 description");
		underTest.intake("roboDog", "roboDog_test", "roboDog description");
		underTest.intake("roboCat", "roboCat_test", "roboCat description");
		underTest.intake("undefined", "undefined_test", "undefined description");
		// Act
		Set<?> setUnderTest = underTest.getKeys();
		int result = setUnderTest.size(); 
		// Assert
		assertEquals(7, result);
	}

}
