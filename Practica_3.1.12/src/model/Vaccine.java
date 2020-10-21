package model;

import java.time.LocalDate;

public class Vaccine {

	private final LocalDate date;
	private String name;
	private boolean sideEffects;
	
	public Vaccine(String name) {
		
		this.date = LocalDate.now();
		this.name = name;
		this.sideEffects = false;
	}
	
	// Getters and Setters
	
	public boolean isSideEffects() {
		return sideEffects;
	}

	public void setSideEffects() {
		this.sideEffects = true;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getName() {
		return name;
	}
}
