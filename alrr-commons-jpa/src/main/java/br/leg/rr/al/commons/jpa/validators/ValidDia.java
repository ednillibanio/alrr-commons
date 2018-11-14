package br.leg.rr.al.commons.jpa.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.hibernate.validator.constraints.Range;

@Range(min = 1, max = 31, message = "O dia deve ser entre 1 e 31.")
@Documented
@Target({ ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DiaConstraintValidator.class)
public @interface ValidDia {

	String message() default "Dia inválido. Informe outro dia.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
