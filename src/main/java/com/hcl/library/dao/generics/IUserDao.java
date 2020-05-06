package com.hcl.library.dao.generics;

import java.util.List;

import com.hcl.library.model.Loan;
import com.hcl.library.model.User;

public interface IUserDao extends IGenericDao <User> {
	
	public User findById(int id);
	
	public List<User> findAllClients();
	
	public List<Loan> loans(User u);

}
