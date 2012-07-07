package com.optimizenow.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.table.TableModel;


import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.optimizenow.model.EntidadeModelo;
import com.vlsolutions.swing.table.VLJTable;
import com.vlsolutions.swing.table.filters.RegExpFilter;

public class FrameResultadoConsulta<T> extends JInternalFrame {

	private static final long serialVersionUID = -3438874610472418404L;

	private final List<T> listaComResultados;

	private VLJTable table;

	private JScrollPane scrollPane;

	private JButton botaoFiltro;
	
	final private FrameCadastro frame;

	public FrameResultadoConsulta(List<T> object, FrameCadastro frame) {
		listaComResultados = object;
		this.frame = frame;
		initComponents();
		insertComponents();
	}

	public void initComponents() {
		table = new VLJTable();
		botaoFiltro = new JButton("Filtrar");
		botaoFiltro.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				table.setFilterHeaderVisible(!table.isFilterHeaderVisible());
				
			}
			
		});
		this.setTitle("Resultado da consulta");
		this.setClosable(true);
		this.setIconifiable(true);
		this.setMaximizable(true);
		this.setResizable(true);
		final TableModel model = TableModelFactory.getTableModel(listaComResultados);
		table.setFilteringEnabled(true);
		table.setPopUpSelectorEnabled(true);
		table.getPopUpSelector().setCaseSensitive(false);

		table.setModel(model);
		for (int i = 0; i< model.getColumnCount(); i++) {
			table.installFilter(i, new RegExpFilter(true));
		}
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(table.getPreferredScrollableViewportSize());
		table.setFilterHeaderVisible(false);
		table.addMouseListener(new MouseListener() {

			

			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() >= 2) {
					//STDSTableModel model = (STDSTableModel) table.getModel(); 
					frame.setObjetoModelo((EntidadeModelo) ((STDSTableModel)model).getRow(table.getSelectedRow()));
					System.out.println("Clicou");
					FrameResultadoConsulta.super.dispose();
				}
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}
			
		});
		
	}

	public void insertComponents() {
		final FormLayout layout = new FormLayout("p, p:g, p", // Linha
				"p"); // Colunas
		final CellConstraints cc = new CellConstraints();
		final DefaultFormBuilder builder = new DefaultFormBuilder(layout);
		builder.setDefaultDialogBorder();
		builder.addLabel("Escolha um objeto:", cc.xy(1, 1));
		builder.add(scrollPane, cc.xy(2, 1));
		builder.add(botaoFiltro, cc.xy(3, 1));
		this.getContentPane().add(builder.getPanel());
		pack();
	}

	public EntidadeModelo getObjetoSelecionado() {
		return null;
	}

}
