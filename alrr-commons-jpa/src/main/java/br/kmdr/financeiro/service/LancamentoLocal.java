package br.kmdr.financeiro.service;

import java.util.List;

import javax.ejb.Local;

import br.kmdr.core.dao.JPADao;
import br.kmdr.financeiro.entity.Lancamento;

@Local
public interface LancamentoLocal extends JPADao<Lancamento, Long> {

	List<Lancamento> getLancamentosAReceber(Long contaId);

	List<Lancamento> findAllLancamentosAReceber();

	List<Lancamento> getLancamentosAPagar(Long contaId);

	List<Lancamento> findAllLancamentosAPagar();

	List<Lancamento> findLancamentosHoje(Long contaId);

	List<Lancamento> findLastWeek(Long contaId);

	List<Lancamento> findToday(Long contaId);

}
