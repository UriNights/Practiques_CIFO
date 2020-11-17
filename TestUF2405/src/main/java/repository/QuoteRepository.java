package repository;

import org.springframework.stereotype.Repository;

import model.Book;
import model.Quote;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

public class QuoteRepository {

	private EntityManager entityManager;

	public QuoteRepository(EntityManager entityManager) {

		this.entityManager = entityManager;
	}

	public List<Quote> findAll(Book book) {
		
		if(book != null) {
			return entityManager.createQuery("from Quote where fk_book = " + book.getId()).getResultList();
		}
		
		return null;
	}

	public Optional<Quote> save(Quote quote) {

		try {
			entityManager.getTransaction().begin();
			entityManager.persist(quote);
			entityManager.getTransaction().commit();

			return Optional.of(quote);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return Optional.empty();
	}

	public Optional<Quote> remove(Quote quote) {

		if (quote != null) {

			try {

				entityManager.getTransaction().begin();
				entityManager.remove(quote);
				entityManager.getTransaction().commit();

				return Optional.of(quote);

			} catch (Exception e) {
				e.printStackTrace();
			}

			return Optional.empty();
		}
		
		return null;
	}
}