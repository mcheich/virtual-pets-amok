package main;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Dog;

public class DogTest {

	@Test
	public void dogWalkDecreasesHealth() {
		// Arrange
		Dog underTest = new Dog(10, 10, 10, 10);
		// Act
		underTest.walk();
		int result = underTest.getHealth();
		// Assert
		assertEquals(9, result);
	}
	
	@Test
	public void dogWalkDecreasesLikelyhoodofsoiling() {
		// Arrange
		Dog underTest = new Dog(10, 10, 10, 10);
		// Act
		underTest.walk();
		int result = underTest.soil();
		// Assert
		assertTrue(result == 0 || result == 2);
	}
	
	@Test
	public void dogBoredom15IncreasesHeakthBy1() {
		// Arrange
		Dog underTest = new Dog(10, 15, 10, 10);
		// Act
		underTest.tick();
		int result = underTest.getHealth();
		// Assert
		assertEquals(11, result);
	}
	
	@Test
	public void dogThirst15IncreasesHealthBy1() {
		// Arrange
		Dog underTest = new Dog(10, 10, 15, 10);
		// Act
		underTest.tick();
		int result = underTest.getHealth();
		// Assert
		assertEquals(11, result);
	}
	

}
