import com.albertc8.vehicles.*;

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
	}

}
