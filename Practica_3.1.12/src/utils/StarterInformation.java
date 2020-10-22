package utils;

import java.time.LocalDate;
import java.util.ArrayList;

import model.Student;
import service.StudentsDB;

public class StarterInformation {

	public static ArrayList<StudentsDB> universities = new ArrayList<>();
	
	static {
		StudentsDB UniWales = new StudentsDB("University of Wales", "United Kingdom", "Wales");
		
		UniWales.setNewStudent(new Student("Mario", "Gonzàlez", LocalDate.now(), 170, 80, UniWales));
		UniWales.setNewStudent(new Student("Juan", "Gonzàlez", LocalDate.now(), 170, 80, UniWales));
		UniWales.setNewStudent(new Student("Antonio", "Gonzàlez", LocalDate.now(), 170, 80, UniWales));
		UniWales.setNewStudent(new Student("Maria", "Gonzàlez", LocalDate.now(), 170, 80, UniWales));
		universities.add(UniWales);
		
		StudentsDB UniOxford = new StudentsDB("Oxford Univesity", "United Kingdom", "Oxford");
		
		UniWales.setNewStudent(new Student("Luisa", "Gonzàlez", LocalDate.now(), 170, 80, UniOxford));
		UniWales.setNewStudent(new Student("Hugo", "Gonzàlez", LocalDate.now(), 170, 80, UniOxford));
		UniWales.setNewStudent(new Student("Pedro", "Gonzàlez", LocalDate.now(), 170, 80, UniOxford));
		UniWales.setNewStudent(new Student("Elionor", "Gonzàlez", LocalDate.now(), 170, 80, UniOxford));
		universities.add(UniOxford);
	}
}
