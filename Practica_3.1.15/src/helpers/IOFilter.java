package helpers;

public class IOFilter {

	public static int toIntIfIsBetween(String input, int minNumber, int maxNumber) {
		
		if (input.matches("[0-9]+")) {
			
			int value = Integer.parseInt(input);
			if (minNumber <= value && value <= maxNumber) return value;
		}
		System.out.println("Please, enter a valid input: ");
		return -1;
	}
}
