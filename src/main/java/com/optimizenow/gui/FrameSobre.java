package com.optimizenow.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
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
import com.optimizenow.model.Ramo;
import com.optimizenow.presentation.LojaPresentationModel;
import com.optimizenow.presentation.STDSPresentation;

public class FrameSobre extends FrameCadastro {
    
	private static final long serialVersionUID = 1683266674241550240L;
	
	private final JLabel lblStds = new JLabel("STDS");

	private final JLabel lblDescricao = new JLabel("SISTEMA DE TOMADA DE DECISAO");

	private final JLabel lblProjeto = new JLabel("Projeto Final");

	private final JLabel lblAlunos = new JLabel("Alunos:");

	private final JLabel lblAllan = new JLabel("- ALLAN RIBEIRO CAMPOS MAIO");

	private final JLabel lblMarcos = new JLabel("- MARCOS PAULO NEVES DIAS DE OLIVEIRA");

	private final JLabel lblOrlando = new JLabel("- ORLANDO LINHARES DE OLIVEIRA");

	private final JLabel lblOrientador = new JLabel("Orientador:");
	
	private final JLabel lblSergio = new JLabel("- SERGIO ASSUNCAO MONTEIRO");
	
		public FrameSobre() {
				insertComponents();
	}
		private void insertComponents() {
		final FormLayout layout = new FormLayout(
				"f:p, r:p, 3dlu, p:g, 3dlu, r:p, 3dlu, p:g, 3dlu, p:g", // Colunas
				"p, 3dlu, p, 3dlu, p, 3dlu, p, 3dlu, p, 3dlu, p, 3dlu, p, 3dlu, " +
				"p, 3dlu, p, 3dlu, p, 3dlu, p, 3dlu, p, 3dlu, " +
				"p, 3dlu"); // Linhas
		final CellConstraints cc = new CellConstraints();
		final DefaultFormBuilder builder = new DefaultFormBuilder(layout);
		builder.setDefaultDialogBorder();
		builder.add(lblStds, cc.xy(4, 3));
		builder.add(lblDescricao, cc.xy(4, 5));
		builder.add(lblProjeto, cc.xy(4, 7));
		builder.add(lblAlunos, cc.xy(4, 13));
		builder.add(lblAllan, cc.xy(4, 15));
		builder.add(lblMarcos, cc.xy(4, 17));
		builder.add(lblOrlando, cc.xy(4, 19));
		builder.add(lblOrientador, cc.xy(4, 23));
		builder.add(lblSergio, cc.xy(4, 25));
		
		this.setTitle("Sobre o Sistema");
			
				
		this.getContentPane().add(builder.getPanel());
		this.pack();
	}

	public void fechar() {
		this.dispose();
	}
	
	public EntidadeModelo getObjetoModelo() {
		return null;
	}

	public void setObjetoModelo(final EntidadeModelo entidade) {
	}

	
	
}