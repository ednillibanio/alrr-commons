/*******************************************************************************
 * ALE-RR Licença
 * Copyright (C) 2018, ALE-RR
 * Boa Vista, RR - Brasil
 * Todos os direitos reservados.
 * 
 * Este programa é propriedade da Assembleia Legislativa do Estado de Roraima e 
 * não é permitida a distribuição, alteração ou cópia da mesma sem prévia autoriazação.
 ******************************************************************************/
package br.leg.rr.al.commons.web.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.leg.rr.al.commons.jpa.Telefone;
import br.leg.rr.al.commons.utils.TelefoneUtils;
import br.leg.rr.al.core.web.converters.BasicConverter;

/**
 * @author Ednil Libanio da Costa Junior
 * @date 05-05-2012
 */
@Named(value = "telefoneConverter")
public class TelefoneConverter extends BasicConverter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7220976326007699510L;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (StringUtils.isNotBlank(value)) {

			Telefone tel = (Telefone) getAttributesFrom(component).get("0");

			String numero = TelefoneUtils.unformat(value);
			tel.setDdd(TelefoneUtils.getDdd(numero));
			tel.setNumero(TelefoneUtils.getNumeroSemDdd(numero));
			return tel;
		}
		return value;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {

			Telefone tel = (Telefone) value;
			// adiciona item como atributo do componente
			// precisa desse método para pegá-lo no getAsObject. Senão, não funciona.
			this.addAttribute(component, tel);

			if (tel.getNumero() != null && tel.getTipo() != null) {
				String numero = TelefoneUtils.format(tel.getDdd().concat(tel.getNumero()), tel.getTipo());
				return numero;
			}
		}

		return null;
	}
}
