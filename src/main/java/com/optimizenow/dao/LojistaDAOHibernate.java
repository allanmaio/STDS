package com.optimizenow.dao;

import org.hibernate.Session;

import com.optimizenow.model.Lojista;


public class LojistaDAOHibernate extends GenericHibernateDAO<Lojista, Long>
		implements LojistaDAO {

	public LojistaDAOHibernate() {
		super(Lojista.class);
	}

	public LojistaDAOHibernate(Session session) {
		super(Lojista.class, session);
	}

	@Override
	protected void setSession(Session session) {
		this.session = session;

	}


}
