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
	public void oilReducesOilLevelBy_OILLEVEL_REDUCTION_AMOUNT() {
		// Arrange
		Robotic underTest = new Robotic(10,10,10);
		int expected = underTest.getOillevelReductionAmount();
		// Act
		int existingOilLevel = underTest.getOilLevel();
		underTest.oil();
		int result = underTest.getOilLevel();
		//Assert
		assertEquals(expected,existingOilLevel-result);
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

	@Test
	public void getNameReturnsTest() {
		// Arrange
		Robotic underTest = new Robotic("test","",10,10,10);
		// Act
		String result = underTest.getName();
		//Assert
		assertEquals("test",result);
	}

	@Test
	public void getDecriptionReturnsTest() {
		// Arrange
		Robotic underTest = new Robotic("test","test",10,10,10);
		// Act
		String result = underTest.getDescription();
		//Assert
		assertEquals("test",result);
	}

	@Test
	public void getOilLevelReturns11() {
		// Arrange
		Robotic underTest = new Robotic("test","test",10,10,11);
		// Act
		int result = underTest.getOilLevel();
		//Assert
		assertEquals(11,result);
	}
	
}
