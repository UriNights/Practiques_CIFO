package utils;

public class GenericUtils {

	public static boolean checkAnswer(String answer, int minOption, int maxOption) {

		if (answer.matches("[0-9]+")) {

			int answerToInt = Integer.valueOf(answer);

			if (minOption <= answerToInt && answerToInt <= maxOption) {
				return true;
			}
		}

		return false;
	}
}
