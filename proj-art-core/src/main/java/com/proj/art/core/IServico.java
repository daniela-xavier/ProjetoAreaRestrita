/*
 * IServico.java
 *
 * Created on 12-12-2018
 *
 * Copyright(c) 2018 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.art.core;

import java.util.List;
import java.util.Map;

/**
 * Description the class  IServico - Classe que contém o contrato para as
 * implementações de Service.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 12/12/2018
 */
public interface IServico {

    /**
     * Toda classe DAO deve conter as anotações.
     *
     * @Component
     * @Service("<DomainEntity>Service")
     * @ADomainEntity(nome = "<DomainEntity>", classe = <DomainEntity>.class)
     */
    /**
     * Método que retorna o repository da entidade.
     *
     * @return IRepository
     */
    public IRepository getRepository();

    /**
     * Método que retorna o mapa com as operações e a lista de Strategys
     * correspondentes.
     *
     * @return Map<String, List<IStrategy>>
     */
    public Map<String, List<IStrategy>> getStrategys();

    /**
     * Método que retorna a Classe da Entidade com base da anotação
     * @ADomainEntity, no atributo classe.
     *
     * @return Class<DomainEntity>
     */
    public Class<?> getClasse();

    /**
     * Método que retorna o nome da Entidade com base da anotação
     * @ADomainEntity, no atributo nome.
     *
     * @return String
     */
    public String getEntidadeNome();
}
