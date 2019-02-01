
public abstract class Vehicle {

	private String licenseNumber;
	private String make;
	private String model;
	private int price;
	
	//no constructors
	
	//getters setters
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}
	
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	//abstract methods
	public abstract void printDescription();
	
	//non abstract methods

	
}
