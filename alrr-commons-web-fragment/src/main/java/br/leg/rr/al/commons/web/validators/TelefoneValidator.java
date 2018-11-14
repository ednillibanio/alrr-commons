package br.leg.rr.al.commons.web.validators;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

import br.leg.rr.al.commons.utils.CommonsValidationMessages;
import br.leg.rr.al.commons.utils.TelefoneUtils;
import br.leg.rr.al.core.utils.MessageUtils;
import br.leg.rr.al.core.web.util.FacesMessageUtils;

/**
 * @author Ednil Libanio da Costa Junior
 * @date 13-04-2012
 */
@Named
public class TelefoneValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

		if (!TelefoneUtils.isValid(value.toString())) {
			// String tel = TelefoneUtils.format(value.toString());
			String msg = MessageUtils.formatMessage(CommonsValidationMessages.TELEFONE_INVALIDO, value.toString());
			throw new ValidatorException(FacesMessageUtils.createError(msg));
		}

	}
}
