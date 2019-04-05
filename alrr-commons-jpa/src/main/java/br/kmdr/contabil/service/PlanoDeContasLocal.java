package br.kmdr.contabil.service;

import java.util.List;

import javax.ejb.Local;

import br.kmdr.contabil.entity.PlanoDeContas;
import br.kmdr.core.dao.JPADao;
import br.kmdr.util.service.BeanException;

@Local
public interface PlanoDeContasLocal extends JPADao<PlanoDeContas,Integer> {

	public List<PlanoDeContas> findByCodigo(String codigo)
			throws BeanException;

	public List<PlanoDeContas> buscarPorNome(String nome)
			throws BeanException;
}
