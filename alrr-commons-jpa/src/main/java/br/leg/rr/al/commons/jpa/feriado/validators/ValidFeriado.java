package br.leg.rr.al.commons.jpa.feriado.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target({ ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FeriadoConstraintValidator.class)
public @interface ValidFeriado {

	String message() default "Feriado Inválido.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
