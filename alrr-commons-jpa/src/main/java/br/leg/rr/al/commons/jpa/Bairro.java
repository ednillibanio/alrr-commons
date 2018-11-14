package br.leg.rr.al.commons.jpa;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.leg.rr.al.core.jpa.BaseEntityStatus;

/**
 * Classe persistente que representa a tabela "bairro".
 * 
 * @author <a href="mailto:ednil.libanio@gmail.com"> Ednil Libanio da Costa
 *         Junior</a>
 * @since 1.0.0
 */
@Entity
@Table
public class Bairro extends BaseEntityStatus<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 796491013446731504L;

	@Column(nullable = false, length = 150)
	@NotNull(message = "Preenchimento obrigatório do campo nome do bairro.")
	@Size(max = 150)
	private String nome;

	@ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "localidade_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "localidade_fk"), nullable = false)
	private Municipio municipio;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Municipio getLocalidade() {
		return municipio;
	}

	public void setLocalidade(Municipio municipio) {
		this.municipio = municipio;
	}

}
