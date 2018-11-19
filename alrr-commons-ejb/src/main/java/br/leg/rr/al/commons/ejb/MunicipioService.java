package br.leg.rr.al.commons.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import br.leg.rr.al.commons.domain.UfType;
import br.leg.rr.al.commons.ibge.ejb.IbgeMunicipioLocal;
import br.leg.rr.al.commons.ibge.jpa.IbgeMunicipio;
import br.leg.rr.al.commons.jpa.Municipio;
import br.leg.rr.al.commons.jpa.Municipio_;
import br.leg.rr.al.core.dao.BaseJPADaoStatus;
import br.leg.rr.al.core.dao.BeanException;
import br.leg.rr.al.core.jpa.BaseEntityStatus_;

@Named
@Stateless
public class MunicipioService extends BaseJPADaoStatus<Municipio, Integer> implements MunicipioLocal {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7074097657495549567L;

	@EJB
	private IbgeMunicipioLocal ibgeMunicipioBean;

	@Override
	public Municipio buscarPorUf(UfType uf, String nome) throws BeanException {

		CriteriaBuilder cb = getCriteriaBuilder();
		CriteriaQuery<Municipio> cq = createCriteriaQuery();
		Root<Municipio> root = cq.from(Municipio.class);
		List<Predicate> predicates = new ArrayList<Predicate>();
		cq.select(root);

		if (uf != null) {

			Predicate cond1 = cb.equal(root.get(Municipio_.uf), uf);
			predicates.add(cond1);
		}

		if (StringUtils.isNotBlank(nome)) {
			Predicate cond2 = cb.equal(cb.lower(root.get(Municipio_.nome)), nome.toLowerCase());
			predicates.add(cond2);
		}

		cq.where(cb.and(predicates.toArray(new Predicate[] {})));

		return getSingleResult(cq);

	}

	@Override
	public List<Municipio> buscarPorNome(String nome, UfType uf) throws BeanException {

		CriteriaBuilder cb = getCriteriaBuilder();
		CriteriaQuery<Municipio> cq = createCriteriaQuery();
		Root<Municipio> root = cq.from(Municipio.class);
		List<Predicate> predicates = new ArrayList<Predicate>();
		cq.select(root);

		if (uf != null) {
			Predicate cond1 = cb.equal(root.get(Municipio_.uf), uf);
			predicates.add(cond1);
		}

		if (StringUtils.isNotBlank(nome)) {
			Predicate cond2 = cb.like(cb.lower(root.get(Municipio_.nome)), "%" + nome.toLowerCase() + "%");
			predicates.add(cond2);
		}

		cq.where(cb.and(predicates.toArray(new Predicate[] {})));

		return getResultList(cq);

	}

	@Override
	public Boolean jaExiste(Municipio entidade) {
		CriteriaBuilder cb = getCriteriaBuilder();
		CriteriaQuery<Municipio> cq = createCriteriaQuery();
		Root<Municipio> root = cq.from(Municipio.class);
		cq.select(root);

		List<Predicate> predicates = new ArrayList<Predicate>();

		Predicate nome = cb.equal(root.get(Municipio_.nome), entidade.getNome());
		predicates.add(nome);

		Predicate uf = cb.equal(root.get(Municipio_.uf), entidade.getUf());
		predicates.add(uf);

		if (entidade.getIbgeId() != null) {
			Predicate id = cb.notEqual(root.get(Municipio_.ibgeId), entidade.getIbgeId());
			predicates.add(id);
		}

		// condição para não verificar a mesma entidade se já existir.
		if (entidade.getId() != null) {
			Predicate id = cb.notEqual(root.get(BaseEntityStatus_.id), entidade.getId());
			predicates.add(id);
		}

		cq.where(predicates.toArray(new Predicate[predicates.size()]));

		return (!getResultList(cq).isEmpty());

	}

	@Override
	public void importarMunicipiosDoIBGE() {
		List<IbgeMunicipio> municipios = ibgeMunicipioBean.buscarMunicipios();
		if (municipios != null) {
			// FIXME: Ver se via implementar aqui a parte de salvar os municipios do ibge.
			// Acho que tem que ser feito em outro local ou não salvar.
			// ibgeMunicipioBean.salvar(municipios);
			String nome = null;
			UfType uf = null;
			Municipio loc = null;
			for (IbgeMunicipio mun : municipios) {

				nome = mun.getNome();
				uf = UfType.valueOf(mun.getUF().getSigla());

				loc = buscarPorUf(uf, nome);

				// atualiza a municipio com o numero do ibge.
				if (loc != null && loc.getIbgeId() == null) {
					loc.setIbgeId(mun.getId());
				} else {
					loc = converterIbgeMunicipioParaLocalidade(mun);
				}
				salvar(loc);
			}
		}

	}

	private Municipio converterIbgeMunicipioParaLocalidade(IbgeMunicipio municipio) {

		Municipio loc = new Municipio();
		loc.setIbgeId(municipio.getId());
		loc.setNome(municipio.getNome());
		loc.setUf(UfType.valueOf(municipio.getUF().getSigla()));
		return loc;

	}

}
