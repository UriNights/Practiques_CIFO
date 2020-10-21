package model;

import java.time.LocalDate;

import service.StudentsDB;
import service.UsersManager;

public class Student extends Person {
	
	private StudentsDB studentsDB;
	
	private final long ID;
	private String userName;
	private String password;

	public Student(String name, String surname, LocalDate birthday, int heightInCm, float weight, StudentsDB studentsDB) {
		super(name, surname, birthday, heightInCm, weight);
		
		this.studentsDB = studentsDB;
		
		ID = UsersManager.createID(this.studentsDB);
		userName = UsersManager.createUser(this.studentsDB, name, surname);
		password = UsersManager.createPassword();
	}

	// Getters and Setters	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getID() {
		return ID;
	}
}
