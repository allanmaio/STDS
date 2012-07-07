package com.optimizenow.dao;

import org.hibernate.Session;

import com.optimizenow.model.Loja;


public class LojaDAOHibernate extends GenericHibernateDAO<Loja, Long> implements
		LojaDAO {

	public LojaDAOHibernate() {
		super(Loja.class);
	}

	public LojaDAOHibernate(final Session session) {
		super(Loja.class, session);
	}

	@Override
	protected void setSession(final Session session) {
		this.session = session;

	}

}
