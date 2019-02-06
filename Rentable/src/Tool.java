import java.text.DecimalFormat;

public class Tool implements Rentable{
	//Tool Class
	// Implements Rentable interface.  
	// Inputs are the name of the tool and the hourly rate to rent the tool.
	// Methods return tool name as description, the compute daily rate hourly rate * 24
	// and the price of a rental based on the daily rate times the number of days requested
	// for the rental.
	
	//ATTRIBUTES
	public String name;
	public double hourlyRate;

	//CONSTRUCTORS
	public Tool() {
		
	}
	
	public Tool( String myName, double myRate) {
		this.name = myName;
		this.hourlyRate = myRate;
	}
	
	
	//REQUIRED METHODS FROM INTERFACE
	public String getDescription() {
		return "Tool: " + name;
	}
	public double getDailyRate() {
		return hourlyRate * 24.00;
	}
	public double getPrice(double days) {
		DecimalFormat twoDForm = new DecimalFormat("#.##");
		double preformatDailyRate = getDailyRate() * days;
		return Double.valueOf(twoDForm.format(preformatDailyRate));
	}
	
}
