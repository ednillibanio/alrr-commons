package br.kmdr.financeiro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.kmdr.core.domain.CartaoType;
import br.kmdr.core.entity.BaseEntity;

@Entity
@Table(name = "bandeira_cartao")
public class BandeiraCartao extends BaseEntity<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -248648415012715565L;

	@Column(unique = true, nullable = false)
	private String nome;

	@Column(nullable = true)
	private byte[] imagem;

	@Column(nullable = true)
	private String site;

	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false, length = 2, name = "tipo_cartao")
	private CartaoType tipoCartao;

	@Column(nullable = false)
	private Boolean ativo = Boolean.TRUE;

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public CartaoType getTipoCartao() {
		return tipoCartao;
	}

	public void setTipoCartao(CartaoType tipoCartao) {
		this.tipoCartao = tipoCartao;
	}

}
