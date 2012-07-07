package com.optimizenow.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.optimizenow.model.EntidadeModelo;
import com.optimizenow.presentation.STDSPresentation;

public abstract class FrameCadastro<T> extends JInternalFrame {

	private static final long serialVersionUID = 6310646468484703985L;

	private JButton btnSalvar;

	private JButton btnConsultar;

	private JButton btnExcluir;

	private JButton btnLimpar;

	private JButton btnSair;

	// protected JInternalFrame frame;

	private JPanel panelBotoesCadastro;

	protected STDSPresentation<T> presentation;

	public FrameCadastro() {
		initComponents();
		insertComponents();

	}

	private void initComponents() {
		// frame = new JInternalFrame();
		this.setClosable(true);
		this.setIconifiable(true);
		this.setMaximizable(true);
		this.setResizable(true);
		btnSalvar = new JButton();
		btnConsultar = new JButton();
		btnExcluir = new JButton();
		btnLimpar = new JButton();
		btnSair = new JButton();

		btnSalvar.setIcon(new ImageIcon("images/ALTERAR.gif"));
		btnSalvar.setToolTipText("Salvar");

		btnConsultar.setIcon(new ImageIcon("images/CONSULTAR.gif"));
		btnConsultar.setToolTipText("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					final List<T> lista = presentation.consultar(getObjetoModelo());
					if (lista.size() > 1) {
						final FrameResultadoConsulta frameResultado = new FrameResultadoConsulta(lista, FrameCadastro.this);
						TelaPrincipal.addInternalFrame(frameResultado);
					} else {
						setObjetoModelo((EntidadeModelo) lista.get(0));
					}
					btnExcluir.setEnabled(true);
				} catch (IndexOutOfBoundsException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null,
							"Nenhum registro encontrado!", "Aviso",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnExcluir.setEnabled(false);
		btnExcluir.setIcon(new ImageIcon("images/EXCLUIR.gif"));
		btnExcluir.setToolTipText("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final int resposta = JOptionPane.showConfirmDialog(null,
						"Deseja realmente excluir?", "Exclusão de Registro",
						JOptionPane.YES_NO_OPTION);
				if (resposta == JOptionPane.YES_OPTION) {
					presentation.excluir(getObjetoModelo());
					btnExcluir.setEnabled(false);
					limpar();
				}
			}
		});

		btnLimpar.setIcon(new ImageIcon("images/LIMPAR.gif"));
		btnLimpar.setToolTipText("Limpar");
		btnLimpar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				limpar();
			}

		});

		btnSalvar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				presentation.salvar(getObjetoModelo());
				limpar();
			}
		});

		btnSair.setIcon(new ImageIcon("images/SAIR.gif"));
		btnSair.setToolTipText("Sair");
		btnSair.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSairActionPerformed(evt);
			}
		});
	}

	protected abstract void setObjetoModelo(EntidadeModelo modelo);

	protected abstract T getObjetoModelo();

	private void btnSairActionPerformed(final ActionEvent evt) {
		this.dispose();
	}

	private void limpar() {
		btnExcluir.setEnabled(false);
		setObjetoModelo(null);
	}

	protected JPanel getBarraBotoesCadastro() {
		return panelBotoesCadastro;
	}

	private void insertComponents() {
		final FormLayout layoutPanelBotoes = new FormLayout(
				"p, 3dlu, p, 3dlu, p, 3dlu, p, 20dlu:grow(0.5), p, 3dlu, p, 20dlu:grow(0.5), p", // colunas
				"p, 3dlu, p, 3dlu"); // linhas

		final CellConstraints ccBotoes = new CellConstraints();

		final DefaultFormBuilder builderBotoes = new DefaultFormBuilder(
				layoutPanelBotoes);

		builderBotoes.add(btnSalvar, ccBotoes.xy(1, 1));
		builderBotoes.add(btnConsultar, ccBotoes.xy(3, 1));
		builderBotoes.add(btnExcluir, ccBotoes.xy(5, 1));
		builderBotoes.add(btnLimpar, ccBotoes.xy(9, 1));
		builderBotoes.add(btnSair, ccBotoes.xy(13, 1));
		builderBotoes.addSeparator(null, ccBotoes.xyw(1, 3, 13));
		panelBotoesCadastro = builderBotoes.getPanel();
	}

	public JInternalFrame getJInternalFrame() {
		return this;
	}
}
