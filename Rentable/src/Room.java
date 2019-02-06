import java.text.DecimalFormat;

public class Room implements Rentable {
	// Room Class
	// Implements Rentable interface.  
	// Inputs are name of room  and a daily rate
	// methods return a room name as a description, a daily rate and a caculated price based on the 
	// daily rate and the number of days passed into the method.
	
	//ATTRIBUTES
	public String name;
	public double dailyRate;

	
	//CONSTRUCTORS
	public Room(String roomName, double dailyRate) {
		this.name = roomName;
		this.dailyRate = dailyRate;
	}

	//REQUIRED METHODS FROM INTERFACE
	public String getDescription() {
		//Return the name of this Room.
		return "Room: " + name;
	}

	public double getDailyRate() {
		//Return the daily rate.  No calculation is
		//performed as the value passed to the class is the 
		//daily rate.
		DecimalFormat twoDForm = new DecimalFormat("#.##");
		return Double.valueOf(twoDForm.format(dailyRate));
		
	}

	public double getPrice(double days) {
		//Compute the final price of the rental
		//by taking in the number of days and 
		//multiplying it by the number of days passed to the 
		//method
		return getDailyRate() * days;
	}

}
