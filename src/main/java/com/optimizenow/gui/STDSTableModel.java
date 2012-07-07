package com.optimizenow.gui;

import java.text.SimpleDateFormat;

import javax.swing.table.DefaultTableModel;

public abstract class STDSTableModel extends DefaultTableModel {
	
	protected String[] columnNames;
	
	protected SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public String getColumnName(final int columnIndex) {
		return columnNames[columnIndex];
	}

	public int getColumnCount() {
		return columnNames.length;
	}


	protected Object getRow(final int rowIndex) {
		return dataVector.get(rowIndex);
	}

	public boolean isCellEditable(final int rowIndex, final int columnIndex) {
		return false;
	}

	

}
