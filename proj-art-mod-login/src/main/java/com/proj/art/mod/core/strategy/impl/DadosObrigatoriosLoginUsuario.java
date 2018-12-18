/*
 * DadosObrigatoriosLoginUsuario.java
 *
 * Created on 13-12-2018
 *
 * Copyright(c) 2018 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.art.mod.core.strategy.impl;

import com.proj.art.core.IStrategy;
import com.proj.art.mod.model.Login;
import com.proj.art.mod.model.Usuario;
import com.proj.art.model.DomainEntity;

/**
 * Description the class  DadosObrigatoriosLoginUsuario - Classe que implementa
 IStrategy e realiza regra de negócio verificando se os dados de login estão
 preenchidos.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 13/12/2018
 */
public class DadosObrigatoriosLoginUsuario implements IStrategy {

    /**
     * Método que processar da classe.
     * @param entidade
     * @return String
     */
    @Override
    public String process(DomainEntity entidade) {

        if (entidade instanceof Login) {
            Login login = (Login)entidade;
            Usuario usuario = login.getUsuario();
         
            String email = usuario.getEmail();
            String senha = usuario.getSenha();

            if (email == null || senha == null) {
                return "<1447>";
            }

            if (email.trim().equals("") || senha.trim().equals("")) {
                return "<1447>";
            }

        } else {
            return "<5603> Deve ser registrado uma usuario!";
        }

        return null;
    }


}
