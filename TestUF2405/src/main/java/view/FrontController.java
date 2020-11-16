package view;

import java.util.Scanner;

import model.Book;
import utilities.IOFilter;

public class FrontController {
	
	private Scanner reader;
	
	public FrontController(Scanner reader) {
		this.reader = reader;
	}

	public void wellcome() {

		System.out.println("\n\t*** Wellcome to our Books library! ***\n\n");
	}

	public int mainMenu() {

		System.out.print("Take an option to continue:\n"
				+ "1) Add book\n"
				+ "2) Add quote\n"
				+ "3) Delete book\n"
				+ "4) Delete quote\n"
				+ "5) List books with their quotes\n"
				+ ">> ");
		
		while (true) {
			
			int input = IOFilter.checkInputForInt(reader.nextLine());	// Return -1 if input is not an integer
			
			if (1 <= input && input <= 5) {
				return input;
			}
			
			System.out.print("Please, enter a valid option.\n"
					+ ">> ");
		}
	}
	
	
	// Options to do

	public Book newBook() {
		
			System.out.println("\nLet's add a new book.");
			
			return new Book(this.askForTitle(), this.askForAuthor());
	}
	
	private String askForTitle() {
		
		String title = "";
		
		while(title.isBlank()) {
			
			System.out.print("Enter a title: ");
			title = reader.nextLine();
		}
		
		return title;
	}
	
	private String askForAuthor() {
		
		String author = "";
		
		while(author.isBlank()) {
			
			System.out.print("Enter the author: ");
			author = reader.nextLine();
		}
		
		return author;
	}
}