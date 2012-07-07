package com.optimizenow.gui;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

public abstract class FrameCadastroComEndereco<T> extends FrameCadastro<T>{

	private final JLabel lblTipoLogradouro = new JLabel("Tipo Logradouro");

	private final JLabel lblLogradouro = new JLabel("Logradouro");

	private final JLabel lblNumero = new JLabel("N\u00famero");

	private final JLabel lblComplemento = new JLabel("Complemento");

	private final JLabel lblBairro = new JLabel("Bairro");

	private final JLabel lblCidade = new JLabel("Cidade");

	private final JLabel lblCEP = new JLabel("CEP");

	protected JComboBox cbxTipoLogradouro;

	protected JTextField txtLogradouro;

	protected JTextField txtNumero;

	protected JTextField txtComplemento;

	protected JTextField txtBairro;

	protected JTextField txtCidade;

	protected JTextField txtCEP;

	private final JLabel lblUF = new JLabel("UF");

	protected JTextField txtUF;

	public FrameCadastroComEndereco() {
		initComponents();
	}

	private void initComponents() {
		cbxTipoLogradouro = new JComboBox();
		cbxTipoLogradouro.setModel(new DefaultComboBoxModel(new String[] {
				"Rua", "Avenida", "Travessa", "Estrada", "Pra\u00e7a" }));
		//txtLogradouro = new JTextField(15);
		txtNumero = new JTextField(15);
		txtComplemento = new JTextField(15);
		txtBairro = new JTextField(15);
		txtCidade = new JTextField(15);
		txtCEP = new JTextField(15);
		txtUF = new JTextField(15);
		
	}

	public PanelBuilder montarPanelEndereco() {
		final FormLayout layout = new FormLayout(
				"r:p, 3dlu, p:g, 10dlu, p, 3dlu, p:g", // Colunas
				"p, 3dlu, p, 3dlu, p, 3dlu, p, 3dlu, p, 3dlu, p"); // Linhas
		final DefaultFormBuilder builder = new DefaultFormBuilder(layout);
		final CellConstraints cc = new CellConstraints();
		builder.addSeparator("Endere\u00e7o", cc.xyw(1, 1, 7));
		builder.add(lblTipoLogradouro, cc.xy(1, 3));
		builder.add(cbxTipoLogradouro, cc.xy(3, 3));
		builder.add(lblLogradouro, cc.xy(1, 5));
		builder.add(txtLogradouro, cc.xyw(3, 5, 5));
		builder.add(lblNumero, cc.xy(1, 7));
		builder.add(txtNumero, cc.xy(3, 7));
		builder.add(lblComplemento, cc.xy(5, 7));
		builder.add(txtComplemento, cc.xy(7, 7));
		builder.add(lblBairro, cc.xy(1, 9));
		builder.add(txtBairro, cc.xy(3, 9));
		builder.add(lblCidade, cc.xy(5, 9));
		builder.add(txtCidade, cc.xy(7, 9));
		builder.add(lblCEP, cc.xy(1, 11));
		builder.add(txtCEP, cc.xy(3, 11));
		builder.add(lblUF, cc.xy(5, 11));
		builder.add(txtUF, cc.xy(7, 11));
		return builder;
	}

}
