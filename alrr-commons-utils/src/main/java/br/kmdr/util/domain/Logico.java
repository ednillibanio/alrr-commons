/**
 * @(#) SimNao.java.
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
 * Descrição da classe.
 * 
 * @author <a href="mailto:carlos.manoel@pdcase.com.br">Carlos Manoel</a>.
 * @version $Revision: 1.1 $
 */
public enum Logico {

	S( "Sim" ), N( "N�o" );

	private Logico(String descricao) {
		this.descricao = descricao;
	}

	private String descricao;

	public String getDescricao() {
		return descricao;
	}

}
