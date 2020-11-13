package app;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainApp {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("library");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		View view = new View();
		Scanner reader = new Scanner(System.in);
		Controller controller = new Controller(reader, entityManager);

		view.wellcome();

		while (true) {

			switch (Integer.parseInt(reader.nextLine())) {

			// Add book
			case 1:
				controller.addBook();
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
}
