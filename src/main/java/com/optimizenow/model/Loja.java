package com.optimizenow.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;
import org.hibernate.engine.CascadeStyle;

import com.jgoodies.binding.beans.Model;

/**
 * Representa a entidade Loja contendo seus atributos.
 *
 */
@Entity
@Table(name = "LOJA")
public final class Loja extends Model implements EntidadeModelo {

	private static final long serialVersionUID = 5598311583301828565L;
	
	private static Log log = LogFactory.getLog(Loja.class);

	public static final String NOME_FANTASIA = "nomeFantasia";

	public static final String RAZAO_SOCIAL = "razaoSocial";

	public static final String DT_INICIO = "dtInicio";

	public static final String DT_DESLIGAMENTO = "dtDesligamento";

	public static final String TELEFONE = "telefone";

	public static final String SITE = "site";

	public static final String FAX = "fax";
	
	public static final String LOJISTA = "lojista";
	
	public static final String UNIDADE = "unidade";
	
	public static final String RAMO = "ramo";
	
	public static final String VENDAS = "vendas";
	
	public static final String FLUXOPESSOAS = "fluxoPessoas";

	public static final String ENDERECO = "endereco";

	public static final String TIPO_LOGRADOURO = "tipoLogradouro";

	public static final String LOGRADOURO = "logradouro";
	
	public static final String NUMERO_ENDERECO = "numeroEndereco";

	public static final String COMPLEMENTO = "complemento";

	public static final String BAIRRO = "bairro";

	public static final String CIDADE = "cidade";
	
	public static final String CEP = "cep";

	public static final String UF = "uf";
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_LOJA_SEQ")
	@SequenceGenerator(sequenceName = "ID_LOJA_SEQ", name = "ID_LOJA_SEQ", allocationSize = 1)
	private int ID_Loja;

	@Column(name = "NOME_FANTASIA")
	private String nomeFantasia;

	@Column(name = "RAZAO_SOCIAL")
	private String razaoSocial;

	@Column(name = "DT_INICIO")
	@Type(type = "java.sql.Date")
	private Date dtInicio;

	@Column(name = "DT_DESLIGAMENTO")
	@Type(type = "java.sql.Date")
	private Date dtDesligamento;

	@OneToOne(optional = true)
	@JoinColumn(name = "ID_LOJISTA")
	private Lojista lojista;

	@Column(name = "TELEFONE")
	private String telefone;

	@Column(name = "FAX")
	private String fax;

	@Column(name = "SITE")
	private String site;
	
	@OneToOne(optional = true)
	@Cascade(value = CascadeType.ALL)
	@JoinColumn(name = "ID_ENDERECO")
	private Endereco endereco;
	
	@OneToOne(optional = true)
	@JoinColumn(name = "ID_UNIDADE")
	private UnidadeComercial unidadeComercial;
	
	@OneToOne(optional = true)
	@JoinColumn(name = "ID_RAMO")
	private Ramo ramo;
	
	@Column(name = "VENDAS")
	private BigDecimal vendas;
	
	@Column(name = "FLUXOPESSOAS")
	private Long fluxoPessoas;
	
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

	public int getID_Loja() {
		log.info("executou getID_Loja()");
		return ID_Loja;
	}

	public void setID_Loja(final int loja) {
		ID_Loja = loja;
	}

	public Loja() {
		//Construtor vazio para utilizacao do Framework Hibernate.
	}

	public Date getDtDesligamento() {
		return dtDesligamento;
	}

	public void setDtDesligamento(final Date dtDesligamento) {
		this.dtDesligamento = dtDesligamento;
	}

	public Date getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(final Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(final String fax) {
		this.fax = fax;
	}

	public Lojista getLojista() {
		return lojista;
	}

	public void setLojista(final Lojista lojista) {
		this.lojista = lojista;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(final String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(final String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getSite() {
		return site;
	}

	public void setSite(final String site) {
		this.site = site;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(final String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return getNomeFantasia();
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(final Endereco endereco) {
		this.endereco = endereco;
	}

	public UnidadeComercial getUnidadeComercial() {
		return unidadeComercial;
	}

	public void setUnidadeComercial(final UnidadeComercial unidadeComercial) {
		this.unidadeComercial = unidadeComercial;
	}

	public Ramo getRamo() {
		return ramo;
	}

	public void setRamo(final Ramo ramo) {
		this.ramo = ramo;
	}

	public BigDecimal getVendas() {
		return vendas;
	}

	public void setVendas(final BigDecimal vendas) {
		this.vendas = vendas;
	}

	public Long getFluxoPessoas() {
		return fluxoPessoas;
	}

	public void setFluxoPessoas(final Long fluxoPessoas) {
		this.fluxoPessoas = fluxoPessoas;
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
