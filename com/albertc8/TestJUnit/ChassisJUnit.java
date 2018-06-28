package com.albertc8.TestJUnit;

import static org.junit.Assert.*;
import org.junit.Test;
import com.albertc8.vehicles.*;

public class ChassisJUnit {
	
	Chassis chassis = new Chassis();

	// Check blank chassis allowed
	@Test
	public void chassisIsBlank() {
		assertTrue(chassis.isValid());
	}
	
	// Check the constructor that take chassis as a parameter
	Chassis vin = new Chassis("ABC 123");
	
	// Check the spaces have been removed
	@Test
	public void chassisRemoveSpaces() {
		assertEquals("ABC123",vin.getChassis());
	}
	
	// Check chassis length 17 or greater is invalid
	@Test	
	public void chassisLength() {
		vin.setChassis("ABCDE12345ABCDE123");
		assertFalse(vin.isValid());
	}

	// Check for illegal character in the chassis
	@Test
	public void chassisIllegalChars() {
		
		// Invalid chassis contains I,O,Q
		
		// Contains 'I'
		vin.setChassis("VIN1234");
		assertFalse(vin.isValid());
		
		// Contains 'O'
		vin.setChassis("VN12O34");
		assertFalse(vin.isValid());
		
		// Contains 'Q'
		vin.setChassis("VN123Q4");
		assertFalse(vin.isValid());
		
		// single char chassis I
		vin.setChassis("I");
		assertFalse(vin.isValid());
		
		// single char chassis O
		vin.setChassis("O");
		assertFalse(vin.isValid());
				
		// single char chassis Q
		vin.setChassis("Q");
		assertFalse(vin.isValid());
		
		// single char chassis A
		vin.setChassis("A");
		assertTrue(vin.isValid());
	}
	
}
