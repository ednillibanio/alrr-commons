package br.leg.rr.al.commons.ejb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import br.leg.rr.al.commons.domain.FeriadoType;
import br.leg.rr.al.commons.jpa.Feriado;
import br.leg.rr.al.commons.jpa.Feriado_;
import br.leg.rr.al.core.dao.DominioJPADaoStatus;
import br.leg.rr.al.core.domain.Mes;
import br.leg.rr.al.core.domain.StatusType;
import br.leg.rr.al.core.helper.DataUtils;

/**
 * @author <a href="mailto:ednil.libanio@gmail.com"> Ednil Libanio da Costa
 *         Junior</a><br/>
 *         Data Criação: 22-08-2018<br/>
 * @since 1.0.0
 */
@Named
@Stateless
public class FeriadoService extends DominioJPADaoStatus<Feriado> implements FeriadoLocal {

	@SuppressWarnings("unchecked")
	@Override
	public List<Feriado> pesquisar(Map<String, Object> params) {

		/** FILTROS **/
		List<Predicate> predicates = new ArrayList<Predicate>();
		Predicate cond = null;
		String nome = null;
		StatusType sit = null;
		List<Mes> meses = null;
		List<FeriadoType> tipos = null;

		final CriteriaBuilder cb = getCriteriaBuilder();
		CriteriaQuery<Feriado> cq = cb.createQuery(Feriado.class);
		final Root<Feriado> root = cq.from(Feriado.class);
		cq.select(root).distinct(true);

		if (params.size() > 0) {

			if (params.containsKey(PESQUISAR_PARAM_NOME)) {

				nome = (String) params.get(PESQUISAR_PARAM_NOME);

				if (StringUtils.isNotBlank(nome)) {

					cond = cb.like(cb.lower(root.get(Feriado_.nome)), "%" + nome.toLowerCase() + "%");
					predicates.add(cond);
				}
			}

			if (params.containsKey(PESQUISAR_PARAM_SITUACAO)) {
				sit = (StatusType) params.get(PESQUISAR_PARAM_SITUACAO);
				if (sit != null) {
					cond = cb.equal(root.get(Feriado_.situacao), sit);
					predicates.add(cond);
				}
			}

			if (params.containsKey(PESQUISAR_PARAM_MESES)) {

				meses = (List<Mes>) params.get(PESQUISAR_PARAM_MESES);

				if (meses != null && meses.size() > 0) {

					cond = root.get(Feriado_.mes).in(Arrays.asList(meses));
					predicates.add(cond);
				}
			}

			if (params.containsKey(PESQUISAR_PARAM_MESES)) {

				tipos = (List<FeriadoType>) params.get(PESQUISAR_PARAM_TIPOS);

				if (tipos != null && (tipos.size() > 0)) {

					cond = root.get(Feriado_.tipo).in(Arrays.asList(tipos));
					predicates.add(cond);
				}
			}

			cq.where(cb.and(predicates.toArray(new Predicate[] {})));
			return getResultList(cq);

		}

		return null;

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -426295874384756347L;

	@Override
	public List<Feriado> pesquisar(Feriado feriado, List<FeriadoType> tipos, List<Mes> meses) {
		final CriteriaBuilder builder = getCriteriaBuilder();
		CriteriaQuery<Feriado> cq = builder.createQuery(Feriado.class);
		final Root<Feriado> feriadoRoot = cq.from(Feriado.class);
		cq.select(feriadoRoot);

		List<Predicate> predicateList = new ArrayList<Predicate>();

		Predicate predMes, nome, predTipo;

		if (!StringUtils.isBlank(feriado.getNome())) {
			nome = builder.like(builder.upper(feriadoRoot.get(Feriado_.nome)),
					"%" + feriado.getNome().toUpperCase() + "%");
			predicateList.add(nome);
		}

		if (meses != null && (meses.size() > 0)) {
			predMes = feriadoRoot.get(Feriado_.mes).in(Arrays.asList(meses));
			predicateList.add(predMes);
		}

		if (tipos != null && (tipos.size() > 0)) {
			predTipo = feriadoRoot.get(Feriado_.tipo).in(Arrays.asList(tipos));
			predicateList.add(predTipo);
		}

		if (predicateList.size() > 0) {
			cq.where(predicateList.toArray(new Predicate[predicateList.size()]));
		}
		return getEntityManager().createQuery(cq).getResultList();
	}

	@Override
	public List<Feriado> buscarPorIntervalo(Date inicio, Date fim) {
		CriteriaBuilder cb = getCriteriaBuilder();
		CriteriaQuery<Feriado> cq = createCriteriaQuery();
		Root<Feriado> root = cq.from(Feriado.class);
		cq.select(root);
		List<Predicate> predicates = new ArrayList<Predicate>();

		if (inicio != null && fim != null) {
			Integer inicioDia = DataUtils.getDia(inicio);
			Integer inicioMes = DataUtils.getMes(inicio);

			Integer fimDia = DataUtils.getDia(fim);
			Integer fimMes = DataUtils.getMes(fim);

			Expression<Integer> edia = root.get(Feriado_.dia).as(Integer.class);
			Expression<Integer> emes = root.get(Feriado_.mes).as(Integer.class);

			Predicate cond = cb.greaterThanOrEqualTo(edia, inicioDia);
			predicates.add(cond);
			Predicate cond2 = cb.and(cb.greaterThanOrEqualTo(emes, inicioMes));
			predicates.add(cond2);

			Predicate cond3 = cb.lessThanOrEqualTo(edia, fimDia);
			predicates.add(cond3);
			Predicate cond4 = cb.and(cb.lessThanOrEqualTo(emes, fimMes));
			predicates.add(cond4);

			cq.where(cb.and(predicates.toArray(new Predicate[] {})));
			return getResultList(cq);
		}
		return null;
	}

	@Override
	public Boolean jaExiste(Feriado entidade) {
		CriteriaBuilder cb = getCriteriaBuilder();
		CriteriaQuery<Feriado> cq = createCriteriaQuery();
		Root<Feriado> root = cq.from(Feriado.class);
		cq.select(root);
		List<Predicate> predicates = new ArrayList<Predicate>();

		Predicate dia = cb.equal(root.get(Feriado_.dia), entidade.getDia());
		predicates.add(dia);

		Predicate mes = cb.equal(root.get(Feriado_.mes), entidade.getMes());
		predicates.add(mes);

		Predicate tipo = cb.equal(root.get(Feriado_.tipo), entidade.getTipo());
		predicates.add(tipo);

		// condição para não verificar a mesma entidade se já existir.
		if (entidade.getId() != null) {
			Predicate id = cb.notEqual(root.get("id"), entidade.getId());
			predicates.add(id);
		}

		cq.where(cb.and(predicates.toArray(new Predicate[] {})));

		return (!getResultList(cq).isEmpty());
	}

}
