
package br.com.arearestrita.strategy.impl;

import br.com.arearestrita.strategy.IStrategy;
import br.com.arearestrita.model.DomainEntity;

/**
 * Description the class  PasswordAuthorizedExclusion - Classe que implementa o método
 process do contrato com IStrategy.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version  $Revision: 1
 * @since Build 0.1 04/12/019
 */
public class PasswordAuthorizedExclusion implements IStrategy {

    /**
     * Método que não permite a execução desta ação.
     *
     * @param entity
     * @return String
     */
    @Override
    public String process(DomainEntity entity) {
        return "Processos inválido. Não é possível executar esta ação.";
    }
}

