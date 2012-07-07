package com.optimizenow.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.optimizenow.model.EntidadeModelo;
import com.optimizenow.model.Loja;
import com.optimizenow.model.UnidadeComercial;
import com.optimizenow.presentation.STDSPresentation;

public class FrameVisualizarPlanta<T> extends JInternalFrame implements
		InternalFrame {

	private static final long serialVersionUID = 3585939411576582755L;

	private JTabbedPane tabbedPanel;

	private PanelPlanta panelPlanta;

	private PanelPlantaOtimizada panelPlantaOtimizada;

	private final STDSPresentation<T> presentationUnidade = new STDSPresentation<T>(
			new UnidadeComercial());

	private final STDSPresentation<T> presentationLoja = new STDSPresentation<T>(
			new Loja());

	final private PanelOtimizar panelOtimizar = new PanelOtimizar();

	private JPanel panelBotoesVisualizacao;

	private JCheckBox chkVisualizarUnidades = new JCheckBox("Número Unidades");

	private JCheckBox chkVisualizarLojas = new JCheckBox("Nome Lojas (Somente na Planta Otimizada)");

	public FrameVisualizarPlanta() {
		initComponents();
		insertComponents();
	}

	private void initComponents() {
		tabbedPanel = new JTabbedPane();
		panelPlanta = new PanelPlanta();
		panelPlantaOtimizada = new PanelPlantaOtimizada();
		tabbedPanel.addTab("Planta", panelPlanta);
		tabbedPanel.addTab("Planta Otimizada", panelPlantaOtimizada);
		tabbedPanel.addTab("Otimizar", panelOtimizar.getPanel());
		final java.awt.Dimension screenSize = java.awt.Toolkit
				.getDefaultToolkit().getScreenSize();
		tabbedPanel.setPreferredSize(new Dimension(screenSize.width - 20,
				screenSize.height - 100));
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setResizable(true);
		setTitle("Planta");
		FormLayout layout = new FormLayout("p, p, p", "p");
		DefaultFormBuilder builder = new DefaultFormBuilder(layout);
		CellConstraints cc = new CellConstraints();
		builder.addLabel("Exibir: ", cc.xy(1, 1));
		builder.add(chkVisualizarUnidades, cc.xy(2, 1));
		builder.add(chkVisualizarLojas, cc.xy(3, 1));
		panelBotoesVisualizacao = builder.getPanel();

	}

	private void insertComponents() {
		final FormLayout layout = new FormLayout("p:g", // Colunas
				"p, p:g"); // Linhas
		final DefaultFormBuilder builder = new DefaultFormBuilder(layout);
		final CellConstraints cc = new CellConstraints();
		builder.add(panelBotoesVisualizacao, cc.xy(1, 1));
		builder.add(tabbedPanel, cc.xy(1, 2));

		this.getContentPane().add(builder.getPanel());

		panelPlanta.desenharPlanta(presentationUnidade.findAll());
		panelPlantaOtimizada.desenharPlanta(presentationUnidade.findAll(),
				presentationLoja.findAll());
		pack();
		chkVisualizarLojas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPlantaOtimizada.inibirNomeLojas();
			}
		});
		
		chkVisualizarUnidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPlantaOtimizada.inibirNumeroUnidades();
				panelPlanta.inibirNumeroUnidades();
			}
		});

	}

	public void fechar() {
		this.dispose();
	}

	public EntidadeModelo getObjetoModelo() {
		return null;
	}

	public void setObjetoModelo(final EntidadeModelo entidade) {
		// Apagar quando fizer refactoring para retirar InternalFrame
	}

}
