/*
 * IStrategy.java
 *
 * Created on 12-12-2018
 *
 * Copyright(c) 2018 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.art.core;

import com.proj.art.model.DomainEntity;

/**
 * Description the class  IStrategy - Classe que implementa o padrão strategy.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 12/12/2018
 */

public interface IStrategy {

    /**
     * Método que realiza o process do método strategy.
     * @param entidade
     * @return String
     */
    public String process(DomainEntity entidade);
}
