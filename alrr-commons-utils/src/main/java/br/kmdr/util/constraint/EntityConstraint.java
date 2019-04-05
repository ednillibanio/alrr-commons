package br.kmdr.util.constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Target({ ElementType.ANNOTATION_TYPE, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
// FIXME: Tentei fazer com que os constraints de nível de classe, já tivessem
// essa configuracao em vez d ficar digitando toda hora. Ver depois se tem um
// jeito.
public @interface EntityConstraint {

}
