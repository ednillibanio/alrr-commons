package br.kmdr.imobil.service.contabil;

import java.util.List;

import javax.ejb.Local;

import br.kmdr.imobil.entity.contabil.PlanoDeContas;
import br.kmdr.util.dao.Dao;
import br.kmdr.util.service.BaseBeanException;

@Local
public interface PlanoDeContasLocal extends Dao<PlanoDeContas> {

	public List<PlanoDeContas> findByCodigo(String codigo)
			throws BaseBeanException;

	public List<PlanoDeContas> findByNome(String nome)
			throws BaseBeanException;
}
