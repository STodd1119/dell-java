
public class ParkingGarage {
	//Attributes
	private Car[] spots;
	private int spot;
	private int garagecapacity;
	private String garageName;

	//Constructor
	public ParkingGarage (int capacity) {
		garagecapacity = capacity;
		spots = new Car[capacity];
	}
	
	//getters setters
	public Car[] getSpots() {
		return spots;
	}

	public void setSpots(Car[] spots) {
		this.spots = spots;
	}

	public int getSpot() {
		return spot;
	}

	public void setSpot(int spot) {
		this.spot = spot;
	}


	public boolean anyOpenSpots() {
		for (int i=0; i < garagecapacity; i++) {
			if (spots[i] == null) {
				return true;
			}
		}
		return false;		
	}
	
	public String getGarageName() {
		return garageName;
	}

	public void setGarageName(String garageName) {
		this.garageName = garageName;
	}

	public void park(Car car, int spot) {
		try {
			if (anyOpenSpots()) {
			
				if (spots[spot] == null) {
					spots[spot] = car;
					System.out.println("Car: " + car.getLicenseNum() + " parked in spot " + spot + " in " + this.getGarageName());
				}else {
					//Spot is occupied need to try another.
					System.out.println();
					System.out.println();
					System.out.println("ERROR " + spot + " is Occupied");
					System.out.println("Car "+ car.getLicenseNum() + " tried to park in an occupied spot");
					System.out.println();
					//spots[lookForOpenSpot(car)] = car;
					
				}
			}else {
				//No Open Spots
				System.out.println("Unable to find a place in " + this.getGarageName() + " for " + car.getLicenseNum());
				System.out.println("No Open spots in " + this.garageName + " please find another garage.");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println();
			System.out.println("Problem in "+ this.garageName);
			System.out.println("ERROR SPOT " + spot + " DOES NOT EXIST:" + e);
		}
		
	}
	
	public void vacate(int spot) {
		// remove car from spot
		System.out.println();
		System.out.println();
		System.out.println("Space " + spot + " in " + this.garageName + " has been vacated and is now free.");
		spots[spot] = null;
	}
	
	
	public void printInventory() {
		//print all the instances in spots}
		
		System.out.println("Report for " + this.garageName);
		System.out.println();
		for (int i = 0; i < garagecapacity; i++) {
			if (spots[i] != null) {
				System.out.println("Space " + i + " contains:");
				System.out.println("License: " + spots[i].getLicenseNum());
				System.out.println("Make: "+ spots[i].getMake());
				System.out.println("Color: "+ spots[i].getColor());
				System.out.println("Model: "+ spots[i].getModel());	
				System.out.println();
		
			}else {
				System.out.println("Spot "+ i + " is empty.");
			}
			
					
		}
	}
}
