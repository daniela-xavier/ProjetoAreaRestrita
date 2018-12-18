/*
 * Login.java
 *
 * Created on 12-12-2018
 *
 * Copyright(c) 2018 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.art.mod.model;

import com.google.gson.annotations.Expose;
import com.proj.art.model.DomainEntity;
import java.util.Date;
import javax.persistence.AttributeOverride;
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
 * Description the class  Login - Classe de entidade dominio login, que fornecerá 
 * o fluxo para login no sistema.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 12/12/2018
 */
@Entity
@Table(name = "LOG_ACESSO")
@AttributeOverride(name = "id", column = @Column(name = "COD_LOG_ACESSO"))
@SequenceGenerator(name = "SEQ_LOG_ACESSO", sequenceName = "SEQ_LOG_ACESSO", allocationSize = 1)
public class Login extends DomainEntity {

    @Expose
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LOG_ACESSO")
    @SequenceGenerator(name = "SEQ_LOG_ACESSO", sequenceName = "SEQ_LOG_ACESSO", allocationSize = 1)
    @Column(name = "COD_LOG_ACESSO", nullable = false, insertable = true, updatable = true)
    public Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Expose
    @Column(name = "ACESSO_IP")
    private String ip;

    @Expose
    @Column(name = "DISPOSITIVO")
    private String dispositivo;

    @Expose
    @Column(name = "NAVEGADOR")
    private String navegador;

    @Expose
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_ACESSO")
    private Date dtAcesso;

    @Expose
    @Column(name = "LOCAL_ACESSO")
    private String local;

    @Expose
    @Column(name = "ESTADO")
    private String estado;

    @Expose
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "COD_USUARIO_AREA_RESTRITA")
    @Fetch(FetchMode.JOIN)
    private Usuario usuario;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getDtAcesso() {
        return dtAcesso;
    }

    public void setDtAcesso(Date dtAcesso) {
        this.dtAcesso = dtAcesso;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNavegador() {
        return navegador;
    }

    public void setNavegador(String navegador) {
        this.navegador = navegador;
    }


}

