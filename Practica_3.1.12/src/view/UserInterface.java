package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.Controller;
import model.University;

public class UserInterface {

	private Scanner scan;
	private UIMenuItems menuItems;

	public UserInterface(Scanner scan) {

		this.scan = scan;
		this.menuItems = new UIMenuItems(scan);
	}

	public void startMenu() {

		while (true) {
			
			switch (this.menuItems.mainMenu()) {
			case "1":
				this.universitiesMenu(Controller.getUniverisities());
				break;

			case "2":
				Controller.addUniversity();
				break;

			case "3":
				Controller.deleteUniversity();
				break;

			case "4":
				menuItems.bye();
				System.exit(0);
				break;

			default:
				break;
			}
		}
	}

	private void universitiesMenu(ArrayList<University> listUniverisities) {

		while (true) {
			
			String answer = menuItems.listUniversities(listUniverisities);
			
			switch (answer) {
			case "0":
				return;

			default:
				this.universityInfoMenu(listUniverisities.get(Integer.valueOf(answer)));
				break;
			}
		}
	}

	private void universityInfoMenu(University university) {	//passar el hashmap de studentsDB
		
		while (true) {
			
			String answer = menuItems.universityInfo(university);
			
			switch (answer) {
			case "0":
				return;

			default:
				break;
			}
		}
	}
}