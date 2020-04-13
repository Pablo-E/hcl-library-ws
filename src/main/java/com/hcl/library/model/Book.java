package com.hcl.library.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "book")
public class Book {

	@Id
	@Column(name = "isbn")
	private String isbn;
	
	@Column(name = "title")
	private String title;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "author")
	private Author author;

	@Column(name = "pages")
	private int pages;

	@Column(name = "publisher")
	private String publisher;
	
	@Column(name = "genre")
	private String genre;
	
	@Column(name = "stock")
	private int stock;

}
