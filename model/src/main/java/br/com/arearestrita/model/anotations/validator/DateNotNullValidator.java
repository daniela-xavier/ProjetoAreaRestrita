package br.com.arearestrita.model.anotations.validator;

import br.com.arearestrita.model.anotations.DateNotNull;
import java.util.Date;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Description the class DateNotNullValidator - Validador de date nula.
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version  $Revision: 1
 * @since Build 0.1 02/12/019
 */
public class DateNotNullValidator implements ConstraintValidator<DateNotNull, Date> {

    @Override
    public void initialize(DateNotNull constraintAnnotation) {

    }

    @Override
    public boolean isValid(Date date, ConstraintValidatorContext context) {
        if (date == null) {
            return true;
        }             
        return false;
    }

}
