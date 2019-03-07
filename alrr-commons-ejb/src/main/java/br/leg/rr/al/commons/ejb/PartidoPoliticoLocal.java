package br.leg.rr.al.commons.ejb;

import java.util.List;

import javax.ejb.Local;

import br.leg.rr.al.commons.jpa.PartidoPolitico;
import br.leg.rr.al.core.dao.DominioIndexadoJPADao;
import br.leg.rr.al.core.dao.DominioJPADao;

@Local
public interface PartidoPoliticoLocal extends DominioIndexadoJPADao<PartidoPolitico> {

	public List<PartidoPolitico> buscarPorSigla(String sigla);
}
