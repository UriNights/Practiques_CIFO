package View;

import java.util.Scanner;

import Services.Dungeon;

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
		// TODO Auto-generated method stub
		return 0;
	}

	public int askForHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int askForDificulty() {
		// TODO Auto-generated method stub
		return 0;
	}
}
