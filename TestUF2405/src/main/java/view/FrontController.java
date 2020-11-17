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

		System.out.println("\n\t*** Wellcome to our Books library! ***");
	}

	public int mainMenu() {

		System.out.print("\nTake an option to continue:\n"
				+ "1) Add book\n"
				+ "2) Add quote\n"
				+ "3) Delete book\n"
				+ "4) Delete quote\n"
				+ "5) List books with their quotes\n"
				+ "6) Exit\n");
		
		return this.getOptionBetween(1, 6);
	}
	
	private int getOptionBetween(int minOption, int maxOption) {
		
		int input;
		while (true) {
			
			System.out.print(">> ");
			input = IOFilter.checkInputForInt(reader.nextLine());	// Return -1 if input is not an integer
			
			if (minOption <= input && input <= maxOption) {
				return input;
			}
			
			System.out.print("Please, enter a valid option.\n");
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

		if (allObjects == null || allObjects.isEmpty()) {
			System.out.println("\nSelection is empty.");
			return;
		}
		
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
		
		if (allBooks.isEmpty()) {
			System.out.println("\nSelection is empty.");
			return null;
		}
		
		System.out.println("\nSelect a book from the list: ");
		this.printList(allBooks);
		
		return allBooks.get(this.getOptionBetween(1, allBooks.size()) - 1);
	}

	
	// Quote
	public String askForQuote() {

		return this.askForString("\nEnter a new quote: ");
	}

	public Quote selectQuote(List<Quote> allQuotes) {

		if (allQuotes.isEmpty()) {
			System.out.println("\nSelection is empty.");
			return null;
		}
		
		System.out.println("\nSelect a quote from the list: ");
		this.printList(allQuotes);
		
		return allQuotes.get(this.getOptionBetween(1, allQuotes.size()) - 1);
	}
}