package com.optimizenow.util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.cfg.Configuration;

import com.optimizenow.dao.DAOFactory;
import com.optimizenow.dao.LojaDAO;
import com.optimizenow.datasource.HibernateUtil;
import com.optimizenow.model.Endereco;
import com.optimizenow.model.Loja;
import com.optimizenow.model.Ramo;
import com.optimizenow.presentation.LojaPresentationModel;
import com.optimizenow.presentation.STDSPresentation;


public class CargaNaBase {
	
	static {
		inicializaHibernate();
	}

	public static void carregarRamos() {
		inicializaHibernate();

		
		STDSPresentation presentation = new STDSPresentation(new Ramo());
		
		List<String> ramos = new ArrayList<String>();
		
		
		ramos.add("Moda jovem");
		ramos.add("Moda feminina");
		ramos.add("Moda Praia");
		ramos.add("Moda masculina");
		ramos.add("Jóias e relógios");
		ramos.add("Presentes e souvenirs");
		ramos.add("Calçados");
		ramos.add("Telefonia");
		ramos.add("Perfumaria e cosméticos");
		ramos.add("Moda Unissex");
		ramos.add("Calçados em geral");
		ramos.add("Lojas de departamentos");
		ramos.add("Moda infantil");
		ramos.add("Artigos esportivos");
		ramos.add("Moda praia");
		ramos.add("Banco");
		ramos.add("Eletrodomésticos");
		ramos.add("Departamentos");
		ramos.add("Cabeleireiros");
		ramos.add("Farmácia/drogaria");
		ramos.add("Artigos eletrônicos");
		ramos.add("Artigos para viagem");
		ramos.add("Restaurantes");
		ramos.add("Informática");
		ramos.add("Jornais");
		ramos.add("Móveis e decorações");
		ramos.add("Pet shop");
		
		
		
		
		
		for (String s : ramos) {
			Ramo ramo = new Ramo();
			ramo.setDescricao( s);
			presentation.salvar(ramo);
		}
		
		for(int i = 0; i<10; i++) {
			
		}
		
	}

	
	public static void limparRamos() {
		inicializaHibernate();
		STDSPresentation presentation = new STDSPresentation(new Ramo());
		
		List<Ramo> ramos = presentation.findAll();
		for(Ramo o : ramos) {
			presentation.excluir(o);
		}
		
		
	}
	
	
	public static void main(String args[]) {
		CargaNaBase.carregarRamos();
		//CargaNaBase.limparRamos();
		//CargaNaBase.testarCadastroEndereco();
	}
	
	public static void testarCadastroEndereco() {
			
		Loja loja = new Loja();
		STDSPresentation presentation = new STDSPresentation(loja);
		loja.setNomeFantasia("testeComEndereco2");
		Endereco end = new Endereco();
		end.setLogradouro("rua X");
		loja.setEndereco(end);
		presentation.salvar(loja);
			/*
			try {
				loja.makeTransient(unidadeComercial);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
	}

	private static void inicializaHibernate() {
		Configuration cfg = HibernateUtil.getConfiguration();
		cfg.setProperty("hibernate.connection.username", "sa");
		cfg.setProperty("hibernate.connection.password", "");
		HibernateUtil.rebuildSessionFactory(cfg);
	}
	
}
