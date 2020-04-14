package com.hcl.library.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.hcl.library.dao.generics.ILoanDao;
import com.hcl.library.model.Loan;

public class ImplLoanDao implements ILoanDao {

	EntityManager em;

	@Override
	public void add(Loan l) {
		try {
			em = openConnection();
			em.getTransaction().begin();
			em.persist(l);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw (e);
		} finally {
			em.close();
		}
	}

	@Override
	public void remove(Loan l) {
		try {
			em = openConnection();
			em.getTransaction().begin();
			em.remove(l);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw (e);
		} finally {
			em.close();
		}

	}

	@Override
	public void update(Loan l) {
		try {
			em = openConnection();
			em.getTransaction().begin();
			em.merge(l);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw (e);
		} finally {
			em.close();
		}

	}

	@Override
	public Loan findById(int id) {
		Loan findedLoan;
		try {
			em = openConnection();
			em.getTransaction().begin();
			findedLoan = em.find(Loan.class, id);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw (e);
		} finally {
			em.close();
		}

		return findedLoan;
	}

	@Override
	public List<Loan> findAll() {

		List<Loan> loanList;

		try {
			em = openConnection();
			em.getTransaction().begin();
			loanList = em.createQuery("SELECT l FROM Loan l", Loan.class).getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw (e);
		} finally {
			em.close();
		}

		return loanList;
	}

	@Override
	public EntityManager openConnection() {
		if (em == null) {
			em = emf.createEntityManager();
			return em;
		} else {
			return em;
		}
	}

}
