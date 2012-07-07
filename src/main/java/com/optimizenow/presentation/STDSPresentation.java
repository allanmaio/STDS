package com.optimizenow.presentation;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;


import com.jgoodies.binding.PresentationModel;
import com.optimizenow.dao.DAOFactory;
import com.optimizenow.dao.GenericDAO;

public class STDSPresentation<T> extends PresentationModel {

	private static final long serialVersionUID = 6988790873905537491L;

	final private GenericDAO<T, Serializable> dao;

	public STDSPresentation(Object bean) {
		super(bean);
		if (bean == null) {
			dao = null;
		} else {
			dao = DAOFactory.DEFAULT.getDAO(bean);
		}
	}

	public void salvar(final T entidadeModelo) {
		dao.makePersistent(entidadeModelo);
	}

	public void excluir(final T entidadeModelo) {
		dao.makeTransient(entidadeModelo);
	}

	public List<T> consultar(final T entidadeModelo) {
		return dao.findByExample(entidadeModelo, null);
	}

	public List findAll() {
		return dao.findAll();
	}

	public Connection getConnection() {
		return dao.getConnection();
	}

}
