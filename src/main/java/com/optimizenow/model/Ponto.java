package com.optimizenow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Representa a entidade Ponto contendo seus atributos.
 * 
 */
@Entity
@Table(name = "PONTO")
public final class Ponto implements EntidadeModelo, Comparable<Ponto> {

	private static final long serialVersionUID = 5363349432107205329L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_PONTO_SEQ")
	@SequenceGenerator(sequenceName = "ID_PONTO_SEQ", name = "ID_PONTO_SEQ", allocationSize = 1)
	private int ID_Ponto;

	@Column(name = "X")
	private int x;

	@Column(name = "Y")
	private int y;

	@Column(name = "ORDEM")
	private int ordem;
	
	public Ponto(){
		//Construtor vazio para utilizacao do Framework Hibernate.
	}

	public int getID_Ponto() {
		return ID_Ponto;
	}

	public void setID_Ponto(final int ponto) {
		ID_Ponto = ponto;
	}

	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(final int ordem) {
		this.ordem = ordem;
	}

	public int getX() {
		return x;
	}

	public void setX(final int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(final int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "IDPonto= " + getID_Ponto() + " X= " + getX() + " Y= " + getY()
				+ " Ordem= " + getOrdem();
	}

	public int compareTo(final Ponto o) {
		final int BEFORE = -1;
		final int EQUAL = 0;
		final int AFTER = 1;
		if (this == o) {
			return EQUAL;
		}
		if (this.getOrdem() < o.getOrdem()) {
			return BEFORE;
		}
		if (this.getOrdem() > o.getOrdem()) {
			return AFTER;
		}
		return EQUAL;
	}

}
