import java.util.Scanner;

public class Caculator {

	public static void main(String[] args) {
		// Ask the user for 2 numbers.
		// Print out the sum of the 2 numbers.
		// Print out the difference of the 2 numbers.
		// Print out the product of the 2 numbers.
		// Print out the quotient of the 2 numebrs.
		// Guidelines:
		//
		// Your program should implement the operations as different methods
		// The methods should take in 2 numbers as input
		// The methods should return a single number as the return value
		int firstnum = 0;
		int secondnum = 0;
		System.out.println("Welcome to Caculator");
		System.out.println("Please enter your first number.\n");
		Scanner reader = new Scanner(System.in);
		firstnum = reader.nextInt();
		System.out.println("Please enter your Second number.\n");
		secondnum = reader.nextInt();

		System.out.println(firstnum + " + " + secondnum + " = " + Add(firstnum, secondnum));

		System.out.println(firstnum + " - " + secondnum + " = " + Subt(firstnum, secondnum));

		System.out.println(firstnum + " x " + secondnum + " = " + Multi(firstnum, secondnum));

		System.out.println(
				firstnum + " / " + secondnum + " = " + Div(firstnum, secondnum) + "." + Mod(firstnum, secondnum));
		reader.close();
	}

	public static int Add(int firstnum, int secondnum) {
		int result = 0;
		result = firstnum + secondnum;
		return result;
	}

	public static int Subt(int firstnum, int secondnum) {

		int result = 0;
		result = firstnum - secondnum;
		return result;
	}

	public static int Multi(int firstnum, int secondnum) {

		int result = 0;
		result = firstnum * secondnum;
		return result;
	}

	public static int Div(int firstnum, int secondnum) {

		int result = 0;
		result = firstnum / secondnum;
		return result;
	}

	public static int Mod(int firstnum, int secondnum) {

		int result = 0;
		result = firstnum % secondnum;
		return result;
	}
}
