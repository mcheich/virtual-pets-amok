package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Robotic;

public class RoboticTest {

	@Test
	public void roboticStartsWithOilLevel10() {
		// Arrange
		Robotic underTest = new Robotic(10,10,10);
		// Act
		int result = underTest.getOilLevel();
		//Assert
		assertEquals(10,result);
	}
	
	@Test
	public void oilReducesOilLevel1() {
		// Arrange
		Robotic underTest = new Robotic(10,10,10);
		// Act
		underTest.oil();
		int result = underTest.getOilLevel();
		//Assert
		assertEquals(9,result);
	}

	@Test
	public void oilDoesNotReducesOilLevelBelow0() {
		// Arrange
		Robotic underTest = new Robotic(10,10,0);
		// Act
		underTest.oil();
		int result = underTest.getOilLevel();
		//Assert
		assertEquals(0,result);
	}
}
