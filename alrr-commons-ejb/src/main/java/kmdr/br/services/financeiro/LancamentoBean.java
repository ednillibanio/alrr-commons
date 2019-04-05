package br.kmdr.imobil.service.financeiro;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Named;

import br.kmdr.imobil.entity.financeiro.Lancamento;
import br.kmdr.util.dao.BaseDao;
import br.kmdr.util.domain.LancamentoSituacao;

@Named
@Stateless
public class LancamentoBean extends BaseDao<Lancamento> implements
		LancamentoLocal {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1208226422871893838L;

	@Override
	public List<Lancamento> getLancamentosAReceber(Long contaId) {

		Map<String, Object> params = new Hashtable<String, Object>(2);
		params.put("conta_id", contaId.toString());
		params.put("situacao", LancamentoSituacao.A_RECEBER);

		return findByNamedQuery("Lancamento.findBySituacao", params);
	}

	@Override
	public List<Lancamento> findAllLancamentosAReceber() {
		return findByNamedQuery("Lancamento.findAllBySituacao", "situacao",
				LancamentoSituacao.A_RECEBER);
	}

	@Override
	public List<Lancamento> getLancamentosAPagar(Long contaId) {
		return findByNamedQuery("Lancamento.findBySituacao", "situacao",
				LancamentoSituacao.A_PAGAR);
	}

	@Override
	public List<Lancamento> findAllLancamentosAPagar() {
		return findByNamedQuery("Lancamento.findAllBySituacao", "situacao",
				LancamentoSituacao.A_PAGAR);
	}

	@Override
	public List<Lancamento> findLancamentosHoje(Long contaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lancamento> findLastWeek(Long contaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lancamento> findToday(Long contaId) {
		return findByNamedQuery("Lancamento.findToday", "conta_id", contaId);
	}

}
