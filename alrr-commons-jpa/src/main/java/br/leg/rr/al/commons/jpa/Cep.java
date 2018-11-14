package br.leg.rr.al.commons.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.leg.rr.al.commons.domain.UfType;
import br.leg.rr.al.core.jpa.BaseEntityStatus;

/**
 * Classe persistente que representa a tabela "cep".
 * 
 * @author <a href="mailto:ednil.libanio@gmail.com"> Ednil Libanio da Costa
 *         Junior</a>
 * @since 1.0.0
 */
@Entity
@Table
public class Cep extends BaseEntityStatus<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1696673731486221778L;

	@Column(nullable = false, length = 8)
	private String numero;

	@Column(nullable = false, length = 250)
	private String logradouro;

	@Column(nullable = true, length = 250)
	private String bairro;

	@Column(nullable = true, length = 100)
	private String complemento;

	@Column(nullable = false, length = 250)
	private String localidade;

	@Enumerated(EnumType.STRING)
	@Column(name = "uf", nullable = false, length = 2)
	private UfType uf;

	@Transient
	private Boolean erro;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String cep) {
		this.numero = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public UfType getUf() {
		return uf;
	}

	public void setUf(UfType uf) {
		this.uf = uf;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Boolean getErro() {
		return erro;
	}

	public void setErro(Boolean erro) {
		this.erro = erro;
	}

}
