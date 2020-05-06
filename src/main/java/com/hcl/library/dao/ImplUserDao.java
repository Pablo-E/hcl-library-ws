package com.hcl.library.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.hcl.library.dao.generics.IUserDao;
import com.hcl.library.model.Loan;
import com.hcl.library.model.User;

public class ImplUserDao implements IUserDao {
	
	EntityManager em;
	
	@Override
	public void add(User u) {
		try {
			em = openConnection();
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw (e);
		} finally {
			em.close();
		}

	}

	@Override
	public void remove(User u) {
		try {
			em = openConnection();
			em.getTransaction().begin();
			em.remove(u);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw (e);
		} finally {
			em.close();
		}

	}

	@Override
	public void update(User u) {
		try {
			em = openConnection();
			em.getTransaction().begin();
			em.merge(u);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw (e);
		} finally {
			em.close();
		}

	}

	@Override
	public User findById(int id) {
		
		User findedPerson = new User();
		
		try {
			em = openConnection();
			em.getTransaction().begin();
			findedPerson = em.find(User.class, id);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw (e);
		} finally {
			em.close();
		}


		return findedPerson;
	}

	@Override
	public List<User> findAll() {

		List<User> userList;

		try {
			em = openConnection();
			em.getTransaction().begin();
			userList = em.createQuery("SELECT u FROM User u", User.class).getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw (e);
		} finally {
			em.close();
		}

		return userList;
	}

	@Override
	public List<Loan> loans(User u) {

		List<Loan> loans;

		try {
			em = openConnection();
			em.getTransaction().begin();
			loans = em.createQuery("SELECT l FROM Loan l WHERE l.client =  :client", Loan.class)
					.setParameter("client", u)
					.getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw (e);
		} finally {
			em.close();
		}

		for (Loan loan : loans) {
			System.out.println(loan);
		}
		return loans;

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

	@Override
	public List<User> findAllClients() {
		
		List<User> clientList;

		try {
			em = openConnection();
			em.getTransaction().begin();
			clientList = em.createQuery("SELECT u FROM User u WHERE u.role = 'CLIENT'", User.class).getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw (e);
		} finally {
			em.close();
		}

		return clientList;
	}
}
