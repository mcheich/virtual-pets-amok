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
		Cat underTest = new Cat(10, 10, 5, 5, 5);
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
		Cat underTest = new Cat(10, 10, 5, 5, 5);
		// Act
		int result = underTest.getHunger();
		// Assert
		assertEquals(5, result);
	}
	
	@Test
	public void catStartsWithWaste10() {
		// Arrange
		Cat underTest = new Cat(10, 10);
		// Act
		int result = underTest.getWaste();
		// Assert
		assertEquals(10, result);
	}
	
	@Test
	public void catStartsWithWaste5() {
		// Arrange
		Cat underTest = new Cat(10,10,5,5,5);
		// Act
		int result = underTest.getWaste();
		// Assert
		assertEquals(5, result);
	}
	
	@Test
	public void playDecreasesBoredomBy3() {
		// Arrange
		Cat underTest = new Cat(10, 10);
		// Act
		underTest.play();
	}

}
