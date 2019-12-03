package br.com.arearestrita.view.response;

import br.com.arearestrita.aplicacao.EntityApplication;

/**
 * Description the class  ResponseMessage - Classe responsável pela mensagem de
 * resposta da aplicação.
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $Revision: 1
 * @since Build 0.1 02/12/019
 */
public class ResponseMessage extends EntityApplication {

    private final Boolean hasError;
    private final String message;

    /**
     * Construtor com parametros.
     *
     * @param hasError - Se há erro ou não na resposta.
     * @param message  - Se há mensagem de erro ou não.
     */
    public ResponseMessage(Boolean hasError, String message) {
        this.hasError = hasError;
        this.message = message;
    }

    /**
     * Método que retorna o estado de erro.
     *
     * @return Boolean - (true - com erro, false - sem erro).
     */
    public Boolean getHasError() {
        return hasError;
    }

    /**
     * Método de recuperação da mensagem.
     *
     * @return String
     */
    public String getMessage() {
        return message;
    }
}

