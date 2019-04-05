package br.kmdr.imobil.service.financeiro;

import java.util.List;

import javax.ejb.Local;

import br.kmdr.imobil.entity.financeiro.Banco;
import br.kmdr.util.dao.Dao;

@Local
public interface BancoLocal extends Dao<Banco> {

	public Banco findByCodigo(String codigo);

	public List<Banco> findByNome(String nome);

}
