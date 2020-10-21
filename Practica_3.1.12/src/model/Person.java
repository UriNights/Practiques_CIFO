package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Person {

	private final String name;
	private final String surname;
	
	private boolean isAdult;
	private final LocalDate birthday;

	private int heightInCm;
	private float weight;
	
	public Person(String name, String surname, LocalDate birthday, int heightInCm, float weight) {
		
		this.name = name;
		this.surname = surname;
		
		isAdult = this.isAdult(birthday);
		this.birthday = birthday;
		
		this.heightInCm = heightInCm;
		this.weight = weight;
	}
	
	//---
	
	private boolean isAdult(LocalDate birthday) {
		return (18 < this.birthday.until(LocalDate.now(), ChronoUnit.YEARS));
	}
	
	public float bodyMassIndex() {
		return (float) (this.weight / Math.pow(this.heightInCm, 2));
	}

	//Getters and Setters	
	
	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public boolean isAdult() {
		return isAdult;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public int getHeightInCm() {
		return heightInCm;
	}

	public float getWeight() {
		return weight;
	}
	
	
}
