/*
 * EntityApplication.java
 *
 * Created on 12-12-2018
 *
 * Copyright(c) 2018 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.art.core.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description the class  EntityApplication -  Entidade da Aplicação.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 12/12/2018
 */

public class EntityApplication {

    /**
     * Método de log das Entidades por classe.
     * @param clazz
     * @return Logger
     */
    public Logger getLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }
}
