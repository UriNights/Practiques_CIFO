package com.example.demo.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "BOOK")
@Getter @Setter public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Basic(optional = false)
	@Column(name = "TITLE", nullable = false, length = 50)
	private String title;
	
	@OneToMany(cascade = CascadeType.DETACH, mappedBy = "book")
	private List<Quote> quotes;

	Book() {
	}

	public Book(Long id, String name) {
		this.id = id;
		this.title = name;
	}

	public Book(String name) {
		this.title = name;
	}

	@Override
	public String toString() {
		return "Book{" + "id=" + id + ", name='" + title + '\'' + ", quotes=" + quotes + '}';
	}
}
