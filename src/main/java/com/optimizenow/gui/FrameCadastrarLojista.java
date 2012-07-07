package com.optimizenow.gui;

import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.sf.nachocalendar.components.DateField;

import com.jgoodies.binding.adapter.BasicComponentFactory;
import com.jgoodies.binding.adapter.Bindings;
import com.jgoodies.binding.adapter.ComboBoxAdapter;
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.optimizenow.model.EntidadeModelo;
import com.optimizenow.model.Loja;
import com.optimizenow.model.Lojista;
import com.optimizenow.presentation.STDSPresentation;

public class FrameCadastrarLojista<T> extends FrameCadastroComEndereco {

	private static final long serialVersionUID = 893007713408495471L;

	private JComboBox cbxEstadoCivil;

	private JComboBox cbxSexo;

	private final JLabel lblCPF = new JLabel("CPF");

	private final JLabel lblCelular = new JLabel("Celular");

	private final JLabel lblEmail = new JLabel("E-mail");

	private final JLabel lblEstadoCivil = new JLabel("Estado Civil");

	private final JLabel lblOBS = new JLabel("OBS");

	private final JLabel lblRG = new JLabel("RG");

	private final JLabel lblSexo = new JLabel("Sexo");

	private final JLabel lblTelComercial = new JLabel("Tel Comercial");

	private final JLabel lblTelefone = new JLabel("Telefone");

	private final JLabel lblDtNascimento = new JLabel("Data Nascimento");

	private final DateField dtNascimento = new DateField();

	private final JLabel lblNome = new JLabel("Nome");

	private JTextField txtCPF;

	private JTextField txtCelular;

	private JTextField txtEmail;

	private JTextField txtNome;

	private JTextField txtOBS;

	private JTextField txtRG;

	private JTextField txtTelComercial;

	private JTextField txtTelefone;

	private JPanel panelBotoesCadastro;

	private JPanel panelEndereco;

	private Lojista lojista = new Lojista();

	public FrameCadastrarLojista() {
		presentation = new STDSPresentation<T>(
				lojista);
		initComponents();
		insertComponents();
	}

	private void initComponents() {
		cbxTipoLogradouro = new JComboBox();
		cbxSexo = new JComboBox();
		cbxEstadoCivil = new JComboBox();
		txtNome = BasicComponentFactory.createTextField(presentation
				.getModel(Lojista.NOME));
		txtRG = BasicComponentFactory.createLongField(presentation
				.getModel(Lojista.RG));
		txtCPF = BasicComponentFactory.createLongField(presentation
				.getModel(Lojista.CPF), NumberFormat.getNumberInstance());
		txtCelular = BasicComponentFactory.createTextField(presentation
				.getModel(Lojista.CELULAR));
		txtEmail = BasicComponentFactory.createTextField(presentation
				.getModel(Lojista.EMAIL));
		txtTelComercial = BasicComponentFactory.createTextField(
				presentation.getModel(Lojista.TEL_COMERCIAL));
		txtTelefone = BasicComponentFactory.createTextField(presentation
				.getModel(Lojista.TELEFONE));
		txtOBS = BasicComponentFactory.createTextField(presentation
				.getModel(Lojista.OBS));

		Bindings.bind(dtNascimento.getFormattedTextField(), presentation
				.getModel(Lojista.DT_NASCIMENTO));

		this.setTitle("Cadastrar Lojistas");
		lblDtNascimento.setText("Data de Nascimento");
		//cbxTipoLogradouro.setModel(new DefaultComboBoxModel(new String[] {
		//		"Item 1", "Item 2", "Item 3", "Item 4" }));

		final ArrayList<String> sexo = new ArrayList<String>();
		sexo.add("Masculino");
		sexo.add("Feminino");
		final ComboBoxAdapter cbAdapterSexo = new ComboBoxAdapter(sexo,
				presentation.getModel(Lojista.SEXO));
		cbxSexo.setModel(cbAdapterSexo);

		final ArrayList<String> estadoCivil = new ArrayList<String>();
		estadoCivil.add("Solteiro");
		estadoCivil.add("Casado");
		estadoCivil.add("Vi\u00favo");
		estadoCivil.add("Divorciado");
		final ComboBoxAdapter cbAdapterEstadoCivil = new ComboBoxAdapter(estadoCivil,
				presentation.getModel(Lojista.ESTADO_CIVIL));
		cbxEstadoCivil.setModel(cbAdapterEstadoCivil);

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
				presentation.getModel(Lojista.TIPO_LOGRADOURO));
		cbxTipoLogradouro.setModel(cbAdapterTipoLogradouro);
		
		txtLogradouro = BasicComponentFactory.createTextField(presentation.getModel(Lojista.LOGRADOURO));
		txtNumero = BasicComponentFactory.createTextField(presentation.getModel(Lojista.NUMERO_ENDERECO));
		txtComplemento = BasicComponentFactory.createTextField(presentation.getModel(Lojista.COMPLEMENTO));
		txtBairro = BasicComponentFactory.createTextField(presentation.getModel(Lojista.BAIRRO));
		txtCidade = BasicComponentFactory.createTextField(presentation.getModel(Lojista.CIDADE));
		txtCEP = BasicComponentFactory.createTextField(presentation.getModel(Lojista.CEP));
		txtUF = BasicComponentFactory.createTextField(presentation.getModel(Lojista.UF));
		panelEndereco = montarPanelEndereco().getPanel();
	}

	private void insertComponents() {
		final FormLayout layout = new FormLayout(
				"f:p, r:p, 3dlu, p:g, 40dlu, 3dlu, r:p, 3dlu, p:g", // Colunas
				"p, p, 3dlu, p, 3dlu, p, 3dlu, p, 3dlu, p, 3dlu, p, 3dlu, p"); // Linhas

		final DefaultFormBuilder builder = new DefaultFormBuilder(layout);
		builder.setDefaultDialogBorder();
		final CellConstraints cc = new CellConstraints();
		builder.add(panelBotoesCadastro, cc.xyw(1, 1, 9));
		builder.add(lblNome, cc.xy(2, 2));
		builder.add(txtNome, cc.xyw(4, 2, 2));
		builder.add(lblSexo, cc.xy(7, 2));
		builder.add(cbxSexo, cc.xy(9, 2));
		builder.add(lblEstadoCivil, cc.xy(2, 4));
		builder.add(cbxEstadoCivil, cc.xy(4, 4));
		builder.add(lblCPF, cc.xy(7, 4));
		builder.add(txtCPF, cc.xy(9, 4));
		builder.add(lblRG, cc.xy(2, 6));
		builder.add(txtRG, cc.xy(4, 6));
		builder.add(lblCelular, cc.xy(7, 6));
		builder.add(txtCelular, cc.xy(9, 6));
		builder.add(lblTelefone, cc.xy(2, 8));
		builder.add(txtTelefone, cc.xy(4, 8));
		builder.add(lblTelComercial, cc.xy(7, 8));
		builder.add(txtTelComercial, cc.xy(9, 8));
		builder.add(lblEmail, cc.xy(2, 10));
		builder.add(txtEmail, cc.xy(4, 10));
		builder.add(lblDtNascimento, cc.xy(7, 10));
		builder.add(dtNascimento, cc.xy(9, 10));
		builder.add(lblOBS, cc.xy(2, 12));
		builder.add(txtOBS, cc.xyw(4, 12, 6));
		builder.add(panelEndereco, cc.xyw(1, 14, 9));
		this.getContentPane().add(builder.getPanel());
		this.pack();
	}

	public void fechar() {
		this.dispose();
	}

	public EntidadeModelo getObjetoModelo() {
		return this.lojista;
	}

	public void setObjetoModelo(final EntidadeModelo entidade) {
		if (entidade == null) {
			this.lojista = new Lojista();
			presentation.setBean(this.lojista);
		} else {
			final Lojista lojistaNova = (Lojista) entidade;
			this.lojista = lojistaNova;
			presentation.setBean(lojistaNova);
		}

	}

}
