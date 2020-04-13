package com.hcl.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "author")
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_author")
	private int idAuthor;
	
	@Column(name = "name_author")
	private String nameAuthor;
	
	@Column(name = "last_name_author")
	private String lastNameAuthor;
	
	@Column(name = "nationality")
	private String nationality;

}
