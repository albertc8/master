import com.albertc8.database.SQLConnectionURL;
import com.albertc8.login.*;
import com.albertc8.vehicles.*;

import java.awt.EventQueue;
import java.io.*;
import java.sql.*;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class Main {
	
	private static final String INPUT_FILE = "C:\\Users\\chen\\eclipse-workspace\\EvoDMS\\src\\connection.xml"; 
	
	/**
	 * Launch the application. 
	 */
	public static void main(String args[]) {		
				
		try {
		
		File inputFile = new File(INPUT_FILE);
			
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document doc = builder.parse(inputFile);
		doc.getDocumentElement().normalize();
		
		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		
		NodeList nList = doc.getElementsByTagName("connection");
		Node nNode = nList.item(0);
        System.out.println("Current Element :" + nNode.getNodeName());
        
        Element eElement = (Element) nNode;
        System.out.println("server   :" + eElement.getElementsByTagName("server").item(0).getTextContent());
        System.out.println("instance :" + eElement.getElementsByTagName("instance").item(0).getTextContent());
        System.out.println("database :" + eElement.getElementsByTagName("database").item(0).getTextContent());
        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
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
		
		Login login = new Login(); // MODEL
				
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Display the login screen
					LoginView loginView = new LoginView("Log in", login); // VIEW
					loginView.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static String getCharacterDataFromElement(Element e) {
		Node child = ((Node) e).getFirstChild();
		if (child instanceof CharacterData) {
			CharacterData cd = (CharacterData) child;
		    return cd.getData();
		}
		return "?";
	  }
}
