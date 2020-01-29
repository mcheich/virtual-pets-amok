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
	public void walkDecreasesHealthBy1() {
		// Arrange
		RoboDog underTest = new RoboDog(10, 10, 10);
		// Act
		underTest.walk();
		int result = underTest.getHealth();
		// Assert
		assertEquals(9, result);
	}

}
