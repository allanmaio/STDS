package com.optimizenow.otimizacao;

import java.util.List;

import com.optimizenow.model.Loja;


public class OtimizarLoja {
	
	private List<Loja> objetosEcontradosOtimizados;
	
	private boolean otimizou = false;

	public int[] otimizarLoja(List<Loja> objetosEncontrados) {
		
		//final List objetosEncontrados = presentation.findAll();
		int numeroObjetosValidos = 0;
		final int numeroObjetos = objetosEncontrados.size();
		double[][] matrizDados = new double[numeroObjetos][3];
		final int numeroClusters = 4;
		final int numeroCaracteristicas = 3;

		for (int i = 0; i < objetosEncontrados.size(); i++) {
			final Loja loja = (Loja) objetosEncontrados.get(i);
			if (loja.getRamo() != null && loja.getVendas() != null
					&& loja.getFluxoPessoas() != null) {
				numeroObjetosValidos++;
			} else {
				objetosEncontrados.remove(i);
			}

		}
		
		
		for (int i = 0; i < numeroObjetosValidos; i++) {
			matrizDados[i][0] = ((Loja) objetosEncontrados.get(i)).getRamo()
					.getID();
			matrizDados[i][1] = ((Loja) objetosEncontrados.get(i)).getVendas()
					.doubleValue();
			matrizDados[i][2] = ((Loja) objetosEncontrados.get(i))
					.getFluxoPessoas();

		}

		final JForgyHeterogeneo forgy = new JForgyHeterogeneo(numeroObjetosValidos, numeroClusters,
				numeroCaracteristicas, matrizDados);
		forgy.forgy();

		int[] particao = forgy.getParticao();
		objetosEcontradosOtimizados = objetosEncontrados;
		otimizou = true;
		return particao;
	}
	
	public List<Loja> getObjetosEncontrados() throws OtimizacaoInicializarException {
		if (otimizou == false) {
			throw new OtimizacaoInicializarException();
		}
		return objetosEcontradosOtimizados; 
	}

}
