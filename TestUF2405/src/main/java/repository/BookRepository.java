package repository;

import javax.persistence.EntityManager;

import model.Book;

import java.util.List;
import java.util.Optional;

public class BookRepository {

	private EntityManager entityManager;

	public BookRepository(EntityManager entityManager) {

		this.entityManager = entityManager;
	}

	public List<Book> findAll() {

		return entityManager.createQuery("from Book").getResultList();
	}

	public Optional<Book> findByTitle(String title) {

		Book book = entityManager.createQuery("SELECT b FROM Book b WHERE b.title = :title", Book.class)
				.setParameter("title", title).getSingleResult();

		return book != null ? Optional.of(book) : Optional.empty();
	}

	public Optional<Book> save(Book book) {

		try {

			entityManager.getTransaction().begin();
			entityManager.persist(book);
			entityManager.getTransaction().commit();

			return Optional.of(book);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return Optional.empty();
	}

	public Optional<Book> remove(Book book) {

		if (book != null) {

			try {

				entityManager.getTransaction().begin();
				entityManager.remove(book);
				entityManager.getTransaction().commit();

				return Optional.of(book);

			} catch (Exception e) {
				e.printStackTrace();
			}

			return Optional.empty();
		}

		return null;
	}
}