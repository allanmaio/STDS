package com.optimizenow.gui;

import com.optimizenow.model.EntidadeModelo;

public interface InternalFrame<T> {

	String espacoPadrao = "3dlu";

	EntidadeModelo<T> getObjetoModelo();

	void fechar();

	void setObjetoModelo(EntidadeModelo entidade);
	
}
