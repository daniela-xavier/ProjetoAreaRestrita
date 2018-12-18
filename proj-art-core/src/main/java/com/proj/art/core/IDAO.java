package com.proj.art.core;

import java.util.List;

/*
 * IDAO.java
 *
 * Created on 12-12-2018
 *
 * Copyright(c) 2018 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

/**
 * Description the class  IDAO - Classe de contrato para os métodos executados no
 * padrão DAO.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 12/12/2018
 */

public interface IDAO<DomainEntity> {

    /**
     * Toda classe DAO deve conter as anotações. 
     * @Component("<nameEntity>DAO")
     * @Repository
     */
    
    /**
     * Método que realiza a pesquisa de entidade por id.
     *
     * @param id
     * @return domainEntity
     */
    public DomainEntity findOne(long id);

    /**
     * Método de pesquisa de todas as entidades.
     *
     * @return List<'DomainEntity'>
     */
    public List<DomainEntity> findAll();

    /**
     * Método de pesquisa de todas as entidades, com o valor de inicio e fim da
     * lista.
     *
     * @param begin
     * @param end
     * @return List<'DomainEntity'>
     */
    public List<DomainEntity> findByMaxList(int begin, int end);

    /**
     * Método de pesquisa de entidade por critérios.
     *
     * @param entity
     * @return List<'DomainEntity'>
     */
    public List<DomainEntity> findByCriteria(DomainEntity entity);

    /**
     * Método que salva a entidade.
     *
     * @param entity
     */
    public void save(DomainEntity entity);

    /**
     * Método que atualiza entidade.
     *
     * @param entity
     * @return domainEntity
     */
    public DomainEntity update(DomainEntity entity);

    /**
     * Método que deleta a entidade.
     *
     * @param entity
     */
    public void delete(DomainEntity entity);

    /**
     * Método que deleta a entidade por id.
     *
     * @param id
     */
    public void deleteById(long id);
}
