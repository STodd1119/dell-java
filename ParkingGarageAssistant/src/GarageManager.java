
public class GarageManager {

	public static void main(String[] args) {

		//create  cars
		Car steveCar = new Car("Black", "BR549", "Ford", "F150");
		Car car1 = new Car("Red", "xyz345", "Porche", "911");
		Car car2 = new Car("Blue", "BIGTRUCK", "Chevy", "Silverado");
		Car car3 = new Car("Green", "GREENHORNET", "Mazda", "SX7");
		Car car4 = new Car("White", "1234abc", "VW", "Bug");
		Car car5 = new Car("Maroon", "77712x", "Hummer", "V");
		Car car6 = new Car("Yellow", "zzz432", "Dodge", "Ram");
		
		//create a garages	
		ParkingGarage steveGarage = new ParkingGarage(5);
		steveGarage.setGarageName("Steves Garage");
		ParkingGarage bobGarage = new ParkingGarage(3);
		bobGarage.setGarageName("Bob's Garage");
		
		//move cars into the the garages
		//move cars into Steves garage
		steveGarage.park(steveCar, 0);
		steveGarage.park(car1,1);
		steveGarage.park(car2,2);
		
		//move cars into Bobs Garage
		bobGarage.park(car3, 0);
		bobGarage.park(car4, 1);
		bobGarage.park(car5, 2);
		
		// try to park a car  in a spot that is not in the garage.
		bobGarage.park(car3, 3);
		//try to park a care in a spot that is already taken.
		bobGarage.park(car3, 0);
		
		//report on the garages
		steveGarage.printInventory();
		bobGarage.printInventory();
		
		//remove some cars from garages.
		steveGarage.vacate(1);
		bobGarage.vacate(2);
		
		//report again on garages
		steveGarage.printInventory();
		bobGarage.printInventory();
		
		//add cars to garages
		bobGarage.park(car1, 2);
		steveGarage.park(car5, 1);
		
		//final report on garage status.
		steveGarage.printInventory();
		bobGarage.printInventory();
		
	

	}

}
