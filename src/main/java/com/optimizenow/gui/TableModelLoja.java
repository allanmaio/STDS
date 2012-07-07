package com.optimizenow.gui;

import java.util.List;
import java.util.Vector;

import com.optimizenow.model.Loja;


public class TableModelLoja extends STDSTableModel {

	private Loja loja;
	
	public TableModelLoja(List objetosEncontrados) {
		dataVector = new Vector(objetosEncontrados);
		columnNames = new String[]{"Nome Fantasia", "Razao Social", "Data Inicio", "Data Desligamento"};
	}

	@Override
	public Object getValueAt(final int row, final int column) {
		if (getRow(row) instanceof Loja) {
			loja = (Loja) getRow(row);
			switch (column) {
			case 0:
				return loja.getNomeFantasia();
			case 1:
				return loja.getRazaoSocial() == null ?"" : loja.getRazaoSocial();
			case 2:
				return loja.getDtInicio() == null ? "" : sdf.format(loja.getDtInicio());
			case 3:
				return loja.getDtDesligamento() == null ? "" : sdf.format(loja.getDtDesligamento());
			default:
				return null;
			}
		} else {
			return null;
		}
	}
	

}
