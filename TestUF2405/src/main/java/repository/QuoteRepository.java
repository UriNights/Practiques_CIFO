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
		return entityManager.createQuery("from Quote").getResultList();
	}

	public Optional<Quote> save(Book book, String quote) {
		
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

	public void remove(Book book, Quote quote) {
		// TODO Auto-generated method stub
		
	}
}