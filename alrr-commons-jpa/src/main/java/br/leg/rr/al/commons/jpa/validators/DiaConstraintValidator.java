package br.leg.rr.al.commons.jpa.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.leg.rr.al.core.helper.DataUtils;

/**
 * @author <a href="mailto:ednil.libanio@gmail.com"> Ednil Libanio da Costa Junior</a><br/> 
 * Data Criação:   23-08-2018<br/>
 * @since 1.0.0
 */
public class DiaConstraintValidator implements ConstraintValidator<ValidDia, String> {

	ValidDia check;

	@Override
	public void initialize(ValidDia arg0) {
		this.check = arg0;

	}

	@Override
	public boolean isValid(String dia, ConstraintValidatorContext ctx) {

		if (!DataUtils.isDia((String) dia)) {
			return false;
		}

		return true;
	}

}
