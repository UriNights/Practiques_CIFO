package utilities;

public class IOFilter {

	public static int checkInputForInt(String input) {

		if (input.matches("[0-9]+")) {

			return Integer.parseInt(input);
		}

		return -1;
	}

	public static int numberOfWords(String sentence) {

		boolean state = false; // false means next char is blank space, or next line, or tab.
		int counter = 0;

		int i = 0;
		while (i < sentence.length()) {

			// If next character is a separator, set the state as false
			if (sentence.charAt(i) == ' '
					|| sentence.charAt(i) == '\n'
					|| sentence.charAt(i) == '\t') {
				
				state = false;
			}

			// If next character is not a word separator and state is OUT, then set the
			// state as IN and increment word count
			else if (!state) {
				state = true;
				counter++;
			}

			// Move to next character
			++i;
		}

		return counter;
	}
}
