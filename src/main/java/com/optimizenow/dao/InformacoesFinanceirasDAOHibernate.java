package com.optimizenow.dao;

import org.hibernate.Session;

import com.optimizenow.model.InformacoesFinanceiras;


public class InformacoesFinanceirasDAOHibernate extends GenericHibernateDAO<InformacoesFinanceiras, Long>
		implements InformacoesFinanceirasDAO {

	public InformacoesFinanceirasDAOHibernate() {
		super(InformacoesFinanceiras.class);
	}

	public InformacoesFinanceirasDAOHibernate(final Session session) {
		super(InformacoesFinanceiras.class, session);
	}

	@Override
	protected void setSession(final Session session) {
		this.session = session;

	}

}
