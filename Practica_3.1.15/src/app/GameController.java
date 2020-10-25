package app;

import controller.Controller;

public class GameController {

	private final Controller controller;

	public GameController() {
		this.controller = new Controller();
	}

	public void start() {

		boolean newGame = true;
		
		while (newGame) {
			this.newGame();

			while (this.controller.nextTurn());
			
			newGame = this.controller.nextGame();
		}
	}

	private void newGame() {
		this.controller.configureGame();
	}
}