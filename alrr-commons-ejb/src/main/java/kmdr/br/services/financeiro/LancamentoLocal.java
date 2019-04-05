package br.kmdr.imobil.service.financeiro;

import java.util.List;

import javax.ejb.Local;

import br.kmdr.imobil.entity.financeiro.Lancamento;
import br.kmdr.util.dao.Dao;

@Local
public interface LancamentoLocal extends Dao<Lancamento> {

	List<Lancamento> getLancamentosAReceber(Long contaId);

	List<Lancamento> findAllLancamentosAReceber();

	List<Lancamento> getLancamentosAPagar(Long contaId);

	List<Lancamento> findAllLancamentosAPagar();
	
	List<Lancamento> findLancamentosHoje(Long contaId);
	
	List<Lancamento> findLastWeek(Long contaId);
	
	List<Lancamento> findToday(Long contaId);
	

}
