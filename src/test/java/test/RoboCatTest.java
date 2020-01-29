package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.RoboCat;

public class RoboCatTest {

	@Test
	public void roboCatStartsWithOilLevel10() {
		// Arrange
		RoboCat underTest = new RoboCat(10,10,10);
		// Act
		int result = underTest.getHealth();
		// Assert
		assertEquals(10, result);
	}

}
