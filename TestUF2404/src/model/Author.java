package model;

import java.util.ArrayList;

public class Author {

	private final String name;
	private String email;
	private char gender;
	private ArrayList<Book> books;

	public Author(String name, String email, char gender) {
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.books = new ArrayList<>();
	}
	
	public void addBook(Book book) {
		this.books.add(book);
	}
	
	public void addBooks(ArrayList<Book> books) {
		this.books.addAll(books);
	}

	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getGender() {
		return gender;
	}

	public String toString() {

		StringBuilder string = new StringBuilder(this.name + "(" + this.gender + ") at " + this.email);
		string.append(" || Book/s: ");
		
		for (Book book : books) {
			string.append(book.getTitle() + ", ");
		}
		
		return string.toString().substring(0, (string.length() - 2));
	}
}
