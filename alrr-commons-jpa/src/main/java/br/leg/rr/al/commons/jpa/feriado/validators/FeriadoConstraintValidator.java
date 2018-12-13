package br.leg.rr.al.commons.jpa.feriado.validators;

import javax.inject.Named;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.leg.rr.al.commons.domain.FeriadoType;
import br.leg.rr.al.commons.jpa.Feriado;

/**
 * <p>
 * Essa classe de Bean Validation valida se os campos obrigatórios estão
 * preenchidos de acordo com o tipo do feriado. As seguintes validações serão
 * aplicadas:
 * </p>
 * <ul>
 * <li>No caso do tipo feriado igual a Nacional, os campos uf e municipio devem
 * ser vazios.</li>
 * <li>No caso do tipo feriado igual a Estadual, o campo uf é obrigatório, e o
 * campo municipio vazio.</li>
 * <li>No caso do tipo feriado igual a Municipal, o campo uf e municipio devem
 * ser obrigatórios.</li>
 * </ul>
 * 
 * @author <a href="mailto:ednil.libanio@gmail.com"> Ednil Libanio da Costa
 *         Junior</a>
 * @since 1.0.0
 */
@Named
public class FeriadoConstraintValidator implements ConstraintValidator<ValidFeriado, Feriado> {

	@Override
	public void initialize(ValidFeriado constraintAnnotation) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(Feriado feriado, ConstraintValidatorContext context) {

		if (feriado == null) {
			return true;
		}

		Boolean valido = true;
		context.disableDefaultConstraintViolation();

		if (feriado.getTipo() == null) {

			valido = false;
			context.buildConstraintViolationWithTemplate("Tipo Feriado obrigatório").addPropertyNode("tipo")
					.addConstraintViolation();
		} else if (feriado.getTipo().equals(FeriadoType.NACIONAL)) {

			if (feriado.getUf() != null) {
				context.buildConstraintViolationWithTemplate(
						"O valor do campo Uf deve ser nulo para o tipo de feriado Nacional.").addConstraintViolation();
				valido = false;
			}

			if (feriado.getMunicipio() != null) {
				context.buildConstraintViolationWithTemplate(
						"O valor do campo Municipio deve ser nulo para o tipo de feriado Nacional.")
						.addConstraintViolation();
				valido = false;
			}

		} else if (feriado.getTipo().equals(FeriadoType.ESTADUAL)) {

			if (feriado.getUf() == null) {
				context.buildConstraintViolationWithTemplate("campo obrigatório.").addPropertyNode("uf")
						.addConstraintViolation();
				valido = false;
			}

			if (feriado.getMunicipio() != null) {
				context.buildConstraintViolationWithTemplate(
						"O valor do campo Municipio deve ser nulo para o tipo de feriado igual a Estadual.")
						.addPropertyNode("municipio").addConstraintViolation();
				valido = false;
			}

		} else if (feriado.getTipo().equals(FeriadoType.MUNICIPAL)) {

			valido = (feriado.getMunicipio() != null);

			if (!valido) {
				context.buildConstraintViolationWithTemplate("campo obrigatório.").addPropertyNode("municipio")
						.addConstraintViolation();
			}

		}

		return valido;

	}
}
