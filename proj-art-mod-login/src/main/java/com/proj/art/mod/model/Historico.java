/*
 * Historico.java
 *
 * Created on 13-12-2018
 *
 * Copyright(c) 2018 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.art.mod.model;

import com.google.gson.annotations.Expose;
import com.proj.art.model.DomainEntity;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Description the class  Historico - Classe para dados de historico.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 13/12/2018
 */
@Entity
@Table(name = "HISTORICO_USUARIO")
public class Historico extends DomainEntity {

    @Expose
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HISTORICO_USUARIO")
    @SequenceGenerator(name = "SEQ_HISTORICO_USUARIO", sequenceName = "SEQ_HISTORICO_USUARIO", allocationSize = 1)
    @Column(name = "COD_HISTORICO", nullable = false, insertable = true, updatable = true)
    public Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Expose
    @Column(name = "ULTIMO_ACESSO_IP")
    private String ip;
    
    @Expose
    @Column(name = "ULTIMO_ACESSO_NAVEGADOR")
    private String navegador;
    
    @Expose
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ULTIMO_ACESSO")    
    private Date dtUltimoAcesso;
    
    @Expose
    @Column(name = "DISPOSITIVO")
    private String dispositivo;
    
    @Expose
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "COD_USUARIO_AREA_RESTRITA")
    @Fetch(FetchMode.JOIN)
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNavegador() {
        return navegador;
    }

    public void setNavegador(String navegador) {
        this.navegador = navegador;
    }

    public Date getDtUltimoAcesso() {
        return dtUltimoAcesso;
    }

    public void setDtUltimoAcesso(Date dtUltimoAcesso) {
        this.dtUltimoAcesso = dtUltimoAcesso;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }


}

