package main;

import java.util.Scanner;
import java.util.stream.Stream;

public class View {

	private Scanner scan;
	
	public View(Scanner scan) {
		this.scan = scan;
	}
	
	public Date askForDate() {
		
		while (true) {
			
			System.out.println("Introduce a date to know the day name (dd/mm/yyyy): ");
			String dateString = scan.nextLine();
			
			int[] splitedDate;
			
			if (dateString.matches("([0-9]{2}/){2}[0-9]+")) {
				splitedDate = Stream.of(dateString.split("/")).mapToInt(i -> Integer.valueOf(i)).toArray();
			} else {
				System.out.println("You've typed a wrong format for the given date.");
				continue;
			}
			
			if (Util.checkDate(splitedDate)) {
				return new Date(splitedDate[0], splitedDate[1], splitedDate[2]);
			}
		}
	}

	public void giveDayName(Date dateFromUser) {
		
		System.out.println("" + dateFromUser.dayName(dateFromUser.totalDays()));
	}
}
