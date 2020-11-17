package controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Book;
import model.Quote;
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
		
		Book book;
		while (true) {
			
			switch (this.frontController.mainMenu()) {

				// Add book
				case 1:
					this.addBook(this.frontController.newBook());
					break;
	
				// Add quote
				case 2:
					this.addQuote(new Quote(this.frontController.askForQuote(),
							this.frontController.selectBook(this.bookRepository.findAll())));
					break;
	
				// Delete book
				case 3:
					this.removeBook(
							this.frontController.selectBook(
									this.bookRepository.findAll()));
					break;
	
				// Delete quote
				case 4:
					book = this.frontController.selectBook(
							this.bookRepository.findAll());
					
					
					this.removeQuote(this.frontController.selectQuote(this.quoteRepository.findAll(book)));
					break;
	
				// List all books with quotes
				case 5:
					book = this.frontController.selectBook(
							this.bookRepository.findAll());
					
					if (book != null) {
						this.frontController.printList(this.quoteRepository.findAll(book));
					}
					break;

				// Exit
				case 6:
					this.entityManager.close();
					System.exit(0);
				default:
					break;
			}
		}
	}

	
	// Repository actions
	private void addBook(Book book) {

		this.bookRepository.save(book);
	}

	private void removeBook(Book book) {

		this.bookRepository.remove(book);
	}
	
	private void addQuote(Quote quote) {

		this.quoteRepository.save(quote);
	}
	
	private void removeQuote(Quote quote) {

		this.quoteRepository.remove(quote);
	}
}
