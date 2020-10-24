package app;


import controller.ViewController;
import services.Dungeon;

public class GameController {
	
	private ViewController viewController;
	private Dungeon dungeon;
	
	public GameController() {
		this.viewController = new ViewController();
	}

	public void start() {

		while (true) {
			this.newGame();
			
			
		}
	}
	
	private void newGame() {
		
		this.dungeon = this.viewController.configureGame();
	}
}
