package com.hcl.library.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.hcl.library.dao.generics.IBookDao;
import com.hcl.library.model.Book;

public class ImplBookDao implements IBookDao {
	
	EntityManager em;
	
	@Override
	public void add(Book b) {
		// setting isbn
		if (b.getIsbn() == null) {
			StringBuilder isbn = new StringBuilder();
			isbn.append(b.getTitle().trim().toUpperCase().substring(0, 4))
					.append((int) (Math.floor(Math.random() * (9998 - 999 + 1) + 999)));
			b.setIsbn(isbn.toString());
		}

		try {
			em = openConnection();
			em.getTransaction().begin();
			em.persist(b);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw (e);
		} finally {
			em.close();
		} 
	}

	@Override
	public void remove(Book b) {
		try {
			em = openConnection();
			em.getTransaction().begin();
			em.remove(b);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw (e);
		} finally {
			em.close();
		}
		
	}

	@Override
	public void update(Book b) {
		try {
			em = openConnection();
			em.getTransaction().begin();
			em.merge(b);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw (e);
		} finally {
			em.close();
		}
		
	}

	@Override
	public Book findById(String isbn) {
		Book findedBook;
		try {
			em = openConnection();
			em.getTransaction().begin();
			findedBook = em.find(Book.class, isbn);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw (e);
		} finally {
			em.close();
		}
		
		return findedBook;
	}

	@Override
	public List<Book> findAll() {
		
		List<Book> bookList;

		try {
			em = openConnection();
			em.getTransaction().begin();
			bookList = em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw (e);
		} finally {
			em.close();
		}

		return bookList;
	}

	@Override
	public EntityManager openConnection() {
		if (em == null) {
			em = emf.createEntityManager();
			return em;
		}else {
			return em;			
		}
	}
}
