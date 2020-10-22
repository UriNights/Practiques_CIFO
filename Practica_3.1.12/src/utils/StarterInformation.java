package utils;

import java.time.LocalDate;
import java.util.ArrayList;

import model.Student;
import service.StudentsDB;

public class StarterInformation {

	public static ArrayList<StudentsDB> universities = new ArrayList<>();
	
	static {
		StudentsDB UniWales = new StudentsDB("University of Wales", "United Kingdom", "Wales");
		
		UniWales.setNewStudent(new Student("Mario", "Gonz�lez", LocalDate.now(), 170, 80, UniWales));
		UniWales.setNewStudent(new Student("Juan", "Gonz�lez", LocalDate.now(), 170, 80, UniWales));
		UniWales.setNewStudent(new Student("Antonio", "Gonz�lez", LocalDate.now(), 170, 80, UniWales));
		UniWales.setNewStudent(new Student("Maria", "Gonz�lez", LocalDate.now(), 170, 80, UniWales));
		universities.add(UniWales);
		
		StudentsDB UniOxford = new StudentsDB("Oxford Univesity", "United Kingdom", "Oxford");
		
		UniWales.setNewStudent(new Student("Luisa", "Gonz�lez", LocalDate.now(), 170, 80, UniOxford));
		UniWales.setNewStudent(new Student("Hugo", "Gonz�lez", LocalDate.now(), 170, 80, UniOxford));
		UniWales.setNewStudent(new Student("Pedro", "Gonz�lez", LocalDate.now(), 170, 80, UniOxford));
		UniWales.setNewStudent(new Student("Elionor", "Gonz�lez", LocalDate.now(), 170, 80, UniOxford));
		universities.add(UniOxford);
	}
}
