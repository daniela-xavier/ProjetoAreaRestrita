package br.com.arearestrita.aplicacao;

import br.com.arearestrita.model.IEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description the class  EntidadeAplicacao - Classe de implementação de EntidadeAplicacao.
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $Revision: 1
 * @since Build 0.1 02/12/019
 */

public class EntityApplication implements IEntity {
    /**
     * Método de log das Entidades por classe.
     * @param clazz
     * @return Logger
     */
    public Logger getLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }
}
