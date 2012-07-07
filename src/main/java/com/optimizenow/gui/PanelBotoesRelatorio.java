package com.optimizenow.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.optimizenow.presentation.STDSPresentation;
import com.optimizenow.util.Util;

public class PanelBotoesRelatorio {

	private JButton btnVisualizar;

	private JButton btnImprimir;

	private JButton btnSair;

	private InternalFrameRelatorio internalFrame;

	private JPanel panelBotoesRelatorio;

	private PanelPeriodo panelPeriodo;

	public PanelBotoesRelatorio() {
		initComponents();
		insertComponents();
	}

	private void initComponents() {
		btnVisualizar = new JButton();
		btnImprimir = new JButton();
		btnSair = new JButton();
		btnVisualizar.setIcon(new ImageIcon("images/VISUALIZAR.gif"));
		btnVisualizar.setToolTipText("Visualizar");
		btnImprimir.setIcon(new ImageIcon("images/IMPRIMIR.gif"));
		btnImprimir.setToolTipText("Imprimir");
		btnSair.setIcon(new ImageIcon("images/SAIR.gif"));
		btnSair.setToolTipText("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				internalFrame.fechar();
			}
		});
		
		btnVisualizar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					final JasperViewer viewer = new JasperViewer(PanelBotoesRelatorio.this.gerarRelatorio(), false);
					viewer.setTitle(internalFrame.getTitle());
					Util.maximizarJanela(viewer);
					viewer.setVisible(true);
				} catch (JRException e1) {
					JOptionPane.showMessageDialog(null, "Problema ao gerar o relatorio", "Erro", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				
			}
			
		});
		
		btnImprimir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					JasperPrintManager.printReport(gerarRelatorio(), true);
				} catch (JRException e1) {
					JOptionPane.showMessageDialog(null, "Problema ao gerar o relatorio", "Erro", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
			
		});
	}
	
	

	public JPanel getPanelBotoesRelatorio(final InternalFrameRelatorio internalFrame, PanelPeriodo periodo) {
		this.internalFrame = internalFrame;
		this.panelPeriodo = periodo;
		return panelBotoesRelatorio;
	}

	private void insertComponents() {
		final FormLayout layout = new FormLayout("p", // Colunas
				"p, 3dlu, p, 3dlu, p"); // Linhas
		final DefaultFormBuilder builder = new DefaultFormBuilder(layout);
		final CellConstraints cc = new CellConstraints();
		builder.add(btnVisualizar, cc.xy(1, 1));
		builder.add(btnImprimir, cc.xy(1, 3));
		builder.add(btnSair, cc.xy(1, 5));
		panelBotoesRelatorio = builder.getPanel();
	}

	private JasperPrint gerarRelatorio() throws JRException {
		final JasperReport report = JasperCompileManager.compileReport("reports/" + internalFrame.getNomeRelatorio() + ".jrxml");
		Map parametros = new HashMap();
		parametros = internalFrame.getParemetros();
		parametros.put("PER_DT_INICIO", (Date)(panelPeriodo.getDtInicio()));
		parametros.put("PER_DT_FIM", (Date)(panelPeriodo.getDtFim()));
		return JasperFillManager.fillReport(report, internalFrame.getParemetros(), new STDSPresentation(internalFrame.getObjetoModelo()).getConnection());
	}
}