package com.hcl.library.dao;

import java.util.List;

import com.hcl.library.dao.generics.IUserDao;
import com.hcl.library.model.Loan;
import com.hcl.library.model.User;

public class ImplUserDao implements IUserDao {

	@Override
	public void add(User u) {
		try {
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw (e);
		}
	}

	@Override
	public void remove(User u) {
		try {
			em.getTransaction().begin();
			em.remove(u);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw (e);
		}
	}

	@Override
	public void update(User u) {
		try {
			em.getTransaction().begin();
			em.merge(u);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw (e);
		}
	}

	@Override
	public User findById(int id) {
		User findedPerson = new User();
		try {
			em.getTransaction().begin();
			findedPerson = em.find(User.class, id);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw (e);
		}

		return findedPerson;
	}

	@Override
	public List<User> findAll() {

		List<User> userList;

		try {
			em.getTransaction().begin();
			userList = em.createQuery("SELECT u FROM User u", User.class).getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw (e);
		}
		return userList;
	}

	@Override
	public List<Loan> loans(User u) {

		List<Loan> loans;

		try {
			em.getTransaction().begin();
			loans = em.createQuery("SELECT l FROM Loan l WHERE l.client =  :client", Loan.class)
					.setParameter("client", u)
					.getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw (e);
		}
		for (Loan loan : loans) {
			System.out.println(loan);
		}
		return loans;

	}
}
