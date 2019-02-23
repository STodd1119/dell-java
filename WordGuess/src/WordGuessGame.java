import java.io.*;
import java.util.*;
import java.util.Random;
import java.util.Scanner;

public class WordGuessGame {
	
	public static Scanner reader = new Scanner(System.in);
	public static char[] usedLetters = new char[26];
	public static int numberOfGuesses = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = null;
		
		//Create a List called word list
		List<String> wordList = new ArrayList<String>();
		
		// read in words from a file called words.txt into your wordList list.
		// close the file.
		try {
			in = new BufferedReader(new FileReader("words.txt"));
			String line;
			while ((line = in.readLine()) != null) {
				wordList.add(line);
			}
		} finally {
			// Close input and output streams
			if (in != null) {
				in.close();
			}
		}

		// Using the Random number generator create a random number
		// that is based on the size of the number of words in the list.
		Random randNumGenerator = new Random();
		int randNum = randNumGenerator.nextInt(wordList.size());

		// Using the random number select the word in the list that will be used to guess
		String wordToGuess = wordList.get(randNum);

		//DEBUG - Uncommented this will print the solution before the prompt for guess ***remove for final version
		//System.out.println(wordToGuess);
		
		System.out.println("Welcome to the word guessing game.");
		System.out.println("I will select a word at random from a ");
		System.out.println("file containing over 20,000 words");
		System.out.println("See how fast you can guess all the letters.");
		System.out.println();
		System.out.println("Here is your word to guess.  Enter one letter only.");
		System.out.println();
		System.out.println();
		
		//Change the word to guess to a character array.
		char wordToGuessChar[] = wordToGuess.toCharArray();
		//Create an array that will be used to display the word on the console.
		char wtgDisplay[] = new char[(wordToGuessChar.length)];
		

		// Initialize the character array that will be used to display 
		// the word on the console to dashes.
		for (int i= 0; i< wordToGuessChar.length; i++) {
			wtgDisplay[i] = '-';
		}
		
		// While the flag to keep guessing is true loop through 
		// asking the user to supply guesses.  Compare those
		// against the letters in the character array and when found
		// modify the display array to show the guess along with the remaining dashes.
		boolean keepGuessing = true;
		while (keepGuessing) {
			System.out.println(wtgDisplay);
			System.out.println("your guess please");
			String userGuess = reader.next();
			// Validate the user guess and then 
			// Increment the number of guesses by one and add it to the used letter array.
			if (validateUserGuess(userGuess)) {
				char ugChar[] = userGuess.toCharArray();
				char userGuessChar = ugChar[0];
				usedLetters[numberOfGuesses] = userGuessChar;
				numberOfGuesses++;
			
				// Evaluate user guess and change the display with the letters of the guess that were correct.
				for (int i= 0; i<wordToGuessChar.length; i++) {
					if(wordToGuessChar[i] == userGuessChar){
						wtgDisplay[i] = userGuessChar;
					}
				}
			
				// Call helper method that will check the display for any remaining dashes
				// if they are found return false and return winner
				if (checkforDashesLeft(wtgDisplay)) {
					keepGuessing = true;
				} else {
					keepGuessing = false;
				}
				
			} else {
				System.out.println("Invalid Guess");
			}
		} //end of the while loop that keeps guessing
		
		//print out the winning information
		System.out.println();
		System.out.println();
		System.out.println(wtgDisplay );
		System.out.println("is the word.");
		System.out.println();
		System.out.println();
		System.out.println("You got all the letters in "+ numberOfGuesses + " guesses.  Good job");
		
		
	}
	
	
	
	public static boolean checkforDashesLeft(char[] wtgDisplay) {
		//helper method used to check if any dashes are left in the display
		//if none exist then the user has guessed all the letters in the word and  the game is over.
		for (int i = 0; i < wtgDisplay.length; i++) {
			if (wtgDisplay[i] == '-') {
				return true;
			}
		}
		return false;
	}

	public static boolean validateUserGuess(String userGuess) {
		// Method validates that the user input is correct.  It checks for
		// length, empty guess, numeric input, and if the letter has been used.
		if (userGuess.length()>1) {
			System.out.println("You may submit only one character.  Please try again...");
			return false;
		} else if (userGuess.isEmpty()) {
			System.out.println("You must enter a character to guess.  Please try again...");
			return false;
		} else if (isNumeric(userGuess)) {
			System.out.println("you must enter a character to guess.  Please try again...");
			return false;
		}else if (hasLetterBeenUsed(userGuess)){
			System.out.println("The letter: " + userGuess + " has already been used. Please select another.");
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean hasLetterBeenUsed(String userGuess) {
		// Method checks the usedLetters array for letters that have
		// already been used.  If they have been used then it returns
		// an error.
		char userGuessChar[] = userGuess.toCharArray();
		for (int i = 0; i < usedLetters.length; i ++) {
			if (userGuessChar[0]== usedLetters[i]) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isNumeric(String str)  {
		// Method that will parse a string for a numierc value
		// if one is found it will return a true.  If it is 
		// not a numeric it returns false.
		try  {  
			double d = Double.parseDouble(str);  
		}  
		catch(NumberFormatException nfe) {  
			return false;  
		}  
		
		return true;  
	}
	
}
