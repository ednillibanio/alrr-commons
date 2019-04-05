package br.kmdr.util.constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckIfExistEntityValidator.class)
@Documented
public @interface CheckIfExistEntity {

	String message() default "{app.entidade.ja.existe}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	// Nome das colunas que serão utilizadas para verificar se é único o
	// registro.
	String namedQuery() default "";

	String columnName();
}
