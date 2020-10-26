package controller;

import java.util.Scanner;

import services.Dungeon;
import view.UserInterface;

public class Controller {

	private final Scanner scan;
	private final UserInterface userInterface;
	private Dungeon dungeon;
	
	public Controller() {
		
		this.scan = new Scanner(System.in);
		this.userInterface = new UserInterface(scan);
	}
	
	public void configureGame() {
		
		userInterface.newGameAdvice();
		
		int width = this.userInterface.askForWidth();
		int height = this.userInterface.askForHeight();
		int difficulty = this.userInterface.askForDifficulty();
		
		this.dungeon = new Dungeon(width, height, difficulty);
		this.userInterface.setDungeon(this.dungeon);
	}

	public boolean nextTurn() {

		userInterface.printGame();
		
		while (!dungeon.movePlayerAndKill(userInterface.askForMovement())) {
			userInterface.movementOutOfBoard();
		}
		
		dungeon.moveVampires();
		
		int gameState = dungeon.gameState();
		
		if (gameState == 0) return true;
		
		if (gameState == 1) userInterface.playerWin();
		if (gameState == -1) userInterface.playerLose();
		
		return false;
	}

	public boolean nextGame() {
		
		return userInterface.askForNewGame();		
	}
}
