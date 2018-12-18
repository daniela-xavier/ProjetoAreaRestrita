/*
 * ComplementaryEntityActive.java
 *
 * Created on 12-12-2018
 *
 * Copyright(c) 2018 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.art.core.strategy.impl;

import com.proj.art.core.IStrategy;
import com.proj.art.model.DomainEntity;

/**
 * Description the class  ComplementaryEntityActive - Classe que implementa o método
 process do contrato com IStrategy.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 12/12/2018
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

