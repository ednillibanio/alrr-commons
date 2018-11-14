package br.leg.rr.al.commons.web.validators;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

import br.leg.rr.al.commons.web.CommonsWebValidationMessages;
import br.leg.rr.al.core.helper.DataUtils;
import br.leg.rr.al.core.utils.MessageUtils;
import br.leg.rr.al.core.web.util.FacesMessageUtils;

@Named
@RequestScoped
public class DiaValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

		if (!DataUtils.isDia((String) value)) {
			String msg = MessageUtils.formatMessage(CommonsWebValidationMessages.DIA_INVALIDO);
			throw new ValidatorException(FacesMessageUtils.createError(msg));
		}

	}

}
