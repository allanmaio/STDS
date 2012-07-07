package com.optimizenow.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.optimizenow.model.Loja;
import com.optimizenow.model.Ponto;
import com.optimizenow.model.UnidadeComercial;
import com.optimizenow.otimizacao.OtimizacaoInicializarException;
import com.optimizenow.otimizacao.OtimizarLoja;
import com.optimizenow.otimizacao.OtimizarUnidades;
import com.sun.org.apache.bcel.internal.generic.RETURN;


public class PanelPlantaOtimizada extends JPanel {

	private static final long serialVersionUID = 7590115418726409944L;

	protected Map<UnidadeComercial, Polygon> poligonos = new HashMap<UnidadeComercial, Polygon>();

	private List<Loja> listaLojas;

	private List<UnidadeComercial> listaUnidades;

	private int[] particaoLojas;

	private List<Loja> objetosEncontradosLojas;

	private int[] particaoUnidades;

	private List<UnidadeComercial> objetosEncontradosUnidades;

	private Map<UnidadeComercial, Loja> unidadeXLoja = new HashMap<UnidadeComercial, Loja>();

	private List<Loja> grupoLojas1 = new ArrayList<Loja>();

	private List<Loja> grupoLojas2 = new ArrayList<Loja>();

	private List<Loja> grupoLojas3 = new ArrayList<Loja>();

	private List<Loja> grupoLojas4 = new ArrayList<Loja>();

	private boolean exibirNomeLojas = false;

	private boolean exibirNumeroUnidades = false;

	public PanelPlantaOtimizada() {
		this.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				for (UnidadeComercial unidade : poligonos.keySet()) {
					Polygon poly = poligonos.get(unidade);
					if (poly.contains(e.getPoint())) {
						JOptionPane.showMessageDialog(null,
								"Unidade selecionada: "
										+ unidade.getNumero()
										+ " \n Loja: "
										+ unidadeXLoja.get(unidade)
												.getNomeFantasia(), "STDS", JOptionPane.INFORMATION_MESSAGE); 
												// + " Ponto: X " + e.getPoint().getX() + " Y " + e.getPoint().getY());
					}
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

	public void desenharPlanta(List unidades, List lojas) {
		listaLojas = lojas;
		listaUnidades = unidades;
		otimizarUnidades();
		otimizarLojas();
		List<UnidadeComercial> unidades2 = (List<UnidadeComercial>) objetosEncontradosUnidades;
		for (UnidadeComercial unidadeComercial : unidades2) {
			Polygon poly = new Polygon();
			List<Ponto> pontos = unidadeComercial.getPontos();
			Collections.sort(pontos);
			for (Ponto ponto : pontos) {
				poly.addPoint(ponto.getX(), ponto.getY());
			}
			poligonos.put(unidadeComercial, poly);
		}
		linkarUnidadeComLoja();
	}

	private void linkarUnidadeComLoja() {
		// monta grupos de lojas
		for (int i = 0; i < particaoLojas.length; i++) {
			switch (particaoLojas[i]) {
			case 0:
				grupoLojas1.add(objetosEncontradosLojas.get(i));
				break;
			case 1:
				grupoLojas2.add(objetosEncontradosLojas.get(i));
				break;
			case 2:
				grupoLojas3.add(objetosEncontradosLojas.get(i));
				break;
			case 3:
				grupoLojas4.add(objetosEncontradosLojas.get(i));
				break;
			default:
				break;
			}
		}

		// monta grupos de unidades e associa com loja do mesmo grupo
		for (int i = 0; i < particaoUnidades.length; i++) {
			switch (particaoUnidades[i]) {
			case 0:
				unidadeXLoja.put(objetosEncontradosUnidades.get(i),
						proximo(grupoLojas1));
				break;
			case 1:
				unidadeXLoja.put(objetosEncontradosUnidades.get(i),
						proximo(grupoLojas2));
				break;
			case 2:
				unidadeXLoja.put(objetosEncontradosUnidades.get(i),
						proximo(grupoLojas3));
				break;
			case 3:
				unidadeXLoja.put(objetosEncontradosUnidades.get(i),
						proximo(grupoLojas4));
				break;
			default:
				break;
			}
		}
	}

	private Loja proximo(List<Loja> lista) {
		Loja loja = null;
		if (lista.size() > 0) {
			for (Loja loja1 : lista) {
				loja = loja1;
				break;
			}
			lista.remove(loja);
		}
		return loja;
	}

	private void otimizarLojas() {
		OtimizarLoja otimizarLoja = new OtimizarLoja();
		particaoLojas = otimizarLoja.otimizarLoja(listaLojas);
		try {
			objetosEncontradosLojas = otimizarLoja.getObjetosEncontrados();
		} catch (OtimizacaoInicializarException e) {
			JOptionPane.showMessageDialog(null,
					"Otimização precisa ser feita antes de obter o resultado!");
			e.printStackTrace();
		}

	}

	private void otimizarUnidades() {
		OtimizarUnidades otimizarUnidades = new OtimizarUnidades();
		particaoUnidades = otimizarUnidades.otimizarUnidades(listaUnidades);
		try {
			objetosEncontradosUnidades = otimizarUnidades
					.getObjetosEncontrados();
		} catch (OtimizacaoInicializarException e) {
			JOptionPane.showMessageDialog(null,
					"Otimização precisa ser feita antes de obter o resultado!");
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(0));
		// g2.setColor(Color.GREEN);
		for (UnidadeComercial unidade : poligonos.keySet()) {
			Polygon poly = poligonos.get(unidade);
			double x = poly.getBounds2D().getCenterX();
			double y = poly.getBounds2D().getCenterY();
			g2.setFont(g2.getFont().deriveFont(15f).deriveFont(Font.BOLD));
			g2.setColor(Color.BLACK);
			g2.setStroke(new BasicStroke(3));
			g2.draw(poly);
			g2.setColor(Color.LIGHT_GRAY);
			g2.fill(poly);
/*
			g2.setColor(Color.CYAN);
			g2.fill(poly);
			g2.draw(poly);
			g2.setColor(Color.BLUE);
*/
			g2.setColor(Color.BLUE);
			if (unidadeXLoja.get(unidade) != null
					&& unidadeXLoja.get(unidade).getNomeFantasia() != null
					&& exibirNomeLojas) {
				g2.drawString(unidadeXLoja.get(unidade).getNomeFantasia(),
						(float) (x - unidadeXLoja.get(unidade)
								.getNomeFantasia().length() * 2),
						(float) y + 12);
			}
			if (unidade.getNumero() != null && exibirNumeroUnidades) {
				g2.drawString(unidade.getNumero(), (float) x, (float) y);
			}

		}
	}

	private Color corPorGrupo(UnidadeComercial unidade) {
		//Rever para não dar NullPointerException
		int grupo = 0;
		int indice = 0;
		for (int i = 0; i < objetosEncontradosUnidades.size(); i++) {
			if (objetosEncontradosUnidades.get(i).equals(unidade)) {
				indice = i;
			}
		}
		try {
			grupo = particaoUnidades[indice];
			switch (grupo) {
			case 0:
				return Color.CYAN;
			case 1:
				return Color.MAGENTA;
			case 2:
				return Color.GRAY;
			case 3:
				return Color.BLUE;
				
			default:
				break;
			}
			
		 } catch(NullPointerException e) {
			 e.printStackTrace();
		 }
		return null;
	}

	public void inibirNomeLojas() {
		exibirNomeLojas = !exibirNomeLojas;
		this.updateUI();
	}

	public void inibirNumeroUnidades() {
		exibirNumeroUnidades = !exibirNumeroUnidades;
		this.updateUI();
	}
}