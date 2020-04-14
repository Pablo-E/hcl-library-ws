package com.hcl.library.app.ws.ui.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookRequestModel {
	
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
