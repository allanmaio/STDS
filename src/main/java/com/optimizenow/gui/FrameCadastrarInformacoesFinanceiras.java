package com.optimizenow.gui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import com.jgoodies.binding.adapter.BasicComponentFactory;
import com.jgoodies.binding.adapter.Bindings;
import com.jgoodies.binding.list.SelectionInList;
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.optimizenow.model.EntidadeModelo;
import com.optimizenow.model.Loja;
import com.optimizenow.presentation.STDSPresentation;

public class FrameCadastrarInformacoesFinanceiras<T> extends FrameCadastro {

	private static final long serialVersionUID = -4608181435660595072L;

	private JComboBox cbxLoja;

	private JComboBox cbxMes;

	private final JLabel lblFluxoPessoas = new JLabel("Fluxo de Pessoas");

	private final JLabel lblLoja = new JLabel("Loja");

	//private final JLabel lblMes = new JLabel("M\u00eas");

	private final JLabel lblVendas = new JLabel("Vendas");

	private JTextField txtFluxoPessoas;

	private JTextField txtVendas;

	private JPanel panelBotoesCadastro;
	
	private Loja loja = new Loja();

	public FrameCadastrarInformacoesFinanceiras() {
		presentation = new STDSPresentation(loja);
		initComponents();
		insertComponents();
	}

	private void initComponents() {
		final SelectionInList selectionInListLojas = new SelectionInList(presentation.findAll());
		cbxLoja = BasicComponentFactory.createComboBox(selectionInListLojas);
		cbxMes = new JComboBox();
		txtFluxoPessoas = BasicComponentFactory.createLongField(presentation.getModel(Loja.FLUXOPESSOAS));
		txtVendas = new JTextField();
		Bindings.bind(txtVendas, new BigDecimalConverter(presentation.getModel(Loja.VENDAS)));
		this.setTitle("Cadastrar Informa\u00e7\u00f5es Financeiras");

		cbxMes.setModel(new DefaultComboBoxModel(new String[] { "Janeiro",
				"Fevereiro", "Mar\u00e7o", "Abril", "Maio", "Junho" }));
		cbxLoja.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				setObjetoModelo((EntidadeModelo) e.getItem());
			}
		});
		
		panelBotoesCadastro = getBarraBotoesCadastro();

	}

	private void insertComponents() {
		final FormLayout layout = new FormLayout("f:p, r:p, 3dlu, p:g, p:g", // Colunas
				"p, p, 3dlu, p, 3dlu, p, 3dlu, p"); // Linhas
		final DefaultFormBuilder builder = new DefaultFormBuilder(layout);
		builder.setDefaultDialogBorder();
		final CellConstraints cc = new CellConstraints();
		builder.add(panelBotoesCadastro, cc.xyw(1, 1, 5));
		builder.add(lblLoja, cc.xy(2, 2));
		builder.add(cbxLoja, cc.xyw(4, 2, 2));
		//builder.add(lblMes, cc.xy(2, 4));
		//builder.add(cbxMes, cc.xy(4, 4));
		builder.add(lblFluxoPessoas, cc.xy(2, 6));
		builder.add(txtFluxoPessoas, cc.xy(4, 6));
		builder.add(lblVendas, cc.xy(2, 8));
		builder.add(txtVendas, cc.xy(4, 8));
		this.getContentPane().add(builder.getPanel());
		this.pack();
	}

	public void fechar() {
		this.dispose();
	}

	public EntidadeModelo getObjetoModelo() {
		return loja;
	}

	public void setObjetoModelo(final EntidadeModelo entidade) {
		if (entidade == null) {
			this.loja = new Loja();
			presentation.setBean(this.loja);
		} else {
			final Loja lojaNova = (Loja) entidade;
			this.loja = lojaNova;
			presentation.setBean(lojaNova);
		}

	}

}
