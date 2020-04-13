package com.hcl.library.dao.generics;

import com.hcl.library.model.Loan;

public interface ILoanDao extends IGenericDao <Loan> {
	
	public Loan findById(int id);

}
