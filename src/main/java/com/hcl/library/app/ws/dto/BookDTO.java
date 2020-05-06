package com.hcl.library.app.ws.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {
	
	private String isbn;
	private String title;
	private int pages;
	private String publisher;
	private String genre;
	private int stock;
	
	private String nameAuthor;
	private String lastNameAuthor;
	private String nationality;

}
