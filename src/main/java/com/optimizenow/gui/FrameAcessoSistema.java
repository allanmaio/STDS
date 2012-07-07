package com.optimizenow.gui;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.optimizenow.model.EntidadeModelo;
import com.optimizenow.presentation.STDSPresentation;

public class FrameAcessoSistema<T> extends FrameCadastro {

	private static final long serialVersionUID = -4608181435660595072L;

	private JComboBox cbxNome;

	private JLabel lblNome;

	private JComboBox cbxPermissao;

	private JLabel lblPermissao;

	private JLabel lblLogin;

	private JTextField txtLogin;

	private JLabel lblSenha;

	private JTextField txtSenha;

	private JPanel panelBotoesCadastro;

	public FrameAcessoSistema() {
		presentation = new STDSPresentation<T>(
				null);
		initComponents();
		insertComponents();
	}

	private void initComponents() {
		cbxNome = new JComboBox();
		lblNome = new JLabel("Nome");
		lblPermissao = new JLabel("Permiss\u00e3o");
		cbxPermissao = new JComboBox();
		lblLogin = new JLabel("Login");
		txtLogin = new JTextField(10);
		lblSenha = new JLabel("Senha");
		txtSenha = new JTextField(10);
		this.setTitle("Cadastrar Acesso ao Sistema");

		cbxNome.setModel(new DefaultComboBoxModel(new String[] { "Orlando",
				"Allan", "Marcos" }));

		cbxPermissao.setModel(new DefaultComboBoxModel(new String[] {
				"Administrador", "Usu\u00e1rio"}));

		panelBotoesCadastro = getBarraBotoesCadastro();

	}

	private void insertComponents() {
		final FormLayout layout = new FormLayout("f:p, r:p, 3dlu, p:g, p:g", // Colunas
				"p, p, 3dlu, p, 3dlu, p, 3dlu, p"); // Linhas
		final DefaultFormBuilder builder = new DefaultFormBuilder(layout);
		builder.setDefaultDialogBorder();
		final CellConstraints cc = new CellConstraints();
		builder.add(panelBotoesCadastro, cc.xyw(1, 1, 5));
		builder.add(lblNome, cc.xy(2, 2));
		builder.add(cbxNome, cc.xyw(4, 2, 2));
		builder.add(lblPermissao, cc.xy(2, 4));
		builder.add(cbxPermissao, cc.xy(4, 4));
		builder.add(lblLogin, cc.xy(2, 6));
		builder.add(txtLogin, cc.xy(4, 6));
		builder.add(lblSenha, cc.xy(2, 8));
		builder.add(txtSenha, cc.xy(4, 8));
		this.getContentPane().add(builder.getPanel());
		this.pack();
	}

	public void fechar() {
		this.dispose();
	}

	public EntidadeModelo getObjetoModelo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setObjetoModelo(final EntidadeModelo entidade) {
		// TODO Auto-generated method stub

	}

}
