package com.hcl.library.dao;

import java.util.List;

import com.hcl.library.dao.generics.IAuthorDao;
import com.hcl.library.model.Author;

public class ImplAuthorDao implements IAuthorDao {

	@Override
	public void add(Author t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Author t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Author t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Author> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Author findById(int id) {
		Author findedAuthor;
		try {
			em.getTransaction().begin();
			findedAuthor = em.find(Author.class, id);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw (e);
		}
		return findedAuthor;
	}
	
}
