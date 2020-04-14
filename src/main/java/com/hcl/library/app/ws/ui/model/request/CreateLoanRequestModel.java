package com.hcl.library.app.ws.ui.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateLoanRequestModel {
	
	private int idStaff;
	private int idUser;
	private String isbnBook;

}
