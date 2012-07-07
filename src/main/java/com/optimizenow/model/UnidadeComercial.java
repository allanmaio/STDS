package com.optimizenow.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.jgoodies.binding.beans.Model;
/**
 * Representa a entidade Unidade Comercial contendo seus atributos.
 *
 */

@Entity
@Table(name = "UNIDADE_COMERCIAL")

public final class UnidadeComercial extends Model implements EntidadeModelo {

	private static final long serialVersionUID = 60260925943426864L;

	public static final String NUMERO = "numero";

	public static final String AREA = "area";

	public static final String DT_FIM = "dtFim";

	public static final String DT_INICIO = "dtInicio";

	public static final String ATIVA = "ativa";

	public static final String PONTOS = "pontos";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_UNIDADE_SEQ")
	@SequenceGenerator(sequenceName = "ID_UNIDADE_SEQ", name = "ID_UNIDADE_SEQ", allocationSize = 1)
	private int ID_Unidade;

	@Column(name = "NUMERO")
	@OrderBy()
	private String numero;

	@Column(name = "AREA")
	private Double area;

	@Column(name = "DT_INICIO")
	@Type(type = "java.sql.Date")
	private Date dtInicio;

	@Column(name = "DT_FIM")
	@Type(type = "java.sql.Date")
	private Date dtFim;

	@Column(name = "ATIVA")
	private boolean ativa;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_UNIDADE")
	private List<Ponto> pontos;

	public UnidadeComercial() {
		//Construtor vazio para utilizacao do Framework Hibernate.
	}

	public int getID_Unidade() {
		return this.ID_Unidade;
	}

	public void setID_Unidade(final int ID_Unidade) {
		this.ID_Unidade = ID_Unidade;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(final String numero) {
		System.out.println("Numero= " + numero);
		this.numero = numero;
	}

	public Double getArea() {
		return this.area;
	}

	public void setArea(final Double area) {
		this.area = area;
	}

	public Date getDtInicio() {
		return this.dtInicio;
	}

	public void setDtInicio(final Date dtInicio) {
		System.out.println("dtInicio= " + dtInicio);
		this.dtInicio = dtInicio;
	}

	public Date getDtFim() {
		return this.dtFim;
	}

	public void setDtFim(final Date dtFim) {
		System.out.println("dtFim= " + dtFim);
		this.dtFim = dtFim;
	}

	public boolean isAtiva() {
		return this.ativa;
	}

	public void setAtiva(final boolean ativa) {
		this.ativa = ativa;
	}

	public List<Ponto> getPontos() {
		return pontos;
	}

	public void setPontos(final List<Ponto> pontos) {
		this.pontos = pontos;
	}

	@Override
	public String toString() {
		return getNumero();
	}
	
}
