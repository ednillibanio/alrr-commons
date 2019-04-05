package br.kmdr.contabil.service;

import java.util.List;

import javax.ejb.Local;

import br.kmdr.contabil.entity.CentroDeCustos;
import br.kmdr.core.dao.JPADao;
import br.kmdr.util.service.BeanException;

@Local
public interface CentroDeCustosLocal extends JPADao<CentroDeCustos,Integer> {

	public List<CentroDeCustos> findByCodigo(String codigo)
			throws BeanException;

	public List<CentroDeCustos> buscarPorNome(String nome)
			throws BeanException;
}
