package com.optimizenow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.jgoodies.binding.beans.Model;

@Entity
@Table(name = "ENDERECO")
public final class Endereco extends Model implements EntidadeModelo {
	
	private static final long serialVersionUID = 2706944094002880052L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_ENDERECO_SEQ")
	@SequenceGenerator(sequenceName = "ID_ENDERECO_SEQ", name = "ID_ENDERECO_SEQ", allocationSize = 1)
	private int ID_Endereco;
	
	@Column(name = "LOGRADOURO")
	private String logradouro;
	
	@Column(name = "TIPO_LOGRADOURO")	
	private String tipoLogradouro;
	
	@Column(name = "NUMERO")	
	private Long numero;
	
	public int getID_Endereco() {
		return ID_Endereco;
	}
	public void setID_Endereco(final int endereco) {
		ID_Endereco = endereco;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(final String logradouro) {
		this.logradouro = logradouro;
	}
	
	public Long getNumero() {
		return numero;
	}
	public void setNumero(final Long numero) {
		this.numero = numero;
	}
	
	public String getTipoLogradouro() {
		return tipoLogradouro;
	}
	public void setTipoLogradouro(final String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

}
