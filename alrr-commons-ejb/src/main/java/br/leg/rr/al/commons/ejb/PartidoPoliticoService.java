package br.leg.rr.al.commons.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.leg.rr.al.commons.jpa.PartidoPolitico;
import br.leg.rr.al.core.dao.BaseDominioIndexadoJPADao;
import br.leg.rr.al.core.domain.StatusType;

@Named
@Stateless
public class PartidoPoliticoService extends BaseDominioIndexadoJPADao<PartidoPolitico> implements PartidoPoliticoLocal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4041196114197590398L;

	@Override
	public List<PartidoPolitico> buscarPorSigla(String sigla) {

		CriteriaQuery<PartidoPolitico> cq = getCriteriaBuilder().createQuery(PartidoPolitico.class);
		Root<PartidoPolitico> root = cq.from(PartidoPolitico.class);
		cq.select(root);

		Expression<String> exp = getCriteriaBuilder().lower(root.get("sigla"));
		Predicate like = getCriteriaBuilder().like(exp, "%" + sigla.toLowerCase().trim() + "%");

		Predicate ativos = getCriteriaBuilder().equal(root.get("situacao"), StatusType.ATIVO);

		cq.where(like, ativos);

		TypedQuery<PartidoPolitico> q = getEntityManager().createQuery(cq);
		return q.getResultList();

	}

	@Override
	public Boolean jaExiste(PartidoPolitico entidade) {
		return false;
	}

}
