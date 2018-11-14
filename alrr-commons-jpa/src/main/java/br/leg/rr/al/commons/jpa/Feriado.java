package br.leg.rr.al.commons.jpa;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import br.leg.rr.al.commons.domain.FeriadoType;
import br.leg.rr.al.commons.domain.FeriadoTypeConverter;
import br.leg.rr.al.commons.domain.UfType;
import br.leg.rr.al.commons.jpa.feriado.validators.ValidFeriado;
import br.leg.rr.al.commons.jpa.validators.ValidDia;
import br.leg.rr.al.core.domain.Mes;
import br.leg.rr.al.core.domain.MesConverter;
import br.leg.rr.al.core.jpa.Dominio;

/**
 * Classe persistente que representa a tabela "feriado".
 * 
 * @author <a href="mailto:ednil.libanio@gmail.com"> Ednil Libanio da Costa
 *         Junior</a>
 * @since 1.0.0
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "nome", "dia", "mes",
		"tipo_feriado" }, name = "feriado_uqk1"))
// TODO: check gera, mas só pra um. Não consegui achar pra colocar em todos.
// Descobrir como que faz depois.
@ValidFeriado
public class Feriado extends Dominio {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6796246838607795199L;

	@ValidDia
	@NotNull(message = "Dia: campo obrigatório.")
	@Column(length = 2, nullable = false)
	private String dia = null;

	@NotNull(message = "Mês: campo obrigatório.")
	@Convert(converter = MesConverter.class)
	@Column(nullable = false, length = 2)
	private Mes mes = null;

	@NotNull(message = "Tipo Feriado: campo obrigatório.")
	@Convert(converter = FeriadoTypeConverter.class)
	@Column(name = "tipo_feriado", length = 1, nullable = false)
	private FeriadoType tipo;

	// @Null(groups = FeriadoNacional.class, message = "Uf deve ser vazio para
	// feriado igual a Nacional.")
	// @NotNull(groups = FeriadoEstadual.class, message = "Uf: campo obrigatório
	// bean.")
	@Enumerated(EnumType.STRING)
	@Column(name = "uf", length = 2, nullable = true)
	private UfType uf = null;

	// @NotNull(groups = { FeriadoMunicipal.class, FeriadoEstadual.class }, message
	// = "Municipio: campo obrigatório.")
	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "localidade_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "localidade_fk"), nullable = true)
	private Municipio municipio = null;

	/**
	 * Recupera o dia do feriado.
	 * 
	 * @return dia
	 */
	public String getDia() {
		return dia;
	}

	/**
	 * Define o dia do feriado.
	 * 
	 * @param dia
	 */
	public void setDia(String dia) {
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
	public Municipio getLocalidade() {
		return municipio;
	}

	/**
	 * Define a municipio do feriado. Preenchimento obrigatório se o tipo do
	 * feriado for igual a Municipal.
	 * 
	 * @see Feriado#setTipo(FeriadoType)
	 * @param municipio
	 */
	public void setLocalidade(Municipio municipio) {
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
	public UfType getUf() {
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
	public void setUf(UfType uf) {
		this.uf = uf;
	}

}
