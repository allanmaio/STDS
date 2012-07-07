package com.optimizenow.otimizacao;

public class JPrincipal {
 
	public static void main(String[] args) {
		
		JExemplo exemplo=new JExemplo();//Esta classe carrega dados exemplos.
		
		
		JForgyHeterogeneo forgy = new JForgyHeterogeneo(exemplo.getNumObj(), 
				           exemplo.getNum_Cl(), 
						   exemplo.getNCaracteristicas(), 
						   exemplo.getMatrizDeDados());
		forgy.forgy();
		
		int[] particao = forgy.getParticao();
		
		for(int i=0;i<particao.length; i++)
           System.out.println("Loja  "+i+",  Grupo " +particao[i]);
		
		System.out.println("Numero de Iteracoes de Forgy: "+forgy.getNumeroDeIteracoesF());
	}
}
