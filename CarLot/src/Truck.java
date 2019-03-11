
public class Truck extends Vehicle {
	//Attributes
	private int bedSize;
	
	//Constructors
	public Truck() {
		
	}
	public Truck(String licenseNum, String make, String model, int price,int bed) {
		this.setLicenseNumber(licenseNum);
		this.setMake(make);
		this.setModel(model);
		this.setPrice(price);
		this.setBedSize(bed);
	}
	
	
	public int getBedSize() {
		return bedSize;
	}

	public void setBedSize(int bedSize) {
		this.bedSize = bedSize;
	}


	public void printDescription() {
		// include bed size in this description
		System.out.println("Make: " + this.getMake());
		System.out.println("Model: "+ this.getModel());
		System.out.println("License Number:" + this.getLicenseNumber());
		System.out.println("Price: " + this.getPrice());
		System.out.println("Bed Size: " + this.getBedSize());
	}

}
