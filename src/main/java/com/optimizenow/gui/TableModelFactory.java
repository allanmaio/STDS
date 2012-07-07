package com.optimizenow.gui;

import java.util.List;

import javax.swing.table.TableModel;

import com.optimizenow.model.Loja;
import com.optimizenow.model.Lojista;
import com.optimizenow.model.UnidadeComercial;


public final class TableModelFactory {
	
	private TableModelFactory() {
		
	}

	public static TableModel getTableModel(final List objetosEncontrados) {
		final Class classeObjetoEncontrado = objetosEncontrados.get(0).getClass();
		if (classeObjetoEncontrado.isInstance(new UnidadeComercial())) {
			return new TableModelUnidadeComercial(objetosEncontrados);
		}
		if (classeObjetoEncontrado.isInstance(new Loja())) {
			return new TableModelLoja(objetosEncontrados);
		}
		if (classeObjetoEncontrado.isInstance(new Lojista())) {
			return new TableModelLojista(objetosEncontrados);
		}
		
		return null;
	}

}
