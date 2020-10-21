package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Person extends SuperBeing{
	
	private final String surname;
	private Pet pet;

	public Person(String name, String surname, LocalDate birthday, int heightInCm, float weight) {
		
		super(name, birthday, heightInCm, weight);
		
		this.surname = surname;
	}
	
	public Person(String name, String surname, LocalDate birthday, int heightInCm, float weight, Pet pet) {
		this(name, surname, birthday, heightInCm, weight);
		
		this.pet = pet;
	}

	public boolean isAdult(LocalDate birthday) {
		return (18 < super.birthday.until(LocalDate.now(), ChronoUnit.YEARS));
	}
	
	//Getters and Setters
	
	public String getSurname() {
		return surname;
	}
	
	public Pet getPet() {
		return pet;
	}
}
