/*
 * LoginStrategy.java
 *
 * Created on 13-12-2018
 *
 * Copyright(c) 2018 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */
package com.proj.art.mod.core.strategy;

import com.proj.art.core.IStrategy;
import com.proj.art.core.strategy.impl.ComplementaryEntityActive;
import com.proj.art.core.strategy.impl.DisableAction;
import com.proj.art.mod.core.strategy.impl.DadosObrigatoriosLoginUsuario;
import com.proj.art.mod.core.strategy.impl.ValidarUsuarioLogin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Description the class LoginStrategy - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 13/12/2018
 */
@Component("loginStrategy")
public class LoginStrategy {

    /* Cria o mapa que podera conter todas as listas de regras de negocio especifica 
     * por operacao do produto
     */
    Map<String, List<IStrategy>> rnsLogin = new HashMap<>();

    //@Autowired
    ComplementaryEntityActive cpAtivo = new ComplementaryEntityActive();
    
    // @Autowired
    // ComplementaryEntityChangedInBy cpAlteradoEmPor = new ComplementaryEntityChangedInBy();
    
    //@Autowired
    DisableAction desabilitarAcao = new DisableAction();
    
    //@Autowired
    ValidarUsuarioLogin vValidarUsuarioLogin =  new ValidarUsuarioLogin();
    
    //@Autowired
    DadosObrigatoriosLoginUsuario vDadosLoginUsuario = new DadosObrigatoriosLoginUsuario();

    public LoginStrategy() {
        //Regras para entidade Login

        /* Criando uma lista para conter as regras de negocio de Login
         * quando a operacao for salvar
         */
        List<IStrategy> rnsSalvarLogin = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao salvar do Login */
        rnsSalvarLogin.add(vValidarUsuarioLogin);
        rnsSalvarLogin.add(vDadosLoginUsuario);

        /* Criando uma lista para conter as regras de negocio de Login
         * quando a operacao for alterar
         */
        List<IStrategy> rnsAlterarLogin = new ArrayList<IStrategy>();
        /* Adicionando as regras a serem utilizadas na operacao alterar do Login */
        rnsAlterarLogin.add(desabilitarAcao);

        /* Criando uma lista para conter as regras de negocio de produto
         * quando a operacao for consultar
         */
        List<IStrategy> rnsConsultarLogin = new ArrayList<IStrategy>();
        rnsConsultarLogin.add(desabilitarAcao);

        /* Criando uma lista para conter as regras de negocio de produto
         * quando a operacao for consultar
         */
        List<IStrategy> rnsVisualizarLogin = new ArrayList<IStrategy>();
        rnsVisualizarLogin.add(desabilitarAcao);

        /* Criando uma lista para conter as regras de negocio de produto
         * quando a operacao for consultar
         */
        List<IStrategy> rnsDeletarLogin = new ArrayList<IStrategy>();
        rnsDeletarLogin.add(desabilitarAcao);

        /* Adicionando as regras a serem utilizadas na operacao consultar do Login */
        rnsConsultarLogin.add(cpAtivo);
        /*
         * Adiciona a listra de regras na operacao salvar no mapa do Login 
         */
        rnsLogin.put("SALVAR", rnsSalvarLogin);
        /*
         * Adiciona a listra de regras na operacao alterar no mapa do Login 
         */
        rnsLogin.put("ALTERAR", rnsAlterarLogin);
        /*
         * Adiciona a listra de regras na operacao consultar no mapa do Login 
         */
        rnsLogin.put("CONSULTAR", rnsConsultarLogin);
        /*
         * Adiciona a listra de regras na operacao visualizar no mapa do Login 
         */
        rnsLogin.put("VISUALIZAR", rnsVisualizarLogin);
        /*
         * Adiciona a listra de regras na operacao deletar no mapa do Login 
         */
        rnsLogin.put("DELETAR", rnsDeletarLogin);

      
    }

    public Map<String, List<IStrategy>> getRnsLogin() {
        return rnsLogin;
    }

}
