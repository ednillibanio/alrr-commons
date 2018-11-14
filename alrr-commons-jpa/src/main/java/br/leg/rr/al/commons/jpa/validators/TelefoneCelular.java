/**
 * 
 */
package br.leg.rr.al.commons.jpa.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

/**
 * @author Ednil Libanio da Costa Junior
 * @date 13-04-2018
 */
@Qualifier
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = { ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
public @interface TelefoneCelular {

}
