package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.RoboDog;

public class RoboDogTest {

	@Test
	public void oilDecreasesOilLevelBy1() {
		// Arrange
		RoboDog underTest = new RoboDog(10, 10, 10);
		// Act
		underTest.oil();
		int result = underTest.getOilLevel();
		// Assert
		assertEquals(9, result);
	}

	@Test
	public void oilDoesNotDecreaseOilLevelLessThan0() {
		// Arrange
		RoboDog underTest = new RoboDog(10, 10, 0);
		// Act
		underTest.oil();
		int result = underTest.getOilLevel();
		// Assert
		assertEquals(0, result);
	}

	@Test
	public void walkDecreasesHealthBy1() {
		// Arrange
		RoboDog underTest = new RoboDog(10, 10, 10);
		// Act
		underTest.walk();
		int result = underTest.getHealth();
		// Assert
		assertEquals(9, result);
	}

	@Test
	public void tickIncreaseOilLevelBy1() {
		// Arrange
		RoboDog underTest = new RoboDog(10, 10, 10);
		// Act
		underTest.tick();
		int result = underTest.getOilLevel();
		// Assert
		assertEquals(11, result);
	}

	@Test
	public void tickDoesNotIncreaseOilLevelAbove20() {
		// Arrange
		RoboDog underTest = new RoboDog(10, 10, 20);
		// Act
		underTest.tick();
		int result = underTest.getOilLevel();
		// Assert
		assertEquals(20, result);
	}

	@Test
	public void oilLevelOf15AboveIncreasesHealthBy1() {
		// Arrange
		RoboDog underTest = new RoboDog(10, 10, 15);
		// Act
		underTest.tick();
		int result = underTest.getHealth();
		// Assert
		assertEquals(11, result);
	}

}
