
public class Car {
	//Attributes
	private String color;
	private String licenseNum;
	private String make;
	private String model;

	//Constructors
	public Car() {
		
	}
	
	public Car(String color, String licenseNum, String make, String model) {
		this.setColor(color);
		this.setLicenseNum(licenseNum);
		this.setMake(make);
		this.setModel(model);
	}

	//getters and setters
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getLicenseNum() {
		return licenseNum;
	}

	public void setLicenseNum(String licenseNum) {
		this.licenseNum = licenseNum;
	}

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
	
	
	
	
}
