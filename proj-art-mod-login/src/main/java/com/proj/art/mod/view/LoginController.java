/*
 * LoginController.java
 *
 * Created on 13-12-2018
 *
 * Copyright(c) 2018 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.art.mod.view;

import com.proj.art.mod.model.Login;
import com.proj.art.view.controller.DomainEntityController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description the class  LoginController - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 13/12/2018
 */
@Controller(value = "loginController")
@RequestMapping("/login")
public class LoginController extends DomainEntityController<Login> {

    public LoginController() {
        super(Login.class);
    }
}