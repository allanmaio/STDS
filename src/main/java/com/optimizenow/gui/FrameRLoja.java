package com.optimizenow.gui;

import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.optimizenow.model.EntidadeModelo;
import com.optimizenow.model.Loja;

public class FrameRLoja extends JInternalFrame implements InternalFrameRelatorio {

	private static final long serialVersionUID = -5199063118575654925L;

	private JComboBox cbxLojas;

	private JLabel lblCodigoLoja;

	private JLabel lblLojas;

	private JTextField txtCodigoLoja;

	private PanelPeriodo panelPeriodo;

	private PanelBotoesRelatorio panelBotoesRelatorio;

	private EntidadeModelo entidadeModelo = new Loja();

	final private Map mapaParametros = new HashMap();

	public FrameRLoja() {
		initComponents();
		insertComponents();
	}

	private void initComponents() {
		txtCodigoLoja = new JTextField(30);
		cbxLojas = new JComboBox();
		lblCodigoLoja = new JLabel();
		lblLojas = new JLabel();
		setClosable(true);
		setIconifiable(true);
		setTitle("Relat\u00f3rio de Lojas");

		cbxLojas.setModel(new DefaultComboBoxModel(new String[] { "Item 1",
				"Item 2", "Item 3", "Item 4" }));

		lblCodigoLoja.setText("C\u00f3digo da Loja");
		lblLojas.setText("Lojas");
		panelPeriodo = new PanelPeriodo();
		panelBotoesRelatorio = new PanelBotoesRelatorio();

	}

	private void insertComponents() {
		final FormLayout layout = new FormLayout("r:p, 3dlu, p, 20dlu:g, 3dlu, p", // Colunas
				"p, 3dlu, p, 3dlu, p:g"); // Linhas
		final DefaultFormBuilder builder = new DefaultFormBuilder(layout);
		builder.setDefaultDialogBorder();
		final CellConstraints cc = new CellConstraints();
		builder.add(lblCodigoLoja, cc.xy(1, 1));
		builder.add(txtCodigoLoja, cc.xyw(3, 1, 1));
		builder.add(lblLojas, cc.xyw(1, 3, 3));
		builder.add(cbxLojas, cc.xyw(3, 3, 1));
		builder.add(panelPeriodo.getPanelPeriodo(), cc.xyw(1, 5, 4));
		builder.add(panelBotoesRelatorio.getPanelBotoesRelatorio(this, this.panelPeriodo), cc
				.xywh(6, 1, 1, 5));
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
		return this.mapaParametros;
	}

	public String getNomeRelatorio() {
		return "Loja";
	}
}
