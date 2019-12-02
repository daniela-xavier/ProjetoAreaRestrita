package br.com.arearestrita.model.anotations.validator;

import br.com.arearestrita.model.anotations.ActivePattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Description the class DateNotNullValidator - Validador de date nula.
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version  $Revision: 1
 * @since Build 0.1 02/12/019
 */
public class ActivePatternValidator implements ConstraintValidator<ActivePattern, String> {

    @Override
    public void initialize(ActivePattern constraintAnnotation) {

    }

    @Override
    public boolean isValid(String active, ConstraintValidatorContext context) {
        return active.equals("s") || active.equals("n");
    }

}
