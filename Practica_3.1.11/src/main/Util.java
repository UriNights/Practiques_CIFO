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
		
		// Month checking
		
		if (splitedDate[1] < 1 || 12 < splitedDate[1]) {
			System.out.println("Number of month has to be between 1 - 12.");
			return false;
		}
		
		
		// Day checking
		
		if (Util.isLeapYear(splitedDate[2]) && splitedDate[1] == 2 && 29 == splitedDate[0]) {
			return true;
		}
		
		if (splitedDate[0] < 1 || Date.daysForMonth[splitedDate[1] - 1] < splitedDate[0]) {
			System.out.println("You put a invalid day for this month.");
			return false;
		}
		
		
		// Minimum date
		
		if (splitedDate[2] < Util.getMinimumDate().getYear()) {
			System.out.println("You should introduce a date after 1/1/1978.");
			return false;
		}
		
		if (splitedDate[2] == Util.getMinimumDate().getYear() && splitedDate[1] < Util.getMinimumDate().getMonth()) {
			System.out.println("You should introduce a date after 1/1/1978.");
			return false;
		}
		
		if (splitedDate[2] == Util.getMinimumDate().getYear() && splitedDate[1] == Util.getMinimumDate().getMonth() && splitedDate[0] <= Util.getMinimumDate().getDay()) {
			System.out.println("You should introduce a date after 1/1/1978.");
			return false;
		}
		
		return true;
	}
}
