/*
 * AbstractService.java
 *
 * Created on 12-12-2018
 *
 * Copyright(c) 2018 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.art.core.service.impl;

import com.proj.art.model.anotations.ADomainEntity;

/**
 * Description the class  AbstractService - Classe que implementa o retorno dos
 * atributos da anotação @ADomainEntity
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 12/12/2018
 */
public abstract class AbstractService {

    /**
     * Método que recupera a classe de <DomainEntity>Service.class instanciada.
     *
     * @return Classe<DomainEntity>
     */
    public Class<?> getClasse() {

        ADomainEntity annotation = this.getClass().getAnnotation(ADomainEntity.class);
        if (annotation != null) {
            return annotation.classe();
        }

        return null;
    }

    /**
     * Método que recupera o nome da entidade de <DomainEntity>Service.class
     * instanciada.
     *
     * @return <DomainEntity>
     */
    public String getEntidadeNome() {

        ADomainEntity annotation = this.getClass().getAnnotation(ADomainEntity.class);
        if (annotation != null) {
            return annotation.nome();
        }

        return null;
    }

}

