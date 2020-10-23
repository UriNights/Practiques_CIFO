package services;

import java.util.ArrayList;

import model.Author;

public class AuthorsDB {

	private ArrayList<Author> authorsList;
	
	public AuthorsDB() {
		this.authorsList = new ArrayList<>();
	}
	
	public ArrayList<Author> getAuthorsList() {
		return authorsList;
	}

	public void addAuthor(Author author) {
		this.authorsList.add(author);
	}
	
	public Author getAuthorByPosition(int position) {
		if (0 <= position && position < this.authorsList.size()) {
			return this.authorsList.get(position);
		}
		
		return null;
	}
	
	public void printAll() {
		for (Author author : this.authorsList) {
			System.out.println(author);
		}
	}
}
