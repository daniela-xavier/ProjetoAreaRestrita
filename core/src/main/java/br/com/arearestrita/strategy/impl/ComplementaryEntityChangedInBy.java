
package br.com.arearestrita.strategy.impl;

import br.com.arearestrita.strategy.IStrategy;
import br.com.arearestrita.model.DomainEntity;

import java.util.Calendar;
import java.util.Date;

/**
 * Description the class ComplementaryEntityChangedInBy - Classe que implementa
 * o método process do contrato com IStrategy.
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 23/01/2019
 */
public class ComplementaryEntityChangedInBy implements IStrategy {

    /**
     * Método que realiza o process do método strategy, Adiciona usuario
     * 'FOZWEBSERVICE' e a data atual na entity passada por parametro, atributos
     * de alteração.
     *
     * @param entity
     * @return String
     */
    @Override
    public String process(DomainEntity entity) {

        if (entity.getOwner().isEmpty()) {
            entity.setChangedBy("FOZART");
        } else {
            entity.setChangedBy(entity.getOwner());
        }

        if (entity.getChangedIn() == null) {
            Date data = Calendar.getInstance().getTime();
            entity.setChangedIn(data);
        }
        
        return null;
    }

}
