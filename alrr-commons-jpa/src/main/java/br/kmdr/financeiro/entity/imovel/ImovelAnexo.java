package br.kmdr.imobil.entity.imovel;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import br.kmdr.util.domain.ImovelAnexoType;
import br.kmdr.util.entity.BaseEntity;

@Entity
@Table(name = "imovel_foto")
public class ImovelAnexo extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6860120064293361569L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, length = 4)
	private Long id;

	@Lob
	@Basic(fetch = FetchType.LAZY, optional = false)
	private byte[] anexo;

	@Column(length = 150, nullable = true)
	private String nome;

	@Column(length = 400, nullable = true)
	private String descricao;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "tipo_anexo", nullable = false)
	private ImovelAnexoType tipoAnexo;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getAnexo() {
		return anexo;
	}

	public void setAnexo(byte[] anexo) {
		this.anexo = anexo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ImovelAnexoType getTipoAnexo() {
		return tipoAnexo;
	}

	public void setTipoAnexo(ImovelAnexoType tipoAnexo) {
		this.tipoAnexo = tipoAnexo;
	}

}
