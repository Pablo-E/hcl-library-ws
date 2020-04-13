package com.hcl.library.dao.generics;

import com.hcl.library.model.Book;

public interface IBookDao extends IGenericDao<Book> {
	
	public Book findById(String isbn);

}
