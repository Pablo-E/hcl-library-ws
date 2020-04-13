package com.hcl.library.dao.generics;

import com.hcl.library.model.Author;

public interface IAuthorDao extends IGenericDao<Author> {
	
	public Author findById(int id);

}
