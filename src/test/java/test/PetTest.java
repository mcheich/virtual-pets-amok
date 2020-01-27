package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Cat;
import main.Pet;

public class PetTest {

	@Test
	public void adjustHealthDoesNotIncreaseHealthAbove20() {
		// Arrange
		Pet underTest = new Pet(10, 10);
		// Act
		underTest.adjustHealth(12);
		int result = underTest.getHealth();
		// Assert
		assertEquals(20, result);
	}
	
	@Test
	public void adjustHealthDoesNotDecreaseHealthBelow0() {
		// Arrange
		Pet underTest = new Pet(10, 10);
		// Act
		underTest.adjustHealth(-11);
		int result = underTest.getHealth();
		// Assert
		assertEquals(0, result);
	}
	
	@Test
	public void playDecreasesBoredomBy3() {
		// Arrange
		Pet underTest = new Pet(10, 10);
		// Act
		underTest.play();
		int result = underTest.getBoredom();
		// Assert
		assertEquals(7, result);
	}
	
	@Test
	public void playDoesNotDecreasesBoredomLessThan0() {
		// Arrange
		Pet underTest = new Pet(10, 10);
		// Act
		underTest.play();
		underTest.play();
		underTest.play();
		underTest.play();
		int result = underTest.getBoredom();
		// Assert
		assertEquals(0, result);
	}
	
	@Test
	public void playIncreasesHealthBy1() {
		// Arrange
		Pet underTest = new Pet(10, 10);
		// Act
		underTest.play();
		int result = underTest.getHealth();
		// Assert
		assertEquals(11, result);
	}

}