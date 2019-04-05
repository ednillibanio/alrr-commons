package br.kmdr.financeiro.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.kmdr.core.entity.BaseEntity;

@Entity
@Table
public class Boleto extends BaseEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4210879836280673052L;

	private int numeroBoleto;

	// descrição dizendo onde pode pagar. Por exemplo, pagável em qualquer banco
	// até o vencimento.
	private String localPagamento;

	// Ex. Não receber após 05 dias do vencimento; Devolver após 05 dias do
	// vencimento.. bla bla..Depios tem que criar uma classe ou colocar em
	// dominio Valor
	/* private List<String> instConbranca; */

	/* private EspecieDocumento especie; */

	// %
	private float multa;

	// %
	private float juroMoraNes;

	// %
	private float descontoAteData;

	private boolean aceite;

}
