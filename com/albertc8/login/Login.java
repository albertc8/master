/*
 * Albert Chen 06/07/2018
 * handles login details - MODEL
 */

package com.albertc8.login;

public class Login {
	
	private String username;
	private String password;
	
	private String errMesg;
	
	public Login() {
		
	}
	
	/**
	 * @return the errMesg
	 */
	public String getErrMesg() {
		return errMesg;
	}

	/*
	 * validate the username
	 */
	private boolean validateUsername() {
		
		// the username cannot be blank
		
		if (username.isEmpty()) {			
			errMesg = "The username is blank";
			return false;
		}
		
		return true;
	}
	
	/*
	 * Validate the password
	 */
	private boolean validatePassword() {
		
		if (password.isEmpty()) {
			errMesg = "The password cannot be blank";
			return false;
		}
		
		return true;
	}
	
	/*
	 * validate the login details username and password
	 */	
	private boolean validateLoginDetails() {
		
		// Query the MS SQL users table
		
		
		return true;
	}
	
	/*
	 * Validate the login details
	 */	
	public boolean ValidateLogin(String username, String password) {
		this.username = username;
		this.password = password;
		
		System.out.println("Going to validate the login details now");
		
		// Check the username is valid
		if (!validateUsername()) {			
			return false;
		}
		
		// Check the password is valid
		if (!validatePassword()) {
			return false;
		}
		
		// valid the username and password combination
		
		
		return true;
	}
}
