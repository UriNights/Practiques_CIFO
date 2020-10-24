package controller;

import java.util.Scanner;

import services.Dungeon;
import view.UserInterface;

public class ViewController {

	private Scanner scan;
	private UserInterface userInterface;
	
	public ViewController() {
		this.scan = new Scanner(System.in);
		this.userInterface = new UserInterface(scan);
	}
	
	public Dungeon configureGame() {
		
		userInterface.newGameAdvice();
		
		int width = this.userInterface.askForWidth();
		int height = this.userInterface.askForHeight();
		int difficulty = this.userInterface.askForDifficulty();
		
		return new Dungeon(width, height, difficulty);
	}
}
