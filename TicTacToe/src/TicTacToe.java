import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		
		playGame();
		
	}

	public static void playGame() {
		char[] userGuess; 
		userGuess = new char[9];
		char activeUser = 'X';

		//iniitialize array
		for (int i=0; i < userGuess.length; i++) {
			userGuess[i] = Character.forDigit(i, 10);
		}
		
		drawBoard(userGuess);
		//while we have no winner ask for move changing active user after each call
		while (askForMove(activeUser, userGuess)) {
		 	if (activeUser == 'X') {
		 		activeUser = 'O';
		 	}else {
		 		activeUser = 'X';
		 	}
		}
		
		
		drawBoard(userGuess);
		
	}
	
	public static void drawBoard(char[] userGuess) {
		
		System.out.println("     |     |");
		System.out.println("_ " + userGuess[0] + " _|_ " + userGuess[1] + " _|_ "+ userGuess[2] + " _");
		System.out.println("     |     |");
		System.out.println("_ " + userGuess[3] + " _|_ " + userGuess[4] + " _|_ "+ userGuess[5] + " _");
		System.out.println("     |     |");
		System.out.println("  " + userGuess[6] + "  |  " + userGuess[7] + "  |  "+ userGuess[8]);
	
	}
	
	public static boolean askForMove(char activeUser, char[]userGuess) {
		int userSelection = 0;
	
		System.out.println("User: " + activeUser + " it is your move.");
		System.out.println("Please enter the number of the square you wish to occupy:");
		
		Scanner reader = new Scanner(System.in);
		userSelection = reader.nextInt();
		
		if (validInput(userGuess, userSelection)) {
			//assign selection to array and check for win
			userGuess[userSelection] = activeUser;
			
			//check for win.  If it win announce winner and end
			if (checkForWin(userGuess, activeUser)) {
				//winner need to announce winner and close out.
				reader.close();
				drawBoard(userGuess);
				return false;
			}else {
				//No winner next guess
				reader.close();
				drawBoard(userGuess);
				return true;
			}
		} else {
			//print you have entered an invalid choice repaint the board and ask to try again.
			System.out.println("You have entered and invalid choice please try agian");
		}
		
		reader.close();
		return false;
	}
	
	public static boolean validInput(char[] userGuess, int userSelection) {
		
		//if userSelection not a number between 0-8 return false  
		
		if (userGuess[userSelection] == 'X'|| userGuess[userSelection] == 'O' ) {
			return false;
		}
		
		return true;
	}
	
	public static boolean checkForWin(char[] userGuess, char activeUser) {
		
		if (verticalWin(userGuess, activeUser)) {
			return true;
		}else if (horizontalWin(userGuess, activeUser)){
			return true;
		}else if (diagonialWin(userGuess, activeUser)) {
			return true;
		}
		
		return false;
	}
	public static boolean verticalWin(char[] userGuess, char activeUser){
		if (userGuess[0] ==  activeUser && userGuess[1] ==  activeUser && userGuess[2] ==  activeUser) {
			return true;
		}else if (userGuess[3] ==  activeUser && userGuess[4] ==  activeUser && userGuess[5] ==  activeUser) {
			return true;
		}else if (userGuess[6] ==  activeUser && userGuess[7] ==  activeUser && userGuess[8] ==  activeUser) {
			return true;
		}
		
		return false;
	}
	
	public static boolean horizontalWin(char[] userGuess, char activeUser) {
		if (userGuess[0] ==  activeUser && userGuess[3] ==  activeUser && userGuess[6] ==  activeUser) {
			return true;
		}else if (userGuess[1] ==  activeUser && userGuess[4] ==  activeUser && userGuess[7] ==  activeUser) {
			return true;
		}else if (userGuess[2] ==  activeUser && userGuess[5] ==  activeUser && userGuess[8] ==  activeUser) {
			return true;
		}
		return false;
	}
	
	public static boolean diagonialWin(char[] userGuess, char activeUser) {
		if (userGuess[0] ==  activeUser && userGuess[4] ==  activeUser && userGuess[8] ==  activeUser) {
			return true;
		}else if (userGuess[6] ==  activeUser && userGuess[4] ==  activeUser && userGuess[2] ==  activeUser) {
			return true;
		}
		return false;
	}
	
}


