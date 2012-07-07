package com.optimizenow.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.jgoodies.binding.beans.Model;

@Entity
@Table(name = "INFORMACOES_FINANCEIRAS")
public class InformacoesFinanceiras extends Model implements EntidadeModelo {

	private static final long serialVersionUID = 5869844323222179295L;
	
	public static final String MES = "mes";
	
	public static final String FLUXO_PESSOAS = "fluxoPessoas";
	
	public static final String VENDAS = "vendas";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_INFORMACOES_SEQ")
	@SequenceGenerator(sequenceName = "ID_INFORMACOES_SEQ", name = "ID_INFORMACOES_SEQ", allocationSize = 1)
	private int ID_InformacoesFinanceiras;

	@Column(name = "MES")	
	private Date mes;
	@Column(name = "VENDAS")
	private BigDecimal vendas;
	@Column(name = "FLUXO_PESSOAS")
	private Integer fluxoPessoas;
	
	public InformacoesFinanceiras() {
	}

	public int getID_InformacoesFinanceiras() {
		return ID_InformacoesFinanceiras;
	}

	public void setID_InformacoesFinanceiras(final int informacoesFinanceiras) {
		ID_InformacoesFinanceiras = informacoesFinanceiras;
	}

	public Integer getFluxoPessoas() {
		return fluxoPessoas;
	}

	public void setFluxoPessoas(final Integer fluxoPessoas) {
		this.fluxoPessoas = fluxoPessoas;
	}

	public Date getMes() {
		return mes;
	}

	public void setMes(final Date mes) {
		this.mes = mes;
	}

	public BigDecimal getVendas() {
		return vendas;
	}

	public void setVendas(final BigDecimal vendas) {
		this.vendas = vendas;
	}

}
