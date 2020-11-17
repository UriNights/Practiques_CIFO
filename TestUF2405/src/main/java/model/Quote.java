package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import utilities.IOFilter;
import view.Printable;

@Entity
@Table(name = "QUOTES")

@Getter @Setter public class Quote implements Printable {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "SENTENCE", length = 50, nullable = false)
	private String sentence;
	
	@Column(name = "WORDS_NUMBER", nullable = false)
	private int numberWords;
	
    @ManyToOne
    @JoinColumn(name = "FK_BOOK", nullable = false, updatable = false)
	private Book book;

	protected Quote() {
	}

	public Quote(String sentence, Book book) {
		
		this.sentence = sentence;
		this.numberWords = IOFilter.numberOfWords(sentence);
		this.book = book;
	}

	@Override
	public String toString() {
		
		return "Quote [id=" + this.id + ", sentence=" + this.sentence + ", numberWords=" + this.numberWords + ", book=" + this.book + "]";
	}

	@Override
	public String toPrint() {

		return this.sentence;
	}
}