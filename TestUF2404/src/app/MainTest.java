package app;

import java.util.ArrayList;
import java.util.Scanner;

import model.*;
import services.AuthorsDB;
import view.UserInterface;

public class MainTest {

	private static Scanner reader;
	private static UserInterface userInterface;
	private static AuthorsDB authorsDB;
	
	public static void main(String[] args) {

		reader = new Scanner(System.in);
		userInterface = new UserInterface(reader);
		authorsDB = new AuthorsDB();

		MainTest.start();
		MainTest.assign(1);
		MainTest.assign();
		
		System.out.println("\nSee you in the sky!");
		System.exit(0);
	}

	public static void start() {

		authorsDB.addAuthor(new Author("Antoni", "antoni@gmail.com", 'm'));
		authorsDB.getAuthorByPosition(0).addBook(new Book("Un libro cualquiera", 2015, "Editorial Manolo", 15.99));
		authorsDB.getAuthorByPosition(0).addBook(new Book("Una persona por la calle", 1999, "Editorial Street", 10.99));
		authorsDB.getAuthorByPosition(0).addBook(new Book("El barco pirata", 2002, "Editorial Barcos", 25.0));
		
		authorsDB.addAuthor(new Author("Nuria", "nuria@gmail.com", 'f'));
		authorsDB.addAuthor(new Author("Pep", "pep@gmail.com", 'm'));
	}

	public static ArrayList<Book> createBook() {
		
		ArrayList<Book> booksList = new ArrayList<>();
		
		while(userInterface.askForAnotherBook()) {
			Book book = userInterface.askForBook();
			booksList.add(book);
		}
		
		return booksList;
	}

	public static void assign(int authorPosition) {
		
		ArrayList<Book> booksList = createBook();
		authorsDB.getAuthorByPosition(authorPosition).addBooks(booksList);
	}
	
	public static void assign() {

		ArrayList<Book> booksList = createBook();
		authorsDB.getAuthorByPosition(userInterface.askForAuthorPosition(authorsDB)).addBooks(booksList);
	}
}
