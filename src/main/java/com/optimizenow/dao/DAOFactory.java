package com.optimizenow.dao;

import java.io.Serializable;

import com.optimizenow.model.InformacoesFinanceiras;
import com.optimizenow.model.Loja;
import com.optimizenow.model.Lojista;
import com.optimizenow.model.Ponto;
import com.optimizenow.model.Ramo;
import com.optimizenow.model.UnidadeComercial;


public abstract class DAOFactory<T> {
	public static final DAOFactory HIBERNATE = new HibernateDAOFactory();
	
	public static final DAOFactory DEFAULT = HIBERNATE;

	public abstract GenericDAO getUnidadeComercialDAO();

	public abstract GenericDAO getPontoDAO();
	
	public abstract GenericDAO getLojaDAO();
	
	public abstract GenericDAO getLojistaDAO();
	
	public abstract GenericDAO getRamoDAO();
	
	public abstract GenericDAO getInformacoesFinanceirasDAO();

	/*
	public GenericDAO<T, Serializable> getDAO(final Class classe) {
		if (classe.isInstance(new Loja())) {
			return getLojaDAO();
		}
		if (classe.isInstance(new UnidadeComercial())) {
			return getUnidadeComercialDAO();
		}
		if (classe.isInstance(new Ponto())) {
			return getPontoDAO();
		}
		if (classe.isInstance(new Lojista())) {
			return getLojistaDAO();
		}
		return null;
	}
	*/

	public GenericDAO<T, Serializable> getDAO(Object objeto) {
		Class classe = objeto.getClass();
		if (classe.isInstance(new Loja())) {
			return getLojaDAO();
		}
		if (classe.isInstance(new UnidadeComercial())) {
			return getUnidadeComercialDAO();
		}
		if (classe.isInstance(new Ponto())) {
			return getPontoDAO();
		}
		if (classe.isInstance(new Lojista())) {
			return getLojistaDAO();
		}
		if (classe.isInstance(new Ramo())) {
			return getRamoDAO();
		}
		if (classe.isInstance(new InformacoesFinanceiras())) {
			return getInformacoesFinanceirasDAO();
		}

		return null;
	}


}