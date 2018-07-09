/*
 * Albert Chen 06/07/2018
 * handles login details - MODEL
 */

package com.albertc8.login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.albertc8.database.SQLConnectionURL;

public class Login {
	
	// TODO - these needs to be moved to a parameter table
	private final String server = "DESKTOP-T4119UA";
	private final String instance = "SQLEXPRESS";
	private final String database = "DMSDB";
	
	private String username; // the entered username
	private String password; // the entered password
	
	private String errMesg; // Error message
		
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
		
		// There could be more validate required on the user name
		
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
		
		// There could be more validation on the password
		
		return true;
	}
	
	/*
	 * validate the login details username and password
	 */	
	private boolean validateLoginDetails() {
		
		SQLConnectionURL sqlConnectionURL = null; // MS SQL URL
		Connection conn = null; // SQL connection
		Statement stmt = null; // SQL query statement
		ResultSet rs = null; // Read SQL results
				
		boolean validLogin = false; // Flag if user name is found in users table
		errMesg = "";
		
		if (sqlConnectionURL == null) {
			// Create the connection
			sqlConnectionURL = new SQLConnectionURL(server, instance, database);
		} 
		
		// Query the MS SQL users table
		conn = sqlConnectionURL.openConnection();
				
		if (conn != null) {
			
			try { 
				// Create and execute an SQL statement that returns some data.
				String SQL = "Select userid, password from users where userid like '" + username + "'";
				stmt = conn.createStatement();
				rs = stmt.executeQuery(SQL);
								
				// Iterate through the data in the result set and display it.
	    		while (rs.next()) {
	    			//Ensure we have the correct user record
	    			if (rs.getString(1).equalsIgnoreCase(username) && rs.getString(2).matches(password)) {
	    				validLogin = true;	    					    				
	    			}
	    			break;	    			
	    		}
			} catch(SQLException ex) {
				ex.printStackTrace();			
			}			
		}
		
		if (!validLogin) {
			errMesg = "Incorrect username and password combination";
		}
					
		return validLogin;
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
		if (!validateLoginDetails()) {
			return false;
		}
		
		return true;
	}
}
