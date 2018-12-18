/*
 * HistoricoDAO.java
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
import com.proj.art.mod.model.Historico;
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
 * Description the class  HistoricoDAO - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 13/12/2018
 */
@Component("historicoDAO")
@Repository
public class HistoricoDAO extends DAOImp<Historico> implements IDAO<Historico> {

    /**
     * Método que consulta todos os historicos, porém apenas retorna os 10
     * primeiros.
     *
     * @return List<Historico>
     */
    public List<Historico> findByMaxList() {
        CriteriaBuilder builder = this.em.getCriteriaBuilder();
        CriteriaQuery<Historico> query = builder.createQuery(Historico.class);

        TypedQuery<Historico> typedQuery = this.em.createQuery(query.select(query.from(Historico.class))
        ).setFirstResult(0) // offset
                .setMaxResults(10); // limit

        List<Historico> results = typedQuery.getResultList();
        return results;

    }

    /**
     * Método que consulta usuário de acordo com os atributos preenchidos.
     *
     * @param historico
     * @return List<Historico>
     */
    @Override
    public List<Historico> findByCriteria(Historico historico) {
        CriteriaBuilder builder = this.em.getCriteriaBuilder();
        CriteriaQuery<Historico> query = builder.createQuery(Historico.class);
        Root from = query.from(Historico.class);

        Predicate predicate = builder.and();

        if (historico.getId() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<Long>get("id"), historico.getId()));
        }

        if (historico.getActive() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<String>get("ativo"), historico.getActive()));
        }

        if (historico.getIncludedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<Date>get("includedIn"), new DateTime(historico.getIncludedIn(), DateTimeZone.UTC)));
        }

        if (historico.getChangedIn() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<Date>get("changedIn"), new DateTime(historico.getChangedIn(), DateTimeZone.UTC)));
        }

        if (historico.getIncludedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<String>get("includedBy"), (historico.getIncludedBy())));
        }

        if (historico.getChangedBy() != null) {
            predicate = builder.and(predicate,
                    builder.equal(from.<String>get("chancedBy"), (historico.getChangedBy())));
        }

        TypedQuery<Historico> typedQuery = this.em.createQuery(
                query.select(from)
                        .where(predicate)
                        .orderBy(builder.asc(from.get("id")))
        );

        List<Historico> results = typedQuery.getResultList();
        return results;
    }

}
