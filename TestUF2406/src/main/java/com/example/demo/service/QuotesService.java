package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Quote;
import com.example.demo.repository.QuotesRepository;
import com.example.demo.utilities.IOTools;

@Service
public class QuotesService {

	@Autowired
	QuotesRepository repository;
	
	public Iterable<Quote> findAll() {
		return repository.findAll();
	}
	
	public Quote addQuote(Quote quote) {
		quote.setNumberWords(IOTools.wordsInSentence(quote.getSentence()));
		return repository.save(quote);
	}
}