package com.optimizenow.dao;

import org.hibernate.Session;

import com.optimizenow.model.Ramo;


public class RamoDAOHibernate extends GenericHibernateDAO<Ramo, Long>
		implements RamoDAO {

	public RamoDAOHibernate() {
		super(Ramo.class);
	}

	public RamoDAOHibernate(final Session session) {
		super(Ramo.class, session);
	}

	@Override
	protected void setSession(final Session session) {
		this.session = session;
	}

}
