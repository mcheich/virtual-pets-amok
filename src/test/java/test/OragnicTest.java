package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Cat;
import main.Organic;

public class OragnicTest {

	@Test
	public void OrganicStartsWithHealthOf10() {
		// Arrange
		Organic underTest = new Organic(10, 10);
		// Act
		int result = underTest.getHealth();
		// Assert
		assertEquals(10, result);
	}

	@Test
	public void OrganicStartsWithHealthOf5() {
		// Arrange
		Organic underTest = new Organic(5, 10);
		// Act
		int result = underTest.getHealth();
		// Assert
		assertEquals(5, result);
	}

	@Test
	public void OrganicStartsWithBoredomOf10() {
		// Arrange
		Organic underTest = new Organic(10, 10);
		// Act
		int result = underTest.getBoredom();
		// Assert
		assertEquals(10, result);
	}

	@Test
	public void OrganicStartsWithBoredomOf5() {
		// Arrange
		Organic underTest = new Organic(10, 5);
		// Act
		int result = underTest.getBoredom();
		// Assert
		assertEquals(5, result);
	}

	@Test
	public void OrganicStartsWithThirstOf10() {
		// Arrange
		Organic underTest = new Organic(10, 10);
		// Act
		int result = underTest.getThirst();
		// Assert
		assertEquals(10, result);
	}

	@Test
	public void OrganicStartsWithThirstOf5() {
		// Arrange
		Organic underTest = new Organic(10, 10, 5, 5);
		// Act
		int result = underTest.getThirst();
		// Assert
		assertEquals(5, result);
	}

	@Test
	public void OrganicStartsWithHungerOf10() {
		// Arrange
		Organic underTest = new Organic(10, 10);
		// Act
		int result = underTest.getHunger();
		// Assert
		assertEquals(10, result);
	}

	@Test
	public void OrganicStartsWithHungerOf5() {
		// Arrange
		Organic underTest = new Organic(10, 10, 5, 5);
		// Act
		int result = underTest.getHunger();
		// Assert
		assertEquals(5, result);
	}


	@Test
	public void waterDecreasesThirstBy3() {
		// Arrange
		Organic underTest = new Organic(10, 10);
		// Act
		underTest.water();
		int result = underTest.getThirst();
		// Assert
		assertEquals(7, result);
	}

	@Test
	public void waterDoesNotDecreasesThirstLessThan0() {
		// Arrange
		Organic underTest = new Organic(10, 10);
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
		Organic underTest = new Organic(10, 10);
		// Act
		underTest.feed();
		int result = underTest.getHunger();
		// Assert
		assertEquals(7, result);
	}

	@Test
	public void feedDoesNotDecreasesHungerLessThan0() {
		// Arrange
		Organic underTest = new Organic(10, 10);
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
	public void soilReturns1() {
		// Arrange
		Organic underTest = new Organic(10, 10);
		// Act
		int result = underTest.soil();
		// Assert
		assertEquals(1, result);
	}
	
	@Test
	public void tickReturns2() {
		// Arrange
		Organic underTest = new Organic(10, 10);
		// Act
		int result = underTest.tick();
		// Assert
		assertEquals(1, result);
	}
	
	@Test
	public void tickIncreasesBoredomBy1() {
		// Arrange
		Organic underTest = new Organic(10, 10);
		// Act
		underTest.tick();
		int result = underTest.getBoredom();
		// Assert
		assertEquals(11, result);
	}
	
	@Test
	public void tickDoesNotIncreasesBoredomAbove20() {
		// Arrange
		Organic underTest = new Organic(10, 20);
		// Act
		underTest.tick();
		int result = underTest.getBoredom();
		// Assert
		assertEquals(20, result);
	}
	
	@Test
	public void tickIncreasesThirstBy2() {
		// Arrange
		Organic underTest = new Organic(10, 10);
		// Act
		underTest.tick();
		int result = underTest.getThirst();
		// Assert
		assertEquals(12, result);
	}
	
	@Test
	public void tickDoesNotIncreasesThirstAbove20() {
		// Arrange
		Organic underTest = new Organic(10, 10, 20, 20);
		// Act
		underTest.tick();
		int result = underTest.getThirst();
		// Assert
		assertEquals(20, result);
	}

	@Test
	public void tickIncreasesHungerBy2() {
		// Arrange
		Organic underTest = new Organic(10, 10);
		// Act
		underTest.tick();
		int result = underTest.getHunger();
		// Assert
		assertEquals(12, result);
	}
	
	@Test
	public void tickDoesNotIncreasesHungerAbove20() {
		// Arrange
		Organic underTest = new Organic(10, 10, 20, 20);
		// Act
		underTest.tick();
		int result = underTest.getHunger();
		// Assert
		assertEquals(20, result);
	}
	
	@Test
	public void waterDecreasesHealthBy1() {
		// Arrange
		Organic underTest = new Organic(10, 10, 20, 20);
		// Act
		underTest.water();
		int result = underTest.getHealth();
		// Assert
		assertEquals(9, result);
	}
	
	@Test
	public void feedDecreasesHealthBy1() {
		// Arrange
		Organic underTest = new Organic(10, 10, 20, 20);
		// Act
		underTest.feed();
		int result = underTest.getHealth();
		// Assert
		assertEquals(9, result);
	}
	
	@Test
	public void thirstOf15IncreasesHealthBy1() {
		// Arrange
		Organic underTest = new Organic(10, 10, 15, 10);
		// Act
		underTest.checkHealth();
		int result = underTest.getHealth();
		// Assert
		assertEquals(11, result);
	}

	@Test
	public void hungerOf15IncreasesHealthBy1() {
		// Arrange
		Organic underTest = new Organic(10, 10, 10, 15);
		// Act
		underTest.checkHealth();
		int result = underTest.getHealth();
		// Assert
		assertEquals(11, result);
	}
	
	@Test
	public void tickCallsPetsChecksHealth() {
		// Arrange
		Organic underTest = new Organic(10, 15, 10, 10);
		// Act
		underTest.tick();
		int result = underTest.getHealth();
		// Assert
		assertEquals(11, result);
	}
	
	@Test
	public void tickIncreasesBoredomeBy1() {
		// Arrange
		Organic underTest = new Organic(10, 10, 10, 10);
		// Act
		underTest.tick();
		int result = underTest.getBoredom();
		// Assert
		assertEquals(11, result);
	}
	

}
