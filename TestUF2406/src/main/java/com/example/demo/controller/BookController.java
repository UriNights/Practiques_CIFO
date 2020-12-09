package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookService service;
	
	@RequestMapping("/library")
	public String showBooks (Model model) {
		model.addAttribute("library", service.findAll());
		return "library.html";
	}
	
	@RequestMapping(value = "/new_book", method = RequestMethod.POST)
	public String insertCreditCard(Book book, Model model) {

		service.addBook(book);
		
		model.addAttribute("library", service.findAll());
		return "library.html";
	}
}