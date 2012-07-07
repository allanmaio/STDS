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
import com.optimizenow.model.InformacoesFinanceiras;

public class FrameRInformacoes extends JInternalFrame implements InternalFrameRelatorio {

	private static final long serialVersionUID = 3406757169519701540L;

	private JComboBox cbxLoja;

	private JLabel lblLoja;

	private JTextField txtMes;

	private JLabel lblMes;

	private PanelPeriodo panelPeriodo;

	private EntidadeModelo entidadeModelo = new InformacoesFinanceiras();

	public FrameRInformacoes() {
		initComponents();
		insertComponents();
	}

	private void initComponents() {
		lblLoja = new JLabel("Loja");
		cbxLoja = new JComboBox();
		txtMes = new JTextField(30);
		lblMes = new JLabel("M\u00eas");
		panelPeriodo = new PanelPeriodo();

		setClosable(true);
		setIconifiable(true);
		setTitle("Relat\u00f3rio de Informa\u00e7\u00f5es Financeiras");
		cbxLoja.setModel(new DefaultComboBoxModel(new String[] { "Ponto Frio",
				"Casas Bahia", "C&A", "Richard�s" }));
	}

	private void insertComponents() {
		final FormLayout layout = new FormLayout("r:p, 3dlu, p, 20dlu:g, 3dlu, p:g", // Colunas
				"p, 3dlu, p, 3dlu, p, 3dlu, p:g"); // Linhas
		final DefaultFormBuilder builder = new DefaultFormBuilder(layout);
		builder.setDefaultDialogBorder();
		final CellConstraints cc = new CellConstraints();
		builder.add(lblMes, cc.xy(1, 3));
		builder.add(txtMes, cc.xyw(3, 3, 1));
		builder.add(lblLoja, cc.xy(1, 5));
		builder.add(cbxLoja, cc.xy(3, 5));
		builder.add(panelPeriodo.getPanelPeriodo(), cc.xyw(1, 7, 4));
		builder.add(new PanelBotoesRelatorio().getPanelBotoesRelatorio(this, this.panelPeriodo),
				cc.xywh(6, 1, 1, 7));
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
		return new HashMap();
	}

	public String getNomeRelatorio() {
		return "InformacoesFinanceiras";
	}
}