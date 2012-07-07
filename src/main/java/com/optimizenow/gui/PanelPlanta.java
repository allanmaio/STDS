package com.optimizenow.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.NumericShaper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.hibernate.criterion.ExistsSubqueryExpression;

import com.optimizenow.model.Ponto;
import com.optimizenow.model.UnidadeComercial;


public class PanelPlanta<T> extends JPanel {

	private static final long serialVersionUID = 7590115418726409944L;
	protected Map<UnidadeComercial, Polygon> poligonos = new HashMap<UnidadeComercial, Polygon>();
	private boolean exibirNumeroUnidades = false;

	public PanelPlanta() {
		this.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {
				for (UnidadeComercial unidade : poligonos.keySet()) {
					Polygon poly = poligonos.get(unidade);
					if (poly.contains(e.getPoint())) {
						JOptionPane.showMessageDialog(null, "Unidade selecionada: " + unidade.getNumero(), "STDS", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	public void desenharPlanta(List<T> unidades) {
		List<UnidadeComercial> unidades2 = (List<UnidadeComercial>) unidades;
		for (UnidadeComercial unidadeComercial : unidades2) {
			Polygon poly = new Polygon();
			List<Ponto> pontos = unidadeComercial.getPontos();
			Collections.sort(pontos);
			for (Ponto ponto : pontos) {
				poly.addPoint(ponto.getX(), ponto.getY());
			}
			poligonos.put(unidadeComercial, poly);
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(0));
		g2.setColor(Color.GREEN);
		for (UnidadeComercial unidade : poligonos.keySet()) {
			Polygon poly = poligonos.get(unidade);
			double x = poly.getBounds2D().getCenterX();
			double y = poly.getBounds2D().getCenterY();
			//g2.drawRect(poly.getBounds()., y, width, height)
			//g2.setColor(Color.BLACK);
			//g2.drawPolygon(poly);
			g2.setColor(Color.BLACK);
			g2.setStroke(new BasicStroke(3));
			g2.draw(poly);
			g2.setColor(Color.BLUE);
			g2.fill(poly);
			g2.setFont(g2.getFont().deriveFont(15f).deriveFont(Font.BOLD));
			g2.setColor(Color.BLACK);
			if (unidade.getNumero() != null && exibirNumeroUnidades) {
				g2.drawString(unidade.getNumero(), (float)x, (float)y);
			}
			g2.setColor(Color.BLUE);
		}
	}
	public void inibirNumeroUnidades() {
		exibirNumeroUnidades = !exibirNumeroUnidades;
		this.updateUI();
	}

}
