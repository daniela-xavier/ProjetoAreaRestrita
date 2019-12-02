package br.com.arearestrita.model.anotations;

import br.com.arearestrita.model.anotations.validator.DateNotNullValidator;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Description the class DateNotNull - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version  $Revision: 1
 * @since Build 0.1 02/12/019
 */

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateNotNullValidator.class)
public @interface DateNotNull {

    String message() default "Valor inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String value() default "";
}
