package br.kmdr.imobil.service.contabil;

import java.util.List;

import javax.ejb.Local;

import br.kmdr.imobil.entity.contabil.CentroDeCustos;
import br.kmdr.util.dao.Dao;
import br.kmdr.util.service.BaseBeanException;

@Local
public interface CentroDeCustosLocal extends Dao<CentroDeCustos> {

	public List<CentroDeCustos> findByCodigo(String codigo)
			throws BaseBeanException;

	public List<CentroDeCustos> findByNome(String nome)
			throws BaseBeanException;
}
