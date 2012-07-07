package com.optimizenow.gui;

import java.util.List;
import java.util.Vector;

import com.optimizenow.model.UnidadeComercial;


public class TableModelUnidadeComercial extends STDSTableModel {

	private UnidadeComercial unidade;
	
	public TableModelUnidadeComercial(final List objetosEncontrados) {
		dataVector = new Vector(objetosEncontrados);
		columnNames = new String[]{"Numero", "Data Inicio", "Data Fim", "Area"};
	}

	public Object getValueAt(final int rowIndex, final int columnIndex) {
		if (getRow(rowIndex) instanceof UnidadeComercial) {
			unidade = (UnidadeComercial) getRow(rowIndex);
			switch (columnIndex) {
			case 0:
				return unidade.getNumero() == null ? "" : unidade.getNumero();
			case 1:
				return unidade.getDtInicio() == null ? "" : sdf.format(unidade.getDtInicio());
			case 2:
				return unidade.getDtFim() == null ? "" : sdf.format(unidade.getDtFim());
			case 3:
				return unidade.getArea() == null ? ""  : unidade.getArea();
			default:
				return null;
			}
		} else {
			return null;
		}
	}
	

}
