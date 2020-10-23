package Controller;

import java.util.Scanner;

import Services.Dungeon;
import View.UserInterface;

public class ViewController {

	private Scanner scan;
	private UserInterface userInterface;
	private Dungeon dungeon;
	
	public ViewController() {
		this.scan = new Scanner(System.in);
		this.userInterface = new UserInterface(scan);
	}
	
	public Dungeon configureGame() {
		
		userInterface.newGameAdvice();
		
		int width = this.userInterface.askForWidth();
		int height = this.userInterface.askForHeight();
		int numberOfVampires = this.userInterface.askForDificulty();
		
		return new Dungeon(width, height, numberOfVampires)
	}
}
