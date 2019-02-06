import java.util.Scanner;

public class RentableProgram {

	public static void main(String[] args) {	
		
		// Create an array of "Rentable" objects
		Rentable[] rentalList = new Rentable[9];
		
		// Create rooms
		Room room1 = new Room("BestWestern", 50.00);
		Room room2 = new Room("Marriot", 20.00);
		Room room3 = new Room("Motel 6", 10.00);
		// Create tools
		Tool tool1 = new Tool("Pliers", .25);
		Tool tool2 = new Tool("Wrench", 1.25);
		Tool tool3 = new Tool("Jack Hammer", 20.50);
		// Create condos 
		Condo condo1 = new Condo("Bobs Condo", 150.50);
		Condo condo2 = new Condo("The Place", 300.00);
		Condo condo3 = new Condo("Waldorf Condos", 2200.00);
		
		//Add all of the items created above to the array
		rentalList[0] = room1;
		rentalList[1] = room2;
		rentalList[2] = room3;
		rentalList[3] = tool1;
		rentalList[4] = tool2;
		rentalList[5] = tool3;
		rentalList[6] = condo1;
		rentalList[7] = condo2;
		rentalList[8] = condo3;
		
		// Create a scanner to recieve user input.
		Scanner reader = new Scanner(System.in);
		// Print out the welcome banner and display the list of items to rent along with their Daily Rate.

		System.out.println("          --Welcome to the Rentable Program--");
		System.out.println();
		System.out.println("Please select the number of the item that you wish to rent below");
		for (int i = 0; i < rentalList.length; i++) {
			//Note that the index amount is incremented by 1 to display a more user friendly list for item selection.
			System.out.println((i + 1) + ". " + rentalList[i].getDescription() + "  Daily Rate: " + rentalList[i].getDailyRate());
		}

		// Decrementing user selection by 1 to allow for difference in displayed item selected and the actual item location in the array.
		int itemSelected = reader.nextInt() - 1;
		
		// Prompt user for the number of days that they wish to rent an item.
		System.out.println("Please enter the number of days you wish to Rent " + rentalList[itemSelected].getDescription() + ":\n");
		double numDays =  reader.nextDouble();
		// Display the selection and rate again along with the caculated price for the rental.
		System.out.println("Item: " + (itemSelected + 1) + ". " + rentalList[itemSelected].getDescription());
		System.out.println("Total Price for " + numDays + " day rental: " + rentalList[itemSelected].getPrice(numDays));
		
		// Close out the reader.
		reader.close();
	}

}
