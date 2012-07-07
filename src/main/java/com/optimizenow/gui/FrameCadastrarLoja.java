package com.optimizenow.gui;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.sf.nachocalendar.components.DateField;

import com.jgoodies.binding.adapter.BasicComponentFactory;
import com.jgoodies.binding.adapter.Bindings;
import com.jgoodies.binding.adapter.ComboBoxAdapter;
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.debug.FormDebugPanel;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.optimizenow.model.EntidadeModelo;
import com.optimizenow.model.Loja;
import com.optimizenow.model.Lojista;
import com.optimizenow.model.Ramo;
import com.optimizenow.presentation.LojaPresentationModel;
import com.optimizenow.presentation.STDSPresentation;

public class FrameCadastrarLoja<T> extends FrameCadastroComEndereco {

	private static final long serialVersionUID = 3554302772494968680L;

	private JButton btnAssociar;

	private JComboBox cbxLojista;

	private final JLabel lblDtInicio = new JLabel("Data de Inicio");

	private final JLabel lblDtDesligamento = new JLabel("Data de Inicio");

	private final DateField dtInicio = new DateField();

	private final DateField dtDesligamento = new DateField();

	private final JLabel lblLojista = new JLabel("Lojista");

	private final JLabel lblNomeFantasia = new JLabel("Nome Fantasia");

	private final JLabel lblRazaoSocial = new JLabel("Raz\u00e3o Social");

	private final JLabel lblSite = new JLabel("Site");

	private final JLabel lblTelefone = new JLabel("Telefone");

	private final JLabel lblFax = new JLabel("Fax");

	private JTextField txtFax;

	private JTextField txtNomeFantasia;

	private JTextField txtRazaoSocial;

	private JTextField txtSite;

	private JTextField txtTelefone;

	private JPanel panelBotoesCadastro;

	private JPanel panelEndereco;

	private Loja loja = new Loja();

	final private JLabel lblRamo = new JLabel("Ramo");

	private JComboBox cbxRamo;

	private LojaPresentationModel presentationLoja;

	public FrameCadastrarLoja() {
		presentation = new LojaPresentationModel<T>(
				loja);
		initComponents();
		insertComponents();
	}

	private void initComponents() {
		txtNomeFantasia = BasicComponentFactory
				.createTextField(presentation.getModel(Loja.NOME_FANTASIA));
		txtRazaoSocial = BasicComponentFactory
				.createTextField(presentation.getModel(Loja.RAZAO_SOCIAL));
		btnAssociar = new JButton("Associar");
		txtTelefone = BasicComponentFactory.createTextField(
				presentation.getModel(Loja.TELEFONE));
		txtSite = BasicComponentFactory.createTextField(presentation
				.getModel(Loja.SITE));
		txtFax = BasicComponentFactory.createTextField(
				presentation.getModel(Loja.FAX));
		cbxLojista = new JComboBox();
		cbxRamo = new JComboBox();

		Bindings.bind(dtInicio.getFormattedTextField(), presentation
				.getModel(Loja.DT_INICIO));
		Bindings.bind(dtDesligamento.getFormattedTextField(), presentation
				.getModel(Loja.DT_DESLIGAMENTO));

		this.setTitle("Cadastrar Loja");
		lblDtInicio.setText("Data de In\u00edcio");
		lblDtDesligamento.setText("Data de Desligamento");
		
		final ComboBoxAdapter cbAdapterRamo = new ComboBoxAdapter(new STDSPresentation(new Ramo()).findAll(), presentation.getModel(Loja.RAMO));
		cbxRamo.setModel(cbAdapterRamo);
		final ComboBoxAdapter cbAdapterLojista = new ComboBoxAdapter(new STDSPresentation(new Lojista()).findAll(),
				presentation.getModel(Loja.LOJISTA));
		cbxLojista.setModel(cbAdapterLojista);
		panelBotoesCadastro = getBarraBotoesCadastro();
		
		final ArrayList<String> tiposLogradouro = new ArrayList<String>();
		tiposLogradouro.add("Rua");
		tiposLogradouro.add("Avenida");
		tiposLogradouro.add("Estrada");
		tiposLogradouro.add("Travessa");
		tiposLogradouro.add("Vila");
		tiposLogradouro.add("Praça");
		tiposLogradouro.add("Bosque");
		final ComboBoxAdapter cbAdapterTipoLogradouro = new ComboBoxAdapter(tiposLogradouro,
				presentation.getModel(Loja.TIPO_LOGRADOURO));
		cbxTipoLogradouro.setModel(cbAdapterTipoLogradouro);
		
		txtLogradouro = BasicComponentFactory.createTextField(presentation.getModel(Loja.LOGRADOURO));
		txtNumero = BasicComponentFactory.createTextField(presentation.getModel(Loja.NUMERO_ENDERECO));
		txtComplemento = BasicComponentFactory.createTextField(presentation.getModel(Loja.COMPLEMENTO));
		txtBairro = BasicComponentFactory.createTextField(presentation.getModel(Loja.BAIRRO));
		txtCidade = BasicComponentFactory.createTextField(presentation.getModel(Loja.CIDADE));
		txtCEP = BasicComponentFactory.createTextField(presentation.getModel(Loja.CEP));
		txtUF = BasicComponentFactory.createTextField(presentation.getModel(Loja.UF));
		panelEndereco = montarPanelEndereco().getPanel();
		
		
	}

	private void insertComponents() {
		final FormLayout layout = new FormLayout(
				"f:p, r:p, 3dlu, p:g, 3dlu, r:p, 3dlu, p:g, 3dlu, p:g", // Colunas
				"p, 3dlu, p, 3dlu, p, 3dlu, p, 3dlu, p, 3dlu, p, 3dlu, p, 3dlu, p, 3dlu"); // Linhas
		final CellConstraints cc = new CellConstraints();
		final DefaultFormBuilder builder = new DefaultFormBuilder(layout);
		builder.setDefaultDialogBorder();
		builder.add(panelBotoesCadastro, cc.xyw(1, 1, 10));
		builder.add(lblNomeFantasia, cc.xy(2, 3));
		builder.add(txtNomeFantasia, cc.xyw(4, 3, 7));
		builder.add(lblRazaoSocial, cc.xy(2, 5));
		builder.add(txtRazaoSocial, cc.xyw(4, 5, 7));
		builder.add(lblDtInicio, cc.xy(2, 7));
		builder.add(dtInicio, cc.xy(4, 7));
		builder.add(lblDtDesligamento, cc.xy(2, 9));
		builder.add(dtDesligamento, cc.xy(4, 9));
		builder.add(lblRamo , cc.xy(6, 7));
		builder.add(cbxRamo, cc.xy(8, 7));
		builder.add(lblLojista, cc.xy(6, 9));
		builder.add(cbxLojista, cc.xy(8, 9));
		builder.add(btnAssociar, cc.xy(10, 9));
		builder.add(lblTelefone, cc.xy(2, 11));
		builder.add(txtTelefone, cc.xy(4, 11));
		builder.add(lblFax, cc.xy(6, 11));
		builder.add(txtFax, cc.xy(8, 11));
		builder.add(lblSite, cc.xy(2, 13));
		builder.add(txtSite, cc.xyw(4, 13, 7));

		builder.add(panelEndereco, cc.xyw(1, 15, 10));

		this.getContentPane().add(builder.getPanel());
		this.pack();
	}

	public void fechar() {
		this.dispose();
	}

	public EntidadeModelo getObjetoModelo() {
		return this.loja;
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
