package com.hcl.library.dao;

import java.util.Date;
import java.util.List;

import com.hcl.library.dao.generics.ILoanDao;
import com.hcl.library.model.Loan;

public class ImplLoanDao implements ILoanDao {

	@Override
	public void add(Loan l) {
		
		//look if there is stock
		if (l.getBook().getStock() > 0) {
			int stock = l.getBook().getStock();
			l.getBook().setStock(stock - 1);
			
			l.setDateLoan(new Date());
			l.setStatus(true);
			
			try {
				em.getTransaction().begin();
				em.persist(l);
				em.getTransaction().commit();
			} catch (Exception e) {
				em.getTransaction().rollback();
				throw (e);
			}
		} else {
			System.out.println("NO STOCK");
		}
		
		
	}

	@Override
	public void remove(Loan l) {
		try {
			em.getTransaction().begin();
			em.remove(l);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw (e);
		}
	}

	@Override
	public void update(Loan l) {
		try {
			em.getTransaction().begin();
			em.merge(l);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw (e);
		}
	}

	@Override
	public Loan findById(int id) {
		Loan findedLoan;
		try {
			em.getTransaction().begin();
			findedLoan = em.find(Loan.class, id);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw (e);
		}

		return findedLoan;
	}

	@Override
	public List<Loan> findAll() {

		List<Loan> loanList;

		try {
			em.getTransaction().begin();
			loanList = em.createQuery("SELECT l FROM Loan l", Loan.class).getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw (e);
		}
		
		return loanList;
	}

}
