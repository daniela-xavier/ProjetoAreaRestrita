
package br.com.arearestrita.strategy.impl;


import br.com.arearestrita.strategy.IStrategy;
import br.com.arearestrita.model.DomainEntity;

import java.util.Calendar;
import java.util.Date;

/**
 * Description the class ComplementaryEntityIncludedInBy - Classe que implementa
 * o método process do contrato com IStrategy.
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version  $Revision: 1
 * @since Build 0.1 04/12/019
 */
public class ComplementaryEntityIncludedInBy implements IStrategy {

    /**
     * Método que realiza o process do método strategy, Adiciona usuario
     * 'FOZWEBSERVICE' e a data atual na entity passada por parametro, atributos
     * de inclusao.
     *
     * @param entity
     * @return String
     */
    @Override
    public String process(DomainEntity entity) {
        if (entity.getOwner().isEmpty()) {
            entity.setIncludedBy("FOZART");
        } else {
            entity.setIncludedBy(entity.getOwner());
        }

        if (entity.getIncludedIn() == null) {
            Date data = Calendar.getInstance().getTime();
            entity.setIncludedIn(data);
        }
        return null;
    }
}
