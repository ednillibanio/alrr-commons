/*******************************************************************************
 * ALE-RR Licença
 * Copyright (C) 2018, ALE-RR
 * Boa Vista, RR - Brasil
 * Todos os direitos reservados.
 * 
 * Este programa é propriedade da Assembleia Legislativa do Estado de Roraima e 
 * não é permitida a distribuição, alteração ou cópia da mesma sem prévia autoriazação.
 ******************************************************************************/
package br.leg.rr.al.commons.utils;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import br.leg.rr.al.commons.domain.TelefoneType;

/**
 * @author Ednil Libanio da Costa Junior
 * @date 05-04-2017
 */
public final class TelefoneUtils implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1710675242459791226L;

	// versão original que deve ser validado um número de celular.
	// private static final String ONZE_DIGITOS_REGEXP =
	// "([1-9][1-9])(9?[6-9]\\d{3})(\\d{4})";
	private static final String ONZE_DIGITOS_REGEXP = "([1-9][1-9])([1-9]\\d{4})(\\d{4})";
	private static final String DEZ_DIGITOS_REGEXP = "([1-9][1-9])([1-9]\\d{3})(\\d{4})";
	// private static final String NOVE_DIGITOS_REGEXP =
	// "((9?[6-9]\\d{3})(\\d{4}))";
	private static final String NOVE_DIGITOS_REGEXP = "(([1-9]\\d{4})(\\d{4}))";
	private static final String OITO_DIGITOS_REGEXP = "([1-9]\\d{3})(\\d{4})";

	/**
	 * Remove a formatação do número do telefone: parenteses '()' e hífen '-'.
	 * 
	 * @param tel
	 *            telefone com a formatação.
	 * @return telefone sem formatação.
	 */
	public static String unformat(String tel) {

		if (StringUtils.isNotBlank(tel)) {
			return tel.replaceAll("[^0-9]", "").trim();
		}
		return tel;
	}

	/**
	 * 
	 * Formata o número do telefone informado.
	 * 
	 * @param numero
	 *            número do telefone a ser formatado.
	 * @param tipo
	 *            Tipo do telefone. Importante para definir qual o tamanho do campo.
	 *            Por exemplo, celular pode ter 11 dígitos se contar com ddd.
	 * @return telefone formatado de acordo com o TelefoneType. Ex. Celular com 11
	 *         digitos: '(##) ####-######'.
	 */
	@SuppressWarnings("null")
	public static String format(Long numero, TelefoneType tipo) {
		if (numero != null) {
			return format(numero.toString(), tipo);
		} else {
			return numero.toString();
		}
	}

	/**
	 * Formata o número do telefone informado.
	 * 
	 * @param numero
	 *            número do telefone a ser formatado.
	 * @param tipo
	 *            Tipo do telefone. Importante para definir qual o tamanho do campo.
	 *            Por exemplo, celular pode ter 11 dígitos se contar com ddd.
	 * @return telefone formatado de acordo com o TelefoneType. Ex. Celular com 11
	 *         digitos: '(##) ####-######'. Caso o a quantidade de dígitos do número
	 *         do telefone não esteja entre 9 e 11, o método retorna o número sem
	 *         formatação.
	 */
	public static String format(String numero, TelefoneType tipo) {

		if (StringUtils.isNotBlank(numero)) {

			String tel = unformat(numero);

			if (TelefoneType.CELULAR.equals(tipo)) {

				if (tel.matches("\\d{9}")) {
					return tel.replaceFirst(NOVE_DIGITOS_REGEXP, "$1-$2");
				} else if (tel.matches("\\d{11}")) {
					return tel.replaceFirst(ONZE_DIGITOS_REGEXP, "($1) $2-$3");
				}

			} else {
				if (tel.matches("\\d{8}")) {
					return tel.replaceFirst(OITO_DIGITOS_REGEXP, "$1-$2");

				} else if (tel.matches("\\d{10}")) {
					return tel.replaceFirst(DEZ_DIGITOS_REGEXP, "($1) $2-$3");
				}
			}

			return tel;
		}

		return numero;

	}

	/**
	 * Obtém o ddd do número do telefone informado.
	 * 
	 * @param numero
	 *            número do telefone que contém o ddd.
	 * @return ddd. Caso o número do telefone informado no argumento seja menor que
	 *         10 dígitos, o método retorna <code>null</code>.
	 */
	public static String getDdd(String numero) {
		if (StringUtils.isNotBlank(numero)) {
			if (numero.length() == 11 || numero.length() == 10) {
				return numero.substring(0, 2);
			}
		}

		return numero;
	}

	/**
	 * Obtém o número do telefone sem o ddd.
	 * 
	 * @param numero
	 *            número do telefone com o ddd.
	 * @return número sem ddd. Caso a quantidade de dígitos no param
	 *         <code>numero</code> seja menor ou igual a 9, retornará o valor do
	 *         param informado.
	 */
	public static String getNumeroSemDdd(String numero) {
		if (StringUtils.isNotBlank(numero)) {
			if (numero.length() == 11) {
				return numero.substring(2, 11);

			} else if (numero.length() == 10) {
				return numero.substring(2, 10);

			} else if (numero.length() <= 9) {
				return numero;
			}
		}

		return numero;

	}

	/**
	 * Valida o número do telefone informado.
	 * 
	 * @param numero
	 *            número do telefone que será validado.
	 * @return <code>true</code> se caso:
	 *         <ul>
	 *         <li>número do telefone for validado com sucesso;</li>
	 *         <li>ou número do telefone seja <code>null;</code> ou vazio</li>
	 *         </ul>
	 *         Caso contrário, retorna <code>false</code>.
	 */
	// FIXME: Falta implementar a validação do número por região se quiser. Talvez
	// seja melhor tirar isso.
	public static boolean isValid(String numero) {

		if (StringUtils.isBlank(numero)) {
			return true;
		}

		// captura só os números
		String tel = unformat(numero);
		if (StringUtils.isBlank(tel)) {
			return true;
		}

		// 10 digitos
		if (tel.matches("\\d{10}"))
			return true;
		// 11 digitos
		else if (tel.matches("\\d{11}"))
			return true;
		else
			return false;

	}
}
