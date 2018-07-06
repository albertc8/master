package com.albertc8.database;

import java.sql.*;

public class SQLConnectionURL {

	private String serverName;   // address of the server to connect to
	private String instanceName; // instance to connect to on serverName
	private String databaseName; // database to connect to
	
	// Declare the JDBC objects.
	private	Connection conn = null;
	
	/* 
	 * Constructor
	 */
	public SQLConnectionURL(String serverName, String instanceName, String databaseName) {
		this.serverName = serverName;
		this.instanceName = instanceName;
		this.databaseName = databaseName;
	}
	
	/*
	 * generate the connection URL
	 */
	private String buildURL() {
		
		//"jdbc:sqlserver://DESKTOP-T4119UA\\SQLEXPRESS;databaseName=DMSDB;integratedSecurity=true";		
		return "jdbc:sqlserver://" + serverName + "\\" + instanceName + ";databaseName=" + databaseName + ";integratedSecurity=true";
	}
		
	/*
	 * Is there already a connections to MS SQL server
	 */
	private boolean isConnected() {
		
		return conn != null ? true : false;		
	}
	
	/*
	 * print the MS SQL server connections details
	 */
	private void printConnectionDetails() {
		
		try {
			// Already an connection
			DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
			System.out.println("Driver name: " + dm.getDriverName());
			System.out.println("Driver version: " + dm.getDriverVersion());
			System.out.println("Product name: " + dm.getDatabaseProductName());
			System.out.println("Product version: " + dm.getDatabaseProductVersion());
		} catch(SQLException ex) {
			ex.printStackTrace();
		}		
	}
	
	/*
	 * Open the connections to SQL server database
	 */
	public Connection openConnection() {
		
		// Check if there is already connected
		if (isConnected()) {
			return null;
		} else {
		
			// Create a variable for the connection string.
			String connectionUrl = buildURL();
			
			try {
				 
			    // Establish the connection.
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection(connectionUrl,"","");
				
				printConnectionDetails();
				
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
			
			return conn;
		}		
	}
	
	/*
	 * Close the database connections
	 */
	public void closeConnection() {		
              
	    try {
	        if (conn != null && !conn.isClosed()) {
	            conn.close();
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}
	
}
