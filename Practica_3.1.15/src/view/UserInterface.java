package view;

import java.util.Scanner;

import helpers.IOFilter;
import services.Dungeon;

public class UserInterface {

	private Scanner scan;

	public UserInterface(Scanner scan) {

		this.scan = scan;
	}

	public void newGameAdvice() {
		System.out.print("\n\t\t*** Dungeon Keeper ***\n"
				+ "\n"
				+ "Game config:");

	}

	public int askForWidth() {
		System.out.println("\t> Give a width for the map (4 - 50): ");
		
		int input;
		do {
			input = IOFilter.toIntIfIsBetween(this.scan.nextLine(), 4, 50);		// return -1 if it's not between, or even it's a number.
		} while (input == -1);
		
		return input;
	}

	public int askForHeight() {
		System.out.println("\t> Give a height for the map (4 - 10): ");
		
		int input;
		do {
			input = IOFilter.toIntIfIsBetween(this.scan.nextLine(), 4, 10);		// return -1 if it's not between, or even it's a number.
		} while (input == -1);
		
		return input;
	}

	public int askForDifficulty() {
		System.out.println("\t> Give a difficult level, where 1 is the easiest and 10 the hardest (1 - 10): ");
		
		int input;
		do {
			input = IOFilter.toIntIfIsBetween(this.scan.nextLine(), 1, 5);		// return -1 if it's not between, or even it's a number.
		} while (input == -1);
		
		return input;
	}
}
