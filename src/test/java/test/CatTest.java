package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Cat;

public class CatTest {

	@Test
	public void catStartsWithHealthOf10() {
		// Arrange
		Cat underTest = new Cat(10, 10);
		// Act
		int result = underTest.getHealth();
		// Assert
		assertEquals(10, result);
	}

	@Test
	public void catStartsWithHealthOf5() {
		// Arrange
		Cat underTest = new Cat(5, 10);
		// Act
		int result = underTest.getHealth();
		// Assert
		assertEquals(5, result);
	}

	@Test
	public void catStartsWithBoredomOf10() {
		// Arrange
		Cat underTest = new Cat(10, 10);
		// Act
		int result = underTest.getBoredom();
		// Assert
		assertEquals(10, result);
	}

	@Test
	public void catStartsWithBoredomOf5() {
		// Arrange
		Cat underTest = new Cat(10, 5);
		// Act
		int result = underTest.getBoredom();
		// Assert
		assertEquals(5, result);
	}

	@Test
	public void catStartsWithThirstOf10() {
		// Arrange
		Cat underTest = new Cat(10, 10);
		// Act
		int result = underTest.getThirst();
		// Assert
		assertEquals(10, result);
	}

	@Test
	public void catStartsWithThirstOf5() {
		// Arrange
		Cat underTest = new Cat(10, 10, 5, 5);
		// Act
		int result = underTest.getThirst();
		// Assert
		assertEquals(5, result);
	}

	@Test
	public void catStartsWithHungerOf10() {
		// Arrange
		Cat underTest = new Cat(10, 10);
		// Act
		int result = underTest.getHunger();
		// Assert
		assertEquals(10, result);
	}

	@Test
	public void catStartsWithHungerOf5() {
		// Arrange
		Cat underTest = new Cat(10, 10, 5, 5);
		// Act
		int result = underTest.getHunger();
		// Assert
		assertEquals(5, result);
	}


	@Test
	public void waterDecreasesThirstBy3() {
		// Arrange
		Cat underTest = new Cat(10, 10);
		// Act
		underTest.water();
		int result = underTest.getThirst();
		// Assert
		assertEquals(7, result);
	}

	@Test
	public void waterDoesNotDecreasesThirstLessThan0() {
		// Arrange
		Cat underTest = new Cat(10, 10);
		// Act
		underTest.water();
		underTest.water();
		underTest.water();
		underTest.water();
		int result = underTest.getThirst();
		// Assert
		assertEquals(0, result);
	}

	@Test
	public void feedDecreasesHungerBy3() {
		// Arrange
		Cat underTest = new Cat(10, 10);
		// Act
		underTest.feed();
		int result = underTest.getHunger();
		// Assert
		assertEquals(7, result);
	}

	@Test
	public void feedDoesNotDecreasesHungerLessThan0() {
		// Arrange
		Cat underTest = new Cat(10, 10);
		// Act
		underTest.feed();
		underTest.feed();
		underTest.feed();
		underTest.feed();
		int result = underTest.getHunger();
		// Assert
		assertEquals(0, result);
	}

	@Test
	public void soilReturns2() {
		// Arrange
		Cat underTest = new Cat(10, 10);
		// Act
		int result = underTest.soil();
		// Assert
		assertEquals(2, result);
	}
	
	@Test
	public void tickReturns2() {
		// Arrange
		Cat underTest = new Cat(10, 10);
		// Act
		int result = underTest.tick();
		// Assert
		assertEquals(2, result);
	}
	
	@Test
	public void tickIncreasesBoredomBy2() {
		// Arrange
		Cat underTest = new Cat(10, 10);
		// Act
		underTest.tick();
		int result = underTest.getBoredom();
		// Assert
		assertEquals(12, result);
	}
	
	@Test
	public void tickDoesNotIncreasesBoredomAbove20() {
		// Arrange
		Cat underTest = new Cat(10, 20);
		// Act
		underTest.tick();
		int result = underTest.getBoredom();
		// Assert
		assertEquals(20, result);
	}
	
	@Test
	public void tickIncreasesThirstBy2() {
		// Arrange
		Cat underTest = new Cat(10, 10);
		// Act
		underTest.tick();
		int result = underTest.getThirst();
		// Assert
		assertEquals(12, result);
	}
	
	@Test
	public void tickDoesNotIncreasesThirstAbove20() {
		// Arrange
		Cat underTest = new Cat(10, 10, 20, 20);
		// Act
		underTest.tick();
		int result = underTest.getThirst();
		// Assert
		assertEquals(20, result);
	}

	@Test
	public void tickIncreasesHungerBy2() {
		// Arrange
		Cat underTest = new Cat(10, 10);
		// Act
		underTest.tick();
		int result = underTest.getHunger();
		// Assert
		assertEquals(12, result);
	}
	
	@Test
	public void tickDoesNotIncreasesHungerAbove20() {
		// Arrange
		Cat underTest = new Cat(10, 10, 20, 20);
		// Act
		underTest.tick();
		int result = underTest.getHunger();
		// Assert
		assertEquals(20, result);
	}
	
	@Test
	public void waterIncreasesHealthBy1() {
		// Arrange
		Cat underTest = new Cat(10, 10, 20, 20);
		// Act
		underTest.water();
		int result = underTest.getHealth();
		// Assert
		assertEquals(11, result);
	}
	
	@Test
	public void feedDecreasesHealthBy1() {
		// Arrange
		Cat underTest = new Cat(10, 10, 20, 20);
		// Act
		underTest.feed();
		int result = underTest.getHealth();
		// Assert
		assertEquals(9, result);
	}
	
	@Test
	public void checkHealthDecreasesHealthBy1() {
		// Arrange
		Cat underTest = new Cat(5, 6, 6, 6);
		// Act
		underTest.checkHealth();
		int result = underTest.getHealth();
		// Assert
		assertEquals(9, result);
	}
	
	

}
