package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.University;
import utils.GenericUtils;

public class UIMenuItems {

	private Scanner scan;

	protected UIMenuItems(Scanner scan) {

		this.scan = scan;
	}
	
	private String getAnswer(int minOption, int maxOption) {
		
		String answer;
		
		while (true) {
			answer = scan.nextLine();
			if (GenericUtils.checkAnswer(answer, minOption, maxOption)) {
				return answer;
			}
			
			System.out.print("Please, enter an option number: ");
			continue;
		}
	}

	protected String mainMenu() {

		System.out.print("\n\t--- Main menu ---\n"
				+ "\n"
				+ "1) List of universities\n"
				+ "2) Add new university\n"
				+ "3) Delete university\n"
				+ "4) Quit\n"
				+ "Select an option: ");
		
		return this.getAnswer(1, 4);
	}

	protected String listUniversities(ArrayList<University> listUniversities) {

		System.out.println("\n"
				+ "0) Back");

		for (int i = 0; i < listUniversities.size(); i++) {
			System.out.println((i + 1) + ") " + listUniversities.get(i).getName());
		}

		System.out.print("Select university for more information: ");
		
		return this.getAnswer(0, listUniversities.size());
	}

	public String universityInfo(University university) {

		System.out.println("*** " + university + " ***\n"
				+ "0) Back");

		for (int i = 0; i < university.get; i++) {
			System.out.println((i + 1) + ") " + listUniversities.get(i).getName());
		}

		System.out.print("Select university for more information: ");
		
		return this.getAnswer(0, listUniversities.size());
	}
	
	public void bye() {
		
		System.out.print("\nSee you soon!!! :)");
	}
}