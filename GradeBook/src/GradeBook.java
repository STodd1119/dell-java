import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GradeBook {

	public static Scanner reader = new Scanner(System.in);
	public static HashMap<String, String> userGradesMap = new HashMap<String, String>();
	public static HashMap<String, Double> userGradesAvg = new HashMap<String, Double>();
	
	
	public static void main(String[] args) {
		//Prompt user for the number of students to be entered into the gradebook
		//Ask for each students name and a comma seperated list of grades in string format
		//Print out each students name and grade average
		
		promptForInput();
		caculateAverages();
		printReportOfAverages();
		
		System.out.println(" ");
		System.out.println("Thank you for using GradeBook!");
	}

	public static void promptForInput() {
		//Ask user for the number of students that they wish to enter grades for.
		//loop through that number asking for the Students name and a comma separated list of grades.
		//Assign those values to HashMap userGradesMap to be utilized in the averaging of grades function of this program.
		System.out.println("Please enter the number of students that you wish to enter grades for.");
		int numOfStudents = Integer.parseInt(reader.nextLine());
		
		for (int i = 0; i < numOfStudents; i++) {
			System.out.println("Please enter the student name");
			String studentName = reader.nextLine();
			System.out.println("Please enter comma seperated list of grades");
			String gradesString = reader.nextLine();
			userGradesMap.put(studentName, gradesString);
		}


	}
	
	public static void caculateAverages() {
		// Get the list of names in the HashMap of grades that was entered.
		// Loop through each name and calculate the average of the grades entered.
		// Assign those calculated values to HashMap userGradesAvg to be utilized in the final reporting part of this program.
	    ArrayList<String> names = new ArrayList<String>(userGradesMap.keySet()); 
	    for (int i = 0; i < names.size(); i++) {
	    	String currentName = names.get(i);
	    	String currentGrades = userGradesMap.get(currentName);
	    	String[] gradesArray = currentGrades.split(",");
	    	Integer[] gradesIntArray = new Integer[gradesArray.length];
	    	
	    	for (int j = 0; j< gradesArray.length; j++) {
	    		gradesIntArray[j] = Integer.parseInt(gradesArray[j]);
			}
				    	
	    	Double currentAverage = averageArray(gradesIntArray, sumArray(gradesIntArray));
	    	userGradesAvg.put(currentName, currentAverage);
  	    }
	}
	
	public static void printReportOfAverages() {
		// Print two blank lines for spacing from the input
		// Get a list of names in the HashMap that were recorded when calculating averages.
		// Loop through that list and print out the final results of all items in the HashMap.
		System.out.println(" ");
		System.out.println(" ");
		ArrayList<String> names = new ArrayList<String>(userGradesAvg.keySet()); 
		for (int i = 0; i < names.size(); i++) {
			String currentName = names.get(i);
	    	//Double currentGrades = userGradesAvg.get(currentName);
	    	System.out.println("Student: " + currentName + " has an average grade of " + userGradesAvg.get(currentName));
		}
	}
	
	public static Double averageArray(Integer[] intArrayIn, int arrayTotal) {
		// Input: Integer array and a Total of numbers in that array.
		// Output: Double value that is the average of that array.
		double doubTotal = (double) arrayTotal;
		
		Double arrayAverage = (double) (doubTotal / intArrayIn.length);
		return arrayAverage;
	}

	
	public static int sumArray(Integer[] intArrayIn) {
		// Input: Integer array
		// Output: integer that is the sum of all integers in the array.
		
		int total = 0;
		for (int i = 0; i < intArrayIn.length; i++) {
			total = total + intArrayIn[i];
		}
		return total;
	}
}
