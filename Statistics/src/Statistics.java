import java.text.DecimalFormat;
import java.util.Scanner;


public class Statistics {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		promptForInput();

	}
	
	public static void promptForInput() {
		System.out.println("Please enter a comma seperated list of numbers ONLY please:");
		Scanner reader = new Scanner(System.in);
		String userSelString = reader.nextLine();
		String[] userStringArray = userSelString.split(",");
		Integer[] userIntArray = new Integer[userStringArray.length];
		
		for (int i = 0; i< userIntArray.length; i++) {
			userIntArray[i] = Integer.parseInt(userStringArray[i]);
		}
		
		//System.out.println(userIntArray);
		
		findMaxMinValue(userIntArray);
		System.out.println("The number of elements in your array is: " + userIntArray.length);
		//sumArray(userIntArray);
		averageArray(userIntArray, sumArray(userIntArray));
		reader.close();
	}
	
	public static int findMaxMinValue(Integer[] intArrayIn) {
		
		int maxValue = intArrayIn[0];
		int minValue = intArrayIn[0];
		
		for(int i = 1; i < intArrayIn.length; i++) {
			if (intArrayIn[i] > maxValue) {
				maxValue = intArrayIn[i];
			}
			if ( intArrayIn[i] < minValue) {
				minValue = intArrayIn[i];
			}
		}
		System.out.println("The maximum value in your array is: " + maxValue);
		System.out.println("Minumum value is: " + minValue);
		return maxValue;
		
		
	}
	
	public static void averageArray(Integer[] intArrayIn, int arrayTotal) {
		
		DecimalFormat format = new DecimalFormat ("0");
		
		Double arrayAverage = (double) (arrayTotal / intArrayIn.length);
		System.out.println("The average of the array is: " + format.format(arrayAverage));
		
	}

	
	public static int sumArray(Integer[] intArrayIn) {
		int total = 0;
		for (int i = 0; i < intArrayIn.length; i++) {
			total = total + intArrayIn[i];
		}
		System.out.println("The sum of all the numbers in your array is: " + total);
		return total;
	}
}
