import java.util.*;

public class CarLot {
	//attributes
	private String carLotName;
	private List<Vehicle> vehiclesList = new ArrayList<Vehicle>();
	
	//constructors
	public CarLot() {
	
	}

	//getters setters
	public String getCarLotName() {
		return carLotName;
	}

	public void setCarLotName(String carLotName) {
		this.carLotName = carLotName;
	}

	public List<Vehicle> getVehiclesList() {
		return vehiclesList;
	}


	public void setVehiclesList(List<Vehicle> vehiclesList) {
		this.vehiclesList = vehiclesList;
	}

	//Methods
	public void addtoLot(Vehicle myvehicle) {
		//code to add to the list here
		vehiclesList.add(myvehicle);
	}
	
	public void printInventory() {
		//code to print inventory.
		System.out.println(carLotName + " vehicle report.");
		System.out.println("...This lot currently contains " + vehiclesList.size() + " vehicles.");
		System.out.println();
		for (int i = 0; i < vehiclesList.size(); i++) {
			vehiclesList.get(i).printDescription();
			System.out.println();
		}
	}
	

}
