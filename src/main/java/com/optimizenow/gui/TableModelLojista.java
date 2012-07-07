package com.optimizenow.gui;

import java.util.List;
import java.util.Vector;

import com.optimizenow.model.Lojista;


public class TableModelLojista extends STDSTableModel {
	
	private Lojista lojista;

	public TableModelLojista(final List objetosEncontrados) {
		dataVector = new Vector(objetosEncontrados);
		columnNames = new String[]{"Nome", "RG", "Estado Civil", "Data Nascimento"};
	}

	public Object getValueAt(final int rowIndex, final int columnIndex) {
		if (getRow(rowIndex) instanceof Lojista) {
			lojista = (Lojista) getRow(rowIndex);
			switch (columnIndex) {
			case 0:
				return lojista.getNome() == null ? "" : lojista.getNome();
			case 1:
				return lojista.getRg() == null ? "" : String.valueOf(lojista.getRg());
			case 2:
				return lojista.getEstadoCivil() == null ? "" : lojista.getEstadoCivil();
			case 3:
				return lojista.getDtNascimento() == null ? "" : sdf.format(lojista.getDtNascimento());
			default:
				return null;
			}
		} else {
			return null;
		}
	}


}
