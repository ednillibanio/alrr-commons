package br.leg.rr.al.commons.ejb;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Named;

@Named
@Stateless
public class TelefoneService implements TelefoneLocal, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4793939344872728220L;

}
