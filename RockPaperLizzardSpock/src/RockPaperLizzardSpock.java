import java.util.Random;
import java.util.Scanner;

public class RockPaperLizzardSpock {

	public static Scanner reader = new Scanner(System.in);	
	
	public static void main(String[] args) {

			
			System.out.println("Welcome to ROCK PAPER SCISSORS LIZZARD SPOCK.");
			
			while (playGame()) {
				//play the game
			}
			reader.close();
		}		
			
			
		public static boolean playGame() {	
		//	Ask the user for their  (Rock, Paper, or Scissors).
		//	Generate a random value as the computer's hand.
		//	Print out both the user's hand and the computer's hand to the screen.
		//	Compare the user's hand against the computer's hand.
		//	Print out who won.

			
			boolean continuePlaying = true;
			String userInput = "";
			while (continuePlaying) {
			  try {
				System.out.println("Please enter your choice:");
				System.out.println("Rock");
				System.out.println("Paper");
				System.out.println("Scissors");
				System.out.println("Lizard");
				System.out.println("Spock");
			
				userInput = reader.nextLine();
				userInput = userInput.toUpperCase();
				verifyInput(userInput);
				continuePlaying = false;
				
			  } catch (Exception e) {
				  System.out.println("");
				  System.out.println("");
				  System.out.println("You entered: "+ userInput + " Which was not correct.");
				  System.out.println("");
				  System.out.println("");
			  }
			}  
			//Generate Computer guess
			String compGuess = generateComputerGuess();
								
			//Check to see who the winner is.
				
			int winner = evaluateGuesses(userInput, compGuess);
				
			if (winner == 0 ) {
			  // error duplicate show tie and solicit input again
			  System.out.println("");
			  System.out.println("We TIED and need to start over.");
			  System.out.println("");
			  return true;
			}else if (winner == 1) {
			  System.out.println("You won!");
			}else {
			  System.out.println("Sorry you lost!");
			}
				
			System.out.println("Do you wish to play again? Y to play again. Any other character to end" );
	      	String playAgain = reader.nextLine();
			
	        if (playAgain.equalsIgnoreCase("Y")) {
	          return true;
	        } else {
	          System.out.println("Thanks for playing..");
	          return false;
	        }
		}
		
		public static int evaluateGuesses(String userInput, String compGuess) {
			// Evaluate the input from the user against the computer
			//		Scissors cuts Paper
			//		Paper covers Rock
			//		Rock crushes Lizard
			//		Lizard poisons Spock
			//		Spock smashes Scissors
			//		Scissors decapitates Lizard
			//		Lizard eats Paper
			//		Paper disproves Spock
			//		Spock vaporizes Rock
			//		(and as it always has) Rock crushes Scissors
			
			int intuserInputValue = 0;
			int intCompGuessValue = 0;
			
			intuserInputValue = assignIntValuetoUserGuess(userInput);
			intCompGuessValue = assignIntValuetoUserGuess(compGuess);
			
			if(intuserInputValue == intCompGuessValue) {
				return 0;
			}
			
	        switch (intuserInputValue) {
	        //rock = 1
	        case 1:
	        	printResults(intuserInputValue, intCompGuessValue );
	        	if (intCompGuessValue == 3 || intCompGuessValue == 4) {
	        		//user wins
	        		return 1;
	        	}else if (intCompGuessValue == 2 || intCompGuessValue == 5 ) {
	        		//computer wins
	        		return-1;
	        	}else {
	        		displayErrorMessage(intuserInputValue, intCompGuessValue);
	        		break;
	        	}
	        	
	        //paper = 2	
	        case 2:
	        	printResults(intuserInputValue, intCompGuessValue );
	           	if (intCompGuessValue == 1 || intCompGuessValue == 5) {
	        		//user wins
	        		return 1;
	        	}else if (intCompGuessValue == 3 || intCompGuessValue == 4 ) {
	        		//computer wins
	        		return-1;
	        	}else {
	        		displayErrorMessage(intuserInputValue, intCompGuessValue);
	        		break;
	        	}
	        //Scissors = 3
	        case 3:
	        	printResults(intuserInputValue, intCompGuessValue );
	           	if (intCompGuessValue == 2 || intCompGuessValue == 4) {
	        		//user wins
	        		return 1;
	        	}else if (intCompGuessValue == 5 || intCompGuessValue == 1 ) {
	        		//computer wins
	        		return-1;
	        	}else {
	        		displayErrorMessage(intuserInputValue, intCompGuessValue);
	        		break;
	        	}
	        //lizard = 4
	        case 4:
	        	printResults(intuserInputValue, intCompGuessValue );
	           	if (intCompGuessValue == 5 || intCompGuessValue == 2) {
	        		//user wins
	        		return 1;
	        	}else if (intCompGuessValue == 1 || intCompGuessValue == 3 ) {
	        		//computer wins
	        		return-1;
	        	}else {
	        		displayErrorMessage(intuserInputValue, intCompGuessValue);
	        		break;
	        	}
	        //spock = 5
	        case 5:	
	        	printResults(intuserInputValue, intCompGuessValue );
	          	if (intCompGuessValue == 3 || intCompGuessValue == 1) {
	        		//user wins
	        		return 1;
	        	}else if (intCompGuessValue == 4 || intCompGuessValue == 2 ) {
	        		//computer wins
	        		return-1;
	        	}else {
	        		displayErrorMessage(intuserInputValue, intCompGuessValue);
	        		break;
	        	}
	            
	        }
	        return 0;
		}
		
		public static void printResults (int intuserInputValue, int intCompGuessValue ) {
			
			//Scissors cuts Paper.
			if (intuserInputValue == 3 && intCompGuessValue == 2 ||intuserInputValue == 2 && intCompGuessValue == 3) {
				System.out.println("Scissors cuts Paper.");
				return;
			} 
			//Paper covers Rock.
			if (intuserInputValue == 1 && intCompGuessValue == 2 ||intuserInputValue == 2 && intCompGuessValue == 1) {
				System.out.println("Paper covers Rock.");
				return;
			} 
			//Rock crushes lizard
			if (intuserInputValue == 1 && intCompGuessValue == 4 ||intuserInputValue == 4 && intCompGuessValue == 1) {
				System.out.println("Rock crushes Lizard.");
				return;
			} 
			//Lizard poisons Spock
			if (intuserInputValue == 4 && intCompGuessValue == 5 ||intuserInputValue == 5 && intCompGuessValue == 4) {
				System.out.println("Lizard poisons Spock.");
				return;
			} 
			//Spock smashes Scissors
			if (intuserInputValue == 5 && intCompGuessValue == 3 ||intuserInputValue == 3 && intCompGuessValue == 5) {
				System.out.println("Spock smashes Scissors.");
				return;
			}
			//Scissors decapitate Lizard
			if (intuserInputValue == 3 && intCompGuessValue == 4 ||intuserInputValue == 4 && intCompGuessValue == 3) {
				System.out.println("Scissors decapitate Lizard.");
				return;
			}
			//Lizard eats Paper
			if (intuserInputValue == 4 && intCompGuessValue == 2 ||intuserInputValue == 2 && intCompGuessValue == 4) {
				System.out.println("Lizard eats Paper.");
				return;
			}
			//Paper disproves Spock
			if (intuserInputValue == 2 && intCompGuessValue == 5 ||intuserInputValue == 5 && intCompGuessValue == 2) {
				System.out.println("Paper disproves Spock.");
				return;
			}
			//Spock vaporizes Rock
			if (intuserInputValue == 5 && intCompGuessValue == 1 ||intuserInputValue == 1 && intCompGuessValue == 5) {
				System.out.println("Spock vaporizes Rock.");
				return;
			}
			//(and as it always has) Rock crushes Scissors
			if (intuserInputValue == 1 && intCompGuessValue == 3 ||intuserInputValue == 3 && intCompGuessValue == 1) {
				System.out.println("(and as it always has) Rock crushes Scissors.");
				return;
			}
			
			
		}
		
		
		public static String verifyInput(String userInput) {
			if (userInput.length()>0) {
				
				switch (userInput.toUpperCase()) {
				case "ROCK":
					return "ROCK";
				case "PAPER":
				return "PAPER";
				case "SCISSORS":
				return "SCISSORS";
				case "LIZARD":
				return "LIZARD";
				case "SPOCK":
				return "SPOCK";
				default:
				//return "ERROR";
					throw new IllegalArgumentException();
				}

			}else {
				return "ERROR";
			}
		}

		public static int assignIntValuetoUserGuess(String guessInput) {
			switch(guessInput) {
			case "ROCK":
				return 1;
			case "PAPER":
			return 2;
			case "SCISSORS":
			return 3;
			case "LIZARD":
			return 4;
			case "SPOCK":
			return 5;
			default:
			return 0;
			}
		}
		
		public static String generateComputerGuess() {
			Random randNumGenerator = new Random();
			int randNum = randNumGenerator.nextInt(4); 
			String returnString;
			
			switch (randNum) {
	        case 0:  returnString = "ROCK";
	        		 break;
	        case 1:  returnString = "PAPER";
	        		 break;
	        case 2:  returnString = "SCISSORS";
	        		break;
	        case 3:  returnString = "LIZARD";
	        		break;
	        case 4:  returnString = "SPOCK";
	        		break;
	        default: returnString = "ERROR";
	    }
			System.out.println("I picked " + returnString + ".");
			return returnString;

		}
		
		public static void displayErrorMessage (int intuserInputValue, int intCompGuessValue ) {
			System.out.println("Houston we have a problem.");
			System.out.println("ERROR intuserInputValue is: "+ intuserInputValue + "intCompGuessValue is: " + intCompGuessValue);
		}


	}

