package service;

import java.util.HashMap;

import model.Student;
import model.University;

public class StudentsDB {
	
	private final University university;
	
	private HashMap<Long, Student> idAndStudents;
	private static long lastID;
	
	public StudentsDB(String name, String country, String city) {
		
		this.university = new University(name, country, city);
		
		this.idAndStudents = new HashMap<>();
		this.lastID = 0;
	}

	public long getLastID() {

		return lastID;
	}
	
	private long getNextID() {

		this.lastID++;
		return this.lastID;
	}

	public boolean checkIfUserExist(String userName) {
		
		for (Student student : idAndStudents.values()) {
			
			if (student.getUserName().equals(userName)) {
				return true;
			}
		}
		
		return false;
	}

	// Getters and Setters
	
	public HashMap<Long, Student> getIdAndStudents() {
		return idAndStudents;
	}

	public void setNewStudent(Student student) {
		this.idAndStudents.put(this.getNextID(), student);
	}

	public University getUniversity() {
		return university;
	}

	public static void setLastID(long lastID) {
		StudentsDB.lastID = lastID;
	}
}
