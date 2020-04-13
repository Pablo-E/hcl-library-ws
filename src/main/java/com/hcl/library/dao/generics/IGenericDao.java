package com.hcl.library.dao.generics;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public interface IGenericDao<T> {
	
	public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hcl-library");
	public EntityManager em = emf.createEntityManager();
	
	public void add(T t);
	public void remove(T t);
	public void update(T t);
	public List<T> findAll();
	
	public static void closeConnection() {
		em.close();
	}

}
