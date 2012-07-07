package com.optimizenow.gui;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.optimizenow.model.EntidadeModelo;
import com.optimizenow.model.UnidadeComercial;

public class FrameRUnidade extends JInternalFrame implements InternalFrameRelatorio {

	private static final long serialVersionUID = 3406757169519701540L;

	private JLabel lblNumero;

	private JTextField txtNumero;

	private PanelPeriodo panelPeriodo;

	private EntidadeModelo entidadeModelo = new UnidadeComercial();

	final private Map mapaParametros = new HashMap();

	public FrameRUnidade() {
		initComponents();
		insertComponents();
	}

	private void initComponents() {
		txtNumero = new JTextField(30);
		lblNumero = new JLabel("N\u00famero");
		panelPeriodo = new PanelPeriodo();

		setClosable(true);
		setIconifiable(true);
		setTitle("Relat\u00f3rio de Unidade Comerciais");
	}

	private void insertComponents() {
		final FormLayout layout = new FormLayout("r:p, 3dlu, p, 20dlu:g, 3dlu, p:g", // Colunas
				"p, 3dlu, p:g"); // Linhas
		final DefaultFormBuilder builder = new DefaultFormBuilder(layout);
		builder.setDefaultDialogBorder();
		final CellConstraints cc = new CellConstraints();
		builder.add(lblNumero, cc.xy(1, 1));
		builder.add(txtNumero, cc.xyw(3, 1, 1));
		builder.add(panelPeriodo.getPanelPeriodo(), cc.xyw(1, 3, 4));
		builder.add(new PanelBotoesRelatorio().getPanelBotoesRelatorio(this, this.panelPeriodo),
				cc.xywh(6, 1, 1, 3));
		this.getContentPane().add(builder.getPanel());
		pack();
	}

	public void fechar() {
		this.dispose();
	}

	public EntidadeModelo getObjetoModelo() {
		return this.entidadeModelo;
	}

	public void setObjetoModelo(final EntidadeModelo entidade) {
		this.entidadeModelo = entidade;
	}

	public Map getParemetros() {
		return this.mapaParametros ;
	}

	public String getNomeRelatorio() {
		return "UnidadeComercial";
	}
}