package br.kmdr.imobil.service.financeiro;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;

import br.kmdr.imobil.entity.financeiro.Banco;
import br.kmdr.util.dao.BaseDao;

@Named
@Stateless
public class BancoBean extends BaseDao<Banco> implements BancoLocal {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7641500888870969137L;

	@Override
	public Banco findByCodigo(String codigo) {
		return findEntity("Banco.findByCodigo", "codigo", codigo);
	}

	@Override
	public List<Banco> findByNome(String nome) {
		return findByNamedQuery("Banco.findByNome", "nome",
				"%".concat(nome.toUpperCase().concat("%")));
	}
}
