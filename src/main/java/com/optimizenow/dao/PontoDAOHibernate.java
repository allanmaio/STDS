package com.optimizenow.dao;

import org.hibernate.Session;

import com.optimizenow.model.Ponto;


public class PontoDAOHibernate extends GenericHibernateDAO<Ponto, Long>
		implements PontoDAO {

	protected PontoDAOHibernate() {
		super(Ponto.class);
	}

	public PontoDAOHibernate(Session session) {
		super(Ponto.class, session);
	}

	@Override
	protected void setSession(Session session) {
		this.session = session;
	}

}
