package com.example.demo.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.utilities.IOTools;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "QUOTE")
@Getter @Setter public class Quote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Basic(optional = false)
	@Column(name = "TAG", nullable = false, length = 40)
	private String tag;
	
	@Basic(optional = false)
	@Column(name = "SENTENCE", nullable = false, length = 100)
	private String sentence;
	
	@Basic(optional = false)
	@Column(name = "WORDS", nullable = false)
	private int numberWords;
	
    @ManyToOne
    @JoinColumn(name = "BOOK_FK")
	private Book book;

	public Quote() {
	}

	public Quote(int id, String sentence, int numberWords, Book book) {
		this.id = id;
		this.sentence = sentence;
		this.numberWords = IOTools.wordsInSentence(sentence);
		this.book = book;
	}

	@Override
	public String toString() {
		return "Quote [id=" + id + ", sentence=" + sentence + ", numberWords=" + numberWords + ", book=" + book + "]";
	}
}
