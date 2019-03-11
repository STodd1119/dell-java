import java.util.Scanner;

public class TicTacToe {
	
	//global variables
	public static char[] userGuess = new char[9];
	public static char activeUser = 'O';
	public static Scanner reader = new Scanner(System.in);
	public static boolean inputError = false;
	public static boolean catWin = false;

	
	//Main Section
	public static void main(String[] args) {

		while (playGame()) {
			//game is going....
		}
		reader.close();
	}

	public static boolean playGame() {

		String playAgain = "";
		
		for (int i=0; i < userGuess.length; i++) {
			userGuess[i] = Character.forDigit(i, 10);
		}
		
		drawBoard();
		//while we have no winner ask for move changing active user after each call
		while (askForMove()) {
			//keep asking for a move while we have no winner or tie
		}
		
		//Ask user to play again.
		System.out.println("Do you wish to play again? Y or N");
		playAgain = reader.next();
		playAgain = playAgain.toUpperCase();
		if (playAgain.equals("Y")) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public static void drawBoard() {
		//print out the board with the current user guesses populated.
		System.out.println("     |     |");
		System.out.println("_ " + userGuess[0] + " _|_ " + userGuess[1] + " _|_ "+ userGuess[2] + " _");
		System.out.println("     |     |");
		System.out.println("_ " + userGuess[3] + " _|_ " + userGuess[4] + " _|_ "+ userGuess[5] + " _");
		System.out.println("     |     |");
		System.out.println("  " + userGuess[6] + "  |  " + userGuess[7] + "  |  "+ userGuess[8]);
	
	}
	
	public static boolean askForMove() {
		// Prompt for moves check for valid input and check if move is a winner.
		
		int userSelection = 0;
		String userSelString = "";
		
		if (!inputError) {
			if (activeUser == 'X') {
		 		activeUser = 'O';
		 	}else {
		 		activeUser = 'X';
		 	}
		} else {
			inputError = false;
		}
		
		System.out.println("User: " + activeUser + " it is your move.");
		System.out.println("Please enter the number of the square you wish to occupy:");
				
		userSelString = reader.next();
		
		if (validString(userSelString)) {
			userSelection = Integer.parseInt(userSelString);
		} else {
			System.out.println("You have entered an invalid choince please try again");
			inputError = true;
			drawBoard();
			return true;
		}	
		
		if (spaceNotTaken(userSelection)) {
			userGuess[userSelection] = activeUser;
		} else {
			System.out.println("You have entered and invalid choice please try agian");
			inputError = true;
			return true;
		}
		
		if (checkForWin()) {
			//If a winner 
			drawBoard();
			return false;
		}else {
			//No winner next guess			
			drawBoard();
			return true;
		}
	}
	
	public static boolean validString(String input) {
		//accept only valid input 
		String[] validStuff = {"0", "1", "2", "3", "4", "5", "6", "7", "8"}; 
		
		for (int i = 0; i < validStuff.length; i++) {
			if (input.equals(validStuff[i]) ) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean spaceNotTaken(int userSelection) {
		//verify that the selected space has not already been taken by a previous guess.
		if (userGuess[userSelection] == 'X'|| userGuess[userSelection] == 'O' ) {
			System.out.println("That space is already taken.");
			return false;
		}
		return true;
	}
	
	public static boolean checkForWin() {
		//Call helper methods that will verify if we have a winner.
		if (verticalWin()) {
			System.out.println(activeUser + " is winner of this game.");
			return true;
		}else if (horizontalWin()){
			System.out.println(activeUser + " is winner of this game.");
			return true;
		}else if (diagonialWin()) {
			System.out.println(activeUser + " is winner of this game.");
			return true;
		}else if (checkForCatGame()){
			System.out.println("Cat Game!  NO WINNER");
			catWin = true;
			return true;
		}else {
			//do nothing
		}
		return false;
	}
	
	public static boolean verticalWin(){
		if (userGuess[0] ==  activeUser && userGuess[1] ==  activeUser && userGuess[2] ==  activeUser) {
			return true;
		}else if (userGuess[3] ==  activeUser && userGuess[4] ==  activeUser && userGuess[5] ==  activeUser) {
			return true;
		}else if (userGuess[6] ==  activeUser && userGuess[7] ==  activeUser && userGuess[8] ==  activeUser) {
			return true;
		}
		
		return false;
	}
	
	public static boolean horizontalWin() {
		if (userGuess[0] ==  activeUser && userGuess[3] ==  activeUser && userGuess[6] ==  activeUser) {
			return true;
		}else if (userGuess[1] ==  activeUser && userGuess[4] ==  activeUser && userGuess[7] ==  activeUser) {
			return true;
		}else if (userGuess[2] ==  activeUser && userGuess[5] ==  activeUser && userGuess[8] ==  activeUser) {
			return true;
		}
		return false;
	}
	
	public static boolean diagonialWin() {
		if (userGuess[0] ==  activeUser && userGuess[4] ==  activeUser && userGuess[8] ==  activeUser) {
			return true;
		}else if (userGuess[6] ==  activeUser && userGuess[4] ==  activeUser && userGuess[2] ==  activeUser) {
			return true;
		}
		return false;
	}
	
	public static boolean checkForCatGame() {
		// if all guesses have been made and none of the other wins are true then Cat game
		// no one wins.
		if ((userGuess[0] == 'X' || userGuess[0] == 'O') &&
				(userGuess[1] == 'X' || userGuess[1] == 'O') && 
				(userGuess[2] == 'X' || userGuess[2] == 'O') && 
				(userGuess[3] == 'X' || userGuess[3] == 'O') && 
				(userGuess[4] == 'X' || userGuess[4] == 'O') && 
				(userGuess[5] == 'X' || userGuess[5] == 'O') && 
				(userGuess[6] == 'X' || userGuess[6] == 'O') && 
				(userGuess[7] == 'X' || userGuess[7] == 'O') && 
				(userGuess[8] == 'X' || userGuess[8] == 'O')) {
			return true;
		}
		return false;
	}
	
}


