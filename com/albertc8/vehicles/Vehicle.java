package com.albertc8.vehicles;

import com.albertc8.vehicles.Chassis;

public class Vehicle {

	protected String manufacturer;
	protected String model;
	protected String variant;
	protected Chassis chassis;
	
	/* 
	 *  Constructor
	 *  @param vehicle manufacturer
	 *  @param vehicle model
	 *  @param vehicle variable
	 *  @param vehicle chassis
	 */
	public Vehicle(String manufacturer, String model, String variant) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.variant = variant;
		// The vehicle can be created without chassis provided
		chassis = new Chassis();
	}

	/**
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @return the variant
	 */
	public String getVariant() {
		return variant;
	}

	/**
	 * @return the chassis
	 */
	public Chassis getChassis() {
		return chassis;
	}
	
}
