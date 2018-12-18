/*
 * Usuario.java
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
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Description the class  Usuario - Classe de objeto real Usuario.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 13/12/2018
 */
@Entity
@Table(name = "USUARIO_AREA_RESTRITA") 
public class Usuario extends DomainEntity{
      
    @Expose
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIO_AREA_RESTRITA")
    @SequenceGenerator(name = "SEQ_USUARIO_AREA_RESTRITA", sequenceName = "SEQ_USUARIO_AREA_RESTRITA", allocationSize = 1)
    @Column(name = "COD_USUARIO_AREA_RESTRITA", nullable = false, insertable = true, updatable = true)
    public Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Expose
    @Column(name = "EMAIL", unique = true)
    private String email;
      
    @Expose
    @Column(name = "SENHA")
    private String senha;
    
    @Expose(serialize = false, deserialize = false)
    @Transient
    private String senhaConfirme;
    
    @Expose
    @OneToOne(targetEntity = Perfil.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "COD_PERFIL")
    private Perfil perfil;
           
    @Expose
    @Column(name = "TERMO_AUTORIZA")
    private String aceiteTermo;
    
    @Expose
    @Column(name = "OBSERVACAO")
    private String observacao;
    
    @Expose
    @Temporal(TemporalType.TIMESTAMP)     
    @Column(name = "DT_ACEITE_TERMO")    
    private Date dtAceiteTermo;
    
    @Expose
    @Temporal(TemporalType.TIMESTAMP)     
    @Column(name = "ULTIMO_ACESSO")    
    private Date dtUtimoAcesso;
    
    /*
    @Expose
    @OneToOne(targetEntity = PessoaFisica.class, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "COD_PESSOA")
    private PessoaFisica cliente;
    */
    
    @Expose(serialize = false, deserialize = false)
    @OneToMany(mappedBy="usuario", fetch = FetchType.LAZY, targetEntity = Historico.class, cascade = CascadeType.REFRESH)     
    private List<Historico> historico;
    
    @Expose(serialize = false, deserialize = false)
    @OneToMany(mappedBy="usuario", fetch = FetchType.EAGER, targetEntity = Login.class, cascade=CascadeType.REFRESH)    
    private List<Login> logins;
  
    
    @Expose
    @Column(name = "TOKEN")
    private String token;
    
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDtUtimoAcesso() {
        return dtUtimoAcesso;
    }

    public void setDtUtimoAcesso(Date dtUtimoAcesso) {
        this.dtUtimoAcesso = dtUtimoAcesso;
    }
      
    
    

    public List<Login> getLogins() {
        return logins;
    }

    public void setLogins(List<Login> logins) {
        this.logins = logins;
    }

    
    public List<Historico> getHistorico() {
        return historico;
    }

    public void setHistorico(List<Historico> historico) {
        this.historico = historico;
    }
    
   
    
    
    
    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }
  
    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getSenha() {
        return senha;
    }

    /**
     *
     * @param senha
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }    
    
    /**
     *
     * @return
     */
    public Perfil getPerfil() {
    return perfil;
    }
    
    /**
     *
     * @param perfil
     */
    public void setPerfil(Perfil perfil) {
    this.perfil = perfil;
    }
    
    /**
     *
     * @return
     */
    public String getAceiteTermo() {
        return aceiteTermo;
    }

    /**
     *
     * @param aceiteTermo
     */
    public void setAceiteTermo(String aceiteTermo) {
        this.aceiteTermo = aceiteTermo;
    }

    /**
     *
     * @return
     */
    public Date getDtAceiteTermo() {
        return dtAceiteTermo;
    }

    /**
     *
     * @param dtAceiteTermo
     */
    public void setDtAceiteTermo(Date dtAceiteTermo) {
        this.dtAceiteTermo = dtAceiteTermo;
    }


    /**
     *
     * @return
     */
    public String getSenhaConfirme() {
        return senhaConfirme;
    }

    /**
     *
     * @param senhaConfirme
     */
    public void setSenhaConfirme(String senhaConfirme) {
        this.senhaConfirme = senhaConfirme;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    
}

