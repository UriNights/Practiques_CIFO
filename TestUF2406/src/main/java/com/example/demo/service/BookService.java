package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository repository;
	
	public Iterable<Book> findAll() {
		return repository.findAll();
	}
	
	public Book addBook(Book book) {
		return repository.save(book);
	}
}