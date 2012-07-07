package com.optimizenow.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.jgoodies.binding.beans.Model;

/**
 * Representa a entidade Lojista contendo seus atributos.
 * 
 */
@Entity
@Table(name = "LOJISTA")
public final class Lojista extends Model implements EntidadeModelo {


	private static final long serialVersionUID = -4635601573179230554L;

	public static final String NOME = "nome";

	public static final String RG = "rg";

	public static final String CPF = "cpf";

	public static final String CELULAR = "celular";

	public static final String EMAIL = "email";

	public static final String TEL_COMERCIAL = "telComercial";

	public static final String TELEFONE = "telefone";

	public static final String OBS = "obs";

	public static final String DT_NASCIMENTO = "dtNascimento";

	public static final String SEXO = "sexo";

	public static final String ESTADO_CIVIL = "estadoCivil";

	public static final String TIPO_LOGRADOURO = "tipoLogradouro";

	public static final String LOGRADOURO = "logradouro";

	public static final String NUMERO_ENDERECO = "numeroEndereco";

	public static final String COMPLEMENTO = "complemento";

	public static final String BAIRRO = "bairro";

	public static final String CIDADE = "cidade";

	public static final String CEP = "cep";

	public static final String UF = "uf";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_LOJISTA_SEQ")
	@SequenceGenerator(sequenceName = "ID_LOJISTA_SEQ", name = "ID_LOJISTA_SEQ", allocationSize = 1)
	private int ID_Lojista;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "SEXO")
	private String sexo;

	@Column(name = "ESTADO_CIVIL")
	private String estadoCivil;

	@Column(name = "CPF")
	private Long cpf;

	@Column(name = "RG")
	private Long rg;

	@Column(name = "CELULAR")
	private String celular;

	@Column(name = "TELEFONE")
	private String telefone;

	@Column(name = "TEL_COMERCIAL")
	private String telComercial;

	@Column(name = "E_MAIL")
	private String email;

	@Column(name = "DATA_NASCIMENTO")
	private Date dtNascimento;

	@Column(name = "OBS")
	private String obs;
	
	@Column(name = "TIPO_LOGRADOURO")
	private String tipoLogradouro;

	@Column(name = "LOGRADOURO")
	private String logradouro;

	@Column(name = "NUMERO_ENDERECO")
	private String numeroEndereco;

	@Column(name = "COMPLEMENTO")
	private String complemento;

	@Column(name = "BAIRRO")
	private String bairro;

	@Column(name = "CIDADE")
	private String cidade;

	@Column(name = "CEP")
	private String cep;

	@Column(name = "UF")
	private String uf;

	@OneToOne(optional = true)
	@JoinColumn(name = "ID_ENDERECO")
	private Endereco endereco;

	public Lojista() {
		//Construtor vazio para utilizacao do Framework Hibernate.
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(final String celular) {
		this.celular = celular;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(final Long cpf) {
		this.cpf = cpf;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(final Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(final String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public int getID_Lojista() {
		return ID_Lojista;
	}

	public void setID_Lojista(final int lojista) {
		ID_Lojista = lojista;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(final String obs) {
		this.obs = obs;
	}

	public Long getRg() {
		return rg;
	}

	public void setRg(final Long rg) {
		this.rg = rg;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(final String sexo) {
		this.sexo = sexo;
	}

	public String getTelComercial() {
		return telComercial;
	}

	public void setTelComercial(final String telComercial) {
		this.telComercial = telComercial;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(final String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(final Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return getNome();
	}

	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(String numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
