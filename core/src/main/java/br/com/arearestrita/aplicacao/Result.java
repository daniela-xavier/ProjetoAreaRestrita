package br.com.arearestrita.aplicacao;

import br.com.arearestrita.model.DomainEntity;
import com.google.gson.annotations.Expose;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Description the class  br.com.arearestrita.core.IFachada - Classe que comporta o retorno dos serviços e operações.
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $Revision: 1
 * @since Build 0.1 02/12/019
 */
public class Result extends EntityApplication {


    @Expose
    private String message;

    @Expose
    private Optional<DomainEntity> entity;

    @Expose
    private boolean error;

    @Expose
    Pageable pageable;

    /**
     * Método de recuperação do campo message
     *
     * @return valor do campo message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Valor de message atribuído a message
     *
     * @param message Atributo da Classe
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Método de recuperação do campo entity
     *
     * @return valor do campo entity
     */
    public Optional<DomainEntity> getEntity() {
        return entity;
    }

    /**
     * Valor de entity atribuído a entity
     *
     * @param entity Atributo da Classe
     */
    public void setEntity(Optional<DomainEntity> entity) {
        this.entity = entity;
    }

    /**
     * Valor de entity atribuído a entity
     *
     * @param entity Atributo da Classe
     * @param pageable Atributo da Classe para paginação
     */
    public void setEntity(Optional<DomainEntity> entity,  Pageable pageable) {
        this.entity = entity;
        this.pageable = pageable;
    }

    /**
     * Método de recuperação do campo error.
     *
     * @return error (true - contém erro ou false - não contém erro.)
     */
    public boolean hasError() {
        return this.error;
    }

    /**
     * Método que atribui true (contém erro) a variável error.
     */
    public void setError() {
        this.error = true;
    }


}
