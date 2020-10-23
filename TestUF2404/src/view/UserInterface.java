package view;

import java.util.Scanner;

import model.*;
import services.AuthorsDB;

public class UserInterface {

	private Scanner reader;

	public UserInterface(Scanner reader) {
		this.reader = reader;
	}

	public boolean askForAnotherBook() {
		System.out.print("\nLet's create a book? (y/n) ");

		char answer;
		while (true) {
			answer = this.reader.nextLine().charAt(0);

			if (answer == 'y') {
				return true;
			}

			if (answer == 'n') {
				return false;
			}

			System.out.print("Please, enter a valid answer: (y/n) ");
		}
	}

	public Book askForBook() {
		System.out.print("What's the title? ");
		String title = this.reader.nextLine();

		int year = this.askForYear();

		System.out.print("Which was the publisher? ");
		String publisher = this.reader.nextLine();

		double cost = this.askForPrice();

		return new Book(title, year, publisher, cost);
	}

	private int askForYear() {
		System.out.print("What year was it published? ");

		String stringYear;
		while (true) {
			stringYear = this.reader.nextLine();

			if (stringYear.matches("[0-9]+")) {
				return Integer.valueOf(stringYear);
			}
			System.out.print("Bad input, you shuld enter an integer number: ");
		}
	}

	private double askForPrice() {
		System.out.print("How much it costs? ");

		String stringCost;
		while (true) {
			stringCost = reader.nextLine();

			if (stringCost.matches("[0-9]+(.[0-9]*)?")) {

				// Return only two decimals
				return Math.round(Double.valueOf(stringCost) * 100.0) / 100.0;

			}
			System.out.print("You should enter a positive integer or float number: ");
		}
	}

	public Author askForAuthor() {
		System.out.print("\nWhich is the author name? ");
		String name = this.reader.nextLine();

		System.out.print("What's the author e-mail? ");
		String email = this.reader.nextLine();

		char gender = this.askForGender();

		return new Author(name, email, gender);
	}

	private char askForGender() {
		System.out.print("Which is him/her gender? (m/f) ");

		char gender;
		while (true) {
			gender = this.reader.nextLine().charAt(0);

			if (gender == 'm' || gender == 'f') {
				return gender;
			}

			System.out.print("Please, enter a gender: (m/f) ");
		}
	}

	public int askForAuthorPosition(AuthorsDB authorsDB) {
		System.out.print("\nWhich number of author you want to assign this book/s? ");

		while (true) {
			String auxNumberOfAuthor = reader.nextLine();

			if (auxNumberOfAuthor.matches("[0-9]+")) {
				int numberOfAuthor = Integer.valueOf(auxNumberOfAuthor);

				if (0 <= numberOfAuthor && numberOfAuthor < authorsDB.getAuthorsList().size()) {
					return numberOfAuthor;
				}
			}

			System.out.print("Please, enter a number between 0 and " + (authorsDB.getAuthorsList().size() - 1)
					+ " (both included): ");
		}
	}
}