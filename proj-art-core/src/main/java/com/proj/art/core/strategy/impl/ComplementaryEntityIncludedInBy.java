/*
 * ComplementaryEntityIncludedInBy.java
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
import java.util.Calendar;
import java.util.Date;

/**
 * Description the class  ComplementaryEntityIncludedInBy - Classe que implementa o método
 process do contrato com IStrategy.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 12/12/2018
 */
public class ComplementaryEntityIncludedInBy implements IStrategy {

    /**
     * Método que realiza o process do método strategy, Adiciona usuario
 'FOZWEBSERVICE' e a data atual na entity passada por parametro, atributos
 de inclusao.
     *
     * @param entity
     * @return String
     */
    @Override
    public String process(DomainEntity entity) {
        entity.setIncludedBy("FOZART");
        Date data = Calendar.getInstance().getTime();
        entity.setIncludedIn(data);
        return null;
    }
}

