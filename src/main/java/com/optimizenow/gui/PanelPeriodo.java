package com.optimizenow.gui;

import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.sf.nachocalendar.components.DateField;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

public class PanelPeriodo {

	JPanel panelPeriodo;

	private final JLabel lblDe = new JLabel("De");

	private DateField dtDe;

	private final JLabel lblAte = new JLabel("at\u00e9");

	private DateField dtAte;

	public PanelPeriodo() {
		initComponents();
		insertComponents();
	}

	private void initComponents() {
		dtDe = new DateField();
		dtAte = new DateField();
	}

	private void insertComponents() {
		final FormLayout layout = new FormLayout(
				"r:p, 3dlu, p:g, 3dlu, r:p, 3dlu, p:g", // Colunas
				"p, 3dlu, p"); // Linhas
		final DefaultFormBuilder builder = new DefaultFormBuilder(layout);
		final CellConstraints cc = new CellConstraints();
		builder.addSeparator("Per\u00edodo", cc.xyw(1, 1, 7));
		builder.add(lblDe, cc.xy(1, 3));
		builder.add(dtDe, cc.xy(3, 3));
		builder.add(lblAte, cc.xy(5, 3));
		builder.add(dtAte, cc.xy(7, 3));
		panelPeriodo = builder.getPanel();
	}

	public JPanel getPanelPeriodo() {
		return this.panelPeriodo;
	}

	public Object getDtInicio() {
		return dtDe.getValue();
	}

	public Object getDtFim() {
		return dtAte.getValue();
	}
}
