package utils;

import java.util.Random;

public class RandomRequest {
	
	private static Random random = new Random();

	public static char getChar() {
		
		// First randomize for number or letter
		
		if (random.nextInt(1) == 0) {
			return (char) (random.nextInt(9) + '0');
		}
		
		// If don't give number, go ahead for a letter
		// Lower case letters in ASCII: from 97 to 122
		
		char letter = (char) (random.nextInt(25) + 'a');
		
		// Then we try for an upper case
		
		if (random.nextInt(1) == 0) {
			return Character.toUpperCase(letter);
		}
		
		return letter;
	}
	
	public static int getIntFromZeroTo(int maxNumber) {
		
	}
}
