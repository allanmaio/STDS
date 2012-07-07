package com.optimizenow.otimizacao;

public class JExemplo {
	private int numObj;
	private int num_Cl;
	private int nCaracteristicas;
	private double matrizDeDados[][];
/*-------------------------------------------------------------------------*/
  public JExemplo()
  {				
    setNum_Cl(3);
    setNumObj(10);
    setNCaracteristicas(2);		
    setMatrizDeDados();	
  }
/*-------------------------------------------------------------------------*/
//Este metodo alimenta a matriz de caracteristicas.   
/*-------------------------------------------------------------------------*/  
  public void setMatrizDeDados() {
	matrizDeDados = new double[getNumObj()][getNCaracteristicas()];
    int k=0;  		
	for(int i=0; i<matrizDeDados.length; i++)
	  for(int j=0; j<matrizDeDados[0].length; j++)
		matrizDeDados[i][j]=i+j+k++;		
  }	
/*-------------------------------------------------------------------------*/
  public double[][] getMatrizDeDados() {
		return matrizDeDados;
  }
/*-------------------------------------------------------------------------*/
  public void setMatrizDeDados(double[][] matrizDeDados) {
		this.matrizDeDados = matrizDeDados;
  }
/*-------------------------------------------------------------------------*/
  public int getNCaracteristicas() {
    return nCaracteristicas;
  }
/*-------------------------------------------------------------------------*/
public void setNCaracteristicas(int caracteristicas) {
		nCaracteristicas = caracteristicas;
	}
/*-------------------------------------------------------------------------*/
public int getNum_Cl() {
		return num_Cl;
	}
/*-------------------------------------------------------------------------*/
public void setNum_Cl(int num_Cl) {
		this.num_Cl = num_Cl;
	}
/*-------------------------------------------------------------------------*/
public int getNumObj() {
		return numObj;
	}
/*-------------------------------------------------------------------------*/
public void setNumObj(int numObj) {
		this.numObj = numObj;
	}
/*-------------------------------------------------------------------------*/
}
