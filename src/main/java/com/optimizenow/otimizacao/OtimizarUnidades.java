package com.optimizenow.otimizacao;

import java.awt.Polygon;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.optimizenow.model.Ponto;
import com.optimizenow.model.UnidadeComercial;


public class OtimizarUnidades {

	private List<UnidadeComercial> objetosEcontradosOtimizados;

	private UnidadeComercial[] unidades;

	private boolean otimizou = false;

	private Map<Polygon, UnidadeComercial> unidadesXPoligonos = new HashMap<Polygon, UnidadeComercial>();

	private Polygon[] poligonos;

	public int[] otimizarUnidades(List<UnidadeComercial> objetosEncontrados) {

		int numeroObjetosValidos = 0;
		final int numeroObjetos = objetosEncontrados.size();
		final int numeroCaracteristicas = 2;
		double[][] matrizDados = new double[numeroObjetos][numeroCaracteristicas];
		final int numeroClusters = 4;

		for (int i = 0; i < objetosEncontrados.size(); i++) {
			final UnidadeComercial unidadeComercial = (UnidadeComercial) objetosEncontrados
					.get(i);
			if (unidadeComercial.getPontos().size() > 0) {
				List<Ponto> pontos = unidadeComercial.getPontos();
				Collections.sort(pontos);
				Polygon poly = new Polygon();
				for (Ponto p : unidadeComercial.getPontos()) {
					poly.addPoint(p.getX(), p.getY());
				}
				numeroObjetosValidos++;
				unidadesXPoligonos.put(poly, unidadeComercial);

			} else {
				objetosEncontrados.remove(i);
			}
		}
		unidades = new UnidadeComercial[objetosEncontrados.size()];
		poligonos = new Polygon[objetosEncontrados.size()];

		for (int i = 0; i < objetosEncontrados.size(); i++) {
			unidades[i] = objetosEncontrados.get(i);
			if (unidades[i].getPontos().size() > 0) {
				List<Ponto> pontos = unidades[i].getPontos();
				Collections.sort(pontos);
				Polygon poly = new Polygon();
				for (Ponto p : unidades[i].getPontos()) {
					poly.addPoint(p.getX(), p.getY());
				}
				poligonos[i] = poly;
			}
		}


		for (int j = 0; j < numeroObjetosValidos; j++) {
			try {
				matrizDados[j][0] = poligonos[j].getBounds2D().getCenterX();
				matrizDados[j][1] = poligonos[j].getBounds2D().getCenterY();
			} catch(NullPointerException e) {
				e.printStackTrace();
			}
		}

		final JForgyHomogeneo forgy = new JForgyHomogeneo(numeroObjetosValidos, numeroClusters,
				numeroCaracteristicas, matrizDados);
		forgy.forgy();

		int[] particao = forgy.getParticao();

		objetosEcontradosOtimizados = objetosEncontrados;
		otimizou = true;
		return particao;
	}

	public List<UnidadeComercial> getObjetosEncontrados() throws OtimizacaoInicializarException {

		if (otimizou == false) {
			throw new OtimizacaoInicializarException();
		}
		return objetosEcontradosOtimizados;
	}

}
