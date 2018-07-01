/*
 * Albert Chen 29/06/2018
 * 
 * Handle a stock vehicle
 * 
 */

package com.albertc8.vehicles;

public class Stock extends Vehicle {
	
	private enum Status {
		memorandum, condigned, adopted;
	}
	
	private Status status;
	private String registration;
			
	public Stock(String manufacturer, String model, String variant) {
		super(manufacturer, model, variant);
		status = Status.memorandum;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the registration
	 */
	public String getRegistration() {
		return registration;
	}

	/**
	 * @param registraion the registration to set
	 */
	public void setRegistration(String registraion) {
		this.registration = registraion;
	}
	
	
	
	

}
