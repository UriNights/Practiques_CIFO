package model;

import java.util.ArrayList;

public class Book {

	private final String title;
	private final ArrayList<Author> authors;
	private final int year;
	private final String publisher;
	private double cost;

	public Book(String title, int year, String publisher, double cost) {
		this.title = title;
		this.authors = new ArrayList<>();
		this.year = year;
		this.publisher = publisher;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Book [title=" + this.title + ", author=" + this.authors + ", year=" + this.year + ", publisher="
				+ this.publisher + ", cost=" + this.cost + "]";
	}

	public String getTitle() {
		return this.title;
	}

	public ArrayList<Author> getAuthors() {
		return this.authors;
	}
	
	public void setAuthor(Author author) {
		this.authors.add(author);
	}

	public int getYear() {
		return this.year;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public double getCost() {
		return this.cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
}
