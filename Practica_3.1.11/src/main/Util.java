package main;

public class Util {
	
	private static final Date minimumDate = new Date(1, 1, 1978);
	
	public static Date getMinimumDate() {
		
		return minimumDate;
	}
	
	public static boolean isLeapYear(int year) {
		
		return (year % 4 == 0 || year % 100 == 0 && year % 400 == 0) ? true : false; 
	}
	
	public static boolean checkDate(int[] splitedDate) {
		
		if (splitedDate[2] < Util.getMinimumDate().getYear()) {
			System.out.println("You should introduce a date after 1/1/1987.");
			return false;
		}
		
		
		// Month cheking
		
		if (splitedDate[1] < 1 || 12 < splitedDate[1]) {
			System.out.println("Number of month has to be between 1 - 12.");
			return false;
		}
		
		if (splitedDate[1] < Util.getMinimumDate().getMonth()) {
			System.out.println("You should introduce a date after 1/1/1987.");
			return false;
		}
		
		
		// Day checking
		
		if (Util.isLeapYear(splitedDate[2]) && splitedDate[1] == 2 && splitedDate[0] < 0 || 29 < splitedDate[0]) {
			System.out.println("Introduced a leap year, this month has to be between 1 - 29.");
			return false;
		}

		if (Date.daysForMonth[splitedDate[1]] < splitedDate[0]) {
			System.out.println("The day for this month has to be between 1 - " + Date.daysForMonth[splitedDate[1]] + ".");
			return false;
		}
		
		if (splitedDate[0] <= Util.getMinimumDate().getDay()) {
			System.out.println("You should introduce a date after 1/1/1987.");
			return false;
		}
		
		return true;
	}
}
