package br.leg.rr.al.commons.web.controllers;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.leg.rr.al.core.utils.StringHelper;
import br.leg.rr.al.core.web.util.FacesMessageUtils;
import br.leg.rr.al.localidade.domain.EnderecoType;
import br.leg.rr.al.localidade.ejb.EnderecoLocal;
import br.leg.rr.al.localidade.jpa.Endereco;

@Named
@ViewScoped
public class EnderecoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8778872964198415981L;

	private Endereco endereco = new Endereco();

	private Boolean semCep = false;

	private Boolean semBairro = false;

	@EJB
	private EnderecoLocal enderecoBean;

	/**
	 * Busca o Endereço pelo Cep informado.
	 * 
	 */
	public void buscarEnderecoPorCep() {

		try {

			Endereco end = enderecoBean.buscarEnderecoPorCep(getEndereco().getCep());
			if (end != null) {
				setEndereco(end);
			} else {
				FacesMessageUtils.addError("Não foi possível localizar o endereço pelo cep: " + getEndereco().getCep());
			}
		} catch (Exception e) {

			FacesMessageUtils.addError(e.getMessage());
		}

	}

	/**
	 * Preenche a Municipio do Endereço a partir do Bairro selecionado.
	 * 
	 */
	public void preencherEnderecoPeloBairro(SelectEvent event) {
		enderecoBean.preencherEnderecoPeloBairro(endereco);
	}

	/**
	 * Preenche a Municipio do Endereço a partir do Bairro selecionado.
	 * 
	 */
	public void preencherEnderecoPeloMunicipio(SelectEvent event) {
		endereco.setBairro(null);
	}

	
	/**
	 * Responsável por preencher a variável Endereco a partir do banco de dados.
	 * 
	 * @param enderecos lista com os endereços que foram carregados a partir do
	 *                  banco de dados e que vai ser usada para carregar a variável
	 *                  <code>enderecoComercial</code>.
	 */
	public void preencherEnderecoComercial(Set<Endereco> enderecos) {

		if (enderecos != null && enderecos.size() > 0) {
			for (Endereco end : enderecos) {
				if (end.getTipo() == EnderecoType.COMERCIAL) {
					setEndereco(end);
					break;
				}
			}
		}
	}

	/**
	 * Responsável por preencher a variável Endereco a partir do banco de dados.
	 * 
	 * @param enderecos lista com os endereços que foram carregados a partir do
	 *                  banco de dados e que vai ser usada para carregar a variável
	 *                  <code>enderecoResidencial</code>.
	 */
	public void preencherEnderecoResidencial(Set<Endereco> enderecos) {

		if (enderecos != null && enderecos.size() > 0) {
			for (Endereco end : enderecos) {
				if (end.getTipo() == EnderecoType.RESIDENCIAL) {
					setEndereco(end);
					break;
				}
			}
		}
	}
	
	
	/**
	 * Método que atualiza o endereço associados a uma pessoa. Caso seja novo,
	 * insere. Caso já exista, atualiza os dados.
	 * 
	 * @param pessoa
	 */
	protected void atualizarEndereco(Set<Endereco> enderecos, Endereco endereco) {

		if (endereco != null) {
			if (endereco.getId() == null && endereco.getLogradouro() != null) {
				enderecos.add(endereco);
			} else if (endereco.getId() != null && endereco.getLogradouro() == null) {
				// remover
			}
		}
	}
	
	/**
	 * Transformar primeira letra de cada palavra de logradouro em maiúscula.
	 */
	public void capitalizeLogradouro() {
		String logradouro = StringHelper.capitalizeFully(endereco.getLogradouro());
		endereco.setLogradouro(logradouro);
	}

	/**
	 * Limpa os valores do endereço. Este procedimento evita que um endereço
	 * inválido seja salvo.
	 */
	public void limparEndereco() {
		enderecoBean.limparEndereco(endereco);
		semBairro = false;
	}

	/**
	 * Remove o campo bairro do endereço. Método utilizado para quando não há Cep e
	 * nem Bairro no cadastro do endereço.
	 */
	public void limparBairro() {
		endereco.setBairro(null);
		endereco.setMunicipio(null);
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Boolean getSemCep() {
		return semCep;
	}

	public void setSemCep(Boolean semCep) {
		this.semCep = semCep;
	}

	public Boolean getSemBairro() {
		return semBairro;
	}

	public void setSemBairro(Boolean semBairro) {
		this.semBairro = semBairro;
	}

}
