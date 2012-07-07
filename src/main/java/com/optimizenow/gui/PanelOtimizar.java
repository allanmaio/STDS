package com.optimizenow.gui;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import com.jgoodies.binding.list.SelectionInList;
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.debug.FormDebugPanel;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.optimizenow.model.Loja;
import com.optimizenow.otimizacao.JForgyHeterogeneo;
import com.optimizenow.otimizacao.OtimizacaoInicializarException;
import com.optimizenow.otimizacao.OtimizarLoja;
import com.optimizenow.presentation.STDSPresentation;

public class PanelOtimizar<T> {

	private static final long serialVersionUID = -7016392097954669526L;

	private JPanel panel;

	private JList listaGrupo1, listaGrupo2, listaGrupo3, listaGrupo4;

	final private STDSPresentation<T> presentation = new STDSPresentation<T>(
			new Loja());

	final private List grupo1 = new ArrayList();

	final private List grupo2 = new ArrayList();

	final private List grupo3 = new ArrayList();

	final private List grupo4 = new ArrayList();

	private JLabel lblGrupo1 = new JLabel("Grupo 1");
	
	private JLabel lblGrupo2 = new JLabel("Grupo 2");
	
	private JLabel lblGrupo3 = new JLabel("Grupo 3");
	
	private JLabel lblGrupo4 = new JLabel("Grupo 4");

	private int[] particao;

	private List<Loja> objetosEncontrados;

	public PanelOtimizar() {
		initComponents();
		insertComponents();
	}

	private void initComponents() {

		OtimizarLoja otimizarLoja = new OtimizarLoja();
		particao = otimizarLoja.otimizarLoja(presentation.findAll());
		try {
			objetosEncontrados = otimizarLoja.getObjetosEncontrados();
		} catch (OtimizacaoInicializarException e) {
			JOptionPane.showMessageDialog(null, "Otimização precisa ser feita antes de objer o resultado!");
			e.printStackTrace();
		}
		preencherGrupos(objetosEncontrados, particao);
		
		lblGrupo1.setFont(trocaAtributosFonte(lblGrupo1));
		lblGrupo2.setFont(trocaAtributosFonte(lblGrupo2));
		lblGrupo3.setFont(trocaAtributosFonte(lblGrupo3));
		lblGrupo4.setFont(trocaAtributosFonte(lblGrupo4));

		listaGrupo1 = new JList();
		listaGrupo1.setFont(trocaAtributosFonte(listaGrupo1));
		listaGrupo1.setModel(new SelectionInList(grupo1));

		listaGrupo2 = new JList();
		listaGrupo2.setFont(trocaAtributosFonte(listaGrupo2));
		listaGrupo2.setModel(new SelectionInList(grupo2));

		listaGrupo3 = new JList();
		listaGrupo3.setFont(trocaAtributosFonte(listaGrupo3));
		listaGrupo3.setModel(new SelectionInList(grupo3));

		listaGrupo4 = new JList();
		listaGrupo4.setFont(trocaAtributosFonte(listaGrupo4));
		listaGrupo4.setModel(new SelectionInList(grupo4));

	}

	private Font trocaAtributosFonte(JLabel label) {
		return label.getFont().deriveFont(Font.BOLD).deriveFont(22f);
	}

	private Font trocaAtributosFonte(final JList lista) {
		return lista.getFont().deriveFont(Font.BOLD).deriveFont(22f);
	}

	private void preencherGrupos(final List objetosEncontrados, final int[] particao) {
		for (int i = 0; i < particao.length; i++) {
			switch (particao[i]) {
			case 0:
				grupo1.add(objetosEncontrados.get(i));
				break;
			case 1:
				grupo2.add(objetosEncontrados.get(i));
				break;
			case 2:
				grupo3.add(objetosEncontrados.get(i));
				break;
			case 3:
				grupo4.add(objetosEncontrados.get(i));
				break;
			default:
				break;
			}
		}
	}

	private void insertComponents() {
		final FormLayout layout = new FormLayout(
				"p:g, 3dlu, p:g, 3dlu, p:g, 3dlu, p:g", // Colunas
				"p, 6dlu, t:p"); // Linhas
		final DefaultFormBuilder builder = new DefaultFormBuilder(layout);
		builder.setDefaultDialogBorder();
		final CellConstraints cc = new CellConstraints();
		builder.add(lblGrupo1 , cc.xy(1, 1));
		builder.add(lblGrupo2, cc.xy(3, 1));
		builder.add(lblGrupo3, cc.xy(5, 1));
		builder.add(lblGrupo4, cc.xy(7, 1));
		builder.add(listaGrupo1, cc.xy(1, 3));
		builder.add(listaGrupo2, cc.xy(3, 3));
		builder.add(listaGrupo3, cc.xy(5, 3));
		builder.add(listaGrupo4, cc.xy(7, 3));

		this.panel = builder.getPanel();
	}

	public JPanel getPanel() {
		this.panel.setVisible(true);
		return this.panel;
	}

}
