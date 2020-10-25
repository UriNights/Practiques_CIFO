package view;

import java.util.Scanner;

import helpers.IOFilter;
import services.Dungeon;

public class UserInterface {

	private final Scanner scan;
	private Dungeon dungeon;

	public UserInterface(Scanner scan) {

		this.scan = scan;
	}

	public void newGameAdvice() {
		System.out.println("\n\t\t*** Dungeon Keeper ***\n"
				+ "\n"
				+ "Game config:"
				+ "\n");
	}

	public int askForWidth() {
		System.out.print("   > Give a width for the map (4 - 50): ");
		
		int input;
		do {
			input = IOFilter.toIntIfIsBetween(this.scan.nextLine(), 4, 50);		// return -1 if it's not between, or even it's a number.
		} while (input == -1);
		
		return input;
	}

	public int askForHeight() {
		System.out.print("   > Give a height for the map (4 - 10): ");
		
		int input;
		do {
			input = IOFilter.toIntIfIsBetween(this.scan.nextLine(), 4, 10);		// return -1 if it's not between, or even it's a number.
		} while (input == -1);
		
		return input;
	}

	public int askForDifficulty() {
		System.out.print("   > Give a difficult level, where 1 is the easiest and 10 the hardest (1 - 5): ");
		
		int input;
		do {
			input = IOFilter.toIntIfIsBetween(this.scan.nextLine(), 1, 5);		// return -1 if it's not between, or even it's a number.
		} while (input == -1);
		
		return input;
	}

	public void printGame() {
		System.out.println("\n"
				+ "   - You have " + this.dungeon.getPlayer().getBattery() + " turns before you get out of battery.");
		
		System.out.println(this.dungeon);
	}
	
	public String askForMovement() {
		
		System.out.print("   Next movement > ");
		
		String input;
		do {
			input = scan.nextLine();
		} while (!IOFilter.isMovementInput(input));
			
		return input;
	}
	
	public void movementOutOfBoard() {
		System.out.println("   Careful! You get out of the map!");
	}
	
	public void playerWin() {
		System.out.println(this.dungeon 
				+ "\n\t\t¡¡¡ YOU WIN !!!  :DDD\n");
	}

	public void playerLose() {
		System.out.println(this.dungeon
				+ "\n\t\t¡ You lose !  :(\n");
		
	}
	
	public boolean askForNewGame() {
		
		System.out.print("   Do you want to play another time? (y/n) ");
		
		String input;
		do {
			input = scan.nextLine();
		} while (!IOFilter.isYesOrNot(input));
		
		if (input.equals("y")) return true;
		
		scan.close();
		System.out.println("\n   ... Oh! See you soon!!! :)");
		return false;
	}
	
	
	// Getters and Setters

	public void setDungeon(Dungeon dungeon) {
		this.dungeon = dungeon;
	}
}
