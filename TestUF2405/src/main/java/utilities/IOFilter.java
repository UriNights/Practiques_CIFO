package utilities;

public class IOFilter {

	public static int checkInputForInt(String input) {

		if (input.matches("[0-9]+")) {
			
			return Integer.parseInt(input);
		}
		
		return -1;
	}
}
