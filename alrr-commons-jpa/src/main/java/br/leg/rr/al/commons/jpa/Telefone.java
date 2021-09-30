package br.leg.rr.al.commons.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import br.leg.rr.al.commons.utils.enums.TelefoneType;
import br.leg.rr.al.commons.utils.enums.TelefoneTypeConverter;
import br.leg.rr.al.core.jpa.EntidadeSituacaoBase;

/**
 * Classe persistente que representa a tabela "telefone".
 * 
 * @author <a href="mailto:ednil.libanio@gmail.com"> Ednil Libanio da Costa
 *         Junior</a>
 */
@MappedSuperclass
public class Telefone extends EntidadeSituacaoBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2105986462597463400L;

	/**
	 * Tipo do telefone. Exemplo: Celular, Fixo, Residencial, Comercial, etc.
	 * 
	 * @see TelefoneType
	 */
	@Convert(converter = TelefoneTypeConverter.class)
	@Column(name = "tipo_telefone", length = 1)
	@NotNull(message = "Tipo: campo obrigatório.")
	private TelefoneType tipo;

	/**
	 * DDD do telefone sem formatação.
	 */
	@Column(nullable = true, length = 2)
	private String ddd;

	/**
	 * Número do telefone sem formatação.
	 */
	@Column(nullable = false, length = 9)
	@NotNull(message = "Número: campo obrigatório.")
	private String numero;

	public Telefone() {
	}

	/**
	 * Recupera o tipo do telefone.
	 * 
	 * @see TelefoneType
	 * @return tipo do telefone
	 */
	public TelefoneType getTipo() {
		return tipo;
	}

	/**
	 * Define o tipo do telefone.
	 * 
	 * @see TelefoneType
	 * @param tipoTelefone
	 */
	public void setTipo(TelefoneType tipoTelefone) {
		this.tipo = tipoTelefone;
	}

	/**
	 * Recupera o DDD do telefone sem formatação.
	 * 
	 * @return ddd do telefone
	 */
	public String getDdd() {
		return ddd;
	}

	/**
	 * Define o DDD do telefone sem formatação.
	 * 
	 * @param ddd
	 */
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	/**
	 * Recupera o número do telefone sem formatação.
	 * 
	 * @return número do telefone sem formatação
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Define o número do telefone sem formatação.
	 * 
	 * @param numero
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
