package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import view.Printable;

@Entity
@Table(name = "BOOK")
@NamedQueries({ @NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title = :title"),
@NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b") })

@Getter @Setter public class Book implements Printable {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "TITLE", length = 25, nullable = false)
	private String title;
	
	@Column(name = "AUTHOR", length = 14, nullable = false)
	private String author;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Quote> quotes;

	Book() {
	}

	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	@Override
	public String toString() {

		return "Book{" + "id=" + this.id + ", name='" + this.title + '\'' + ", author=" + this.author + '}';
	}

	@Override
	public String toPrint() {

		return this.title;
	}
}
