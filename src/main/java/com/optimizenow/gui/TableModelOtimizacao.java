package com.optimizenow.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.optimizenow.model.Loja;
import com.optimizenow.model.UnidadeComercial;


public class TableModelOtimizacao extends STDSTableModel {

	private UnidadeComercial unidade;


	public TableModelOtimizacao(List objetosEncontrados) {
		Random random = new Random();
		columnNames = new String[] { "Numero", "Data Inicio", "Data Fim",
				"Area" };
		int j = 0;
		List coluna1 = new ArrayList();
		List coluna2 = new ArrayList();
		List coluna3 = new ArrayList();
		List coluna4 = new ArrayList();
		dataVector.add(0, coluna1);
		dataVector.add(1, coluna2);
		dataVector.add(2, coluna3);
		dataVector.add(3, coluna4);
		for (Object o : objetosEncontrados) {
			j = random.nextInt(4);
			((ArrayList) dataVector.get(j)).add(o);
		}

	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return getElemento(0, rowIndex);
		case 1:
			return getElemento(1, rowIndex);
		case 2:
			return getElemento(2, rowIndex);
		case 3:
			return getElemento(3, rowIndex);
		default:
			return null;
		}
	}

	private Object getElemento(int columnIndex, int rowIndex) {
		Loja loja = null;
		if ((((ArrayList) dataVector.get(columnIndex)).size()) >= rowIndex) {
			return "babou";
		} else {
			try {
				loja = (Loja) ((ArrayList) getRow(columnIndex)).get(rowIndex);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (loja != null) {
				return loja.getNomeFantasia() == null ? "" : loja
						.getNomeFantasia();
			} else {
				return "babou2";
			}
		}

	}

}
