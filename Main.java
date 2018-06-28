import com.albertc8.vehicles.*;

public class Main {
	
	public static void main(String args[]) {
		
		System.out.println("Hello World");
		
		Chassis vin = new Chassis("ABC 123");
		System.out.println(vin.getChassis());
		System.out.println(vin.isValid());
		
	}

}
