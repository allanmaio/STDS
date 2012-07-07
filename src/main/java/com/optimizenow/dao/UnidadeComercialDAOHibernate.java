package com.optimizenow.dao;

import org.hibernate.Session;

import com.optimizenow.model.UnidadeComercial;


public class UnidadeComercialDAOHibernate extends
		GenericHibernateDAO<UnidadeComercial, Long> implements
		UnidadeComercialDAO {

	public UnidadeComercialDAOHibernate() {
		super(UnidadeComercial.class);
	}

	public UnidadeComercialDAOHibernate(Session session) {
		super(UnidadeComercial.class, session);
	}

	@Override
	protected void setSession(Session session) {
		this.session = session;

	}


}
