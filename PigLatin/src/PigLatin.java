import java.util.Scanner;


public class PigLatin {

	public static void main(String[] args) {
		// If a word starts with a vowel, add "yay" to the end. (elephant -> elephantyay)
		// If a word starts with a consonant, and has a vowel in the word, move all the letters before the initial vowel, to end, then add "ay". (pig -> igpay)
		// If a word does not have any vowels, then add "ay". (tsktsk -> tsktskyay)
		
		translate();
		
	}
	
	public static void translate() {
		System.out.println("Please enter the word that you would like to translate into Pig Latin");
		Scanner reader = new Scanner(System.in);
		String userInput = reader.nextLine();
		
		if (validateInputContainsOnlyCharacters(userInput)) {
			System.out.println(xlate(userInput));
			
		}else {
			System.out.println("Your input contains non characters and we can not translate.  Please try again.");
			translate(); 
		}
		
		
		 reader.close();
	}
	
	public static boolean validateInputContainsOnlyCharacters(String userInput) {
		//convert string to char array and scan for only isletter
		String str = userInput;
		boolean itsAllGood = false;
		char[] charArray = str.toCharArray();
		
		
		for (int i =0; i < charArray.length; i++) {
			if (Character.isLetter(charArray[i])){
				itsAllGood = true;
				
			} else {
				itsAllGood = false;
				break;
			}
		}
		
		if (itsAllGood) {
			return true;
		}else {
			return false;
		}
		
		
	}
	
	public static String xlate(String userInput) {
		String pigLatinXlation = "";
	
		
		if (checkIfVowel(userInput.charAt(0))) {
			pigLatinXlation = userInput + "yay";
		} else if (checkWordforVowels(userInput)) {
			for (int i = 0; i < userInput.length(); i++) {
				//need a start location here.
			   if (checkIfVowel(userInput.charAt(i))) {
				   String prefix = userInput.substring(0, i);
				   String suffix = userInput.substring(i, userInput.length());
				   pigLatinXlation = suffix + prefix + "ay";
				   break;
			   }
			}
		}else {
			pigLatinXlation = userInput + "ay";
		}
				
		
		return pigLatinXlation;
	}
	
	public static boolean checkWordforVowels(String userInput) {
		for (int i = 0; i < userInput.length(); i++) {
			if (checkIfVowel(userInput.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	
	public static boolean checkIfVowel(char userInputChar) {
		char uiString = Character.toUpperCase(userInputChar);
		
		char[] vowels = {'A', 'E', 'I', 'O', 'U'};
		
		for (int i = 0; i < (vowels.length); i++) {
			
			if (uiString == vowels[i]) {
				return true;
			}
			
		}
		
		return false;
	}
	
}
