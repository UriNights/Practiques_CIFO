package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Quote;

public interface QuotesRepository extends CrudRepository<Quote, Long> {

}
