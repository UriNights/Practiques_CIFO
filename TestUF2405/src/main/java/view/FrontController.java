package view;

import java.util.List;
import java.util.Scanner;

import model.Book;
import model.Quote;
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
		
		int input;
		while (true) {
			
			input = IOFilter.checkInputForInt(reader.nextLine());	// Return -1 if input is not an integer
			
			if (1 <= input && input <= 5) {
				return input;
			}
			
			System.out.print("Please, enter a valid option.\n"
					+ ">> ");
		}
	}
	
	private String askForString(String question) {

		String string = "";
		
		while(string.isBlank()) {
			
			System.out.print(question);
			string = reader.nextLine();
		}
		
		return string;
	}
	
	public void printList(List<? extends Printable> allObjects) {

		for (int i = 0; i < allObjects.size(); i++) {
			
			System.out.println((i + 1) + ") " + allObjects.get(i).toPrint());
		}		
	}
	
	// Options to do...
	// Book
	public Book newBook() {
		
			System.out.println("\nLet's add a new book.");
			
			return new Book(this.askForTitle(), this.askForAuthor());
	}
	
	private String askForTitle() {
		
		return this.askForString("Enter a title: ");
	}
	
	private String askForAuthor() {
		
		return this.askForString("Enter the author: ");
	}

	public Book selectBook(List<Book> allBooks) {
		
		System.out.print("\nSelect a book from the list: ");
		
		this.printList(allBooks);
		
		int input;
		while (true) {
			
			input = IOFilter.checkInputForInt(reader.nextLine());	// Return -1 if input is not an integer
			
			if (1 <= input && input <= allBooks.size()) {
				return allBooks.get(input - 1);
			}
			
			System.out.print("Please, enter a valid option.\n"
					+ ">> ");
		}
	}

	
	// Quote
	public String askForQuote() {

		return this.askForString("Enter a new quote: ");
	}

	public Quote selectQuote(List<Quote> allQuotes) {

		System.out.print("\nSelect a quote from the list: ");
		
		this.printList(allQuotes);
		
		int input;
		while (true) {
			
			input = IOFilter.checkInputForInt(reader.nextLine());	// Return -1 if input is not an integer
			
			if (1 <= input && input <= allQuotes.size()) {
				return allQuotes.get(input - 1);
			}
			
			System.out.print("Please, enter a valid option.\n"
					+ ">> ");
		}
	}
}