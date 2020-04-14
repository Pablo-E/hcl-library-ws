package com.hcl.library.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "loan")
public class Loan {

	@Id
	@Column(name = "id_loan")
	private int idLoan;

	@OneToOne
	@JoinColumn(name = "staff")
	private User staff;

	@OneToOne
	@JoinColumn(name = "client")
	private User client;

	@OneToOne
	@JoinColumn(name = "book")
	private Book book;

	@Column(name = "status")
	private boolean status;

	@Column(name = "loan_date")
	private Date loanDate;
	
	@Column(name = "return_date")
	private Date returnDate;

	public Loan(User staff, User client, Book book) {
		this.staff = staff;
		this.client = client;
		this.book = book;
		this.loanDate = new Date();
	}
	
	public Loan() {}
}
