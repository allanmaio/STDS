package com.optimizenow.gui;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.sf.nachocalendar.components.DateField;

import com.jgoodies.binding.adapter.BasicComponentFactory;
import com.jgoodies.binding.adapter.Bindings;
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.optimizenow.model.EntidadeModelo;
import com.optimizenow.model.UnidadeComercial;
import com.optimizenow.presentation.STDSPresentation;

public class FrameCadastrarUnidadeComercial<T> extends FrameCadastro {

	private static final long serialVersionUID = -184533781702659181L;

	private JCheckBox cbxAtiva = new JCheckBox();

	private final JLabel lblArea = new JLabel("\u00c1rea(m\u00b2)");

	private final JLabel lblDtInicio = new JLabel("Data de Inicio");

	private final JLabel lblDtTermino = new JLabel("Data de Termino");

	private final JLabel lblNumero = new JLabel("N\u00famero");

	private final DateField dtInicio = new DateField();

	private final DateField dtFim = new DateField();

	private JTextField txtArea;

	private JTextField txtNumero;

	private UnidadeComercial unidadeComercial = new UnidadeComercial();

	private JPanel panelBotoesCadastro;

	public FrameCadastrarUnidadeComercial() {
		presentation = new STDSPresentation<T>(
				unidadeComercial);
		initComponents();
		insertComponents();
	}

	private void initComponents() {
		txtNumero = BasicComponentFactory.createTextField(presentation
				.getModel(UnidadeComercial.NUMERO), false);
		txtArea = new JTextField();
		Bindings.bind(txtArea, new DoubleDecimalConverter(presentation.getModel(UnidadeComercial.AREA)));
		cbxAtiva = BasicComponentFactory.createCheckBox(presentation
				.getModel(UnidadeComercial.ATIVA), "Ativa");

		Bindings.bind(dtFim.getFormattedTextField(), presentation
				.getModel(UnidadeComercial.DT_FIM));
		Bindings.bind(dtInicio.getFormattedTextField(), presentation
				.getModel(UnidadeComercial.DT_INICIO));

		this.setTitle("Cadastrar Unidades Comerciais");
		lblDtInicio.setText("Data de In\u00edcio");
		lblDtTermino.setText("Data de T\u00e9rmino");
		panelBotoesCadastro = getBarraBotoesCadastro();
	}

	private void insertComponents() {
		final FormLayout layout = new FormLayout(
				"f:p, r:p, 3dlu, p:g, 10dlu, r:p, 3dlu, p:g", // colunas
				"p, p, 3dlu, p, 3dlu, p"); // linhas
		final CellConstraints cc = new CellConstraints();
		final DefaultFormBuilder builder = new DefaultFormBuilder(layout);
		builder.setDefaultDialogBorder();
		builder.add(panelBotoesCadastro, cc.xyw(1, 1, 8));
		builder.add(lblNumero, cc.xy(2, 2));
		builder.add(txtNumero, cc.xy(4, 2));
		builder.add(lblDtInicio, cc.xy(6, 2));
		builder.add(dtInicio, cc.xy(8, 2));
		builder.add(lblArea, cc.xy(2, 4));
		builder.add(txtArea, cc.xy(4, 4));
		builder.add(lblDtTermino, cc.xy(6, 4));
		builder.add(dtFim, cc.xy(8, 4));
		builder.add(cbxAtiva, cc.xy(2, 6));
		this.getContentPane().add(builder.getPanel());
		this.pack();
	}

	public void fechar() {
		this.dispose();
	}

	public EntidadeModelo getObjetoModelo() {
		return this.unidadeComercial;
	}

	public void setObjetoModelo(final EntidadeModelo entidade) {
		if (entidade == null) {
			this.unidadeComercial = new UnidadeComercial();
			presentation.setBean(this.unidadeComercial);
		} else {
			final UnidadeComercial unidadeNova = (UnidadeComercial) entidade;
			this.unidadeComercial = unidadeNova;
			presentation.setBean(unidadeNova);
		}
	}

}