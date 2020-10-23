package app;


import Controller.ViewController;
import Services.Dungeon;

public class GameLuncher {
	
	private ViewController viewController;
	private Dungeon dungeon;
	
	public GameLuncher() {
		this.viewController = new ViewController();
	}

	public void start() {

		while (true) {
			this.newGame();
		}
	}
	
	private void newGame() {
		
		dungeon = this.viewController.configureGame();
	}
}
