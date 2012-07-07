package com.optimizenow.otimizacao;

public class JForgyHomogeneo {
	private double matrizDeDados[][]; // Matriz de Dados dos Objetos //numObj
										// X numCaracteristicas

	private int nIterF; // N�mero de Itera��es

	private int numObj; // N�mero de Objetos

	private int num_Cl; // N�mero de Clusters

	private int particao[]; // Parti��es //numObj

	private double matC[][]; // Matriz de Centr�ides //numCaracteristicas X
								// num_Cl

	private int numCaracteristicas; // N�mero de Caracteristicas

	public JForgyHomogeneo(int numObj, int num_Cl, int nCaracteristicas,
			double matrizDeDados[][]) {
		setNum_Cl(num_Cl);
		setNumObj(numObj);
		setParticao();
		setCaracteristicas(nCaracteristicas);
		setMatC();
		setMatrizDeDados(matrizDeDados);
	}

	public int getNum_Cl() {
		return num_Cl;
	}

	public void setNum_Cl(int num_Cl) {
		this.num_Cl = num_Cl;
	}

	public int getNumObj() {
		return numObj;
	}

	public void setNumObj(int numObj) {
		this.numObj = numObj;
	}

	public int[] getParticao() {
		return particao;
	}

	public void setParticao(int[] particao) {
		this.particao = particao;
	}

	public void setParticao() {
		particao = new int[getNumObj()];
	}

	private void setMatC() {
		matC = new double[getCaracteristicas()][getNum_Cl()];
	}

	public int getCaracteristicas() {
		return numCaracteristicas;
	}

	public void setCaracteristicas(int n) {
		numCaracteristicas = n;
	}

	public void setMatrizDeDados(double matrizDeDados[][]) {
		this.matrizDeDados = matrizDeDados;
	}

	public int getNIterF() {
		return nIterF;
	}

	public void setNIterF(int nIterF) {
		nIterF = 0;
	}

	private void zerarVetor(double vetor[]) {
		for (int i = 0; i < vetor.length; i++)
			vetor[i] = 0.0;
	}

	private void zerarMatriz(double matriz[][]) {
		for (int i = 0; i < matriz.length; i++)
			for (int j = 0; j < matriz[0].length; j++)
				matriz[i][j] = 0.0;
	}

	private void inicial() {

		int cont = -1;

		for (int i = 0; i < getNumObj(); i++) // (*Aloca��o Inicial*)
		{
			if (cont < getNum_Cl() - 1)
				cont++;
			else
				cont = 0;

			particao[i] = cont;
		}// for
	}


	public void forgy() {

		int cont;
		double f_Atual; // {Fun��o Objetivo Atual}
		double f_Ant; // {Fun��o Objetivo Anterior}
		double somat; // {Somat�rio}
		double somatorio[] = new double[getCaracteristicas()];
		double erro_Forgy;

		inicial();

		setNIterF(0);
		// {Inicializa��o}
		f_Atual = 1e+300;

		do {
			nIterF++;
			f_Ant = f_Atual;
			f_Atual = 0;
			zerarMatriz(matC);
			setMatC();
			/* {Calculando as Centr�ides} */
			for (int i = 0; i < getNum_Cl(); i++) {
				cont = 0;
				zerarVetor(somatorio);

				for (int j = 0; j < getNumObj(); j++) /* {N�mero de Clientes} */
				{
					if (i == particao[j]) /*
											 * {Se o objeto i estiver alocado em
											 * P[i], ent�o fa�a}
											 */
					{
						for (int k = 0; k < getCaracteristicas(); k++)
							somatorio[k] = somatorio[k] + matrizDeDados[j][k];
						cont++;
					}/* if (i==particao[j]) */
				}/* for(int j=0; j<getNumObj(); j++) */

				if (cont > 0) {
					for (int k = 0; k < getCaracteristicas(); k++)
						matC[k][i] = somatorio[k] / cont; /*
															 * {C�lculo dos
															 * Centr�ides}
															 */
				}/* {if(Cont<>0)} */

			}/* for(int i=0;i<getNum_Cl();i++) */

			if (f_Atual < f_Ant)
				realoca();
			somat = 0;
			for (int i = 0; i < getNum_Cl(); i++) /* {C�lculo dos di�metros} */
			{
				for (int j = 0; j < getNumObj(); j++) /* {N�mero de Clientes} */
				{
					if (i == particao[j])
						for (int k = 0; k < getCaracteristicas(); k++)
							somat = somat
									+ Math
											.pow(matrizDeDados[j][k]
													- matC[k][i], 2);
				}/* {for j:=1 to Lin = NClientes do} */
			}/* {for i:=1 to (Num_Cl = N�mero de Clusters) do} */
			f_Atual = Math.sqrt(somat); /* {C�lculo da Fun��o Objetivo} */
		} while (f_Atual < f_Ant);
		erro_Forgy = f_Ant;
	}// { Forgy }

	private void realoca() {

		int indice;
		double acc1, acc2; // {Acumuladores}

		for (int i = 0; i < getNumObj(); i++) /* {N�mero de Objetos} */
		{
			acc2 = 0;
			indice = particao[i];
			for (int j = 0; j < getCaracteristicas(); j++)
				acc2 = Math.pow(matrizDeDados[i][j] - matC[j][indice], 2)
						+ acc2;

			indice = particao[i];

			for (int j = 0; j < getNum_Cl(); j++) {
				acc1 = 0;
				for (int k = 0; k < getCaracteristicas(); k++)
					acc1 = Math.pow(matrizDeDados[i][k] - matC[k][j], 2) + acc1;

				if ((acc1 < acc2) && (j != particao[i])) {
					indice = j; /* {Faz um novo agrupamento} */
					acc2 = acc1;
				}
			}/* for(int j=0; j<getNum_Cl(); j++) */

			particao[i] = indice;
		}/* for(int i=0; i< getNumObj(); i++) */
	} /* { Realoca } */
}

