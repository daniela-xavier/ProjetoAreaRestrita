/*
 * ResponseMessage.java
 *
 * Created on 13-12-2018
 *
 * Copyright(c) 2018 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.art.view.response;

import com.proj.art.core.application.EntityApplication;

/**
 * Description the class  ResponseMessage - Classe responsável pela mensagem de
 * resposta da aplicação.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 13/12/2018
 */
public class ResponseMessage extends EntityApplication {

    private final Boolean hasError;
    private final String message;

    /**
     * Construtor com parametros.
     * @param hasError - Se há erro ou não na resposta.
     * @param message - Se há mensagem de erro ou não.
     */
    public ResponseMessage(Boolean hasError, String message) {
        this.hasError = hasError;
        this.message = message;
    }

    /**
     * Método que retorna o estado de erro.
     * @return Boolean - (true - com erro, false - sem erro).
     */
    public Boolean getHasError() {
        return hasError;
    }

    /**
     * Método de recuperação da mensagem.
     * @return String
     */
    public String getMessage() {
        return message;
    }
}
