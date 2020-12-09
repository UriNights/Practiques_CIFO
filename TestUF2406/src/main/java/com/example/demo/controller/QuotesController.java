package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.Quote;
import com.example.demo.service.QuotesService;

@Controller
@RequestMapping("/quotes")
public class QuotesController {

	@Autowired
	QuotesService service;
	
	@RequestMapping("/all")
	public String showBooks (Model model) {
		model.addAttribute("allSentences", service.findAll());
		return "quotes.html";
	}
	
	@RequestMapping(value = "/new_sentence", method = RequestMethod.POST)
	public String insertCreditCard(Quote quote, Model model) {

		service.addQuote(quote);
		
		model.addAttribute("allSentences", service.findAll());
		return "quotes.html";
	}
}