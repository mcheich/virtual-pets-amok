package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Cat;
import main.Organic;
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
	
	@Test
	public void tickShouldIncreaseBoredomBy1() {
		// Arrange
		Pet underTest = new Pet(10, 10);
		// Act
		underTest.tick();
		int result = underTest.getBoredom();
		// Assert
		assertEquals(11, result);		
	}
	
	@Test
	public void tickShouldnotIncreaseBoredomByMoreThan20() {
		// Arrange
		Pet underTest = new Pet(10, 20);
		// Act
		underTest.tick();
		int result = underTest.getBoredom();
		// Assert
		assertEquals(20, result);		
	}
	
	@Test
	public void boredomeOf15IncreasesHealthBy1() {
		// Arrange
		Pet underTest = new Pet(10, 15);
		// Act
		underTest.checkHealthConditions();
		int result = underTest.getHealth();
		// Assert
		assertEquals(11, result);
	}
	
	@Test
	public void getNameReturnsTest() {
		// Arrange
		Pet underTest = new Pet("test", "",10,10);
		// Act
		String result = underTest.getName();
		//Assert
		assertEquals("test", result);
	}

	@Test
	public void getDescriptionReturnsTest() {
		// Arrange
		Pet underTest = new Pet("test", "test",10,10);
		// Act
		String result = underTest.getDescription();
		//Assert
		assertEquals("test", result);
	}
	
	@Test
	public void getHealthReturns11() {
		// Arrange
		Pet underTest = new Pet("test", "test",11,10);
		// Act
		int result = underTest.getHealth();
		//Assert
		assertEquals(11, result);
	}
	
	@Test
	public void getBoredomeReturns11() {
		// Arrange
		Pet underTest = new Pet("test", "test",10,11);
		// Act
		int result = underTest.getBoredom();
		//Assert
		assertEquals(11, result);
	}
	
	@Test
	public void createsPetWithNameTest() {
		// Arrange
		Pet underTest = new Pet("test", "");
		// Act
		String result = underTest.getName();
		//Assert
		assertEquals("test", result);
	}

	@Test
	public void createsPetWithDescriptionTest() {
		// Arrange
		Pet underTest = new Pet("", "test");
		// Act
		String result = underTest.getDescription();
		//Assert
		assertEquals("test", result);
	}


}