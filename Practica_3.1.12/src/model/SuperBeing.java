package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class SuperBeing {

	private final String name;
	
	protected final LocalDate birthday;

	private int heightInCm;
	private float weight;
	
	public SuperBeing(String name, LocalDate birthday, int heightInCm, float weight) {
		
		this.name = name;

		this.birthday = birthday;
		
		this.heightInCm = heightInCm;
		this.weight = weight;
	}
	
	//---
	
	protected abstract boolean isAdult(LocalDate birthday);
	
	public float bodyMassIndex() {
		return (float) (this.weight / Math.pow(this.heightInCm, 2));
	}

	//Getters and Setters	
	
	public String getName() {
		return name;
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
