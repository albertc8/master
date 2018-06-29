package com.albertc8.TestJUnit;

import static org.junit.Assert.*;
import org.junit.Test;
import com.albertc8.vehicles.*;

public class ChassisJUnit {
	
	Chassis chassis = new Chassis();

	// Check blank chassis allowed
	@Test
	public void chassisIsBlank() {
		assertEquals("",chassis.getChassis());
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
		assertFalse(vin.setChassis("ABCDE12345ABCDE123"));		
	}

	// Check for illegal character in the chassis
	@Test
	public void chassisIllegalChars() {
		
		// Invalid chassis contains I,O,Q			
		assertFalse(vin.setChassis("vin1234")); // Contains 'I' and lower case letters		
		assertEquals("",vin.getChassis());
		assertFalse(vin.setChassis("VN12O34"));	// Contains 'O'
		assertEquals("",vin.getChassis());
		assertFalse(vin.setChassis("VN123Q4")); // Contains 'Q'
		assertEquals("",vin.getChassis());
		assertFalse(vin.setChassis("I")); // single char chassis I
		assertEquals("",vin.getChassis());
		assertFalse(vin.setChassis("O")); // single char chassis O
		assertEquals("",vin.getChassis());
		assertFalse(vin.setChassis("Q")); // single char chassis Q
		assertEquals("",vin.getChassis());
		
		assertTrue("S",vin.setChassis("A")); // single char chassis A
		assertEquals("A",vin.getChassis());
	}
	
}
