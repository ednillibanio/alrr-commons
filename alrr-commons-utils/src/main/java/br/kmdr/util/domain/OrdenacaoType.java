/**
 * @(#) TipoOrdenacao.java.
 *
 * Copyright (c) 2008 PD CASE
 * Belo Horizonte, MG - Brasil
 * Todos os direitos reservados.
 *
 * Este software e confidencial e é propriedade da PD CASE, não é permitida a
 * distribuição/alteração da mesma sem prévia autorização.
 */
package br.kmdr.util.domain;

/**
 * Tipos de Ordenacao
 *
 * @author <a href="mailto:alfredo.furtado@pdcase.com.br">Alfredo Furtado</a>.
 * @version $Revision: 1.0 $
 */
public enum OrdenacaoType {
	
	C("Cronol�gica"), 
	V("Valor"),
	P("Prefer�ncia");
	
	private String descricao;

	private OrdenacaoType(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
