/*
 * LoginDAO.java
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
import com.proj.art.mod.model.Login;
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
 * Description the class LoginDAO - Implementação DAO da entidade login.
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 13/12/2018
 */
@Component("loginDAO")
@Repository
public class LoginDAO extends DAOImp<Login> implements IDAO<Login> {

    /**
     * Método que consulta todos os logins, porém apenas retorna os 10
     * primeiros.
     *
     * @return List<Login>
     */
    public List<Login> findByMaxList() {
        CriteriaBuilder builder = this.em.getCriteriaBuilder();
        CriteriaQuery<Login> query = builder.createQuery(Login.class);

        TypedQuery<Login> typedQuery = this.em.createQuery(query.select(query.from(Login.class))
        ).setFirstResult(0) // offset
                .setMaxResults(10); // limit

        List<Login> results = typedQuery.getResultList();
        return results;

    }

    /**
     * Método que consulta usuário de acordo com os atributos preenchidos.
     *
     * @param login
     * @return List<Login>
     */
    @Override
    public List<Login> findByCriteria(Login login) {
        CriteriaBuilder builder = this.em.getCriteriaBuilder();
        CriteriaQuery<Login> query = builder.createQuery(Login.class);
        Root from = query.from(Login.class);

        Predicate predicate = builder.and();

        if (login.getId() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<Long>get("id"), login.getId()));
        }

        if (login.getEstado() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<String>get("estado"), login.getEstado()));
        }

        if (login.getNavegador() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<String>get("navegador"), login.getNavegador()));
        }

        if (login.getDispositivo() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<String>get("dispositivo"), login.getDispositivo()));
        }

        if (login.getDtAcesso() != null) {
            predicate = builder.and(predicate,
                    builder.greaterThanOrEqualTo(from.<Date>get("dtAcesso"), login.getDtAcesso()));
        }

        if (login.getUsuario() != null) {
            if (login.getUsuario().getEmail() != null) {
                predicate = builder.and(predicate,
                        builder.equal(from.get("login").<String>get("email"), login.getUsuario().getEmail()));
            }

            if (login.getUsuario().getSenha() != null) {
                predicate = builder.and(predicate,
                        builder.equal(from.get("login").<String>get("senha"), login.getUsuario().getSenha()));
            }

            if (login.getUsuario().getPerfil() != null) {

                if (login.getUsuario().getPerfil().getId() != null) {
                    predicate = builder.and(predicate, builder.equal(
                            from.get("login").get("perfil").<Long>get("id"), login.getUsuario().getPerfil().getId()));
                }

                if (login.getUsuario().getPerfil().getNome() != null) {
                    predicate = builder.and(predicate, builder.equal(
                            from.get("login").get("perfil").<String>get("nome"), login.getUsuario().getPerfil().getNome()));
                }

                if (login.getUsuario().getPerfil().getDescricao() != null) {
                    predicate = builder.and(predicate, builder.equal(
                            from.get("login").get("perfil").<String>get("descricao"), login.getUsuario().getPerfil().getDescricao()));
                }

            }

        }

        if (login.getActive() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<String>get("ativo"), login.getActive()));
        }

        if (login.getIncludedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<Date>get("includedIn"), new DateTime(login.getIncludedIn(), DateTimeZone.UTC)));
        }

        if (login.getChangedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<Date>get("changedIn"), new DateTime(login.getChangedIn(), DateTimeZone.UTC)));
        }

        if (login.getIncludedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<String>get("includedBy"), (login.getIncludedBy())));
        }

        if (login.getChangedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<String>get("chancedBy"), (login.getChangedBy())));
        }

        TypedQuery<Login> typedQuery = this.em.createQuery(
                query.select(from)
                        .where(predicate)
                        .orderBy(builder.asc(from.get("id")))
        );

        List<Login> results = typedQuery.getResultList();
        return results;
    }

}
