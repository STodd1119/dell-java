import java.util.Scanner;

public class TicTacToe {
	
	//global variables
	public static char[] userGuess = new char[9];
	public static char activeUser = 'X';
	public static Scanner reader = new Scanner(System.in);

	
	//Main Section
	public static void main(String[] args) {

		while (playGame()) {
			//game is going....
		}
		reader.close();
	}

	public static boolean playGame() {
		//char[] userGuess; 
		//userGuess = new char[9];
		//char activeUser = 'X';
		//Initialize array

		String playAgain = "";
		
		for (int i=0; i < userGuess.length; i++) {
			userGuess[i] = Character.forDigit(i, 10);
		}
		
		drawBoard();
		//while we have no winner ask for move changing active user after each call
		while (askForMove()) {
		 	if (activeUser == 'X') {
		 		activeUser = 'O';
		 	}else {
		 		activeUser = 'X';
		 	}
		}
		
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
		
		System.out.println("     |     |");
		System.out.println("_ " + userGuess[0] + " _|_ " + userGuess[1] + " _|_ "+ userGuess[2] + " _");
		System.out.println("     |     |");
		System.out.println("_ " + userGuess[3] + " _|_ " + userGuess[4] + " _|_ "+ userGuess[5] + " _");
		System.out.println("     |     |");
		System.out.println("  " + userGuess[6] + "  |  " + userGuess[7] + "  |  "+ userGuess[8]);
	
	}
	
	public static boolean askForMove() {
		int userSelection = 0;
		String userSelString = "";
		
		System.out.println("User: " + activeUser + " it is your move.");
		System.out.println("Please enter the number of the square you wish to occupy:");
				
		userSelString = reader.next();
		
		if (validString(userSelString)) {
			userSelection = Integer.parseInt(userSelString);
		
			if (spaceNotTaken(userSelection)) {
				//assign selection to array and check for win
				userGuess[userSelection] = activeUser;
				
				//check for win.  If it win announce winner and end
				if (checkForWin()) {
					//winner need to announce winner and close out.
					System.out.println(activeUser + " is winner of this game.");
					drawBoard();
					return false;
				}else {
					//No winner next guess
					
					drawBoard();
					return true;
				}
			} else {
				//print you have entered an invalid choice repaint the board and ask to try again.
				System.out.println("You have entered and invalid choice please try agian");
			}
		}else {
			System.out.println("You have entered and invalid choice please try agian");
		}
		
		return false;
	}
	
	public static boolean validString(String input) {
		String[] validStuff = {"0", "1", "2", "3", "4", "5", "6", "7", "8"}; 
		
		for (int i = 0; i < validStuff.length; i++) {
			if (input.equals(validStuff[i]) ) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean spaceNotTaken(int userSelection) {
			
		if (userGuess[userSelection] == 'X'|| userGuess[userSelection] == 'O' ) {
			System.out.println("That space is already taken.");
			return false;
		}
		
		return true;
	}
	
	public static boolean checkForWin() {
		
		if (verticalWin()) {
			return true;
		}else if (horizontalWin()){
			return true;
		}else if (diagonialWin()) {
			return true;
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
	
}


