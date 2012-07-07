package com.optimizenow.dao;

import org.hibernate.Session;

import com.optimizenow.datasource.HibernateUtil;


public class HibernateDAOFactory extends DAOFactory {

	public UnidadeComercialDAO getUnidadeComercialDAO() {
		return new UnidadeComercialDAOHibernate(getCurrentSession());
	}

	protected Session getCurrentSession() {
		return HibernateUtil.getSessionFactory().openSession();
	}

	@Override
	public PontoDAO getPontoDAO() {
		return new PontoDAOHibernate(getCurrentSession());
	}
	
	public LojaDAO getLojaDAO(){
		return new LojaDAOHibernate(getCurrentSession());
	}
	
	public LojistaDAO getLojistaDAO(){
		return new LojistaDAOHibernate(getCurrentSession());
	}

	@Override
	public RamoDAO getRamoDAO() {
		return new RamoDAOHibernate(getCurrentSession());
	}

	@Override
	public InformacoesFinanceirasDAO getInformacoesFinanceirasDAO() {
		return new InformacoesFinanceirasDAOHibernate(getCurrentSession());
	}
	

}