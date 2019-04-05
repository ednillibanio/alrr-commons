package br.kmdr.imobil.entity.imovel;

import java.util.Date;
import java.util.List;

import br.kmdr.imobil.entity.pessoa.Pessoa;

public class Locacao {

	private Long id;

	private String valor;
	/**
	 * Mensal Bimestral Trimestral Semestral Anual
	 */
	private String tipoContrato;

	private String diaVencimento;

	private Corretor corretor;

	private List<Pessoa> fiadores;

	private boolean imovelSegurado;

	private List<Pessoa> locatarios;

	private Date dataCadastro;

	private Date dataInicioContrato;

	private int taxaAdministrativa;

	private String Observação;

	// TODO: Definir ainda o contrato. Tem que criar um gerador de contrato
	// modelo.
	private String contrato;
	/**
	 * TODO: Talvez usar o DominioValor ou criar um novo DominioInteiro ou
	 * DominioFracionado..seila como escreve.
	 */
	private Comissao comissao;

	// TODO: arrumar a maneira correta de colocar a data que será reajustado o
	// aluguel, mas será anual. Tem que ver a maneira melhor.
	private Date dataReajuste;

	private Imovel imovel;

}
