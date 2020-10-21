package service;

import java.util.HashMap;

import model.Student;

public class StudentsDB {
	
	private HashMap<Long, Student> idAndStudents;
	private static long lastID;
	
	public StudentsDB() {
		
		this.idAndStudents = new HashMap<>();
		this.lastID = 1;
	}

	public long getLastID() {

		return lastID;
	}
	
	public void incresesLastID() {

		this.lastID++;
	}

	public boolean checkIfUserExist(String userName) {
		
		for (Student student : idAndStudents.values()) {
			
			if (student.getUserName().equals(userName)) {
				return true;
			}
		}
		
		return false;
	}
}
