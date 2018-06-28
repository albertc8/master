package com.albertc8.vehicles;

public class Chassis {
	
	// Static members
	public static String _CHASSIS_ILLEGALCHARS$="IOQ";
	public static int _CHASSIS_MAX_LENGTH=17;
	
	// Members
	private String chassis = "";
	
	/*
	 * Constructor
	 */	
	public Chassis() {};
	
	/* 
	 * @param chassis string
	 */
	public Chassis(String chassis) {
		// remove blank spaces and make all upper case
		this.chassis = chassis.replaceAll("\\s+","").toUpperCase();		
	}
		
	/*  
	 * Validate the chassis
	 */
	public boolean isValid() {
						
		// Allow blank VIN
		if (chassis.isEmpty())
			return true;
		
		// Check the VIN is within the correct length
		if (chassis.length() > _CHASSIS_MAX_LENGTH)
			return false;
		
		// Check for illegal characters in the VIN
		for (int i = 0; i < _CHASSIS_ILLEGALCHARS$.length(); i++) {			
			if (chassis.contains(_CHASSIS_ILLEGALCHARS$.subSequence(i, i + 1))) {
				return false;
			}			
		}		
		
		return true;
	}

	/* 
	 * get chassis
	 */	
	public String getChassis() {
		return chassis;
	}

	/* 
	 * set chassis
	 * @param chassis number
	 */	
	public void setChassis(String chassis) {
		this.chassis = chassis;
	}
}
