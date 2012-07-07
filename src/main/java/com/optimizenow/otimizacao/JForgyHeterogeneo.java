package com.optimizenow.otimizacao;

/**
 * O objetivo desta classe é agrupar elementos heterogêneos.
 */
public class JForgyHeterogeneo {
	/**
	 * Matriz de Dados dos Objetos composta pelo Numero de objetos X Numero de
	 * Caracteristicas
	 */
	private double matrizDeDados[][];

	/**
	 * Número de Iterações
	 */
	private int numeroDeIteracoesF;

	/**
	 * Número de Objetos
	 */
	private int numeroDeObjetos;

	/**
	 * Número de Clusters
	 */
	private int numeroDeClusters;

	/**
	 * Particoes, indica que o elemento referente a posicao i se encontra no
	 * grupo particao[i]
	 */
	private int particao[];

	/**
	 * Matriz de Centróides (o valor todas das colunas representa o total de
	 * carasteristicas e o valor total das linhas o numero total de clusters
	 */
	private double matrizDeCentroides[][];

	/**
	 * Número de Características
	 */
	private int numeroDeCaracteristicas;

	/**
	 * Número de Iterações Máximas
	 */
	final private int numeroDeIteracoesMaximasF;

	/**
	 * Construtor da classe JForgyHeterogeneo
	 * @param numeroDeObjetos
	 * @param numeroDeClusters
	 * @param numeroDeCaracteristicas
	 * @param matrizDeDados
	 */
	public JForgyHeterogeneo(int numeroDeObjetos, int numeroDeClusters, int numeroDeCaracteristicas,
			double matrizDeDados[][]) {
		numeroDeIteracoesMaximasF = 100;
		setNumeroDeClusters(numeroDeClusters);
		setNumeroDeObjetos(numeroDeObjetos);
		setParticao();
		setCaracteristicas(numeroDeCaracteristicas);
		setMatrizDeCentroides();
		setMatrizDeDados(matrizDeDados);
	}

	/**
	 * @return o número de clusters
	 */
	public int getNumeroDeClusters() {
		return numeroDeClusters;
	}

	/**
	 * @param numeroDeClusters
	 */
	public void setNumeroDeClusters(final int numeroDeClusters) {
		this.numeroDeClusters = numeroDeClusters;
	}

	/**
	 * @return Numero de objetos
	 */
	public int getNumeroDeObjetos() {
		return this.numeroDeObjetos;
	}

	/**
	 * @param numeroDeObjetos
	 */
	public void setNumeroDeObjetos(final int numeroDeObjetos) {
		this.numeroDeObjetos = numeroDeObjetos;
	}

	/**
	 * @return particao que contem as informações sobre o grupo de cada elemento
	 */
	public int[] getParticao() {
		return particao;
	}

	/**
	 * @param particao
	 */
	public void setParticao(final int[] particao) {
		this.particao = particao;
	}

	/**
	 * 
	 * Cria o vetor de partição inicial com o tamanho sendo o numero de objetos
	 */
	private void setParticao() {
		particao = new int[getNumeroDeObjetos()];
	}

	/**
	 * Cria a matriz de centroides com o tamanho do numero de caracteristicas X numero de clusters
	 *
	 */
	private void setMatrizDeCentroides() {
		matrizDeCentroides = new double[getCaracteristicas()][getNumeroDeClusters()];
	}

	/**
	 * 
	 * @return Numero de caracteristicas
	 */
	public int getCaracteristicas() {
		return numeroDeCaracteristicas;
	}

	/**
	 * 
	 * @param numeroDeCarcteristicas
	 */
	public void setCaracteristicas(final int numeroDeCarcteristicas) {
		numeroDeCaracteristicas = numeroDeCarcteristicas;
	}

	/**
	 * 
	 * @param matrizDeDados
	 */
	public final void setMatrizDeDados(final double matrizDeDados[][]) {
		this.matrizDeDados = matrizDeDados;
	}

	/**
	 * 
	 * @return numero de iteracoes Forgy
	 */
	public int getNumeroDeIteracoesF() {
		return numeroDeIteracoesF;
	}

	/**
	 * Este metodo esta setando o numero de iteracoes como 0 pois esse numero nao podera ser definido externamente
	 * @param numeroDeIteracoesF
	 */
	public void setNumeroDeIteracoesF(int numeroDeIteracoesF) {
		this.numeroDeIteracoesF = 0;
	}

	/**
	 * 
	 * @param vetor
	 */
	private void zerarVetor(double vetor[]) {
		for (int i = 0; i < vetor.length; i++)
			vetor[i] = 0.0;
	}

	/**
	 * 
	 * @param matriz
	 */
	private void zerarMatriz(double matriz[][]) {
		for (int i = 0; i < matriz.length; i++)
			for (int j = 0; j < matriz[0].length; j++)
				matriz[i][j] = 0.0;
	}

	/**
	 * Gera a particao inicial
	 *
	 */
	private void inicial() {

		int cont = -1;

		for (int i = 0; i < getNumeroDeObjetos(); i++) // (*Alocação Inicial*)
		{
			if (cont < getNumeroDeClusters() - 1)
				cont++;
			else
				cont = 0;

			particao[i] = cont;
		}// for
	}

	/**
	 * Faz os agrupamentos.
	 */
	public void forgy() {

		int cont;
		double f_Atual; // Função Objetivo Atual
		double f_Ant; // Função Objetivo Anterior
		double somat; // Somatório
		double somatorio[] = new double[getCaracteristicas()];
		double erro_Forgy;

		inicial();

		setNumeroDeIteracoesF(0);
		// Inicialização
		f_Atual = 1e+300;

		do {
			numeroDeIteracoesF++;
			f_Ant = f_Atual;
			f_Atual = 0;
			zerarMatriz(matrizDeCentroides);
			setMatrizDeCentroides();
			/* Calculando as Centróides */
			for (int i = 0; i < getNumeroDeClusters(); i++) {
				cont = 0;
				zerarVetor(somatorio);

				for (int j = 0; j < getNumeroDeObjetos(); j++) { /* Número de Clientes */
					if (i == particao[j]) { /*
											 * Se o objeto i estiver alocado em
											 * P[i], então faça
											 */
						for (int k = 0; k < getCaracteristicas(); k++) {
							somatorio[k] = somatorio[k] + matrizDeDados[j][k];
						}
						cont++;
					}/* if (i==particao[j]) */
				}/* for(int j=0; j<getNumObj(); j++) */

				if (cont > 0) {
					for (int k = 0; k < getCaracteristicas(); k++)
						matrizDeCentroides[k][i] = somatorio[k] / cont; /*
																		 * Cálculo
																		 * dos
																		 * Centróides
																		 */
				}/* if(Cont<>0) */

			}/* for(int i=0;i<getNum_Cl();i++) */

			if (f_Atual > f_Ant) /* Encontrar pontos distantes */
				realoca();
			// -----------------------------------------------------------
			somat = 0;
			for (int i = 0; i < getNumeroDeClusters(); i++) /* Cálculo dos diâmetros */
			{
				for (int j = 0; j < getNumeroDeObjetos(); j++) /* Número de Clientes */
				{
					if (i == particao[j])
						for (int k = 0; k < getCaracteristicas(); k++)
							somat = somat
									+ Math.pow(matrizDeDados[j][k]
											- matrizDeCentroides[k][i], 2);
				}/* for j:=1 to Lin = NClientes do */
			}/* for i:=1 to (Num_Cl = Número de Clusters) do */
			f_Atual = Math.sqrt(somat); /* Cálculo da Função Objetivo */
			// -----------------------------------------------------------
		} while ((f_Atual > f_Ant)
				|| (numeroDeIteracoesF > numeroDeIteracoesMaximasF));
		erro_Forgy = f_Ant;
	}//  forgy

	/**
	 * realoca elementos
	 *
	 */
	private void realoca() {

		int indice;
		double acc1, acc2; // {Acumuladores}

		for (int i = 0; i < getNumeroDeObjetos(); i++) /* Número de Objetos */
		{
			acc2 = 0;
			indice = particao[i];
			for (int j = 0; j < getCaracteristicas(); j++)
				acc2 = Math.pow(matrizDeDados[i][j]
						- matrizDeCentroides[j][indice], 2)
						+ acc2;

			indice = particao[i];

			for (int j = 0; j < getNumeroDeClusters(); j++) {
				acc1 = 0;
				for (int k = 0; k < getCaracteristicas(); k++)
					acc1 = Math.pow(matrizDeDados[i][k]
							- matrizDeCentroides[k][j], 2)
							+ acc1;

				if ((acc1 < acc2) && (j != particao[i])) {
					indice = j; /* Faz um novo agrupamento */
					acc2 = acc1;
				}
			}/* for(int j=0; j<getNum_Cl(); j++) */

			particao[i] = indice;
		}/* for(int i=0; i< getNumObj(); i++) */
	} /* realoca  */
}

