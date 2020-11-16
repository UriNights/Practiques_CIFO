package controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Book;
import repository.BookRepository;
import repository.QuoteRepository;
import view.FrontController;

public class Controller {

	private Scanner reader;
	private FrontController frontController;

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	private BookRepository bookRepository;
	private QuoteRepository quoteRepository;

	public Controller() {

		this.reader = new Scanner(System.in);
		this.frontController = new FrontController(reader);

		this.entityManagerFactory = Persistence.createEntityManagerFactory("H2local");
		this.entityManager = entityManagerFactory.createEntityManager();

		this.bookRepository = new BookRepository(this.entityManager);
		this.quoteRepository = new QuoteRepository(this.entityManager);
	}

	public void start() {

		this.frontController.wellcome();

		while (true) {
			
			switch (this.frontController.mainMenu()) {

				// Add book
				case 1:
					this.addBook(this.frontController.newBook());
					break;
	
				// Add quote
				case 2:
					break;
	
				// Delete book
				case 3:
					break;
	
				// Delete quote
				case 4:
					break;
	
				// List all books with quotes
				case 5:
					break;
	
				default:
					break;

			}
		}
	}

	
	// Repository actions

	private void addBook(Book book) {

		bookRepository.save(book);
	}
}
