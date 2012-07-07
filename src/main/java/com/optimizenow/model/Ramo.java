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
@Table(name = "RAMO")
public class Ramo extends Model implements EntidadeModelo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_RAMO_SEQ")
	@SequenceGenerator(sequenceName = "ID_RAMO_SEQ", name = "ID_RAMO_SEQ", allocationSize = 1)
	private int ID_Ramo;

	@Column(name = "DESCRICAO")
	private String descricao;
	
	private static final long serialVersionUID = 1L;
	
	public Ramo() {
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

	public int getID() {
		return ID_Ramo;
	}

	public void setID(final int id) {
		ID_Ramo = id;
	}

	@Override
	public String toString() {
		return this.getDescricao();
	}

}
