/*
 * ExceptionResponse.java
 *
 * Created on 13-12-2018
 *
 * Copyright(c) 2018 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.art.view.response;

/**
 * Description the class  ExceptionResponse - Classe responsável pelo retorno de
 * exceções da aplicação.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 13/12/2018
 */
public class ExceptionResponse extends RuntimeException {

    private final String msg;

    /**
     * Construtor da classe com parametro.
     * @param msg - Mensagem para retorno de exception.
     */
    public ExceptionResponse(String msg) {
        super(msg);
        this.msg = msg;
    }

    /**
     * Método de recuperação de mensagem.
     * @return String
     */
    @Override
    public String getMessage() {
        return msg;
    }

}

