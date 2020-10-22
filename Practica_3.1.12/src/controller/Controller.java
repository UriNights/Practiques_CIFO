package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.University;
import service.StudentsDB;
import utils.StarterInformation;
import view.UserInterface;

public class Controller {

	public static Object quitProgram;
	private static Scanner scan;
	private static UserInterface UI;
	private static ArrayList<StudentsDB> universityList;
	
	public Controller() {
		
		universityList = StarterInformation.universities;
		
		scan = new Scanner(System.in);
		UI = new UserInterface(scan);
	}
	
	public void start() {

		while (true) {
			UI.startMenu();
		}
	}

	// Start Menu
	
	public static ArrayList<University> getUniverisities() {
		
		ArrayList<University> listUniversities = new ArrayList<>();
		for (StudentsDB studentsDB : universityList) {
			listUniversities.add(studentsDB.getUniversity());
		}
		
		return listUniversities;
	}
	
	public static StudentsDB getStudentsDB(int number) {
		
		return universityList.get(number);
	}

	public static void addUniversity() {
		// TODO Auto-generated method stub
		
	}

	public static void deleteUniversity() {
		// TODO Auto-generated method stub
		
	}
}
