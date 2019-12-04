package br.com.arearestrita.strategy.impl;

import br.com.arearestrita.strategy.IStrategy;
import br.com.arearestrita.model.DomainEntity;

/**
 * Description the class  ComplementaryEntityActive - Classe que implementa o método
 process do contrato com IStrategy.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version  $Revision: 1
 * @since Build 0.1 04/12/019
 */
public class ComplementaryEntityActive implements IStrategy {

    /**
     * Método que realiza o process do método strategy,
 Adiciona ativo na entidade passada por parametro.
     * @param entity
     * @return String
     */
    @Override
    public String process(DomainEntity entity) {
        entity.setActive("S");
        return null;
    }

}


