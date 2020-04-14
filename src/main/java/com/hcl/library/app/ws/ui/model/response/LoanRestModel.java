package com.hcl.library.app.ws.ui.model.response;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoanRestModel {

	private int idLoan;
	private Date loanDate;
	private String clietName;
	private String staffName;
	
	
	
}
