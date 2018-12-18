/*
 * LoginService.java
 *
 * Created on 13-12-2018
 *
 * Copyright(c) 2018 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.art.mod.core.service;

import com.proj.art.core.IRepository;
import com.proj.art.core.IServico;
import com.proj.art.core.IStrategy;
import com.proj.art.core.service.impl.AbstractService;
import com.proj.art.mod.core.repository.LoginRepository;
import com.proj.art.mod.core.strategy.LoginStrategy;
import com.proj.art.mod.model.Login;
import com.proj.art.model.anotations.ADomainEntity;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Description the class  LoginService - Classe que contém o servico da entidade Login
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 13/12/2018
 */
@Component
@Service("loginService")
@ADomainEntity(nome = "Login", classe = Login.class)
public class LoginService extends AbstractService implements IServico {

    @Autowired
    @Qualifier(value = "loginRepository")
    LoginRepository loginRepository;

    @Autowired
    @Qualifier(value = "loginStrategy")
    LoginStrategy loginStrategy;

    @Override
    public IRepository getRepository() {
        return loginRepository;
    }

    @Override
    public Map<String, List<IStrategy>> getStrategys() {
        return loginStrategy.getRnsLogin();
    }

}

