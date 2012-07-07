package com.optimizenow.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.table.AbstractTableModel;


import com.jgoodies.binding.adapter.BasicComponentFactory;
import com.jgoodies.binding.list.ArrayListModel;
import com.jgoodies.binding.list.SelectionInList;
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.optimizenow.model.EntidadeModelo;
import com.optimizenow.model.Ponto;
import com.optimizenow.model.UnidadeComercial;
import com.optimizenow.presentation.STDSPresentation;

public class FrameCadastrarPonto<T> extends FrameCadastro {

	private static final long serialVersionUID = -3611404274725377153L;

	private JComboBox cbxUnidade;

	private JScrollPane jScrollPane1;

	private JLabel lblUnidade;

	private JTable tablePontos;

	private UnidadeComercial unidadeComercial = new UnidadeComercial();

	private Ponto ponto;

	private JPanel panelBotoesCadastro;

	private SelectionInList selectionInListUnidades;

	private PontoTableAdapter modelo;

	private JButton botaoAdicionarPonto;

	public FrameCadastrarPonto() {
		presentation = new STDSPresentation<T>(
				unidadeComercial);
		initComponents();
		insertComponents();
	}

	private void initComponents() {
		lblUnidade = new JLabel("Unidade");
		cbxUnidade = new JComboBox();
		botaoAdicionarPonto = new JButton("Adicinar Ponto");
		selectionInListUnidades = new SelectionInList(presentation.findAll());
		cbxUnidade = BasicComponentFactory
				.createComboBox(selectionInListUnidades);

		modelo = new PontoTableAdapter(new UnidadeComercial(), new String[] {
				"Ordem", "X", "Y" });
		tablePontos = new JTable();
		tablePontos.setModel(modelo);
		tablePontos.setSurrendersFocusOnKeystroke(true);

		this.setTitle("Cadastrar Pontos");
		jScrollPane1 = new JScrollPane(tablePontos);

		jScrollPane1.setPreferredSize(tablePontos
				.getPreferredScrollableViewportSize());

		panelBotoesCadastro = getBarraBotoesCadastro();

		botaoAdicionarPonto.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				modelo.addEmptyRow();
				modelo = new PontoTableAdapter(unidadeComercial, new String[] {
						"Ordem", "X", "Y" });
				tablePontos.setModel(modelo);

			}

		});

		cbxUnidade.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				unidadeComercial = (UnidadeComercial) e.getItem();
				modelo = new PontoTableAdapter(unidadeComercial, new String[] {
						"Ordem", "X", "Y" });
				tablePontos.setModel(modelo);
			}
		});

		if (cbxUnidade.getItemCount() != 0) {
			cbxUnidade.setSelectedIndex(0);
		}

	}

	private void insertComponents() {
		final FormLayout layout = new FormLayout("f:p, p:g, 3dlu, p:g, 3dlu, p:g", // Colunas
				"p, p, 3dlu, p:g"); // Linhas
		final CellConstraints cc = new CellConstraints();
		final DefaultFormBuilder builder = new DefaultFormBuilder(layout);
		builder.setDefaultDialogBorder();
		builder.add(panelBotoesCadastro, cc.xyw(1, 1, 6));
		builder.add(lblUnidade, cc.xy(2, 2));
		builder.add(cbxUnidade, cc.xy(4, 2));
		builder.add(botaoAdicionarPonto, cc.xy(6, 2));
		builder.add(jScrollPane1, cc.xyw(1, 4, 6));
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
		} else {
			final UnidadeComercial unidadeNova = (UnidadeComercial) entidade;
			this.unidadeComercial = unidadeNova;
		}
	}

	private class PontoTableAdapter extends AbstractTableModel {

		private static final long serialVersionUID = -7876756798722948010L;

		private ListModel listModel;

		@Override
		public boolean isCellEditable(final int rowIndex, final int columnIndex) {
			return true;
		}

		private void reiniciaListaElementos(final ArrayListModel listaNova) {
			for (int i = 0; i < listModel.getSize(); i++) {
				listaNova.add(listModel.getElementAt(i));
			}
			this.listModel = listaNova;
			listModel.addListDataListener(createChangeHandler());
			setObjetoModelo(unidadeComercial);
		}

		private final String[] columnNames;

		public PontoTableAdapter(UnidadeComercial unidadeComercial) {
			this(unidadeComercial, null);
		}

		public PontoTableAdapter(final UnidadeComercial unidadeComercial,
				String[] columnNames) {
			if (unidadeComercial.getPontos() != null
					&& unidadeComercial.getPontos().size() != 0) {
				this.listModel = new ArrayListModel(unidadeComercial
						.getPontos());
			} else {
				this.listModel = new ArrayListModel();
			}

			if (listModel == null) {
				throw new NullPointerException(
				"The list model must not be null.");
			}
			if (columnNames == null) {
				this.columnNames = null;
			} else {
				this.columnNames = new String[columnNames.length];
				System.arraycopy(columnNames, 0, this.columnNames, 0,
						columnNames.length);
			}
			listModel.addListDataListener(createChangeHandler());
		}

		public int getColumnCount() {
			return columnNames.length;
		}

		public String getColumnName(final int columnIndex) {
			return columnNames[columnIndex];
		}

		public final int getRowCount() {
			return listModel.getSize();
		}

		protected final Object getRow(final int index) {
			return listModel.getElementAt(index);
		}

		public Object getValueAt(final int rowIndex, final int columnIndex) {
			System.out.println(getRow(rowIndex));
			if (getRow(rowIndex) instanceof Ponto) {
				System.out.println(" ROWINDEX= " + rowIndex + " COLUMNINDEX= "
						+ columnIndex + "--------" + ponto);
				ponto = (Ponto) getRow(rowIndex);
				switch (columnIndex) {
				case 0:
					return ponto.getOrdem();
				case 1:
					return ponto.getX();
				case 2:
					return ponto.getY();
				default:
					return null;
				}
			} else {
				return null;
			}
		}

		@Override
		public void setValueAt(final Object aValue, final int rowIndex, final int columnIndex) {
			final ArrayListModel listaNova = new ArrayListModel();
			reiniciaListaElementos(listaNova);
			switch (columnIndex) {
			case 0:
				ponto.setOrdem(Integer.parseInt((String) aValue));
				break;
			case 1:
				ponto.setX(Integer.parseInt((String) aValue));
				break;
			case 2:
				ponto.setY(Integer.parseInt((String) aValue));
				break;
			default:
				break;
			}
		}

		public boolean hasEmptyRow() {
			System.out.println("Tamanho da listModel= " + listModel.getSize());
			return listModel.getSize() == 0;
		}

		public void addEmptyRow() {
			final ArrayListModel listaNova = new ArrayListModel();
			final List pontos = unidadeComercial.getPontos();
			pontos.add(new Ponto());
			reiniciaListaElementos(listaNova);
		}

		protected ListDataListener createChangeHandler() {
			return new ListDataChangeHandler();
		}

		private final class ListDataChangeHandler implements ListDataListener {

			public void intervalAdded(final ListDataEvent evt) {
				fireTableRowsInserted(evt.getIndex0(), evt.getIndex1());
			}

			public void intervalRemoved(final ListDataEvent evt) {
				fireTableRowsDeleted(evt.getIndex0(), evt.getIndex1());
			}

			public void contentsChanged(final ListDataEvent evt) {
				final int firstRow = evt.getIndex0();
				final int lastRow = evt.getIndex1();
				fireTableRowsUpdated(firstRow, lastRow);
			}

		}

	}
}
