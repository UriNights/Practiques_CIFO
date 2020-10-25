package app;

public class Main {

	public static void main(String[] args) {

		GameController gameController = new GameController();
		gameController.start();
		
		System.exit(0);		
	}
}

/* ToDo

calcular el percentatge de torns segons el numero de vempirs, pq sempre es pugui acabar el joc (you lose! There are more vampires than time to kill them!)

primer es mou el player, si caça un vampir el mata, despres es mouen els vampirs

*/