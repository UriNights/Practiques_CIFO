package main;

public class Date {

	public static final int[] daysForMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final String[] nameOfDay = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

	private int day, month, year;

	public Date(int day, int month, int year) {

		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int totalDays() {

		int totalDays = 0;

		if (Util.getMinimumDate().getYear() <= this.year) {

			for (int i = Util.getMinimumDate().getYear(); i < this.year; i++) {
				totalDays += (Util.isLeapYear(i)) ? 366 : 365;
			}
		}
//----------------------****
		if (Util.getMinimumDate().getMonth() <= this.month) {
			for (int i = Util.getMinimumDate().getMonth(); i < this.month; i++) {
				
				if (i == 2 && Util.isLeapYear(this.year)) {
					totalDays += 29;
					continue;
				}
				
				totalDays += Date.daysForMonth[i];
			}
		} else if (this.month < Util.getMinimumDate().getMonth()) {

			for (int i = this.month; i < Util.getMinimumDate().getMonth(); i++) {
				
				if (i == 2 && Util.isLeapYear(this.year)) {
					totalDays -= 29;
					continue;
				}
				
				totalDays -= Date.daysForMonth[i];
			}
		}
		
		totalDays += this.day - Util.getMinimumDate().getDay();

		return totalDays;
	}
	
	public String dayName(int numberOfDays) {		// Counting from 1/1/1978 which is Sunday
		return Date.nameOfDay[numberOfDays%7];
	}
	

	// Getters and Setters

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}
}
