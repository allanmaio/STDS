package com.optimizenow.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;

public abstract class GenericHibernateDAO<T, ID extends Serializable>
		implements GenericDAO<T, ID> {

	private Class<T> persistentClass;

	protected Session session;

	protected GenericHibernateDAO(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	public GenericHibernateDAO(Class<T> persistentClass, Session session) {
		this.persistentClass = persistentClass;
		this.session = session;
	}

	
	protected abstract void setSession(Session s);

	protected Session getSession() {
		if (session == null)
			throw new IllegalStateException(
					"Session has not been set on DAO before usage");
		return session;
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public T findById(int id) {
		T entity;
		entity = (T) getSession().load(getPersistentClass(), id);
		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return findByCriteria();
	}

	@SuppressWarnings("unchecked")
	public List<T> findByExample(T exampleInstance, String[] excludeProperty) {
		Criteria  c = getSession().createCriteria(exampleInstance.getClass());
		c.add(Example.create(exampleInstance));
		List<T> results = c.list();
		return results;
		/*
		 * implementacao original Criteria crit =
		 * getSession().createCriteria(getPersistentClass()); Example example =
		 * Example.create(exampleInstance); if (excludeProperty != null) { for
		 * (String exclude : excludeProperty) {
		 * example.excludeProperty(exclude); } } crit.add(example); return
		 * crit.list();
		 */
	}

	@SuppressWarnings("unchecked")
	public T makePersistent(T entity) {
		getSession().beginTransaction();
		getSession().saveOrUpdate(entity);
		getSession().getTransaction().commit();
		return entity;
	}

	public void makeTransient(T entity) {
		getSession().beginTransaction();
		getSession().delete(entity);
		getSession().getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(Criterion... criterion) {
		List<T> list = null;
		try {
			getSession().beginTransaction();
			Criteria crit = getSession().createCriteria(getPersistentClass());
			for (Criterion c : criterion) {
				crit.add(c);
			}
			list = crit.list();
		} finally {
			getSession().getTransaction().commit();
		}
		return list;
	}
	
	public Connection getConnection() {
		return getSession().connection();
	}
	

}
