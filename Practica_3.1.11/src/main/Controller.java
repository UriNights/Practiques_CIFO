package main;

import java.util.Scanner;

public class Controller {

	private Scanner scan;
	private View userInterface;

	public Controller() {
		this.scan = new Scanner(System.in);
		this.userInterface = new View(this.scan);
	}

	public void Start() {

		while (true) {
			Date dateFromUser = this.userInterface.askForDate();
			this.userInterface.giveDayName(dateFromUser);
		}
	}
}
