
public class Car extends Vehicle {
	//attributes
	private String type;
	private int numDoors;
	
	//constructor
	public Car() {
		
	}
	
	public Car(String licenseNum, String make, String model, int price, String type, int numDoors) {
		this.setLicenseNumber(licenseNum);
		this.setMake(make);
		this.setModel(model);
		this.setPrice(price);
		this.setType(type);
		this.setNumDoors(numDoors);
			
	}
	
	//getters setters
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumDoors() {
		return numDoors;
	}

	public void setNumDoors(int numDoors) {
		this.numDoors = numDoors;
	}
	
	public void printDescription() {
		// 
		System.out.println("Make: " + this.getMake());
		System.out.println("Model: "+ this.getModel());
		System.out.println("License Number:" + this.getLicenseNumber());
		System.out.println("Price: " + this.getPrice());
		System.out.println("Type: " + this.getType());
		System.out.println("Number of Doors: " + this.numDoors);
	}

	

}
