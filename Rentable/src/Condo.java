import java.text.DecimalFormat;

public class Condo implements Rentable {
	//Condo Class
	// Implements Rentable interface.  
	// Inputs are the name of the Condo and the weekly Rate for the Condo.
	// Methods return the name of the condo, the calculated daily rate derived from the weekly rate,
	// and calculated price based on the Daily rate divided times the numver of days requested for the rental.
	
	

	//ATTRIBUTES
	public String name;
	public double weeklyrate;
	
	//CONSTRUCTORS
	public Condo () {
		
	}
	public Condo(String name, double weeklyrate) {
		this.name = name;
		this.weeklyrate = weeklyrate;
	}
	
	//REQUIRED METHODS FROM INTERFACE
	public String getDescription() {
		return "Condo: " + name;
	}
	public double getDailyRate() {
		DecimalFormat twoDForm = new DecimalFormat("#.##");
		return Double.valueOf(twoDForm.format(weeklyrate/7));
	}
	public double getPrice(double days) {
		
		double preformatdouble= (weeklyrate/7) * days;
		DecimalFormat twoDForm = new DecimalFormat("#.##");
		return Double.valueOf(twoDForm.format(preformatdouble));
	}
	
}
