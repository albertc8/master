import com.albertc8.database.SQLConnectionURL;
import com.albertc8.vehicles.*;
import java.sql.*;

public class Main {
	
	public static void main(String args[]) {		
		
		System.out.println("*** Hello World, Welcome to Evo Dealer Management System ***");
		
		// Creating a Stock Vehicle		
		Stock stock = new Stock("Ford", "Ka", "2.0 Eco Sport");
		// Set the Chassis
		Chassis chassis = stock.getChassis();
		chassis.setChassis("VX198782907692");
		
		// This is the Stock vehicle that has been created
		System.out.println("This is the stock vehicle, " + 
					"\nManufacture is " + stock.getManufacturer() +
					"\nModel is " + stock.getModel() +
					"\nVariant is " + stock.getVariant() +
					"\nChassis is " + chassis.getChassis());		
		
		// Creating connection to the SQL server database
		SQLConnectionURL sqlConnectionURL = new SQLConnectionURL("DESKTOP-T4119UA", "SQLEXPRESS","DMSDB");
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		conn = sqlConnectionURL.openConnection();
		if (conn != null) {
			
			System.out.println("Establish connection to SQL server database");
			
			try {
				// Create and execute an SQL statement that returns some data.
				String SQL = "SELECT TOP 10 * FROM vehicle";
				stmt = conn.createStatement();
				rs = stmt.executeQuery(SQL);
			
				// Iterate through the data in the result set and display it.
	    		while (rs.next()) {
	    			System.out.println("Vehicle number " + rs.getString(1));
	    		}
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
		}	
	}
}
