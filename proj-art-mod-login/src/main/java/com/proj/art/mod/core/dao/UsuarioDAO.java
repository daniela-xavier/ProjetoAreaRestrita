/*
 * UsuarioDAO.java
 *
 * Created on 13-12-2018
 *
 * Copyright(c) 2018 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.art.mod.core.dao;

import com.proj.art.core.IDAO;
import com.proj.art.core.dao.impl.DAOImp;
import com.proj.art.mod.model.Usuario;
import java.util.Date;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Description the class  UsuarioDAO - Implementação DAO da entidade usuario.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 13/12/2018
 */
@Component("usuarioDAO")
@Repository
public class UsuarioDAO extends DAOImp<Usuario> implements IDAO<Usuario> {

    /**
     * Método que consulta todos os usuarios, porém apenas retorna os 10
     * primeiros.
     *
     * @return List<Usuario>
     */
    public List<Usuario> findByMaxList() {
        CriteriaBuilder builder = this.em.getCriteriaBuilder();
        CriteriaQuery<Usuario> query = builder.createQuery(Usuario.class);

        TypedQuery<Usuario> typedQuery = this.em.createQuery(query.select(query.from(Usuario.class))
        ).setFirstResult(0) // offset
                .setMaxResults(10); // limit

        List<Usuario> results = typedQuery.getResultList();
        return results;

    }

    /**
     * Método que consulta usuário de acordo com os atributos preenchidos.
     *
     * @param usuario
     * @return List<Usuario>
     */
    @Override
    public List<Usuario> findByCriteria(Usuario usuario) {
        CriteriaBuilder builder = this.em.getCriteriaBuilder();
        CriteriaQuery<Usuario> query = builder.createQuery(Usuario.class);
        Root from = query.from(Usuario.class);

        Predicate predicate = builder.and();

        if (usuario.getId() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<Long>get("id"), usuario.getId()));
        }

        if (usuario.getActive() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<String>get("ativo"), usuario.getActive()));
        }

        if (usuario.getIncludedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<Date>get("includedIn"), new DateTime(usuario.getIncludedIn(), DateTimeZone.UTC)));
        }

        if (usuario.getChangedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<Date>get("changedIn"), new DateTime(usuario.getChangedIn(), DateTimeZone.UTC)));
        }

        if (usuario.getIncludedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<String>get("includedBy"), (usuario.getIncludedBy())));
        }

        if (usuario.getChangedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<String>get("chancedBy"), (usuario.getChangedBy())));
        }

        TypedQuery<Usuario> typedQuery = this.em.createQuery(
                query.select(from)
                        .where(predicate)
                        .orderBy(builder.asc(from.get("id")))
        );

        List<Usuario> results = typedQuery.getResultList();
        return results;
    }

}
