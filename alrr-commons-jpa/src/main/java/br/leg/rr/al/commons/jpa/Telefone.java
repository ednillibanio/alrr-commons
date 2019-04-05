package br.leg.rr.al.commons.jpa;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.leg.rr.al.commons.domain.TelefoneType;
import br.leg.rr.al.commons.domain.TelefoneTypeConverter;
import br.leg.rr.al.core.jpa.BaseEntityStatus;

/**
 * Classe persistente que representa a tabela "telefone".
 * 
 * @author <a href="mailto:ednil.libanio@gmail.com"> Ednil Libanio da Costa
 *         Junior</a>
 * @since 1.0.0
 */
@MappedSuperclass
public class Telefone extends BaseEntityStatus<Integer> {

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

	/**
	 * Retorna os valores dos campos: id, ddd e número.
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", getId()).append("ddd", getDdd())
				.append("numero", getNumero()).toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!getClass().isAssignableFrom(obj.getClass())) {
			return false;
		}

		Telefone tel = (Telefone) obj;

		if (getId() == null) {
			if (tel.getId() != null)
				return false;
		}
		EqualsBuilder eb = new EqualsBuilder();
		eb.append(id, tel.getNumero());
		eb.append(numero, tel.getNumero());
		return eb.isEquals();

	}

}
