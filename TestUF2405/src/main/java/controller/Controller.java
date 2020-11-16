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

	
	// ***************  Gestionar optional quan es guarda i s'esborra de la BBDD
	
	// el find all de les quotes respecte els books està per fer
	
	// pq es deixa un constructor base sense paràmetres?
	
	/* quan funcioni tot
	 
	 		int input;
		while (true) {
			
			input = IOFilter.checkInputForInt(reader.nextLine());	// Return -1 if input is not an integer
			
			if (1 <= input && input <= allQuotes.size()) {
				return allQuotes.get(input - 1);
			}
			
			System.out.print("Please, enter a valid option.\n"
					+ ">> ");
		}
		
		Això es pot convertir en un sol metod de la clase front controller IOFilter.isValidOption(int minim option, int max option) retorna un int
	 */
	
	
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
					this.addQuote(
							this.frontController.selectBook(
									this.bookRepository.findAll()), this.frontController.askForQuote());
					break;
	
				// Delete book
				case 3:
					this.removeBook(
							this.frontController.selectBook(
									this.bookRepository.findAll()));
					break;
	
				// Delete quote
				case 4:
					Book book = this.frontController.selectBook(
									this.bookRepository.findAll());
					
					this.removeQuote(book, this.frontController.selectQuote(this.quoteRepository.findAll(book)));
					break;
	
				// List all books with quotes
				case 5:
					this.frontController.printList(this.bookRepository.findAll());
					break;
	
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
	
	private void addQuote(Book book, String quote) {

		this.quoteRepository.save(book, quote);
	}
	
	private void removeQuote(Book book, Quote quote) {

		this.quoteRepository.remove(book, quote);
	}
}
