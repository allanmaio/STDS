package com.optimizenow.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {

	T findById(int id);

	List<T> findAll();

	List<T> findByExample(T exampleInstance, String... excludeProperty);

	T makePersistent(T entidadeModelo);

	void makeTransient(T entity);

	Connection getConnection();
}
