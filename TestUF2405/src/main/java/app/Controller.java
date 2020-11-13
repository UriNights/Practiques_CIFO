package app;

import java.util.Optional;
import java.util.Scanner;

import javax.persistence.EntityManager;

public class Controller {
	
	private BookRepository bookRepository;
	private QuoteRepository quoteRepository;
	
	private Scanner reader;
	
	public Controller(Scanner reader, EntityManager entityManager) {
		
		this.reader = reader;
		
		this.bookRepository = new BookRepository(entityManager);
		//this.quoteRepository = new QuoteRepository(entityManager);
	}

	public void addBook() {

		bookRepository.save(new Book("hola", "hola"));
	}
}
