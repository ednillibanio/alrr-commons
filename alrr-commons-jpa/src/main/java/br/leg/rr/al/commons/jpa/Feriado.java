package br.leg.rr.al.commons.jpa;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.leg.rr.al.commons.domain.FeriadoType;
import br.leg.rr.al.commons.domain.FeriadoTypeConverter;
import br.leg.rr.al.commons.jpa.feriado.validators.ValidFeriado;
import br.leg.rr.al.commons.jpa.validators.ValidDia;
import br.leg.rr.al.core.domain.Mes;
import br.leg.rr.al.core.domain.MesConverter;
import br.leg.rr.al.core.jpa.Dominio;
import br.leg.rr.al.localidade.jpa.Municipio;
import br.leg.rr.al.localidade.jpa.UnidadeFederativa;

/**
 * Classe persistente que representa a tabela "feriado".
 * 
 * @author <a href="mailto:ednil.libanio@gmail.com"> Ednil Libanio da Costa
 *         Junior</a>
 * @since 1.0.0
 */
@Entity
@Table
@ValidFeriado
public class Feriado extends Dominio {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6796246838607795199L;

	@ValidDia
	@NotNull(message = "Dia: campo obrigatório.")
	@Column(length = 2, nullable = false)
	private Integer dia = null;

	@NotNull(message = "Mês: campo obrigatório.")
	@Convert(converter = MesConverter.class)
	@Column(nullable = false, length = 2)
	private Mes mes = null;

	@NotNull(message = "Tipo Feriado: campo obrigatório.")
	@Convert(converter = FeriadoTypeConverter.class)
	@Column(name = "tipo_feriado", length = 1, nullable = false)
	private FeriadoType tipo;

	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "uf_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "uf_fk"), nullable = true)
	private UnidadeFederativa uf = null;

	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "municipio_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "municipio_fk"), nullable = true)
	private Municipio municipio = null;

	/**
	 * Recupera o dia do feriado.
	 * 
	 * @return dia
	 */
	public Integer getDia() {
		return dia;
	}

	/**
	 * Define o dia do feriado.
	 * 
	 * @param dia
	 */
	public void setDia(Integer dia) {
		this.dia = dia;
	}

	/**
	 * Recupera o mês do feriado.
	 * 
	 * @see Mes
	 * @return mes
	 */
	public Mes getMes() {
		return mes;
	}

	/**
	 * Define o mês do feriado.
	 * 
	 * @param mes
	 */
	public void setMes(Mes mes) {
		this.mes = mes;
	}

	/**
	 * Recupera a municipio do feriado.
	 * 
	 * @see Feriado#getTipo()
	 * @return municipio. Caso o tipo do feriado seja diferente de Municipal,
	 *         retorna <code>null</code>.
	 */
	public Municipio getMunicipio() {
		return municipio;
	}

	/**
	 * Define a municipio do feriado. Preenchimento obrigatório se o tipo do feriado
	 * for igual a Municipal.
	 * 
	 * @see Feriado#setTipo(FeriadoType)
	 * @param municipio
	 */
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	/**
	 * Recupera o tipo do feriado.
	 * 
	 * @see FeriadoType
	 * @return tipo
	 */
	public FeriadoType getTipo() {
		return tipo;
	}

	/**
	 * Define o tipo do feriado. De acordo com o tipo do feriado, os campos uf e
	 * municipio se tornam obrigatórios.<br/>
	 * <br/>
	 * <b>Regras</b>
	 * <ul>
	 * <li>Caso o tipo seja igual a Estadual, o campo {@link #mes} fica
	 * obrigatório.</li>
	 * <li>Caso o tipo seja igual a Municipal, o campo {@link #municipio} se torna
	 * obrigatório.</li>
	 * 
	 * @see FeriadoType
	 * @param tipoFeriado
	 */
	public void setTipo(FeriadoType tipoFeriado) {
		this.tipo = tipoFeriado;
	}

	/**
	 * Recupera a UF do feriado.
	 * 
	 * @return uf caso o tipo do feriado seja igual a Estadual ou Municipal. No caso
	 *         de Municipal, retorna a uf da municipio (município). Caso contrário,
	 *         retorna <code>null</code>.
	 */
	public UnidadeFederativa getUf() {
		if (uf != null) {
			return uf;
		} else if (municipio != null) {
			return municipio.getUf();
		}
		return null;
	}

	/**
	 * Define a UF do feriado, caso o tipo do feriado seja Estadual. Caso contrário
	 * deverá ser <code>null</code>.
	 * 
	 * @param uf
	 */
	public void setUf(UnidadeFederativa uf) {
		this.uf = uf;
	}

}
