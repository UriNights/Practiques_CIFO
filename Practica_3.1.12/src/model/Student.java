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
	
	public String toString() {
		return "ID -> " + this.ID + " // Name: " + super.getName() + " " + super.getSurname();
	}
}

/*Calcular la seva nota d’entrada a la universitat (mínim cinc assignatures més examen d’entrada a la universitat):
Crear un ArrayList d’assignatures amb les notes finals per assignatura.
També una nota d’examen d’entrada.
Nota de tall (es supera o no).
Ponderar les notes d’assignatures (40%) amb la d’examen d’entrada (60%).
Que es pugui treballar el ArrayList.
*/
