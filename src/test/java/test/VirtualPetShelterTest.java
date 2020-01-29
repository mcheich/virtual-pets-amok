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

}
