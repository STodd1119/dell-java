
public class CarLotProgram {

	public static void main(String[] args) {
		
		Truck truck1 = new Truck("BR549", "Ford", "F150", 55000, 16);
		Truck truck2 = new Truck("9999123", "Chevy", "Silverado", 25000, 10);
		Truck truck3 = new Truck("9999123", "Chevy", "Silverado", 25000, 10);
		Car car1 = new Car("xya345", "Mazda", "626", 125000,"sedan", 4);
		Car car2 = new Car("FastCar", "Chevy", "Corvet", 325000,"coupe", 2);
		Car car3 = new Car("ABCEr", "Ford", "Fiesta", 5000,"Hatchback", 3);
		
		
		CarLot lot1 = new CarLot();
		lot1.setCarLotName("Great Car Lot");
		lot1.addtoLot(truck1);
		lot1.addtoLot(truck2);
		lot1.addtoLot(car1);
		
		CarLot lot2 = new CarLot();
		lot2.setCarLotName("The Best Car Lot");
		lot2.addtoLot(car2);
		lot2.addtoLot(truck3);
		lot2.addtoLot(car3);
		
		lot1.printInventory();
		lot2.printInventory();

	}

}
