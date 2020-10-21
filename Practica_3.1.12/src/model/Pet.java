package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import utils.RandomRequest;

public class Pet extends SuperBeing {
	
	private static enum KindOfPets {
		
		DOG("Dog", 1000),
		CAT("Cat", 600),
		BIRD("Bird", 200),
		RAT("Rat", 50);
		
		private static final int numberOfKinds = 4;
		
		//---
		
		private final String kind;
		private final int monthlyExpenses;

		KindOfPets(String kind, int monthlyExpenses) {
			this.kind = kind;
			this.monthlyExpenses = monthlyExpenses;
		}
		
		public static KindOfPets getPet() {
			return values()[RandomRequest.getIntFromZeroTo(numberOfKinds)];
		}
		
		public String getKind() {
			return this.kind;
		}
		
		public int getMonthlyExpenses() {
			return this.monthlyExpenses;
		}
	}
	
	//--- Start Pet class
	
	private KindOfPets kindOfPet;
	private ArrayList<Vaccine> vaccinationCard;

	public Pet(String name, LocalDate birthday, int heightInCm, float weight) {
		super(name, birthday, heightInCm, weight);

		this.kindOfPet = KindOfPets.getPet();
		this.vaccinationCard = new ArrayList<>();
	}
	
	public boolean isAdult(LocalDate birthday) {
		return (1 < super.birthday.until(LocalDate.now(), ChronoUnit.YEARS));
	}
	
	public void setVaccine(Vaccine newVaccine) {
		this.vaccinationCard.add(newVaccine);
	}
}