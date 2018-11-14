package br.leg.rr.al.commons.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.leg.rr.al.commons.domain.UfType;
import br.leg.rr.al.core.jpa.BaseEntityStatus;

/**
 * Classe persistente que representa a tabela "municipio".
 * 
 * @author <a href="mailto:ednil.libanio@gmail.com"> Ednil Libanio da Costa
 *         Junior</a>
 * @since 1.0.0
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "nome", "uf" }), indexes = {
		@Index(name = "localidade_idx1", columnList = "nome"),
		@Index(name = "localidade_idx2", columnList = "nome, uf") })
public class Municipio extends BaseEntityStatus<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1184733666808220254L;

	@Column(name = "ibge_id", nullable = true)
	private Integer ibgeId;

	@Column(nullable = false, length = 130)
	@NotNull(message = "Preenchimento obrigatório do campo nome do município.")
	@Size(max = 130)
	private String nome;

	@NotNull(message = "Preenchimento obrigatório do campo UF do município.")
	@Enumerated(EnumType.STRING)
	@Column(name = "uf", nullable = false, length = 2)
	private UfType uf;

	public String getNome() {
		return nome;
	}

	// TODO: Ver se vai inserir a data de aniversário aqui do municipio. Seria legal
	// também pra uf.
	public void setNome(String nome) {
		this.nome = nome;
	}

	public UfType getUf() {
		return uf;
	}

	public void setUf(UfType uf) {
		this.uf = uf;
	}

	/**
	 * @return the ibgeId
	 */
	public Integer getIbgeId() {
		return ibgeId;
	}

	/**
	 * @param ibgeId
	 *            the ibgeId to set
	 */
	public void setIbgeId(Integer ibgeId) {
		this.ibgeId = ibgeId;
	}

}
